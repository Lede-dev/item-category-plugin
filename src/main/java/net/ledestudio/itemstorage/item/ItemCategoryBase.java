package net.ledestudio.itemstorage.item;

import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ItemCategoryBase implements ItemCategory {

    private final @NotNull String id;
    private @NotNull String name;
    private final Map<String, CustomItem> itemMap = Maps.newConcurrentMap();

    public ItemCategoryBase(@NotNull String id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public @NotNull String getId() {
        return id;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Override
    public @NotNull Map<String, CustomItem> getItemMap() {
        return Maps.newHashMap(itemMap);
    }

    @Override
    public @Nullable CustomItem getItem(@NotNull String itemId) {
        return itemMap.get(itemId);
    }

    @Override
    public void addItem(@NotNull CustomItem item) {
        itemMap.put(item.getId(), item);
    }

    @Override
    public void removeItem(@NotNull CustomItem item) {
        itemMap.remove(item.getId());
    }

    @Override
    public void removeItem(@NotNull String itemId) {
        itemMap.remove(itemId);
    }

    @Override
    public void clear() {
        itemMap.clear();
    }
}
