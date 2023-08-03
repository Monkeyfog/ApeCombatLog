package net.apecombatlog.listener;

import net.apecombatlog.ApeCombatLog;
import net.apecombatlog.managers.CombatPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LogListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        CombatPlayer combatPlayer = CombatPlayer.getCombatPlayer(player);
        if (combatPlayer != null){
            player.setHealth(0);
            combatPlayer.sendMessage("","§a§lʏᴏᴜ ᴀʀᴇ ɴᴏ ʟᴏɴɢᴇʀ ɪɴ ᴄᴏᴍʙᴀᴛ! §f" + player.getName() + " §c§lᴅɪsᴄᴏɴɴᴇᴄᴛᴇᴅ");

            combatPlayer.remove();

        }


    }


}