package com.gempukku.libgdx.graph.ui.shader.common;

import com.gempukku.libgdx.graph.shader.ShaderFieldType;
import com.gempukku.libgdx.graph.shader.config.common.effect.FresnelEffectShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.effect.IntensityShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.lighting.AmbientLightShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.lighting.ApplyNormalMapShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.lighting.CalculateLightingShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.lighting.DirectionalLightShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.lighting.PointLightShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.lighting.SpotLightShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.arithmetic.AddShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.arithmetic.DivideShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.arithmetic.MultiplyShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.arithmetic.OneMinusShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.arithmetic.SubtractShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.AbsShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.CeilingShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.ClampShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.FloorShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.FractionalPartShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.LerpShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.MaximumShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.MinimumShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.ModuloShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.SaturateShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.SignShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.SmoothstepShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.common.StepShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.exponential.ExponentialBase2ShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.exponential.ExponentialShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.exponential.InverseSquareRootShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.exponential.LogarithmBase2ShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.exponential.NaturalLogarithmShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.exponential.PowerShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.exponential.SquareRootShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.geometric.CrossProductShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.geometric.DistanceShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.geometric.DotProductShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.geometric.LengthShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.geometric.NormalizeShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.trigonometry.ArccosShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.trigonometry.ArcsinShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.trigonometry.ArctanShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.trigonometry.CosShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.trigonometry.DegreesShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.trigonometry.RadiansShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.trigonometry.SinShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.trigonometry.TanShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.utility.DistanceFromPlaneShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.value.MergeShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.value.RemapShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.math.value.SplitShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.noise.PerlinNoise2DNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.noise.PerlinNoise3DNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.noise.SimplexNoise2DNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.noise.SimplexNoise3DNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.noise.VoronoiBorder2DNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.noise.VoronoiBorder3DNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.noise.VoronoiDistance2DNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.noise.VoronoiDistance3DNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.provided.CameraDirectionShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.provided.CameraPositionShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.provided.FragmentCoordinateShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.provided.PixelSizeShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.provided.SceneDepthShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.provided.ScreenPositionShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.provided.ViewportSizeShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.shape.CheckerboardShapeShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.shape.DotShapeShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.shape.EllipseShapeShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.shape.RectangleShapeShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.texture.Sampler2DShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.value.ValueBooleanShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.value.ValueColorShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.value.ValueFloatShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.value.ValueVector2ShaderNodeConfiguration;
import com.gempukku.libgdx.graph.shader.config.common.value.ValueVector3ShaderNodeConfiguration;
import com.gempukku.libgdx.graph.ui.UIGraphConfiguration;
import com.gempukku.libgdx.graph.ui.graph.property.PropertyBoxProducer;
import com.gempukku.libgdx.graph.ui.producer.GraphBoxProducer;
import com.gempukku.libgdx.graph.ui.producer.GraphBoxProducerImpl;
import com.gempukku.libgdx.graph.ui.producer.IndexedBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.property.PropertyColorBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.property.PropertyFloatBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.property.PropertyShaderGraphBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.property.PropertyTextureBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.property.PropertyVector2BoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.property.PropertyVector3BoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.provided.SceneColorShaderBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.provided.TimeShaderBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.value.ValueBooleanBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.value.ValueColorBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.value.ValueFloatBoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.value.ValueVector2BoxProducer;
import com.gempukku.libgdx.graph.ui.shader.common.producer.value.ValueVector3BoxProducer;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class UICommonShaderConfiguration implements UIGraphConfiguration<ShaderFieldType> {
    public static Set<GraphBoxProducer<ShaderFieldType>> graphBoxProducers = new LinkedHashSet<>();
    public static Map<String, PropertyBoxProducer<ShaderFieldType>> propertyProducers = new LinkedHashMap<>();

    static {
        graphBoxProducers.add(new PropertyShaderGraphBoxProducer());

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new CalculateLightingShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ApplyNormalMapShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new AmbientLightShaderNodeConfiguration()));
        graphBoxProducers.add(new IndexedBoxProducer<ShaderFieldType>(new DirectionalLightShaderNodeConfiguration()));
        graphBoxProducers.add(new IndexedBoxProducer<ShaderFieldType>(new PointLightShaderNodeConfiguration()));
        graphBoxProducers.add(new IndexedBoxProducer<ShaderFieldType>(new SpotLightShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new Sampler2DShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new AddShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SubtractShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new OneMinusShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new MultiplyShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new DivideShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new PowerShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ExponentialShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ExponentialBase2ShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new NaturalLogarithmShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new LogarithmBase2ShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SquareRootShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new InverseSquareRootShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SinShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new CosShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new TanShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ArcsinShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ArccosShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ArctanShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new RadiansShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new DegreesShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new AbsShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SignShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new FloorShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new CeilingShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new FractionalPartShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ModuloShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new MinimumShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new MaximumShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ClampShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SaturateShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new LerpShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new StepShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SmoothstepShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new LengthShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new DistanceShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new DotProductShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new CrossProductShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new NormalizeShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new DistanceFromPlaneShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SplitShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new MergeShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new RemapShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new IntensityShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new FresnelEffectShaderNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SimplexNoise2DNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SimplexNoise3DNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new PerlinNoise2DNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new PerlinNoise3DNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new VoronoiDistance2DNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new VoronoiDistance3DNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new VoronoiBorder2DNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new VoronoiBorder3DNodeConfiguration()));

        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new DotShapeShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new CheckerboardShapeShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new EllipseShapeShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new RectangleShapeShaderNodeConfiguration()));

        graphBoxProducers.add(new TimeShaderBoxProducer());
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new CameraPositionShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new CameraDirectionShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new FragmentCoordinateShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new SceneDepthShaderNodeConfiguration()));
        graphBoxProducers.add(new SceneColorShaderBoxProducer());
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ScreenPositionShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new PixelSizeShaderNodeConfiguration()));
        graphBoxProducers.add(new GraphBoxProducerImpl<ShaderFieldType>(new ViewportSizeShaderNodeConfiguration()));

        graphBoxProducers.add(new ValueColorBoxProducer<ShaderFieldType>(new ValueColorShaderNodeConfiguration()));
        graphBoxProducers.add(new ValueFloatBoxProducer<ShaderFieldType>(new ValueFloatShaderNodeConfiguration()));
        graphBoxProducers.add(new ValueVector2BoxProducer<ShaderFieldType>(new ValueVector2ShaderNodeConfiguration()));
        graphBoxProducers.add(new ValueVector3BoxProducer<ShaderFieldType>(new ValueVector3ShaderNodeConfiguration()));
        graphBoxProducers.add(new ValueBooleanBoxProducer<ShaderFieldType>(new ValueBooleanShaderNodeConfiguration()));

        propertyProducers.put("Float", new PropertyFloatBoxProducer());
        propertyProducers.put("Vector2", new PropertyVector2BoxProducer());
        propertyProducers.put("Vector3", new PropertyVector3BoxProducer());
        propertyProducers.put("Color", new PropertyColorBoxProducer());
        propertyProducers.put("Texture", new PropertyTextureBoxProducer());
    }

    @Override
    public Set<GraphBoxProducer<ShaderFieldType>> getGraphBoxProducers() {
        return graphBoxProducers;
    }

    @Override
    public Map<String, PropertyBoxProducer<ShaderFieldType>> getPropertyBoxProducers() {
        return propertyProducers;
    }
}