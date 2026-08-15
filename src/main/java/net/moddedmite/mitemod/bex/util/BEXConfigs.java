package net.moddedmite.mitemod.bex.util;

import cn.wensc.mitemod.extreme.util.EXConfigs;
import net.xiaoyu233.fml.FishModLoader;

import java.io.*;
import java.util.*;

public class BEXConfigs extends EXConfigs {
    public static final String configFilePath = FishModLoader.CONFIG_DIR + File.separator + "beyond_extreme.cfg";

    public static Map <String, ConfigItem> bexConfigMap = new HashMap<>();

    public static class bexConfig {
        public static ConfigItem<Boolean> BlnFinsh = new ConfigItem("BlnFinsh", false, "是否开启急速钓鱼");
        public static ConfigItem<Double> skeletonBossMaxHealth = new ConfigItem("skeletonBossMaxHealth", 125d, "骷髅BOSS基础血量", 20d ,10000d);
        public static ConfigItem<Double> skeletonBossBaseDamage = new ConfigItem("skeletonBossBaseDamage", 12d, "骷髅BOSS基础攻击伤害", 1d ,100d);
        public static ConfigItem<Float> skeletonBossSpawnPercent = new ConfigItem("skeletonBossSpawnPercent", 0.5f, "挖掘刷怪笼多大几率刷出骷髅BOSS", 0f,1f);
        public static ConfigItem<Boolean> isSkeletonandZombieSpawnBoth = new ConfigItem("isSkeletonandZombieSpawnBoth", true, "是否有机会在挖掘刷怪笼时同时生成多种boss");
    }

    public static void loadConfigs() {
        bexConfigMap.put("BlnFinsh", bexConfig.BlnFinsh);
        bexConfigMap.put("skeletonBossMaxHealth", bexConfig.skeletonBossMaxHealth);
        bexConfigMap.put("skeletonBossBaseDamage", bexConfig.skeletonBossBaseDamage);
        bexConfigMap.put("skeletonBossSpawnPercent", bexConfig.skeletonBossSpawnPercent);
        bexConfigMap.put("isSkeletonandZombieSpawnBoth", bexConfig.isSkeletonandZombieSpawnBoth);

        EXConfigs.loadOrCreateFile(configFilePath, (fileObj, properties) -> {
            readConfigFromFile(fileObj, properties);
            packConfigFile(fileObj, properties);
        }, BEXConfigs::generateConfigFile);
    }

    public static void readConfigFromFile(File file, Properties properties) {
        for (String key : properties.stringPropertyNames()) {
            ConfigItem configItem = bexConfigMap.get(key);
            if (configItem != null) {
                if (configItem.ConfigValue instanceof Boolean) {
                    configItem.setConfigValue(Boolean.parseBoolean(properties.getProperty(key)));
                } else if (configItem.ConfigValue instanceof Float) {
                    configItem.setConfigValue(Float.parseFloat(properties.getProperty(key)));
                } else if (configItem.ConfigValue instanceof Double) {
                    configItem.setConfigValue(Double.parseDouble(properties.getProperty(key)));
                } else if (configItem.ConfigValue instanceof Integer) {
                    configItem.setConfigValue(Integer.parseInt(properties.getProperty(key)));
                } else {
                    configItem.setConfigValue(properties.getProperty(key));
                }
            }
        }
    }

    public static void packConfigFile(File file, Properties properties) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            for (Map.Entry<String, ConfigItem> entry : bexConfigMap.entrySet()) {
                ConfigItem value = entry.getValue();
                String localValue = properties.getProperty(value.ConfigKey);
                if (localValue == null) {
                    fileWriter.write("// " + value.ConfigComment + "\n");
                    fileWriter.write(value.ConfigKey + "=" + value.ConfigValue + "\n\n");
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateConfigFile(File file) {
        try {
            FileWriter fileWritter = new FileWriter(file);
            fileWritter.write("// Beyond Extreme配置文件，说明：【布尔类型：true为开启，false关闭】，在【名称=值】之间/之后不要存在空格或者其他无关字符，【tick：20tick=1秒】\n");
            for (Map.Entry<String, cn.wensc.mitemod.extreme.util.EXConfigs.ConfigItem> entry : bexConfigMap.entrySet()) {
                cn.wensc.mitemod.extreme.util.EXConfigs.ConfigItem value = entry.getValue();
                fileWritter.write("// " + value.ConfigComment + "\n");
                fileWritter.write(value.ConfigKey + "=" + value.ConfigValue + "\n\n");
            }
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

