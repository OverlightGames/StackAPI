package me.higherlevel.stackapi.items;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.function.Consumer;

public class EmptyDisplayItem extends ClickableItem {
    public EmptyDisplayItem(Material material) {
        super(material, "");
    }

    public EmptyDisplayItem(Material material, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, "", itemMetaConsumer);
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
    }
}
