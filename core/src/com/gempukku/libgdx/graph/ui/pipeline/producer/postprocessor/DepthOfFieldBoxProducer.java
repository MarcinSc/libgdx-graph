package com.gempukku.libgdx.graph.ui.pipeline.producer.postprocessor;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.JsonValue;
import com.gempukku.libgdx.graph.pipeline.PipelineFieldType;
import com.gempukku.libgdx.graph.pipeline.config.postprocessor.DepthOfFieldPipelineNodeConfiguration;
import com.gempukku.libgdx.graph.ui.graph.GraphBox;
import com.gempukku.libgdx.graph.ui.graph.GraphBoxImpl;
import com.gempukku.libgdx.graph.ui.part.CheckboxBoxPart;
import com.gempukku.libgdx.graph.ui.part.FloatBoxPart;
import com.gempukku.libgdx.graph.ui.producer.GraphBoxProducerImpl;
import com.kotcrab.vis.ui.util.Validators;

public class DepthOfFieldBoxProducer extends GraphBoxProducerImpl<PipelineFieldType> {
    public DepthOfFieldBoxProducer() {
        super(new DepthOfFieldPipelineNodeConfiguration());
    }

    @Override
    public GraphBox<PipelineFieldType> createPipelineGraphBox(Skin skin, String id, JsonValue data) {
        GraphBoxImpl<PipelineFieldType> result = createGraphBox(skin, id);

        FloatBoxPart<PipelineFieldType> maxBlurPart = new FloatBoxPart<>(skin, "Max blur", "maxBlur", 10, new Validators.GreaterThanValidator(0, false));
        maxBlurPart.setValue(10f);
        if (data != null)
            maxBlurPart.initialize(data);
        result.addGraphBoxPart(maxBlurPart);

        CheckboxBoxPart<PipelineFieldType> blurBackground = new CheckboxBoxPart<>(skin, "Blur background", "blurBackground");
        blurBackground.setValue(false);
        if (data != null)
            blurBackground.initialize(data);
        result.addGraphBoxPart(blurBackground);

        addConfigurationInputsAndOutputs(skin, result);
        return result;
    }
}
