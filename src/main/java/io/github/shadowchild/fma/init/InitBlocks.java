package io.github.shadowchild.fma.init;


import io.github.shadowchild.fma.content.block.TransmuteRuneBlock;
import io.github.shadowchild.fma.content.block.rune.RuneBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class InitBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final List<Item> ITEM_BLOCKS = new ArrayList<>();
    public static final List<RuneBlock> RUNES = new ArrayList<>();

    public static final Material RUNE = new Material(MapColor.GRAY);

    // Alchemic Blocks

    // Runes
    public static RuneBlock rune_air = new RuneBlock("rune_air", RuneBlock.RuneType.AIR);
    public static RuneBlock rune_earth = new RuneBlock("rune_earth", RuneBlock.RuneType.EARTH);
    public static RuneBlock rune_fire = new RuneBlock("rune_fire", RuneBlock.RuneType.FIRE);
    public static RuneBlock rune_water = new RuneBlock("rune_water", RuneBlock.RuneType.WATER);
    
    public static RuneBlock rune_sulfur = new RuneBlock("rune_sulfur", RuneBlock.RuneType.SULFUR);
    public static RuneBlock rune_mercury = new RuneBlock("rune_mercury", RuneBlock.RuneType.MERCURY);
    public static RuneBlock rune_salt = new RuneBlock("rune_salt", RuneBlock.RuneType.SALT);
    
    public static RuneBlock rune_copper = new RuneBlock("rune_copper", RuneBlock.RuneType.COPPER);
    public static RuneBlock rune_silver = new RuneBlock("rune_silver", RuneBlock.RuneType.SILVER);
    public static RuneBlock rune_gold = new RuneBlock("rune_gold", RuneBlock.RuneType.GOLD);
    public static RuneBlock rune_iron = new RuneBlock("rune_iron", RuneBlock.RuneType.IRON);
    public static RuneBlock rune_antimony = new RuneBlock("rune_antimony", RuneBlock.RuneType.ANTIMONY);
    public static RuneBlock rune_tin = new RuneBlock("rune_tin", RuneBlock.RuneType.TIN);
    public static RuneBlock rune_platinum = new RuneBlock("rune_platinum", RuneBlock.RuneType.PLATINUM);
    public static RuneBlock rune_lead = new RuneBlock("rune_lead", RuneBlock.RuneType.LEAD);
    public static RuneBlock rune_arsenic = new RuneBlock("rune_arsenic", RuneBlock.RuneType.ARSENIC);
    public static RuneBlock rune_phosphorus = new RuneBlock("rune_phosphorus", RuneBlock.RuneType.PHOSPHORUS);
    public static RuneBlock rune_bismuth = new RuneBlock("rune_bismuth", RuneBlock.RuneType.BISMUTH);
    public static RuneBlock rune_magnesium = new RuneBlock("rune_magnesium", RuneBlock.RuneType.MAGNESIUM);
    public static RuneBlock rune_zinc = new RuneBlock("rune_zinc", RuneBlock.RuneType.ZINC);
    public static RuneBlock rune_potash = new RuneBlock("rune_potash", RuneBlock.RuneType.POTASH);

    public static TransmuteRuneBlock crafting_rune = new TransmuteRuneBlock("transmute_rune");
}
