package net.ledestudio.itemstorage.api;

import net.ledestudio.itemstorage.item.CustomItem;
import net.ledestudio.itemstorage.item.ItemCategory;
import net.ledestudio.itemstorage.item.ItemCategoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ItemStorageAPI {

    @NotNull ItemCategoryHolder getItemCategoryHolder();

    @Nullable ItemCategory getItemCategory(@NotNull String categoryId);

    @Nullable CustomItem getItem(@NotNull String itemId);

    @Nullable ItemStack getItemStack(@NotNull String itemId);

    @Nullable ItemStack getOriginalItemStack(@NotNull String itemId);

    void addItem(@NotNull ItemCategory category, @NotNull CustomItem item);

    void removeItem(@NotNull ItemCategory category, @NotNull CustomItem item);

    void removeItem(@NotNull ItemCategory category, @NotNull String itemId);

    @NotNull ItemCategory createItemCategory(@NotNull String categoryId, @NotNull String categoryName);

    @NotNull CustomItem createCustomItem(@NotNull String itemId, @NotNull ItemStack originalItem, @NotNull ItemStack item);

    @NotNull CustomItem createCustomItem(@NotNull String itemId, @NotNull ItemStack item);

}
