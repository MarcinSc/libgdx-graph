package com.gempukku.libgdx.graph.pipeline.property;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.gempukku.libgdx.graph.pipeline.PipelineFieldType;
import com.gempukku.libgdx.graph.pipeline.impl.WritablePipelineProperty;
import org.json.simple.JSONObject;

import java.util.function.Supplier;

public class LightsPipelinePropertyProducer implements PipelinePropertyProducer {
    @Override
    public PipelineFieldType getType() {
        return PipelineFieldType.Lights;
    }

    @Override
    public WritablePipelineProperty createProperty(JSONObject data) {
        return new WritablePipelineProperty(PipelineFieldType.Lights,
                new Supplier<Environment>() {
                    @Override
                    public Environment get() {
                        return null;
                    }
                });
    }
}
