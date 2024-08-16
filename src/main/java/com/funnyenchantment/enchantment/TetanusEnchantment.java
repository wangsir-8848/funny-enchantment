package com.funnyenchantment.enchantment;

import com.funnyenchantment.registry.EffectRegister;
import com.funnyenchantment.registry.EnchantmentRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

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

    /**
     * 这个附魔不能和仁慈附魔同时存在
     * @param other
     * @return
     */
    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != EnchantmentRegister.KINDNESS;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {


        //当玩家主手拿的带有破伤风附魔的工具时 目标将会添加一个持续流血的效果,直到死亡
        //有概率打上该效果   50%的概率
        //但是一次会调用两次这个方法 所以 得修改下
        if (target instanceof LivingEntity target1) {
            if (user.getRandom().nextInt(4)==1) {
                target1.addStatusEffect(new StatusEffectInstance(EffectRegister.TETANUS, Integer.MAX_VALUE, 1));
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
