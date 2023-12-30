package me.higherlevel.stackapi.commands;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import me.higherlevel.stackapi.items.StackItem;
import me.higherlevel.stackapi.items.StackItemManager;

import java.util.concurrent.CompletableFuture;

public class StackItemCommand extends StackCommand {
    public StackItemCommand() {
        super(new CommandAPICommand("stackitem")
                .withArguments(new StringArgument("id").replaceSuggestions(ArgumentSuggestions.stringCollectionAsync(commandSenderSuggestionInfo -> CompletableFuture.supplyAsync(() -> StackItemManager.getIds()))))
                .withOptionalArguments(new IntegerArgument("count"))
                .withUsage("/stackitem <name> [<count>]")
                .executesPlayer((sender, args) -> {
                    String id = (String) args.get(0);
                    if (StackItemManager.fromIdOrNull(id) == null) {
                        throw CommandAPI.failWithString(StackItem.class.getName() + " with ID '" + id + "' doesn't exist!");
                    }

                    if (args.count() == 2) {
                        int count = (int) args.get(1);
                        for (int i = 0; i < count; i++) {
                            sender.getInventory().addItem(StackItemManager.fromId(id).item.asOne());
                        }
                    } else {
                        sender.getInventory().addItem(StackItemManager.fromId(id).item.asOne());
                    }
                }));
    }
}
