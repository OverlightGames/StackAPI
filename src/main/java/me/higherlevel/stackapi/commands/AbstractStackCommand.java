package me.higherlevel.stackapi.commands;

import dev.jorel.commandapi.CommandAPICommand;

/**
 * Defines a structured path to adding new {@link CommandAPICommand}s to the {@link StackCommandManager}.
 */
public class AbstractStackCommand {
    public AbstractStackCommand(CommandAPICommand command) {
        StackCommandManager.registerCommand(command);
    }

    public AbstractStackCommand(CommandAPICommand... commands) {
        for (CommandAPICommand cmd : commands) {
            StackCommandManager.registerCommand(cmd);
        }
    }
}