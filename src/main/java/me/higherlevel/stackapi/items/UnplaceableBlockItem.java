package me.higherlevel.stackapi.items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class UnplaceableBlockItem implements Listener {
    private static final StackItemDataKey UNPLACEABLE_KEY = new StackItemDataKey("unplaceable", PersistentDataType.BOOLEAN, true);

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e) {
        if (!UNPLACEABLE_KEY.dataEquals(e.getItemInHand(), true)) return;
        e.setCancelled(true);
    }

    public static void applyItem(StackItem stackItem) {
        stackItem.item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(UNPLACEABLE_KEY.key, UNPLACEABLE_KEY.type, UNPLACEABLE_KEY.defaultValue));
    }

    public static void applyItem(ItemStack item) {
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(UNPLACEABLE_KEY.key, UNPLACEABLE_KEY.type, UNPLACEABLE_KEY.defaultValue));
    }

    public static boolean isUnplaceable(ItemStack item) {
        return (boolean) UNPLACEABLE_KEY.getData(item);
    }
}