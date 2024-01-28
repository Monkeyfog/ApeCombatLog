package net.apecombatlog.listener;

import net.apecombatlog.ApeCombatLog;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class JoinListener implements Listener {
    private boolean sendAds = ApeCombatLog.getInstance().getConfig().getBoolean("send_ad", true);


    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.isOp() && sendAds==true){
            player.sendMessage("⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠");
            player.sendMessage("§c§l Get the cheapest & best hosting for Minecraft - §f§lhttps://monkeyhost.co §c§lcode - §f§l`monkey` §c§lfor 30% off!");
            player.sendMessage("⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠");
        }
    }
}
