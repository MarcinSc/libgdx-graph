package com.gempukku.libgdx.graph.pipeline;

import com.gempukku.libgdx.graph.data.FieldType;

public enum PipelineFieldType implements FieldType {
    Float, Vector2, Vector3, Color, Boolean,
    Camera, RenderPipeline, Callback;

    @Override
    public boolean accepts(Object value) {
        switch (this) {
            case Float:
                return value instanceof Float;
            case Vector2:
                return value instanceof com.badlogic.gdx.math.Vector2;
            case Vector3:
                return value instanceof com.badlogic.gdx.math.Vector3;
            case Color:
                return value instanceof com.badlogic.gdx.graphics.Color;
            case Boolean:
                return value instanceof Boolean;
            case RenderPipeline:
                return value instanceof com.gempukku.libgdx.graph.pipeline.RenderPipeline;
            case Camera:
                return value instanceof com.badlogic.gdx.graphics.Camera;
            case Callback:
                return value instanceof CustomRenderCallback;
        }
        return false;
    }

    @Override
    public Object convert(Object value) {
        return value;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public boolean isTexture() {
        return false;
    }
}
