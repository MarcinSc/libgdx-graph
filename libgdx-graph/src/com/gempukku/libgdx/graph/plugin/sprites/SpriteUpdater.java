package com.gempukku.libgdx.graph.plugin.sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public interface SpriteUpdater {
    void processUpdate(Vector3 position, Vector2 size, Vector2 anchor);
}
