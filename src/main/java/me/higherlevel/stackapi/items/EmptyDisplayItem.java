package me.higherlevel.stackapi.items;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.function.Consumer;

public class EmptyDisplayItem extends StackItem {
    public EmptyDisplayItem(Material material) {
        super(material, "");
        ClickableItem.applyUnclickable(item);
    }

    public EmptyDisplayItem(Material material, Consumer<ItemMeta> itemMetaConsumer) {
        super(material, "", itemMetaConsumer);
        ClickableItem.applyUnclickable(item);
    }
}
