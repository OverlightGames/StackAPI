package me.higherlevel.stackapi.items;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.function.Consumer;

/**
 * Used to easily construct new {@link StackItem}s that have custom skull textures.
 */
public class StackSkullItem extends StackItem {
    protected void applySkullTextures(String base64SkullId) {
        SkullItemCreator.itemWithBase64(item, base64SkullId);
        //SkullCreator.itemWithUrl(item, "http://textures.minecraft.net/texture/" + base64Uuid);
    }

    /**
     * <p>Creates a new {@link org.bukkit.inventory.ItemStack ItemStack} of type {@link Material#PLAYER_HEAD} and applies the textures obtained from the {@link java.util.Base64 Base64} value.</p>
     * <p>A Base64 value for heads can be found on various websites like <a href="https://minecraft-heads.com">minecraft-heads.com</a> and <a href="https://namemc.com">namemc.com</a></p>
     * @param base64SkullId
     */
    public StackSkullItem(String base64SkullId) {
        super(Material.PLAYER_HEAD);
        applySkullTextures(base64SkullId);
    }

    /**
     * <p>Creates a new {@link org.bukkit.inventory.ItemStack ItemStack} of type {@link Material#PLAYER_HEAD} and applies the textures obtained from the {@link java.util.Base64 Base64} value.</p>
     * <p>A Base64 value for heads can be found on various websites like <a href="https://minecraft-heads.com">minecraft-heads.com</a> and <a href="https://namemc.com">namemc.com</a></p>
     * @param base64SkullId
     */
    public StackSkullItem(String base64SkullId, String miniMessageDisplayName) {
        super(Material.PLAYER_HEAD, miniMessageDisplayName);
        applySkullTextures(base64SkullId);
    }

    /**
     * <p>Creates a new {@link org.bukkit.inventory.ItemStack ItemStack} of type {@link Material#PLAYER_HEAD} and applies the textures obtained from the {@link java.util.Base64 Base64} value.</p>
     * <p>A Base64 value for heads can be found on various websites like <a href="https://minecraft-heads.com">minecraft-heads.com</a> and <a href="https://namemc.com">namemc.com</a></p>
     * @param base64SkullId
     */
    public StackSkullItem(String base64SkullId, String miniMessageDisplayName, List<String> miniMessageLore) {
        super(Material.PLAYER_HEAD, miniMessageDisplayName, miniMessageLore);
        applySkullTextures(base64SkullId);
    }

    /**
     * <p>Creates a new {@link org.bukkit.inventory.ItemStack ItemStack} of type {@link Material#PLAYER_HEAD} and applies the textures obtained from the {@link java.util.Base64 Base64} value.</p>
     * <p>A Base64 value for heads can be found on various websites like <a href="https://minecraft-heads.com">minecraft-heads.com</a> and <a href="https://namemc.com">namemc.com</a></p>
     * @param base64SkullId
     */
    public StackSkullItem(String base64SkullId, String miniMessageDisplayName, Consumer<ItemMeta> itemMetaConsumer) {
        super(Material.PLAYER_HEAD, miniMessageDisplayName, itemMetaConsumer);
        applySkullTextures(base64SkullId);
    }

    /**
     * <p>Creates a new {@link org.bukkit.inventory.ItemStack ItemStack} of type {@link Material#PLAYER_HEAD} and applies the textures obtained from the {@link java.util.Base64 Base64} value.</p>
     * <p>A Base64 value for heads can be found on various websites like <a href="https://minecraft-heads.com">minecraft-heads.com</a> and <a href="https://namemc.com">namemc.com</a></p>
     * @param base64SkullId
     */
    public StackSkullItem(String base64SkullId, String miniMessageDisplayName, List<String> miniMessageLore, Consumer<ItemMeta> itemMetaConsumer) {
        super(Material.PLAYER_HEAD, miniMessageDisplayName, miniMessageLore, itemMetaConsumer);
        applySkullTextures(base64SkullId);
    }
}
