package com.enderdevelopment.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.enderdevelopment.plugin.Main;

public class CustomFeatureCommand implements CommandExecutor {

    private final Main plugin;

    public CustomFeatureCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("/customfeature <add|remove|list> [featureName]");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "add":
                if (args.length < 2) {
                    player.sendMessage("/customfeature add <featureName>");
                    return true;
                }
                plugin.getFeatureManager().addFeature(args[1]);
                player.sendMessage("Feature " + args[1] + " added.");
                break;
            case "remove":
                if (args.length < 2) {
                    player.sendMessage("/customfeature remove <featureName>");
                    return true;
                }
                plugin.getFeatureManager().removeFeature(args[1]);
                player.sendMessage("Feature " + args[1] + " removed.");
                break;
            case "list":
                plugin.getFeatureManager().listFeatures(player);
                break;
            default:
                player.sendMessage("/customfeature <add|remove|list> [featureName]");
        }

        return true;
    }
}