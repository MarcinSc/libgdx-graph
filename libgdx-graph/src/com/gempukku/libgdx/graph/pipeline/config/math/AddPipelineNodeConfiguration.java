package com.gempukku.libgdx.graph.pipeline.config.math;

import com.gempukku.libgdx.graph.NodeConfigurationImpl;
import com.gempukku.libgdx.graph.pipeline.PipelineFieldType;
import com.gempukku.libgdx.graph.pipeline.loader.node.GraphNodeInputImpl;
import com.gempukku.libgdx.graph.pipeline.loader.node.GraphNodeOutputImpl;

import static com.gempukku.libgdx.graph.pipeline.PipelineFieldType.Color;
import static com.gempukku.libgdx.graph.pipeline.PipelineFieldType.Float;
import static com.gempukku.libgdx.graph.pipeline.PipelineFieldType.Vector2;
import static com.gempukku.libgdx.graph.pipeline.PipelineFieldType.Vector3;

public class AddPipelineNodeConfiguration extends NodeConfigurationImpl<PipelineFieldType> {
    public AddPipelineNodeConfiguration() {
        super("Add", "Add");
        addNodeInput(
                new GraphNodeInputImpl<PipelineFieldType>("inputA", "A", true,
                        Color, Vector3, Vector2, Float));
        addNodeInput(
                new GraphNodeInputImpl<PipelineFieldType>("inputB", "B", true,
                        Color, Vector3, Vector2, Float));
        addNodeOutput(
                new GraphNodeOutputImpl<PipelineFieldType>("output", "Result",
                        Float, Vector2, Vector3, Color));
    }
}