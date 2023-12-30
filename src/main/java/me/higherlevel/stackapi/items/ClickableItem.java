package me.higherlevel.stackapi.items;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.function.Consumer;

public abstract class ClickableItem extends StackItem {
    private static final StackItemDataKey CLICKABLE_KEY = new StackItemDataKey("clickable", PersistentDataType.BOOLEAN);
    private static final StackItemDataKey UNCLICKABLE_KEY = new StackItemDataKey("unclickable", PersistentDataType.BOOLEAN);

    public static void applyUnclickable(ItemStack item) {
        if (CLICKABLE_KEY.hasData(item)) {
            throw new IllegalArgumentException("Item has conflicting attributes 'CLICKABLE' and 'UNCLICKABLE'");
        }
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(UNCLICKABLE_KEY.key, UNCLICKABLE_KEY.type, true));
    }

    protected void applyClickable(ItemStack item, String id) {
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(CLICKABLE_KEY.key, CLICKABLE_KEY.type, true));
        registerItem(id);
    }

    public ClickableItem(Material material, String id) {
        super(material);
        applyClickable(item, id);
    }

    public ClickableItem(Material material, String displayName, String id) {
        super(material, displayName);
        applyClickable(item, id);
    }

    public ClickableItem(Material material, List<String> loreText, String id) {
        super(material, loreText);
        applyClickable(item, id);
    }

    public ClickableItem(Material material, String displayName, List<String> loreText, String id) {
        super(material, displayName, loreText);
        applyClickable(item, id);
    }

    public ClickableItem(Material material, Consumer<ItemMeta> itemMetaConsumer, String id) {
        super(material, itemMetaConsumer);
        applyClickable(item, id);
    }

    public ClickableItem(Material material, String displayName, Consumer<ItemMeta> itemMetaConsumer, String id) {
        super(material, displayName, itemMetaConsumer);
        applyClickable(item, id);
    }

    public ClickableItem(Material material, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer, String id) {
        super(material, loreText, itemMetaConsumer);
        applyClickable(item, id);
    }

    public ClickableItem(Material material, String displayName, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer, String id) {
        super(material, displayName, loreText, itemMetaConsumer);
        applyClickable(item, id);
    }

    public abstract void onClick(InventoryClickEvent e);

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (CLICKABLE_KEY.dataEquals(e.getCurrentItem(), true)) {
            onClick(e);
        } else if (UNCLICKABLE_KEY.dataEquals(e.getCurrentItem(), true)) {
            e.setCancelled(true);
        }
    }
}