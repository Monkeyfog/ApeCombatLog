package net.apecombatlog.listener;

import net.apecombatlog.ApeCombatLog;
import net.apecombatlog.managers.CombatPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandListener implements Listener {

    private List<String> blockedCommands = new ArrayList<>();

    public CommandListener() {
        blockedCommands.addAll(ApeCombatLog.getInstance().getConfig().getStringList("blocked_commands"));
    }

    @EventHandler
    public void commandEvent(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase();
        CombatPlayer combatPlayer = CombatPlayer.getCombatPlayer(player);

        if (combatPlayer == null) return; // Ensure combatPlayer is not null

        for (String blockedCommand : blockedCommands) {
            if (command.startsWith(blockedCommand.toLowerCase())) {
                event.setCancelled(true);
                player.sendMessage("You are not allowed to use this command: " + command); // Debug message
                return; // Exit loop once a blocked command is found
            }
        }
    }



}
