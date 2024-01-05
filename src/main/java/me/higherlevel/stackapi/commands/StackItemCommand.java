package me.higherlevel.stackapi.commands;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandMetaData;
import dev.jorel.commandapi.arguments.*;
import me.higherlevel.stackapi.items.NonStackableItem;
import me.higherlevel.stackapi.items.StackItem;
import me.higherlevel.stackapi.items.StackItemManager;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class StackItemCommand extends StackCommand {
    public static Map<NamespacedKey, StackItem> registeredItems;

    public StackItemCommand() {
        super(new CommandAPICommand("give")
                .withArguments(new EntitySelectorArgument.ManyPlayers("targets"), new NamespacedKeyArgument("id").replaceSuggestions(ArgumentSuggestions.stringCollectionAsync(commandSenderSuggestionInfo -> CompletableFuture.supplyAsync(() -> registeredItems.keySet().stream().map(namespacedKey -> namespacedKey.namespace() + ":" + namespacedKey.getKey()).collect(Collectors.toList())))))
                .withOptionalArguments(new IntegerArgument("count"))
                .withUsage("/stackapi:give <targets> <id> [<count>]")
                .executesPlayer((sender, args) -> {
                    Collection<Player> targets = (Collection<Player>) args.get("targets");
                    NamespacedKey id = (NamespacedKey) args.get("id");
                    if (registeredItems.get(id) == null) {
                        throw CommandAPI.failWithString("Unknown item '" + id + "'");
                    }

                    ItemStack item = registeredItems.get(id).item;

                    if (args.count() > 2) {
                        int count = (int) args.get("count");
                        targets.stream().forEach(player -> {
                            for (int i = 0; i < count; i++) {
                                player.getInventory().addItem(item.asOne());
                            }
                        });
                    } else {
                        targets.stream().forEach(player -> player.getInventory().addItem(item.asOne()));
                    }
                }));
    }
}
