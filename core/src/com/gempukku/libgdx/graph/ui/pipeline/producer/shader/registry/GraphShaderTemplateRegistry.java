package com.gempukku.libgdx.graph.ui.pipeline.producer.shader.registry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class GraphShaderTemplateRegistry {
    public static Array<GraphShaderTemplate> modelShaderTemplateList = new Array<>();
    public static Array<GraphShaderTemplate> particlesShaderTemplateList = new Array<>();
    public static Array<GraphShaderTemplate> spriteShaderTemplateList = new Array<>();

    static {
        modelShaderTemplateList.add(
                new FileGraphShaderTemplate("Empty", Gdx.files.classpath("template/model/empty-model-shader.json")));
        modelShaderTemplateList.add(null);
        modelShaderTemplateList.add(
                new LoadFileGraphShaderTemplate("From file..."));

        particlesShaderTemplateList.add(
                new FileGraphShaderTemplate("Empty billboard", Gdx.files.classpath("template/particles/empty-billboard-particles-shader.json")));
        particlesShaderTemplateList.add(null);
        particlesShaderTemplateList.add(
                new LoadFileGraphShaderTemplate("From file..."));

        spriteShaderTemplateList.add(
                new FileGraphShaderTemplate("Empty", Gdx.files.classpath("template/sprite/empty-sprite-shader.json")));
        spriteShaderTemplateList.add(null);
        spriteShaderTemplateList.add(
                new FileGraphShaderTemplate("Animated Sprite", Gdx.files.classpath("template/sprite/animated-sprite-shader.json")));
        spriteShaderTemplateList.add(
                new FileGraphShaderTemplate("Tiled Sprite", Gdx.files.classpath("template/sprite/tiled-sprite-shader.json")));
        spriteShaderTemplateList.add(null);
        spriteShaderTemplateList.add(
                new LoadFileGraphShaderTemplate("From file..."));
    }

    private GraphShaderTemplateRegistry() {

    }
}
