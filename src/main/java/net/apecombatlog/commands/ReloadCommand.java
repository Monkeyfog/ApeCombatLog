package net.apecombatlog.commands;

import net.apecombatlog.ApeCombatLog;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.HumanEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage("You don't have permission to use this command!");
            return true;
        }
        ApeCombatLog.getInstance().reloadConfig();
        sender.sendMessage(" ");
        sender.sendMessage("plugin reloaded!");
        sender.sendMessage(" ");
        return true;
    }
}
