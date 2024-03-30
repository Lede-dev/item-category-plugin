package net.ledestudio.itemstorage;

import net.ledestudio.itemstorage.api.ItemStorageAPI;
import net.ledestudio.itemstorage.config.GameConfig;
import net.ledestudio.itemstorage.item.*;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ItemStorage extends JavaPlugin implements ItemStorageAPI {

    private static ItemStorage instance;

    public static Plugin getInstance() {
        return instance;
    }

    public static ItemStorageAPI getAPI() {
        if (instance == null) {
            throw new NullPointerException("Not Initialized ItemStorage API.");
        }
        return instance;
    }

    private ItemCategoryHolder itemCategoryHolder;

    @Override
    public void onEnable() {
        instance = this;
        itemCategoryHolder = new ConcurrentItemCategoryHolder();

        // Load Config
        saveDefaultConfig();
        GameConfig.load(this);

        // Load Default Items
        ItemCategory minecraft = createItemCategory(
                GameConfig.ItemCategory.getMinecraftCategoryId(), GameConfig.ItemCategory.getMinecraftCategoryName());
        for (Material value : Material.values()) {
            CustomItem item = createCustomItem(value.toString().toLowerCase(), new ItemStack(value));
            minecraft.addItem(item);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public @NotNull ItemCategoryHolder getItemCategoryHolder() {
        return itemCategoryHolder;
    }

    @Override
    public @Nullable ItemCategory getItemCategory(@NotNull String categoryId) {
        return itemCategoryHolder.getItemCategory(categoryId);
    }

    @Override
    public @Nullable CustomItem getItem(@NotNull String itemId) {
        for (ItemCategory category : itemCategoryHolder.getItemCategoryMap().values()) {
            CustomItem item = category.getItem(itemId);
            if (item != null) {
                return item;
            }
        }
        return null;
    }

    @Override
    public @Nullable ItemStack getItemStack(@NotNull String itemId) {
        CustomItem item = getItem(itemId);
        if (item != null) {
            return item.getItemStack();
        }
        return null;
    }

    @Override
    public @Nullable ItemStack getOriginalItemStack(@NotNull String itemId) {
        CustomItem item = getItem(itemId);
        if (item != null) {
            return item.getOriginalItemStack();
        }
        return null;
    }

    @Override
    public void addItem(@NotNull ItemCategory category, @NotNull CustomItem item) {
        category.addItem(item);
    }

    @Override
    public void removeItem(@NotNull ItemCategory category, @NotNull CustomItem item) {
        category.removeItem(item);
    }

    @Override
    public void removeItem(@NotNull ItemCategory category, @NotNull String itemId) {
        category.removeItem(itemId);
    }

    @Override
    public @NotNull ItemCategory createItemCategory(@NotNull String categoryId, @NotNull String categoryName) {
        return new ItemCategoryBase(categoryId, categoryName);
    }

    @Override
    public @NotNull CustomItem createCustomItem(@NotNull String itemId, @NotNull ItemStack originalItem, @NotNull ItemStack item) {
        return new EditedCustomItem(itemId, originalItem, item);
    }

    @Override
    public @NotNull CustomItem createCustomItem(@NotNull String itemId, @NotNull ItemStack item) {
        return new FixedCustomItem(itemId, item);
    }
}
