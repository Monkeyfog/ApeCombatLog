package net.apecombatlog.listener;


import net.apecombatlog.managers.CombatPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Enemy;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) return;
        Player player = (Player)event.getEntity();
        Player damager = (Player)event.getDamager();
        CombatPlayer combatPlayer = CombatPlayer.getCombatPlayer(player);
        if (combatPlayer == null) {
            combatPlayer = CombatPlayer.createPlayer(player, damager);
            combatPlayer.sendMessage("§c§lʏᴏᴜ ɴᴏᴡ ɪɴ ᴄᴏᴍʙᴀᴛ!", "§c§lʏᴏᴜ ɴᴏᴡ ɪɴ ᴄᴏᴍʙᴀᴛ!");
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, false, false, false));
            damager.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, false, false, false));
        } else {
           Bukkit.getScheduler().cancelTask(combatPlayer.getScheadulerId());
           combatPlayer.startRunnable();

        }


    }

}
