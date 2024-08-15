package com.funnyenchantment.registry;

import com.funnyenchantment.enchantment.KindnessEnchantment;
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

    public static final KindnessEnchantment KINDNESS = new KindnessEnchantment(Enchantment.Rarity.UNCOMMON,
            EnchantmentTarget.WEAPON,
            EquipmentSlot.MAINHAND);

    public static void register() {
        register("kindness", KINDNESS);
    }
    private static void register(String name, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, Utils.getIdentifier(name), enchantment);
    }
}
