package com.funnyenchantment.generator;

import com.funnyenchantment.generator.lang.ChineseLangProvider;
import com.funnyenchantment.generator.lang.EnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description 自动生成对应的数据资源
 */
public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(EnglishLangProvider::new);
        pack.addProvider(ChineseLangProvider::new);
    }
}
