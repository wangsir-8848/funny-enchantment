package com.funnyenchantment.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
public class TetanusEnchantment extends Enchantment {
    public TetanusEnchantment(Rarity rarity, EquipmentSlot... slotTypes) {
        super(rarity, EnchantmentTarget.WEAPON, slotTypes);
    }
    //最大附魔等级为1
    //getMaxLevel 原版默认为1 不用修改
}
