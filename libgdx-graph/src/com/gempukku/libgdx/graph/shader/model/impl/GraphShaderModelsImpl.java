package com.gempukku.libgdx.graph.shader.model.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;
import com.gempukku.libgdx.graph.shader.GraphShaderConfig;
import com.gempukku.libgdx.graph.shader.TransformUpdate;
import com.gempukku.libgdx.graph.shader.model.GraphShaderModels;
import com.gempukku.libgdx.graph.shader.model.ModelInstanceOptimizationHints;
import com.gempukku.libgdx.graph.shader.model.TagOptimizationHint;
import com.gempukku.libgdx.graph.util.IdGenerator;
import com.gempukku.libgdx.graph.util.RandomIdGenerator;

import java.util.Comparator;

public class GraphShaderModelsImpl implements GraphShaderModels, Disposable {
    private enum Order {
        Front_To_Back, Back_To_Front;

        public int result(float dst) {
            if (this == Front_To_Back)
                return dst > 0 ? 1 : (dst < 0 ? -1 : 0);
            else
                return dst < 0 ? 1 : (dst > 0 ? -1 : 0);
        }
    }

    private Vector3 cameraPosition = new Vector3();
    private Order order;
    private DistanceRenderableSorter sorter = new DistanceRenderableSorter();

    private ObjectMap<String, GraphShaderModel> graphShaderModels = new ObjectMap<>();
    private ObjectMap<String, GraphShaderModelInstance> models = new ObjectMap<>();

    private Array<GraphShaderModelInstance> preparedForRendering = new Array<>();

    private IdGenerator idGenerator = new RandomIdGenerator(16);
    private Matrix4 transformTempMatrix = new Matrix4();

    private Array<VertexAttribute> registeredAttributes = new Array<>();
    private VertexAttributes vertexAttributes;

    @Override
    public String registerModel(Model model) {
        if (vertexAttributes == null) {
            int maxNumberOfBoneWeights = GraphShaderConfig.getMaxNumberOfBoneWeights();

            int numberOfAttributes = registeredAttributes.size;

            VertexAttribute[] vertexAttributeArr = new VertexAttribute[numberOfAttributes + maxNumberOfBoneWeights];
            for (int i = 0; i < numberOfAttributes; i++) {
                vertexAttributeArr[i] = registeredAttributes.get(i);
            }
            for (int i = 0; i < maxNumberOfBoneWeights; i++) {
                vertexAttributeArr[numberOfAttributes + i] = VertexAttribute.BoneWeight(i);
            }
            vertexAttributes = new VertexAttributes(vertexAttributeArr);
        }
        String id = idGenerator.generateId();
        ModelBasedGraphShaderModel graphShaderModel = new ModelBasedGraphShaderModel(id, model, vertexAttributes);
        graphShaderModels.put(id, graphShaderModel);
        return id;
    }

    @Override
    public void removeModel(String modelId) {
        GraphShaderModel model = graphShaderModels.remove(modelId);
        ObjectMap.Entries<String, GraphShaderModelInstance> iterator = models.iterator();
        for (ObjectMap.Entry<String, GraphShaderModelInstance> entry : iterator) {
            if (entry.value.getModelId().equals(modelId))
                iterator.remove();
        }
        model.dispose();
    }

    @Override
    public void addModelDefaultTag(String modelId, String tag) {
        addModelDefaultTag(modelId, tag, TagOptimizationHint.Flash);
    }

    @Override
    public void addModelDefaultTag(String modelId, String tag, TagOptimizationHint tagOptimizationHint) {
        graphShaderModels.get(modelId).addDefaultTag(tag, tagOptimizationHint);
    }

    @Override
    public void removeModelDefaultTag(String modelId, String tag) {
        graphShaderModels.get(modelId).removeDefaultTag(tag);
    }

    @Override
    public String createModelInstance(String modelId) {
        return createModelInstance(modelId, ModelInstanceOptimizationHints.unoptimized);
    }

    @Override
    public String createModelInstance(String modelId, ModelInstanceOptimizationHints modelInstanceOptimizationHints) {
        String instanceId = idGenerator.generateId();
        GraphShaderModelInstance graphShaderModelInstance = graphShaderModels.get(modelId).createInstance(instanceId, modelInstanceOptimizationHints);
        models.put(instanceId, graphShaderModelInstance);
        return instanceId;
    }

    @Override
    public void destroyModelInstance(String modelInstanceId) {
        models.remove(modelInstanceId);
    }

