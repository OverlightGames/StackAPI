package me.higherlevel.stackapi.items;

import me.higherlevel.stackapi.StackAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>Used to create a new {@link ItemStack} that can be registered later to the {@link StackItemManager} with {@link #registerItem(String)}. The new {@link ItemStack} object is stored in {@link #item}</p>
 * <p>This class implements the {@link Listener} class and registers all events listened to in this class or its derivates.</p>
 */
public abstract class StackItem implements Listener {
    public ItemStack item;
    public String id;

    protected void createSimpleItem(Material material) {
        item = new ItemStack(material);
        StackAPI.getInstance().getServer().getPluginManager().registerEvents(this, StackAPI.getInstance());
    }

    protected void consumeMeta(Consumer<ItemMeta> itemMetaConsumer) {
        ItemMeta meta = item.getItemMeta();
        itemMetaConsumer.accept(meta);
        item.setItemMeta(meta);
    }

    protected void setLore(List<String> loreText) {
        item.editMeta(itemMeta -> {
            List<Component> lore = new ArrayList<>();
            for (String i : loreText) {
                lore.add(MiniMessage.miniMessage().deserialize(i));
            }
            itemMeta.lore(lore);
        });
    }

    /**
     * Takes the {@link StackItem} object and registers it with an ID in the {@link StackItemManager} using {@link StackItemManager#registerItem(StackItem, String)}
     * @param id
     */
    public void registerItem(String id) {
        StackItemManager.registerItem(this, id);
        this.id = id;
    }

    /**
     * <p>Checks if the <b>item</b>'s ID found in its {@link org.bukkit.persistence.PersistentDataContainer PersistentDataContainer} matches the {@link StackItem} object's {@link #id}.</p>
     * <p>If the {@link StackItem} is never registered i.e. the {@link #id} is never set, then this will always return false.</p>
     * @param item The {@link ItemStack} to check its ID for
     * @return true if the {@link ItemStack}'s ID matches the {@link StackItem} object's {@link #id}, otherwise false
     */
    public boolean itemIdMatches(ItemStack item) {
        if (id == null) return false;
        if (StackItemManager.getId(item) == null) return false;
        return StackItemManager.getId(item).equals(id);
    }

    /**
     * Checks if the <b>item</b>'s ID found in its {@link org.bukkit.persistence.PersistentDataContainer PersistentDataContainer} matches the specified <b>id</b>.
     * @param item The {@link ItemStack} to check its ID for
     * @param id The {@link String} that has to be equal to the item's ID
     * @return true if the {@link ItemStack}'s ID matches the specified ID, otherwise false
     */
    public boolean itemIdMatches(ItemStack item, String id) {
        return StackItemManager.getId(item) == id;
    }

    /**
     * Creates a new {@link ItemStack}.
     * @param material The material to use for the {@link ItemStack}
     */
    public StackItem(Material material) {
        createSimpleItem(material);
    }

    /**
     * <p>Creates a new {@link ItemStack} with a custom display name.
     * Note that <b>displayName</b> must be formatted as a {@link MiniMessage} component e.g. "&lt!i&gt&lt;red&gt;My Item"</p>
     * <p>For more information on how {@link MiniMessage} works, visit its documentation <a href="https://docs.advntr.dev/minimessage/index.html">here</a>.</p>
     * @param material The material to use for the {@link #item}
     * @param displayName The display name for the {@link #item} in {@link MiniMessage} format
     */
    public StackItem(Material material, String displayName) {
        createSimpleItem(material);
        item.editMeta(itemMeta -> itemMeta.displayName(MiniMessage.miniMessage().deserialize(displayName)));
    }

    /**
     * <p>
     *     Creates a new {@link ItemStack} with lore.
     *     Note that each element in <b>loreText</b> must be formatted as a {@link MiniMessage} component e.g. "&lt!i&gt&lt;red&gt;My Item"
     * </p>
     * <br>
     * <p>For more information on how {@link MiniMessage} works, visit its documentation <a href="https://docs.advntr.dev/minimessage/index.html">here</a>.</p>
     * @param material The material to use for the {@link #item}
     * @param loreText A list of {@link String}, each element in {@link MiniMessage} format
     */
    public StackItem(Material material, List<String> loreText) {
        createSimpleItem(material);
        setLore(loreText);
    }

    /**
     * <p>
     *     Creates a new {@link ItemStack} with a custom display name and lore.
     *     Note that <b>displayName</b> and each element in <b>loreText</b> must be formatted as a {@link MiniMessage} component e.g. "&lt!i&gt&lt;red&gt;My Item"
     * </p>
     * <br>
     * <p>For more information on how {@link MiniMessage} works, visit its documentation <a href="https://docs.advntr.dev/minimessage/index.html">here</a>.</p>
     * @param material The material to use for the {@link #item}
     * @param displayName The display name for the {@link #item} in {@link MiniMessage} format
     * @param loreText A list of {@link String}, each element in {@link MiniMessage} format
     */
    public StackItem(Material material, String displayName, List<String> loreText) {
        createSimpleItem(material);
        item.editMeta(itemMeta -> itemMeta.displayName(MiniMessage.miniMessage().deserialize(displayName)));
        setLore(loreText);
    }

    /**
     * Creates a new {@link ItemStack} with custom metadata.
     * @param material The material to use for the {@link #item}
     * @param itemMetaConsumer The consumer that will change the {@link ItemMeta} of the {@link #item}
     */
    public StackItem(Material material, Consumer<ItemMeta> itemMetaConsumer) {
        createSimpleItem(material);
        consumeMeta(itemMetaConsumer);
    }

    /**
     * <p>Creates a new {@link ItemStack} with a custom display name.
     * Note that <b>displayName</b> must be formatted as a {@link MiniMessage} component e.g. "&lt!i&gt&lt;red&gt;My Item"</p>
     * <p>For more information on how {@link MiniMessage} works, visit its documentation <a href="https://docs.advntr.dev/minimessage/index.html">here</a>.</p>
     * @param material The material to use for the {@link #item}
     * @param displayName The display name for the {@link #item} in {@link MiniMessage} format
     * @param itemMetaConsumer The consumer that will change the {@link ItemMeta} of the {@link #item}
     */
    public StackItem(Material material, String displayName, Consumer<ItemMeta> itemMetaConsumer) {
        createSimpleItem(material);
        item.editMeta(itemMeta -> itemMeta.displayName(MiniMessage.miniMessage().deserialize(displayName)));
        consumeMeta(itemMetaConsumer);
    }

    /**
     * <p>
     *     Creates a new {@link ItemStack} with lore and custom metadata.
     *     Note that each element in <b>loreText</b> must be formatted as a {@link MiniMessage} component e.g. "&lt!i&gt&lt;red&gt;My Item"
     * </p>
     * <br>
     * <p>For more information on how {@link MiniMessage} works, visit its documentation <a href="https://docs.advntr.dev/minimessage/index.html">here</a>.</p>
     * @param material The material to use for the {@link #item}
     * @param loreText A list of {@link String}, each element in {@link MiniMessage} format
     * @param itemMetaConsumer The consumer that will change the {@link ItemMeta} of the {@link #item}
     */
    public StackItem(Material material, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer) {
        createSimpleItem(material);
        setLore(loreText);
        consumeMeta(itemMetaConsumer);
    }

    /**
     * <p>
     *     Creates a new {@link ItemStack} with a custom display name, lore and custom metadata.
     *     Note that <b>displayName</b> and each element in <b>loreText</b> must be formatted as a {@link MiniMessage} component e.g. "&lt!i&gt&lt;red&gt;My Item"
     * </p>
     * <br>
     * <p>For more information on how {@link MiniMessage} works, visit its documentation <a href="https://docs.advntr.dev/minimessage/index.html">here</a>.</p>
     * @param material The material to use for the {@link #item}
     * @param displayName The display name for the {@link #item} in {@link MiniMessage} format
     * @param loreText A list of {@link String}, each element in {@link MiniMessage} format
     * @param itemMetaConsumer The consumer that will change the {@link ItemMeta} of the {@link #item}
     */
    public StackItem(Material material, String displayName, List<String> loreText, Consumer<ItemMeta> itemMetaConsumer) {
        createSimpleItem(material);
        item.editMeta(itemMeta -> itemMeta.displayName(MiniMessage.miniMessage().deserialize(displayName)));
        setLore(loreText);
        consumeMeta(itemMetaConsumer);
    }
}
