package com.gempukku.libgdx.graph.pipeline.property;

import com.badlogic.gdx.graphics.Color;
import com.gempukku.libgdx.graph.pipeline.PipelineFieldType;
import com.gempukku.libgdx.graph.pipeline.impl.WritablePipelineProperty;
import org.json.simple.JSONObject;

import java.util.function.Supplier;

public class ColorPipelinePropertyProducer implements PipelinePropertyProducer {
    @Override
    public PipelineFieldType getType() {
        return PipelineFieldType.Color;
    }

    @Override
    public WritablePipelineProperty createProperty(JSONObject data) {
        final Color color = Color.valueOf((String) data.get("color"));
        return new WritablePipelineProperty(PipelineFieldType.Color,
                new Supplier<Color>() {
                    @Override
                    public Color get() {
                        return color;
                    }
                });
    }
}
