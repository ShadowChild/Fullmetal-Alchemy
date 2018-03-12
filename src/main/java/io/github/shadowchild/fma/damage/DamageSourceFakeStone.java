package io.github.shadowchild.fma.damage;


import net.minecraft.util.DamageSource;

public class DamageSourceFakeStone extends DamageSource {

    public DamageSourceFakeStone() {

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
