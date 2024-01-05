package me.higherlevel.stackapi.items.test;

import me.higherlevel.stackapi.StackAPI;
import me.higherlevel.stackapi.commands.StackItemCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;

public class StackItem {
    public StackItem(Material material) {
        if (this instanceof Listener listener) {
            Bukkit.getPluginManager().registerEvents(listener, StackAPI.getInstance());
        }
    }

    public void registerToCommand(String id) {
        StackItemCommand.registeredItems.put(new NamespacedKey("stackapi", ));
    }
}