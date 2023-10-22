package net.apecombatlog.listener;

import net.apecombatlog.ApeCombatLog;
import net.apecombatlog.managers.CombatPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class DeathListener implements Listener {
    private String playerDeathCombat = ApeCombatLog.getInstance().getConfig().getString("player_death_combat", "Died");
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getPlayer();
        CombatPlayer combatPlayer = CombatPlayer.getCombatPlayer(player);
        if (combatPlayer != null){
            combatPlayer.sendMessage(combatPlayer.NotInCombatMessages + "§f§l " + player.getName() + "§a§l" +playerDeathCombat, combatPlayer.NotInCombatMessages + "§f " + player.getName() + "§a§l" +playerDeathCombat );
            combatPlayer.remove();
        }


    }


}
