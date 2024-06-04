package net.apecombatlog.listener;


import net.apecombatlog.ApeCombatLog;
import net.apecombatlog.managers.CombatPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Enemy;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.Metadatable;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageListener implements Listener {
    public static boolean isNpc(Object object)
    {
        if ( ! (object instanceof Metadatable)) return false;
        Metadatable metadatable = (Metadatable)object;
        try
        {
            return metadatable.hasMetadata("NPC");
        }
        catch (UnsupportedOperationException e)
        {
            return false;
        }

    }
    private boolean ifCombatEffect = ApeCombatLog.getInstance().getConfig().getBoolean("glowing", true);
    private String InCombatMessage = ApeCombatLog.getInstance().getConfig().getString("in_combat_message", "§c§lYou are now in combat!");
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Player player = (Player)event.getEntity();
        Player damager = (Player)event.getDamager();

        if (!(damager instanceof Player) || isNpc(player)) return;
        if (!(damager instanceof Player)) return;


        CombatPlayer combatPlayer = CombatPlayer.getCombatPlayer(player);
        if (combatPlayer == null) {
            combatPlayer = CombatPlayer.createPlayer(player, damager);
            combatPlayer.sendMessage(InCombatMessage, InCombatMessage);
            if (ifCombatEffect == true){
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, false, false, false));
                damager.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, false, false, false));
            }
        } else {
           Bukkit.getScheduler().cancelTask(combatPlayer.getScheadulerId());
           combatPlayer.startRunnable();

        }


    }

}
