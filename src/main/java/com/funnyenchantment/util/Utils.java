package com.funnyenchantment.util;

import com.funnyenchantment.config.ModBaseInfo;
import net.minecraft.util.Identifier;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/13
 * @description 工具类
 */
public class Utils {

    //获取标签
    public static Identifier getIdentifier(String path) {
        return new Identifier(ModBaseInfo.MOD_ID, path);
    }
}
