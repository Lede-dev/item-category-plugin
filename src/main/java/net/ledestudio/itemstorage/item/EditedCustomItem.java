package net.ledestudio.itemstorage.item;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EditedCustomItem implements CustomItem {

    private final @NotNull String id;
    private final @NotNull ItemStack originalItem;
    private final @NotNull ItemStack editedItem;

    public EditedCustomItem(@NotNull String id, @NotNull ItemStack originalItem, @NotNull ItemStack editedItem) {
        this.id = id;
        this.originalItem = originalItem;
        this.editedItem = editedItem;
    }

    @Override
    public @NotNull String getId() {
        return id;
    }

    @Override
    public @NotNull ItemStack getItemStack() {
        return editedItem;
    }

    @Override
    public @NotNull ItemStack getOriginalItemStack() {
        return originalItem;
    }
}
