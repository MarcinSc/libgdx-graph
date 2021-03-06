package com.gempukku.libgdx.graph.shader.config.common.provided;

import com.gempukku.libgdx.graph.data.NodeConfigurationImpl;
import com.gempukku.libgdx.graph.pipeline.producer.node.GraphNodeOutputImpl;
import com.gempukku.libgdx.graph.shader.ShaderFieldType;

public class ScreenPositionShaderNodeConfiguration extends NodeConfigurationImpl<ShaderFieldType> {
    public ScreenPositionShaderNodeConfiguration() {
        super("ScreenPosition", "Screen position", "Provided");
        addNodeOutput(
                new GraphNodeOutputImpl<ShaderFieldType>("output", "Output", ShaderFieldType.Vector2));
    }
}
