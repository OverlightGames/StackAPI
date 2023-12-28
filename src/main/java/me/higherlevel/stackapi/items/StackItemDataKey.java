package me.higherlevel.stackapi.items;

import me.higherlevel.stackapi.StackAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class StackItemDataKey {
    Object defaultValue;
    NamespacedKey key;
    PersistentDataType type;

    public StackItemDataKey(String key, PersistentDataType type) {
        this.key = new NamespacedKey(StackAPI.getInstance(), key);
        this.type = type;
        this.defaultValue = null;
    }

    public StackItemDataKey(String key, PersistentDataType type, Object defaultValue) {
        this.key = new NamespacedKey(StackAPI.getInstance(), key);
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public StackItemDataKey(NamespacedKey key, PersistentDataType type) {
        this.key = key;
        this.type = type;
        this.defaultValue = null;
    }

    public StackItemDataKey(NamespacedKey key, PersistentDataType type, Object defaultValue) {
        this.key = key;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    /**
     * Attempts to assign the {@link #defaultValue} to the {@link #key namespaced key} in the item's {@link org.bukkit.persistence.PersistentDataContainer PersistentDataContainer}.
     * @param item The item to assign defaults to
     * @return true if the operation was successful, otherwise false
     */
    public boolean assignDefaults(ItemStack item) {
        if (item == null) return false;
        if (!item.hasItemMeta()) return false;
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(key, type, defaultValue));
        return true;
    }

    public Object getData(ItemStack item) {
        if (item == null) return null;
        if (!item.hasItemMeta()) return null;
        if (!item.getItemMeta().getPersistentDataContainer().has(key, type)) return null;
        return item.getItemMeta().getPersistentDataContainer().get(key, type);
    }

    public boolean dataEquals(ItemStack item, Object value) {
        if (item == null) return false;
        if (!item.hasItemMeta()) return false;
        if (!item.getItemMeta().getPersistentDataContainer().has(key, type)) return false;
        if (!item.getItemMeta().getPersistentDataContainer().get(key, type).equals(value)) return false;
        return true;
    }

    public boolean hasData(ItemStack item) {
        if (item == null) return false;
        if (!item.hasItemMeta()) return false;
        return item.getItemMeta().getPersistentDataContainer().has(key, type);
    }
}
