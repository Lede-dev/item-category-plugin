package net.ledestudio.itemstorage.item;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FixedCustomItem implements CustomItem {

    private final @NotNull String id;
    private final @NotNull ItemStack itemStack;

    public FixedCustomItem(@NotNull String id, @NotNull ItemStack itemStack) {
        this.id = id;
        this.itemStack = itemStack;
    }

    @Override
    public @NotNull String getId() {
        return id;
    }

    @Override
    public @NotNull ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public @NotNull ItemStack getOriginalItemStack() {
        return itemStack;
    }
}
