package com.funnyenchantment.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/20
 * @description
 *
 * 总体设计还是得修改玩家的jump()方法。但是具体地调用流程等到实际debug后看如何处理二段跳逻辑
 */
public class DoubleJumpEnchantment extends Enchantment {

    public DoubleJumpEnchantment(Properties properties) {
        super(properties);
    }

}
