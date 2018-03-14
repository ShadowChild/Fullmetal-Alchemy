package io.github.shadowchild.fma.damage;


import net.minecraft.util.DamageSource;

public class FakeStoneDamageSource extends DamageSource {

    public FakeStoneDamageSource() {

        super("fake_stone");
    }

    @Override
    public boolean canHarmInCreative() {

        return true;
    }

    @Override
    public boolean isUnblockable() {

        return true;
    }

    @Override
    public boolean isMagicDamage() {

        return true;
    }
}
