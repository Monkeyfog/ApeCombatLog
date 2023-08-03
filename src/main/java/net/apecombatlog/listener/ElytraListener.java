package net.apecombatlog.listener;

import net.apecombatlog.ApeCombatLog;
import net.apecombatlog.managers.CombatPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ElytraListener implements Listener {
    @EventHandler
    public void onDeath(EntityToggleGlideEvent event){
        if (!(event.getEntity() instanceof Player)) return;


        if (CombatPlayer.getCombatPlayer(((Player) event.getEntity()).getPlayer()) != null){
            event.setCancelled(((Player) event.getEntity()).hasPlayedBefore());
        }


    }


}
