package me.higherlevel.stackapi.commands;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Keeps track of every registered {@link CommandAPICommand} by storing {@link CommandAPICommand}s in a {@link HashSet} called {@link #commands}.</p>
 * <br>
 * <p>Before constructing a new {@link StackCommand} object, check if the ServerCommandManager is enabled with {@link StackCommandManager#isEnabled() ServerCommandManager#isEnabled()}.</p>
 */
public class StackCommandManager {
    private static Set<CommandAPICommand> commands = new HashSet<>();
    private static boolean enabled = false;

    /**
     * @return true if the {@link #onEnable()} method has been called and the plugin has not failed, otherwise false
     */
    public static boolean isEnabled() {
        return enabled;
    }

    /**
     * <p>Should be called before constructing any new {@link StackCommand} objects.</p>
     */
    public static void onEnable() {
        enabled = true;

        new HealCommand();
        new PreviewCommand();
        new UnicodeCommand();
        new StackItemCommand();

        for (CommandAPICommand cmd : commands) {
            cmd.register();
        }
    }

    /**
     * Unregisters all registered {@link #commands} using {@link CommandAPI#unregister(String)}.
     */
    public static void onDisable() {
        for (CommandAPICommand cmd : commands) {
            CommandAPI.unregister(cmd.getName());
        }

        enabled = false;
    }

    public static void registerCommand(@NotNull CommandAPICommand command) {
        commands.add(command);
    }
}