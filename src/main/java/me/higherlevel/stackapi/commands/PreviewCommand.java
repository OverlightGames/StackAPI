package me.higherlevel.stackapi.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import me.higherlevel.stackapi.items.StackDisplayItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PreviewCommand extends AbstractStackCommand {
    public PreviewCommand() {
        super(new CommandAPICommand("preview")
                .withArguments(new StringArgument("type").replaceSuggestions(ArgumentSuggestions.strings("chat", "item", "lore", "actionbar", "title")), new GreedyStringArgument("message"))
                .executesPlayer(((sender, args) -> {
                    if (args.get("type").equals("chat")) {
                        sender.sendMessage(MiniMessage.miniMessage().deserialize((String) args.get(1)));
                    } else if (args.get("type").equals("item")) {
                        Inventory itemDisplayInventory = Bukkit.createInventory(sender, 9, Component.text("Item"));
                        for (int i = 0; i < 9; i++) {
                            itemDisplayInventory.setItem(i, new StackDisplayItem(Material.GRAY_STAINED_GLASS_PANE).item);
                        }
                        ItemStack item = new ItemStack(Material.BOW);
                        item.editMeta(itemMeta -> {
                            itemMeta.displayName(MiniMessage.miniMessage().deserialize((String) args.get(1)));
                            itemMeta.lore(new ArrayList<>() {{
                                add(Component.text("Just some lore...")
                                        .color(NamedTextColor.GRAY));
                            }});
                            itemMeta.setCustomModelData(1);
                        });
                        itemDisplayInventory.setItem(4, item);
                        sender.openInventory(itemDisplayInventory);
                    } else if (args.get("type").equals("lore")) {
                        Inventory itemDisplayInventory = Bukkit.createInventory(sender, 9, Component.text("Lore"));
                        for (int i = 0; i < 9; i++) {
                            itemDisplayInventory.setItem(i, new StackDisplayItem(Material.GRAY_STAINED_GLASS_PANE).item);
                        }
                        ItemStack item = new ItemStack(Material.BOW);
                        item.editMeta(itemMeta -> {
                            itemMeta.displayName(Component.text("Item Name")
                                    .decoration(TextDecoration.ITALIC, false));
                            itemMeta.lore(new ArrayList<>() {{
                                add(MiniMessage.miniMessage().deserialize((String) args.get(1)));
                            }});
                            itemMeta.setCustomModelData(1);
                        });
                        itemDisplayInventory.setItem(4, item);
                        sender.openInventory(itemDisplayInventory);
                    } else if (args.get("type").equals("actionbar")) {
                        sender.sendActionBar(MiniMessage.miniMessage().deserialize((String) args.get(1)));
                    } else if (args.get("type").equals("title")) {
                        sender.showTitle(Title.title(MiniMessage.miniMessage().deserialize((String) args.get(1)), Component.empty()));
                    }
                })));
    }
}
