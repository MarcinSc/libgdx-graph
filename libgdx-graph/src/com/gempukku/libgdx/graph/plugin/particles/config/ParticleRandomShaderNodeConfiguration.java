package com.gempukku.libgdx.graph.plugin.particles.config;

import com.gempukku.libgdx.graph.data.NodeConfigurationImpl;
import com.gempukku.libgdx.graph.pipeline.producer.node.GraphNodeOutputImpl;
import com.gempukku.libgdx.graph.shader.ShaderFieldType;

public class ParticleRandomShaderNodeConfiguration extends NodeConfigurationImpl<ShaderFieldType> {
    public ParticleRandomShaderNodeConfiguration() {
        super("ParticleRandom", "Particle random", "Particle");
        addNodeOutput(
                new GraphNodeOutputImpl<ShaderFieldType>("value", "Value", ShaderFieldType.Float));
    }
}
