package com.gempukku.libgdx.graph.plugin.particles.generator;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Predicate;
import com.gempukku.libgdx.graph.plugin.particles.generator.value.FloatValue;

public class ParallelogramParticleGenerator<T> extends AbstractParticleGenerator<T> {
    private Vector3 origin = new Vector3();
    private Vector3 direction1 = new Vector3(1, 0, 0);
    private Vector3 direction2 = new Vector3(0, 1, 0);

    public ParallelogramParticleGenerator(float lifeLength) {
        super(lifeLength);
    }

    public ParallelogramParticleGenerator(float minLifeLength, float maxLifeLength) {
        super(minLifeLength, maxLifeLength);
    }

    public ParallelogramParticleGenerator(FloatValue lifeLength) {
        super(lifeLength);
    }

    public ParallelogramParticleGenerator(FloatValue lifeLength, Predicate<Vector3> locationPredicate) {
        super(lifeLength, locationPredicate);
    }

    public ParallelogramParticleGenerator(FloatValue lifeLength, Predicate<Vector3> locationPredicate, ParticleDataGenerator<T> particleDataGenerator) {
        super(lifeLength, locationPredicate, particleDataGenerator);
    }

    public Vector3 getOrigin() {
        return origin;
    }

    public Vector3 getDirection1() {
        return direction1;
    }

    public Vector3 getDirection2() {
        return direction2;
    }

    @Override
    protected void generateLocation(Vector3 location) {
        location.set(origin).mulAdd(direction1, MathUtils.random()).mulAdd(direction2, MathUtils.random());
    }
}
