package com.funnyenchantment.mixin;

import com.funnyenchantment.registry.EnchantmentRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "attack", at = @At("HEAD"), cancellable = true)
    public void attackEntity(Entity target, CallbackInfo ci) {
        if (target instanceof LivingEntity) {
            if (EnchantmentHelper.getLevel(EnchantmentRegister.KINDNESS, this.getMainHandStack()) == 1) {
                //当玩家主手拿的带有仁慈附魔的工具时 将被攻击者进行更远的击飞效果
                target.addVelocity(0, 0.5, 0);
                Vec3d velocity = target.getVelocity();
                target.setVelocity(velocity.x + 10, velocity.y + 10, velocity.z + 10);
                ci.cancel();
            }
//            if (EnchantmentHelper.getLevel(EnchantmentRegister.TETANUS, this.getMainHandStack()) == 1) {
//                //当玩家主手拿的带有破伤风附魔的工具时 目标将会添加一个持续流血的效果,直到死亡
//                //有概率打上该效果   50%的概率
//                if (this.random.nextInt(2) == 1) {
//                    target1.addStatusEffect(new StatusEffectInstance(EffectRegister.TETANUS, Integer.MAX_VALUE, 1));
//                }
//           }
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tickHead(CallbackInfo ci) {
        ItemStack equippedStack = getEquippedStack(EquipmentSlot.FEET);
        int superJumpLevel;
        if ((superJumpLevel = EnchantmentHelper.getLevel(EnchantmentRegister.SUPER_JUMP, equippedStack)) > 0) {
            //超级跳跃 持续30秒 没有粒子效果,显示图标
            StatusEffectInstance supperJumpEffect = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 30,
                    superJumpLevel, false
                    , false, true);
            if (this.getStatusEffect(StatusEffects.JUMP_BOOST) == null) {
                this.addStatusEffect(supperJumpEffect);
            } else if (this.getStatusEffect(StatusEffects.JUMP_BOOST).getDuration() < 20) {
                this.addStatusEffect(supperJumpEffect);
            }
        }
    }
}
