package com.gempukku.libgdx.graph.shader.model.impl;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.Pool;
import com.gempukku.libgdx.graph.shader.model.ModelInstanceOptimizationHints;
import com.gempukku.libgdx.graph.shader.model.TagOptimizationHint;
import com.gempukku.libgdx.graph.shader.property.PropertyContainerImpl;

public class GraphShaderModelInstance {
    private String id;
    private GraphShaderModel model;
    private ModelInstance modelInstance;
    private ModelInstanceOptimizationHints modelInstanceOptimizationHints;
    private ObjectMap<String, TagOptimizationHint> tags = new ObjectMap<>();
    private PropertyContainerImpl propertyContainer = new PropertyContainerImpl();

    public GraphShaderModelInstance(String id, GraphShaderModel model, ModelInstance modelInstance, ModelInstanceOptimizationHints modelInstanceOptimizationHints) {
        this.id = id;
        this.model = model;
        this.modelInstance = modelInstance;
        this.modelInstanceOptimizationHints = modelInstanceOptimizationHints;
    }

    public String getId() {
        return id;
    }

    public void addTag(String tag, TagOptimizationHint tagOptimizationHint) {
        tags.put(tag, tagOptimizationHint);
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public void removeAllTags() {
        tags.clear();
    }

    public void setProperty(String name, Object value) {
        propertyContainer.setValue(name, value);
    }

    public void unsetProperty(String name) {
        propertyContainer.remove(name);
    }

    public boolean hasTag(String tag) {
        return tags.containsKey(tag);
    }

    public Object getProperty(String name) {
        return propertyContainer.getValue(name);
    }

    public PropertyContainerImpl getPropertyContainer() {
        return propertyContainer;
    }

    public Matrix4 getTransformMatrix() {
        return modelInstance.transform;
    }

    public GraphShaderModel getModel() {
        return model;
    }

    public ModelInstance getModelInstance() {
        return modelInstance;
    }

    public void getRenderables(Array<Renderable> renderables, Pool<Renderable> pool) {
        modelInstance.getRenderables(renderables, pool);
    }
}