package com.gempukku.libgdx.graph.pipeline.property;

import com.badlogic.gdx.math.Vector2;
import com.gempukku.libgdx.graph.pipeline.PipelineFieldType;
import com.gempukku.libgdx.graph.pipeline.impl.WritablePipelineProperty;
import org.json.simple.JSONObject;

import java.util.function.Supplier;

public class Vector2PipelinePropertyProducer implements PipelinePropertyProducer {
    @Override
    public PipelineFieldType getType() {
        return PipelineFieldType.Vector2;
    }

    @Override
    public WritablePipelineProperty createProperty(JSONObject data) {
        final float x = ((Number) data.get("x")).floatValue();
        final float y = ((Number) data.get("y")).floatValue();
        return new WritablePipelineProperty(PipelineFieldType.Vector2,
                new Supplier<Vector2>() {
                    @Override
                    public Vector2 get() {
                        return new Vector2(x, y);
                    }
                });
    }
}
