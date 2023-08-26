package net.apecombatlog.managers;

import net.apecombatlog.ApeCombatLog;
import org.bukkit.Bukkit;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
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
    public void startRunnable(){
        this.scheadulerId = new BukkitRunnable() {
            @Override
            public void run() {
                player.sendMessage("");
                player.sendMessage("§a§lʏᴏᴜ ᴀʀᴇ ɴᴏ ʟᴏɴɢᴇʀ ɪɴ ᴄᴏᴍʙᴀᴛ!");
                player.sendMessage("");
                damager.sendMessage("");
                damager.sendMessage("§a§lʏᴏᴜ ᴀʀᴇ ɴᴏ ʟᴏɴɢᴇʀ ɪɴ ᴄᴏᴍʙᴀᴛ!");
                damager.sendMessage("");
                remove();
            }
        }.runTaskLater(ApeCombatLog.getInstance(), combatTime * 20).getTaskId();
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
        player.removePotionEffect(PotionEffectType.GLOWING);
        damager.removePotionEffect(PotionEffectType.GLOWING);
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
        player.sendMessage("");
        player.sendMessage(playerMessage);
        player.sendMessage("");
        damager.sendMessage("");
        damager.sendMessage(damagemessage);
        damager.sendMessage("");
    }





}
