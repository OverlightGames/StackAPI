package me.higherlevel.stackapi.items;

import me.higherlevel.stackapi.persistentdatatypes.UUIDDataType;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class NonStackableItem {
    private static final StackItemDataKey NON_STACKABLE_KEY = new StackItemDataKey("non_stackable_uuid", new UUIDDataType());

    public static void applyItem(ItemStack item) {
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(NON_STACKABLE_KEY.key, NON_STACKABLE_KEY.type, UUID.randomUUID()));
    }

    public static void applyItem(StackItem stackItem) {
        stackItem.item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(NON_STACKABLE_KEY.key, NON_STACKABLE_KEY.type, UUID.randomUUID()));
    }

    public static boolean isNonStackable(ItemStack item) {
        return NON_STACKABLE_KEY.hasData(item);
    }
}
