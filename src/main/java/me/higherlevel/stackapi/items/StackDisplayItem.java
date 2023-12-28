package me.higherlevel.stackapi.items;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.function.Consumer;

public class StackDisplayItem extends ClickableItem {
    public StackDisplayItem(Material material) {
        super(material);
    }

    public StackDisplayItem(Material material, String displayName) {
        super(material, displayName);
    }

    public StackDisplayItem(Material material, String displayName, List<String> loreText) {
        super(material, displayName, loreText);
    }

    public StackDisplayItem(Material material, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, itemMetaConsumer);
    }

    public StackDisplayItem(Material material, String displayName, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, displayName, itemMetaConsumer);
    }

    public StackDisplayItem(Material material, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, loreText, itemMetaConsumer);
    }

    public StackDisplayItem(Material material, String displayName, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, displayName, loreText, itemMetaConsumer);
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
    }
}
