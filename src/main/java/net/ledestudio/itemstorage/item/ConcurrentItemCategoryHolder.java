package net.ledestudio.itemstorage.item;

import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
public class ConcurrentItemCategoryHolder implements ItemCategoryHolder {

    private final Map<String, ItemCategory> itemCategoryMap = Maps.newConcurrentMap();

    @Override
    public @Nullable ItemCategory getItemCategory(@NotNull String categoryId) {
        return itemCategoryMap.get(categoryId);
    }

    @Override
    public @NotNull Map<String, ItemCategory> getItemCategoryMap() {
        return Maps.newHashMap(itemCategoryMap);
    }

    @Override
    public void addItemCategory(@NotNull ItemCategory category) {
        itemCategoryMap.put(category.getId(), category);
    }

    @Override
    public void removeItemCategory(@NotNull ItemCategory category) {
        itemCategoryMap.remove(category.getId());
    }

    @Override
    public void removeItemCategory(@NotNull String categoryId) {
        itemCategoryMap.remove(categoryId);
    }

    @Override
    public void clear() {
        itemCategoryMap.clear();
    }

}
