package com.gempukku.libgdx.graph.pipeline.property;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gempukku.libgdx.graph.pipeline.PipelineFieldType;
import com.gempukku.libgdx.graph.pipeline.impl.WritablePipelineProperty;
import org.json.simple.JSONObject;

import java.util.function.Supplier;

public class StagePipelinePropertyProducer implements PipelinePropertyProducer {
    @Override
    public PipelineFieldType getType() {
        return PipelineFieldType.Stage;
    }

    @Override
    public WritablePipelineProperty createProperty(JSONObject data) {
        return new WritablePipelineProperty(PipelineFieldType.Stage,
                new Supplier<Stage>() {
                    @Override
                    public Stage get() {
                        return null;
                    }
                });
    }
}
