package net.ledestudio.itemstorage.item;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface ItemCategoryHolder {

    @Nullable ItemCategory getItemCategory(@NotNull String categoryId);

    @NotNull Map<String, ItemCategory> getItemCategoryMap();

    void addItemCategory(@NotNull ItemCategory category);

    void removeItemCategory(@NotNull ItemCategory category);

    void removeItemCategory(@NotNull String categoryId);

    void clear();

}
