package com.funnyenchantment.registry;

import com.funnyenchantment.enchantment.*;
import com.funnyenchantment.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
public class EnchantmentRegister {

    //附魔概率极低,非常稀有
    public static final KindnessEnchantment KINDNESS = new KindnessEnchantment(Enchantment.properties(ItemTags.SWORD_ENCHANTABLE
            , 2, 3, Enchantment.leveledCost(10, 10), Enchantment.leveledCost(10, 10), 4, EquipmentSlot.MAINHAND));

    public static final TetanusEnchantment TETANUS = new TetanusEnchantment(Enchantment.properties(ItemTags.SWORD_ENCHANTABLE
            , 2,1, Enchantment.leveledCost(10, 10), Enchantment.leveledCost(10, 10), 4, EquipmentSlot.MAINHAND));

    public static final MoreExpEnchantment MORE_EXP = new MoreExpEnchantment(Enchantment.properties(ItemTags.SWORD_ENCHANTABLE
            , 2,1, Enchantment.leveledCost(10, 10), Enchantment.leveledCost(10, 10), 4, EquipmentSlot.MAINHAND));

    public static final SuperJumpEnchantment SUPER_JUMP = new SuperJumpEnchantment(Enchantment.properties(ItemTags.FOOT_ARMOR_ENCHANTABLE
            , 2,5, Enchantment.leveledCost(10, 10), Enchantment.leveledCost(10, 10), 4, EquipmentSlot.FEET));

    public static final VampirismEnchantment VAMPIRISM = new VampirismEnchantment(Enchantment.properties(ItemTags.SWORD_ENCHANTABLE
            , 2,5, Enchantment.leveledCost(10, 10), Enchantment.leveledCost(10, 10), 4, EquipmentSlot.MAINHAND));

    public static final LavaWalkerEnchantment LAVA_WALKER =
            new LavaWalkerEnchantment(Enchantment.properties(ItemTags.FOOT_ARMOR_ENCHANTABLE
            , 2,1, Enchantment.leveledCost(10, 10), Enchantment.leveledCost(10, 10), 4, EquipmentSlot.FEET));

    public static final DoubleJumpEnchantment DOUBLE_JUMP =
            new DoubleJumpEnchantment(Enchantment.properties(ItemTags.FOOT_ARMOR_ENCHANTABLE
            ,2,1,Enchantment.leveledCost(10,19),Enchantment.leveledCost(10,10),4, EquipmentSlot.FEET));

    public static void register() {
        register("kindness", KINDNESS);
        register("tetanus", TETANUS);
        register("more_exp", MORE_EXP);
        register("super_jump", SUPER_JUMP);
        register("vampirism", VAMPIRISM);
        register("lava_walker", LAVA_WALKER);
        register("double_jump", DOUBLE_JUMP);
    }

    private static void register(String name, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, Utils.getIdentifier(name), enchantment);
    }
}
