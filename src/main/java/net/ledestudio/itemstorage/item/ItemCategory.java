package net.ledestudio.itemstorage.item;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface ItemCategory {

    @NotNull String getId();

    @NotNull String getName();

    void setName(@NotNull String name);

    @NotNull Map<String, CustomItem> getItemMap();

    @Nullable CustomItem getItem(@NotNull String itemId);

    void addItem(@NotNull CustomItem item);

    void removeItem(@NotNull CustomItem item);

    void removeItem(@NotNull String itemId);

    void clear();

}
