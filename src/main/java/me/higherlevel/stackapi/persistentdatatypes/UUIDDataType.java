package me.higherlevel.stackapi.persistentdatatypes;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDDataType implements PersistentDataType<byte[], UUID> {
    @Override
    public @NotNull Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @Override
    public @NotNull Class<UUID> getComplexType() {
        return UUID.class;
    }

    @Override
    public byte @NotNull [] toPrimitive(@NotNull UUID complex, @NotNull PersistentDataAdapterContext context) {
        ByteBuffer bytes = ByteBuffer.allocate(16);
        bytes.putLong(complex.getMostSignificantBits());
        bytes.putLong(complex.getLeastSignificantBits());
        return new byte[0];
    }

    @Override
    public @NotNull UUID fromPrimitive(byte @NotNull [] primitive, @NotNull PersistentDataAdapterContext context) {
        ByteBuffer bytes = ByteBuffer.wrap(primitive);
        return new UUID(bytes.getLong(0), bytes.getLong(1));
    }
}
