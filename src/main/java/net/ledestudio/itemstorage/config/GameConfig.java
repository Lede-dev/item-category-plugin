package net.ledestudio.itemstorage.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class GameConfig {

    public static void load(@NotNull Plugin plugin) {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();
        ItemCategory.load(config);
    }

    public static class ItemCategory {

        private static String minecraftCategoryId;
        private static String minecraftCategoryName;

        private static void load(@NotNull FileConfiguration config) {
            minecraftCategoryId = config.getString("category.minecraft.id");
            minecraftCategoryName = config.getString("category.minecraft.name");
        }

        public static String getMinecraftCategoryId() {
            return minecraftCategoryId;
        }

        public static String getMinecraftCategoryName() {
            return minecraftCategoryName;
        }
    }

}
