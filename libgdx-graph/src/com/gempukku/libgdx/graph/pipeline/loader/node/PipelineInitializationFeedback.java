package com.gempukku.libgdx.graph.pipeline.loader.node;

import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.ObjectMap;
import com.gempukku.libgdx.graph.shader.property.PropertyContainerImpl;
import com.gempukku.libgdx.graph.shader.property.PropertySource;

public interface PipelineInitializationFeedback {
    void registerScreenShader(String tag, PropertyContainerImpl propertyContainer);

    void registerParticleEffect(String tag, VertexAttributes vertexAttributes, int maxNumberOfParticles, int initialParticles, float particlesPerSecond);

    void registerModelVertexAttributes(String tag, VertexAttributes vertexAttributes);

    void registerSpriteShader(String tag, VertexAttributes vertexAttributes, boolean opaque, ObjectMap<String, PropertySource> shaderProperties);
}
