package io.github.shadowchild.fma.api;


public enum RuneType {

    // Base
    EARTH,
    FIRE,
    WATER,
    AIR,

    // Tria Prima
    SULFUR,
    MERCURY,
    SALT,

    // Other
    COPPER,
    SILVER,
    GOLD,
    IRON,
    ANTIMONY,
    TIN,
    PLATINUM,
    LEAD,
    ARSENIC,
    PHOSPHORUS,
    BISMUTH,
    MAGNESIUM,
    ZINC,
    POTASH;

    // TODO: Cut down

    public static RuneType getFromInt(int ordinal) {

        return RuneType.values()[ordinal];
    }

    public static RuneType getFromString(String identifier) {

        return RuneType.valueOf(identifier);
    }
}
