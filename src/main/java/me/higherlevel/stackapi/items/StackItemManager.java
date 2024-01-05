package me.higherlevel.stackapi.items;

import me.higherlevel.stackapi.StackAPI;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Used to manage registrations of new {@link StackItem}s or derivates.
 */
public class StackItemManager implements Listener {
    private static Map<String, StackItem> items = new HashMap<>();
    private static final StackItemDataKey ID_KEY = new StackItemDataKey("id", PersistentDataType.STRING);

    /**
     * Called when the {@link me.higherlevel.stackapi.StackAPI StackAPI} is enabled.
     */
    public static void onEnable() {
        Bukkit.getScheduler().runTaskTimer(StackAPI.getInstance(), () -> {
            for (StackItem item : items.values()) {
                if (item instanceof TickableItem tickable) {
                    tickable.tick();
                }
            }
        }, 0L, 1L);

        Bukkit.getScheduler().runTaskTimer(StackAPI.getInstance(), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ListIterator<ItemStack> inventoryIterator = p.getInventory().iterator();
                while (inventoryIterator.hasNext()) {
                    ItemStack item = inventoryIterator.next();
                    if (item == null) continue;
                    if (NonStackableItem.getNonStackableUuid(item) == null) continue;
                    if (!NonStackableItem.getNonStackableUuid(item).equals(NonStackableItem.initialUuid)) continue;
                    if (item.getAmount() != 1) continue;
                    NonStackableItem.randomizeItem(item);
                }
            }
        }, 0L, 5L);

        Bukkit.getPluginManager().registerEvents(new UnplaceableBlockItem(), StackAPI.getInstance());
        Bukkit.getPluginManager().registerEvents(new WearableItem(), StackAPI.getInstance());
    }

    /**
     * <p>Attempts to get the {@link StackItem} object associated with the ID.</p>
     * @param id The ID associated with the {@link StackItem} object
     * @return The {@link StackItem} object
     * @throws IllegalArgumentException Thrown when associated {@link StackItem} not found.
     */
    public static StackItem fromId(String id) {
        if (!items.containsKey(id)) {
            throw new IllegalArgumentException("ServerItem with ID '" + id + "' not found.");
        }
        return items.get(id);
    }

    /**
     * Gets the ID of the ItemStack.
     * @param item The item to get the ID from
     * @return The ID of the item if it has one, otherwise null
     */
    public static String getId(ItemStack item) {
        if (item == null) return null;
        if (!item.hasItemMeta()) return null;
        if (!item.getItemMeta().getPersistentDataContainer().has(ID_KEY.key, ID_KEY.type)) return null;
        return (String) item.getItemMeta().getPersistentDataContainer().get(ID_KEY.key, ID_KEY.type);
    }

    /**
     * <p>Attempts to get the {@link StackItem} object associated with the ID.</p>
     * @param id The ID associated with the {@link StackItem} object
     * @return The {@link StackItem} object or null if it was not found.
     */
    public static StackItem fromIdOrNull(String id) {
        return items.get(id);
    }

    /**
     * @return A new {@link HashSet} containing the values of all the registered {@link StackItem} IDs.
     */
    public static Set<String> getIds() {
        return new HashSet<>(items.keySet());
    }

    /**
     * <p>Registers an {@link StackItem} object by associating it with an ID and storing it in a {@link Map}.</p>
     * <p>Sets a persistent data tag on the item so its {@link StackItem} counterpart can be retrieved by {@link #fromItemStack(ItemStack)}.</p>
     * @param stackItem The {@link StackItem} object or derivative to register
     * @param id The ID to associate the {@link StackItem} object with
     */
    public static void registerItem(StackItem stackItem, String id) {
        if (items.containsKey(id)) {
            throw new IllegalArgumentException("ServerItem with id '" + id + "' has already been registered.");
        }
        stackItem.item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(ID_KEY.key, ID_KEY.type, id));
        items.put(id, stackItem);
    }

    /**
     * <p>Attempts to get the {@link StackItem} associated with the ID stored in the item's {@link PersistentDataContainer}.</p>
     * @param item The {@link ItemStack} to get the ID from
     * @return The associated {@link StackItem} object or null if it was not found.
     */
    public static StackItem fromItemStack(@NotNull ItemStack item) {
        if (!item.hasItemMeta()) return null;
        if (!item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(StackAPI.getInstance(), "id"), PersistentDataType.STRING)) return null;
        return StackItemManager.fromId(item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(StackAPI.getInstance(), "id"), PersistentDataType.STRING));
    }

    /**
     * <p>Checks if the namespaced key's value in the item's {@link PersistentDataContainer} is equal to the specified value.</p>
     * @param item The item to get the persistent data from
     * @param namespacedKey The {@link NamespacedKey} of the data being tested
     * @param persistentDataType The {@link PersistentDataType} of the data being tested
     * @param value The value that the persistent data should be equal to
     * @return true if the value is equal to the data under the namespaced key, otherwise false
     */
    public static boolean itemDataEquals(@NotNull ItemStack item, NamespacedKey namespacedKey, PersistentDataType persistentDataType, Object value) {
        if (!item.hasItemMeta()) return false;
        if (!item.getItemMeta().getPersistentDataContainer().has(namespacedKey, persistentDataType)) return false;
        if (!item.getItemMeta().getPersistentDataContainer().get(namespacedKey, persistentDataType).equals(value)) return false;
        return true;
    }
}
