package net.apecombatlog.managers;

import net.apecombatlog.ApeCombatLog;
import org.bukkit.Bukkit;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class CombatPlayer {
    private Player player;
    private Player damager;


    private int combatTime = ApeCombatLog.getInstance().getConfig().getInt("combat_time");
    private static ArrayList<CombatPlayer> CombatPlayers = new ArrayList<>();
    private int scheadulerId;

    public CombatPlayer(Player player, Player damager){
        this.player = player;
        this.damager = damager;

        startRunnable();
    }
    public String NotInCombatMessages = ApeCombatLog.getInstance().getConfig().getString("not_in_combat_message", "§a§lYou are no longer in combat!");
    private boolean sendMessages = ApeCombatLog.getInstance().getConfig().getBoolean("send_messages", true);
    public void startRunnable(){
        if (sendMessages == true) {
            this.scheadulerId = new BukkitRunnable() {
                @Override
                public void run() {
                    player.sendMessage("");
                    player.sendMessage(NotInCombatMessages);
                    player.sendMessage("");
                    damager.sendMessage("");
                    damager.sendMessage(NotInCombatMessages);
                    damager.sendMessage("");
                    remove();
                }
            }.runTaskLater(ApeCombatLog.getInstance(), combatTime * 20).getTaskId();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getDamager() {
        return damager;
    }

    public void setDamager(Player damager) {
        this.damager = damager;
    }

    public static ArrayList<CombatPlayer> getCombatPlayers() {
        return CombatPlayers;
    }

    public static void setCombatPlayers(ArrayList<CombatPlayer> combatPlayers) {
        CombatPlayers = combatPlayers;
    }

    public int getScheadulerId() {
        return scheadulerId;
    }

    public void setScheadulerId(int scheadulerId) {
        this.scheadulerId = scheadulerId;
    }


    public static CombatPlayer createPlayer(Player player, Player damager){
        CombatPlayer combatPlayer = new CombatPlayer(player, damager);
        CombatPlayers.add(combatPlayer);
        return combatPlayer;
    }
    public void remove(){
        Bukkit.getScheduler().cancelTask(getScheadulerId());
        if (player.hasPotionEffect(PotionEffectType.GLOWING)){
            player.removePotionEffect(PotionEffectType.GLOWING);
            damager.removePotionEffect(PotionEffectType.GLOWING);
        }
        CombatPlayers.remove(this);

    }
    public static CombatPlayer getCombatPlayer(Player player){
        for (CombatPlayer combatPlayer : CombatPlayers) {
            if (combatPlayer.getPlayer() == player){
                return combatPlayer;
            }
        }
        return null;
    }

    public void sendMessage(String playerMessage, String damagemessage){
        if (sendMessages == true) {
            player.sendMessage("");
            player.sendMessage(playerMessage);
            player.sendMessage("");
            damager.sendMessage("");
            damager.sendMessage(damagemessage);
            damager.sendMessage("");
        }
    }





}
