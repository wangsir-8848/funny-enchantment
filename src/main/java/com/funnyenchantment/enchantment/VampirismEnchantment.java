package com.funnyenchantment.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/16
 * @description 吸血书
 */
public class VampirismEnchantment extends Enchantment {
    public VampirismEnchantment(Enchantment.Properties properties) {
        super(properties);
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
