package com.funnyenchantment.registry;

import com.funnyenchantment.enchantment.*;
import com.funnyenchantment.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
public class EnchantmentRegister {

    //附魔概率极低,非常稀有
    public static final KindnessEnchantment KINDNESS = new KindnessEnchantment(Enchantment.Rarity.VERY_RARE,
            EquipmentSlot.MAINHAND);

    public static final TetanusEnchantment TETANUS = new TetanusEnchantment(Enchantment.Rarity.VERY_RARE,
            EquipmentSlot.MAINHAND);

    public static final MoreExpEnchantment MORE_EXP = new MoreExpEnchantment(Enchantment.Rarity.COMMON,
            EquipmentSlot.MAINHAND);

    public static final SuperJumpEnchantment SUPER_JUMP = new SuperJumpEnchantment(Enchantment.Rarity.COMMON,
            EquipmentSlot.FEET);

    public static final VampirismEnchantment VAMPIRISM = new VampirismEnchantment(Enchantment.Rarity.COMMON,
            EquipmentSlot.MAINHAND);

    public static void register() {
        register("kindness", KINDNESS);
        register("tetanus", TETANUS);
        register("more_exp", MORE_EXP);
        register("super_jump", SUPER_JUMP);
        register("vampirism", VAMPIRISM);
    }

    private static void register(String name, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, Utils.getIdentifier(name), enchantment);
    }
}
