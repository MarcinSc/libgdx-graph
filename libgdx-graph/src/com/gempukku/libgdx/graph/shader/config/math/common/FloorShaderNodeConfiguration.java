package com.gempukku.libgdx.graph.shader.config.math.common;

import com.gempukku.libgdx.graph.NodeConfigurationImpl;
import com.gempukku.libgdx.graph.SameTypeOutputTypeFunction;
import com.gempukku.libgdx.graph.pipeline.loader.node.GraphNodeInputImpl;
import com.gempukku.libgdx.graph.pipeline.loader.node.GraphNodeOutputImpl;
import com.gempukku.libgdx.graph.shader.ShaderFieldType;

public class FloorShaderNodeConfiguration extends NodeConfigurationImpl<ShaderFieldType> {
    public FloorShaderNodeConfiguration() {
        super("Floor", "Floor", "Math/Common");
        addNodeInput(
                new GraphNodeInputImpl<ShaderFieldType>("input", "Input", true, ShaderFieldType.Vector4, ShaderFieldType.Vector3, ShaderFieldType.Vector2, ShaderFieldType.Float));
        addNodeOutput(
                new GraphNodeOutputImpl<ShaderFieldType>("output", "Result",
                        new SameTypeOutputTypeFunction<ShaderFieldType>("input"),
                        ShaderFieldType.Float, ShaderFieldType.Vector2, ShaderFieldType.Vector3, ShaderFieldType.Vector4));
    }
}
