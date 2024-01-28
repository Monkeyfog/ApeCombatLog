package net.apecombatlog.listener;

import net.apecombatlog.ApeCombatLog;
import net.apecombatlog.managers.CombatPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class LogListener implements Listener {
    private boolean sendMessages = ApeCombatLog.getInstance().getConfig().getBoolean("send_messages", true);
    private String playerDisconnectMsg = ApeCombatLog.getInstance().getConfig().getString("player_discornnect", "Disconnected");
    @EventHandler

    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        CombatPlayer combatPlayer = CombatPlayer.getCombatPlayer(player);
        if (combatPlayer != null){
            player.setHealth(0);
            if (sendMessages == true) {
                combatPlayer.sendMessage("", combatPlayer.NotInCombatMessages +" §f§l " + player.getName() + " " + playerDisconnectMsg);


            }
            combatPlayer.remove();

        }


    }


}
