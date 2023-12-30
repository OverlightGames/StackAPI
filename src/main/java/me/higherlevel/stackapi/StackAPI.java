package me.higherlevel.stackapi;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import me.higherlevel.stackapi.commands.StackCommandManager;
import me.higherlevel.stackapi.items.StackItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class StackAPI extends JavaPlugin {
    private static StackAPI instance;

    public static StackAPI getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        StackItemManager.onEnable();
        CommandAPI.onEnable();
        StackCommandManager.onEnable();
        getLogger().info("Enabled.");
    }

    @Override
    public void onDisable() {
        StackCommandManager.onDisable();
        getLogger().info("Disabled.");
    }
}