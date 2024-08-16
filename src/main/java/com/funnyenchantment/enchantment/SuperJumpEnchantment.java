package com.funnyenchantment.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/16
 * @description TDDD
 */
public class SuperJumpEnchantment extends Enchantment {
    public SuperJumpEnchantment(Rarity rarity,  EquipmentSlot... slotTypes) {
        super(rarity, EnchantmentTarget.ARMOR_FEET, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

}
