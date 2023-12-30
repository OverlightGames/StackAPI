package me.higherlevel.stackapi.items;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.function.Consumer;

public abstract class DisplayItem extends ClickableItem {
    public DisplayItem(Material material, String id) {
        super(material, id);
    }

    public DisplayItem(Material material, String displayName, String id) {
        super(material, displayName, id);
    }

    public DisplayItem(Material material, List<String> loreText, String id) {
        super(material, loreText, id);
    }

    public DisplayItem(Material material, String displayName, List<String> loreText, String id) {
        super(material, displayName, loreText, id);
    }

    public DisplayItem(Material material, Consumer<ItemMeta> itemMetaConsumer, String id) {
        super(material, itemMetaConsumer, id);
    }

    public DisplayItem(Material material, String displayName, Consumer<ItemMeta> itemMetaConsumer, String id) {
        super(material, displayName, itemMetaConsumer, id);
    }

    public DisplayItem(Material material, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer, String id) {
        super(material, loreText, itemMetaConsumer, id);
    }

    public DisplayItem(Material material, String displayName, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer, String id) {
        super(material, displayName, loreText, itemMetaConsumer, id);
    }

    public abstract void clickOperation(InventoryClickEvent e);

    @Override
    public void onClick(InventoryClickEvent e) {
        clickOperation(e);
        e.setCancelled(true);
    }
}
