package com.funnyenchantment.registry;

import com.funnyenchantment.enchantment.KindnessEnchantment;
import com.funnyenchantment.enchantment.TetanusEnchantment;
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

    public static void register() {
        register("kindness", KINDNESS);
        register("tetanus", TETANUS);
    }

    private static void register(String name, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, Utils.getIdentifier(name), enchantment);
    }
}
