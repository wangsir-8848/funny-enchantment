package com.funnyenchantment.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description 持续流血状态
 */
public class TetanusStatusEffect extends InstantStatusEffect {
    public TetanusStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (entity.getHealth() > 0.0F) {
            entity.damage(entity.getDamageSources().magic(), 0.5F);
        }
        return true;
    }

}
