package io.github.shadowchild.fma.api;


import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;

import java.util.ArrayList;
import java.util.List;

/**
 * The main API class for the Mod Fullmetal Alchemy
 */
public class FullmetalAPI {

    public static final Material RUNE = new Material(MapColor.GRAY);

    /**
     * List for blacklisted Entities.
     * Any Entity registered here will not 'Have a soul' and will not 'charge' a Soul Vessel
     */
    private static final List<Class<? extends EntityLivingBase>> ENTITY_SOUL_BLACKLIST = new ArrayList<>();

    /**
     * @return the List of blacklisted Entities
     */
    public static List<Class<? extends EntityLivingBase>> getEntitySoulBlacklist() {

        return ENTITY_SOUL_BLACKLIST;
    }

    /**
     * @param toBlacklist The Class of the Entity to be blacklisted
     */
    public static void addEntityToSoulBlacklist(Class<? extends EntityLivingBase> toBlacklist) {

        getEntitySoulBlacklist().add(toBlacklist);
    }

    /**
     * @param toBlacklist a List of Classes to be blacklisted
     */
    public static void addEntityToSoulBlacklist(List<Class<? extends EntityLivingBase>> toBlacklist) {

        getEntitySoulBlacklist().addAll(toBlacklist);
    }
}
