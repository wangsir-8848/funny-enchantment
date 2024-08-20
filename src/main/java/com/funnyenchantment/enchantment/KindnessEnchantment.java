package com.funnyenchantment.enchantment;

import com.funnyenchantment.registry.EnchantmentRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description 仁慈
 */
public class KindnessEnchantment extends Enchantment {
    public KindnessEnchantment(Enchantment.Rarity rarity, EquipmentSlot... slotTypes) {
        //这本附魔书只能给武器使用
        super(rarity, EnchantmentTarget.WEAPON, slotTypes);
    }

    //最大附魔等级为1
    //getMaxLevel 原版默认为1 不用修改
    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != EnchantmentRegister.TETANUS;
    }
}
