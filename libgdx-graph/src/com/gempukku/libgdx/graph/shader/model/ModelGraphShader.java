package com.gempukku.libgdx.graph.shader.model;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.utils.IntArray;
import com.gempukku.libgdx.graph.pipeline.loader.rendering.producer.ModelShaderContextImpl;
import com.gempukku.libgdx.graph.shader.GraphShader;
import com.gempukku.libgdx.graph.shader.model.impl.GraphShaderModelInstance;

public class ModelGraphShader extends GraphShader {
    private final IntArray tempArray = new IntArray();
    private Mesh currentMesh;

    public ModelGraphShader(Texture defaultTexture) {
        super(defaultTexture);
    }

    public void render(ModelShaderContextImpl shaderContext, GraphShaderModelInstance graphShaderModelInstance) {
        shaderContext.setPropertyContainer(graphShaderModelInstance.getPropertyContainer());
        graphShaderModelInstance.getRenderables(renderables, renderablesPool);
        for (Renderable renderable : renderables) {
            shaderContext.setRenderable(renderable);
            for (Uniform uniform : localUniforms.values()) {
                uniform.getSetter().set(this, uniform.getLocation(), shaderContext);
            }
            for (StructArrayUniform uniform : localStructArrayUniforms.values()) {
                uniform.getSetter().set(this, uniform.getStartIndex(), uniform.getFieldOffsets(), uniform.getSize(), shaderContext);
            }
            MeshPart meshPart = renderable.meshPart;
            Mesh mesh = meshPart.mesh;
            if (currentMesh != mesh) {
                if (currentMesh != null) currentMesh.unbind(program, tempArray.items);
                currentMesh = mesh;
                currentMesh.bind(program, getAttributeLocations(mesh.getVertexAttributes()));
            }
            meshPart.render(program, false);
        }
        renderables.clear();
    }

    private final int[] getAttributeLocations(final VertexAttributes attrs) {
        tempArray.clear();
        final int n = attrs.size();
        for (int i = 0; i < n; i++) {
            Attribute attribute = attributes.get(attrs.get(i).alias);
            if (attribute != null)
                tempArray.add(attribute.getLocation());
            else
                tempArray.add(-1);
        }
        return tempArray.items;
    }

    @Override
    public void end() {
        if (currentMesh != null) {
            currentMesh.unbind(program, tempArray.items);
            currentMesh = null;
        }
        super.end();
    }
}