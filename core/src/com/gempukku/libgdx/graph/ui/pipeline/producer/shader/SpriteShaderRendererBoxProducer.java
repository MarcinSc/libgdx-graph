package com.gempukku.libgdx.graph.ui.pipeline.producer.shader;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.JsonValue;
import com.gempukku.libgdx.graph.pipeline.PipelineFieldType;
import com.gempukku.libgdx.graph.pipeline.config.rendering.SpriteShaderRendererPipelineNodeConfiguration;
import com.gempukku.libgdx.graph.ui.graph.GraphBox;
import com.gempukku.libgdx.graph.ui.graph.GraphBoxImpl;
import com.gempukku.libgdx.graph.ui.producer.GraphBoxProducerImpl;

public class SpriteShaderRendererBoxProducer extends GraphBoxProducerImpl<PipelineFieldType> {
    public SpriteShaderRendererBoxProducer() {
        super(new SpriteShaderRendererPipelineNodeConfiguration());
    }

    @Override
    public GraphBox<PipelineFieldType> createPipelineGraphBox(Skin skin, String id, JsonValue data) {
        GraphBoxImpl<PipelineFieldType> result = createGraphBox(skin, id);
        addConfigurationInputsAndOutputs(skin, result);
        SpriteShadersBoxPart graphBoxPart = new SpriteShadersBoxPart(skin);
        graphBoxPart.initialize(data);
        result.addGraphBoxPart(graphBoxPart);
        return result;
    }
}