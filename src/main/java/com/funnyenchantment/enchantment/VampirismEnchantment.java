package com.funnyenchantment.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/16
 * @description 吸血书
 */
public class VampirismEnchantment extends Enchantment {
    public VampirismEnchantment(Rarity rarity, EquipmentSlot... slotTypes) {
        super(rarity, EnchantmentTarget.WEAPON, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        // 20%的几率 吸血
        if (user.getRandom().nextInt(10) == 1) {
            user.heal((float) (0.5 * level));
        }
        super.onTargetDamaged(user, target, level);
    }
}
