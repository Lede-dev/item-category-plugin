package net.ledestudio.itemstorage.item;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface CustomItem {

    @NotNull String getId();

    @NotNull ItemStack getItemStack();

    @NotNull ItemStack getOriginalItemStack();

}
