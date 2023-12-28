package me.higherlevel.stackapi.items;

import me.higherlevel.stackapi.StackAPI;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.function.Consumer;

public abstract class ClickableItem extends StackItem {
    public final NamespacedKey CLICKABLE_KEY = new NamespacedKey(StackAPI.getInstance(), "clickable");

    protected void setClickableData() {
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(CLICKABLE_KEY, PersistentDataType.BOOLEAN, true));
    }

    public ClickableItem(Material material) {
        super(material);
        setClickableData();
    }

    public ClickableItem(Material material, String displayName) {
        super(material, displayName);
        setClickableData();
    }

    public ClickableItem(Material material, String displayName, List<String> loreText) {
        super(material, displayName, loreText);
        setClickableData();
    }

    public ClickableItem(Material material, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, itemMetaConsumer);
        setClickableData();
    }

    public ClickableItem(Material material, String displayName, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, displayName, itemMetaConsumer);
        setClickableData();
    }

    public ClickableItem(Material material, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, loreText, itemMetaConsumer);
        setClickableData();
    }

    public ClickableItem(Material material, String displayName, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, displayName, loreText, itemMetaConsumer);
        setClickableData();
    }

    public abstract void onClick(InventoryClickEvent e);

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!StackItemManager.itemDataEquals(e.getCurrentItem(), CLICKABLE_KEY, PersistentDataType.BOOLEAN, true)) return;
        onClick(e);
    }
}