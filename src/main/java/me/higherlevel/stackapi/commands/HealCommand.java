package me.higherlevel.stackapi.commands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.attribute.Attribute;

import java.util.Objects;

public class HealCommand extends AbstractStackCommand {
    public HealCommand() {
        super(new CommandAPICommand("heal")
                .executesPlayer((sender, args) -> {
                    sender.setHealth(Objects.requireNonNull(sender.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue());
                    sender.setFoodLevel(20);
                    sender.setSaturation(20);
                }));
    }
}
