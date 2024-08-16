package com.funnyenchantment;

import net.minecraft.util.math.random.Random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
public class Test {
//    public static final StatusEffect JUMP_BOOST = StatusEffects.register("jump_boost", new StatusEffect(StatusEffectCategory.BENEFICIAL, 16646020));
    public static void main(String[] args) {
          Random random = Random.create();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 2000; i++) {
            int randomInt = random.nextInt(5);
            map.put(randomInt, map.getOrDefault(randomInt, 0)+1);
        }
        map.forEach((k, v) -> System.out.println(k + ":" + v+"   "+(double)v/2000));
    }

}
