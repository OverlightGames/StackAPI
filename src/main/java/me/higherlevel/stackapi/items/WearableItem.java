package me.higherlevel.stackapi.items;

import me.higherlevel.stackapi.persistentdatatypes.EquipmentSlotDataType;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WearableItem implements Listener {
    private static final StackItemDataKey WEARABLE_BLOCK_SLOT_KEY = new StackItemDataKey("wearable_block_slot", new EquipmentSlotDataType());

    public static void applyItem(@NotNull ItemStack item, @NotNull EquipmentSlot slot) {
        if (!slot.isArmor()) {
            throw new IllegalArgumentException("EquipmentSlot cannot be a hand slot!");
        }
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(WEARABLE_BLOCK_SLOT_KEY.key, WEARABLE_BLOCK_SLOT_KEY.type, slot));
    }

    public static void applyItem(@NotNull StackItem stackItem, @NotNull EquipmentSlot slot) {
        if (!slot.isArmor()) {
            throw new IllegalArgumentException("EquipmentSlot cannot be a hand slot!");
        }
        stackItem.item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(WEARABLE_BLOCK_SLOT_KEY.key, WEARABLE_BLOCK_SLOT_KEY.type, slot));
    }

    public static EquipmentSlot fromRawSlot(int rawSlot) {
        switch (rawSlot) {
            case 5: return EquipmentSlot.HEAD;
            case 6: return EquipmentSlot.CHEST;
            case 7: return EquipmentSlot.LEGS;
            case 8: return EquipmentSlot.FEET;
            default: throw new IllegalArgumentException("The raw slot should be an armor slot {5, 6, 7, 8}");
        }
    }

    public static EquipmentSlot fromRawSlotOrNull(int rawSlot) {
        switch (rawSlot) {
            case 5: return EquipmentSlot.HEAD;
            case 6: return EquipmentSlot.CHEST;
            case 7: return EquipmentSlot.LEGS;
            case 8: return EquipmentSlot.FEET;
            default: return null;
        }
    }

    @EventHandler
    public void onPlayerClickArmorSlot(InventoryClickEvent e) {
        if (!e.getClickedInventory().getType().equals(InventoryType.PLAYER)) return;
        ItemStack cursorItem = e.getCursor();
        ItemStack currentItem = e.getCurrentItem();
        EquipmentSlot clickedSlotType = fromRawSlotOrNull(e.getRawSlot());
        if (clickedSlotType == null) return;
        if (!WEARABLE_BLOCK_SLOT_KEY.dataEquals(cursorItem, clickedSlotType)) {

            return;
        }
        if (cursorItem.getAmount() > 1 && e.getCurrentItem().getType().equals(Material.AIR)) {
            e.getCursor().setAmount(e.getCursor().getAmount() - 1);
            e.setCurrentItem(e.getCursor().asOne());
            e.setCancelled(true);
            ((Player) e.getWhoClicked()).playSound(e.getWhoClicked(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.PLAYERS,1.0f, 1.0f);
            return;
        }
        e.setCurrentItem(cursorItem);
        e.getView().setCursor(currentItem);
        e.setCancelled(true);
        ((Player) e.getWhoClicked()).playSound(e.getWhoClicked(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.PLAYERS,1.0f, 1.0f);
    }

    @EventHandler
    public void onPlayerRightClickItem(PlayerInteractEvent e) {
        if (!e.hasItem()) return;
        if (!e.getAction().isRightClick()) return;
        if (!WEARABLE_BLOCK_SLOT_KEY.hasData(e.getItem())) return;
        EquipmentSlot validSlot = (EquipmentSlot) WEARABLE_BLOCK_SLOT_KEY.getData(e.getItem());
        ItemStack interactedItem = e.getItem();
        ItemStack equippedItem = e.getPlayer().getInventory().getItem(validSlot);

        if (StackItemManager.getId(interactedItem).equals(StackItemManager.getId(equippedItem))) return;

        if (interactedItem.getAmount() > 1 && equippedItem.getType().equals(Material.AIR)) {
            e.getItem().setAmount(e.getItem().getAmount() - 1);
            e.getPlayer().getInventory().setItem(validSlot, interactedItem.asOne());
            e.getPlayer().playSound(e.getPlayer(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.PLAYERS,1.0f, 1.0f);
            e.setUseItemInHand(Event.Result.DENY);
            e.setUseInteractedBlock(Event.Result.DENY);
            return;
        }

        e.getPlayer().getInventory().setItem(validSlot, interactedItem);
        if (e.getHand().equals(EquipmentSlot.HAND)) {
            e.getPlayer().getInventory().setItemInMainHand(equippedItem);
        } else if (e.getHand().equals(EquipmentSlot.OFF_HAND)) {
            e.getPlayer().getInventory().setItemInOffHand(equippedItem);
        }

        e.getPlayer().playSound(e.getPlayer(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.PLAYERS,1.0f, 1.0f);
        e.setUseItemInHand(Event.Result.DENY);
        e.setUseInteractedBlock(Event.Result.DENY);
    }
}