    @Override
    public void updateTransform(String modelInstanceId, TransformUpdate transformUpdate) {
        Matrix4 transformMatrix = getModelInstance(modelInstanceId).getTransformMatrix();
        transformTempMatrix.set(transformMatrix);
        transformUpdate.updateTransform(transformTempMatrix);
        transformMatrix.set(transformTempMatrix);
    }

    public AnimationController createAnimationController(String modelInstanceId) {
        return getModelInstance(modelInstanceId).createAnimationController();
    }

    private GraphShaderModelInstance getModelInstance(String modelInstanceId) {
        return models.get(modelInstanceId);
    }

    @Override
    public void addTag(String modelInstanceId, String tag) {
        addTag(modelInstanceId, tag, TagOptimizationHint.Flash);
    }

    @Override
    public void addTag(String modelInstanceId, String tag, TagOptimizationHint tagOptimizationHint) {
        getModelInstance(modelInstanceId).addTag(tag, tagOptimizationHint);
    }

    @Override
    public void removeTag(String modelInstanceId, String tag) {
        getModelInstance(modelInstanceId).removeTag(tag);
    }

    @Override
    public void removeAllTags(String modelInstanceId) {
        getModelInstance(modelInstanceId).removeAllTags();
    }

    @Override
    public void setProperty(String modelInstanceId, String name, Object value) {
        getModelInstance(modelInstanceId).getPropertyContainer().setValue(name, value);
    }

    @Override
    public void unsetProperty(String modelInstanceId, String name) {
        getModelInstance(modelInstanceId).getPropertyContainer().remove(name);
    }

    @Override
    public boolean hasTag(String modelInstanceId, String tag) {
        return getModelInstance(modelInstanceId).hasTag(tag);
    }

    @Override
    public Object getProperty(String modelInstanceId, String name) {
        return getModelInstance(modelInstanceId).getPropertyContainer().getValue(name);
    }

    public void registerAttribute(VertexAttribute vertexAttribute) {
        if (vertexAttribute.usage == VertexAttributes.Usage.ColorPacked)
            vertexAttribute = VertexAttribute.ColorUnpacked();
        if (!registeredAttributes.contains(vertexAttribute, false))
            registeredAttributes.add(vertexAttribute);
    }

    public void prepareForRendering(Camera camera) {
        cameraPosition.set(camera.position);
        order = null;
        preparedForRendering.clear();
        models.values().toArray(preparedForRendering);
    }

    public void orderFrontToBack() {
        if (order == Order.Back_To_Front)
            preparedForRendering.reverse();
        if (order == null)
            sorter.sort(cameraPosition, preparedForRendering, Order.Front_To_Back);
        order = Order.Front_To_Back;
    }

    public void orderBackToFront() {
        if (order == Order.Front_To_Back)
            preparedForRendering.reverse();
        if (order == null)
            sorter.sort(cameraPosition, preparedForRendering, Order.Back_To_Front);
        order = Order.Back_To_Front;
    }

    public Iterable<? extends GraphShaderModelInstance> getModels() {
        return models.values();
    }

    public boolean hasModelWithTag(String tag) {
        for (GraphShaderModelInstance value : models.values()) {
            if (value.hasTag(tag))
                return true;
        }
        return false;
    }

    @Override
    public void dispose() {
        for (GraphShaderModel model : graphShaderModels.values()) {
            model.dispose();
        }
        graphShaderModels.clear();
        models.clear();
    }

    private static class DistanceRenderableSorter implements Comparator<GraphShaderModelInstance> {
        private Vector3 cameraPosition;
        private Order order;
        private final Vector3 tmpV1 = new Vector3();
        private final Vector3 tmpV2 = new Vector3();

        public void sort(Vector3 cameraPosition, Array<GraphShaderModelInstance> renderables, Order order) {
            this.cameraPosition = cameraPosition;
            this.order = order;
            renderables.sort(this);
        }

        private Vector3 getTranslation(Matrix4 worldTransform, Vector3 output) {
            worldTransform.getTranslation(output);
            return output;
        }

        @Override
        public int compare(GraphShaderModelInstance o1, GraphShaderModelInstance o2) {
            getTranslation(o1.getTransformMatrix(), tmpV1);
            getTranslation(o2.getTransformMatrix(), tmpV2);
            final float dst = (int) (1000f * cameraPosition.dst2(tmpV1)) - (int) (1000f * cameraPosition.dst2(tmpV2));
            return order.result(dst);
        }
    }
}
