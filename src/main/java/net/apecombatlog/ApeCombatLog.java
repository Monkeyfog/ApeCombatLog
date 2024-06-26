package net.apecombatlog;

import jdk.jpackage.internal.Log;
import net.apecombatlog.commands.ReloadCommand;
import net.apecombatlog.listener.*;
import org.bstats.bukkit.Metrics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class ApeCombatLog extends JavaPlugin {

    private static ApeCombatLog instance;

    @Override
    public void onEnable() {
        instance = this;
        instance.getLogger().info("");
        instance.getLogger().info("Please Rate us - https://www.spigotmc.org/resources/simple-combat-log.111737/");
        instance.getLogger().info("");
        instance.getLogger().info("Looking for GOOD Hosting? - https://monkeyhost.co &7(message sent only to operators)");
        instance.getLogger().info("");
        saveDefaultConfig();
        reloadConfig();
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new LogListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new ElytraListener(), this);
        Bukkit.getPluginManager().registerEvents(new CommandListener(), this);

        int pluginId = 19373; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
        getCommand("combatreload").setExecutor(new ReloadCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ApeCombatLog getInstance() {
        return instance;
    }



}
