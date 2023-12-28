package me.higherlevel.stackapi.persistentdatatypes;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class EquipmentSlotDataType implements PersistentDataType<Byte, EquipmentSlot> {
    @Override
    public @NotNull Class<Byte> getPrimitiveType() {
        return Byte.class;
    }

    @Override
    public @NotNull Class<EquipmentSlot> getComplexType() {
        return EquipmentSlot.class;
    }

    @Override
    public @NotNull Byte toPrimitive(@NotNull EquipmentSlot complex, @NotNull PersistentDataAdapterContext context) {
        byte slot;
        switch (complex) {
            case HEAD: slot = 0;
            case CHEST: slot = 1;
            case LEGS: slot = 2;
            case FEET: slot = 3;
            case HAND: slot = 4;
            case OFF_HAND: slot = 5;
            default: slot = 0;
        }
        return slot;
    }

    @Override
    public @NotNull EquipmentSlot fromPrimitive(@NotNull Byte primitive, @NotNull PersistentDataAdapterContext context) {
        EquipmentSlot slot;
        switch (primitive) {
            case 0: slot = EquipmentSlot.HEAD;
            case 1: slot = EquipmentSlot.CHEST;
            case 2: slot = EquipmentSlot.LEGS;
            case 3: slot = EquipmentSlot.FEET;
            case 4: slot = EquipmentSlot.HAND;
            case 5: slot = EquipmentSlot.OFF_HAND;
            default: slot = EquipmentSlot.HEAD;
        }
        return slot;
    }
}
