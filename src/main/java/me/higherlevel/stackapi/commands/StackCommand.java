package me.higherlevel.stackapi.commands;

import dev.jorel.commandapi.CommandAPICommand;

/**
 * Defines a structured path to adding new {@link CommandAPICommand}s to the {@link StackCommandManager}.
 */
public class StackCommand {
    public StackCommand(CommandAPICommand command) {
        StackCommandManager.registerCommand(command);
    }

    public StackCommand(CommandAPICommand... commands) {
        for (CommandAPICommand cmd : commands) {
            StackCommandManager.registerCommand(cmd);
        }
    }
}