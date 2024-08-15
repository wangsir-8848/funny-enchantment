package com.funnyenchantment.config;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/7/24
 * @description TDDD
 */
public class ModBaseInfo {

    //一些基本信息
    public static final String MOD_ID = "funnyenchantment";

    public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();

    public static final String MOD_VERSION  = MOD_CONTAINER.getMetadata().getVersion().toString();

    public static final String MOD_NAME = MOD_CONTAINER.getMetadata().getName();

}
