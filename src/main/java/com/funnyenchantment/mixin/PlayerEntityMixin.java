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
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
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


    // 二段跳状态
    @Unique private boolean canDoubleJump = false;
    @Unique private boolean hasDoubleJumped = false;
    @Shadow public void incrementStat(Identifier stat){};
    @Shadow public void addExhaustion(float exhaustion){};


    @Inject(method = "jump",at = @At("HEAD"))
    public void jumpHead(CallbackInfo ci) {
        //检查是否存在二段跳附魔
        if(hasDoubleJumpedEnchantment()){
            if (this.isOnGround()){
                //如果是在地面上  正常跳跃 重置二段跳
                canDoubleJump = true;
                hasDoubleJumped = false;
            } else if (canDoubleJump && !hasDoubleJumped) {
                // 目前状态是在空中
                // 那就进行二段跳
                float f = this.getJumpVelocity();
                if (!(f <= 1.0E-5F)) {
                    Vec3d vec3d = this.getVelocity();
                    this.setVelocity(vec3d.x, (double)f, vec3d.z);
                    if (this.isSprinting()) {
                        float g = this.getYaw() * (float) (Math.PI / 180.0);
                        this.addVelocity(new Vec3d((double)(-MathHelper.sin(g)) * 0.2, 0.0, (double)MathHelper.cos(g) * 0.2));
                    }
                    this.velocityDirty = true;
                }
                // 标记已使用二段跳
                hasDoubleJumped = true;
                // TODO  减少下落伤害的标记   有点小问题
                this.fallDistance = 0;
                this.incrementStat(Stats.JUMP);
                if (this.isSprinting()) {
                    this.addExhaustion(0.4F);
                } else {
                    this.addExhaustion(0.1F);
                }
                ci.cancel();
            }
        }else {
            canDoubleJump = false;
            hasDoubleJumped = false;
        }
    }

    @Unique
    private boolean hasDoubleJumpedEnchantment() {
        ItemStack equippedStack = getEquippedStack(EquipmentSlot.FEET);
        if (EnchantmentHelper.getLevel(EnchantmentRegister.DOUBLE_JUMP, equippedStack) > 0) {
            return true;
        }
        return false;
    }
}
