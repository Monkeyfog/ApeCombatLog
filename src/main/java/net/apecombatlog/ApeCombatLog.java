package net.apecombatlog;

import net.apecombatlog.commands.ReloadCommand;
import org.bstats.bukkit.Metrics;

import net.apecombatlog.listener.DamageListener;
import net.apecombatlog.listener.DeathListener;
import net.apecombatlog.listener.ElytraListener;
import net.apecombatlog.listener.LogListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class ApeCombatLog extends JavaPlugin {

    private static ApeCombatLog instance;

    @Override
    public void onEnable() {
        instance = this;
        instance.getLogger().info("");
        instance.getLogger().info("Please Rate us - https://www.spigotmc.org/resources/simple-combat-log.111737/");
        instance.getLogger().info("");
        instance.getLogger().info("Looking for GOOD Hosting? - https://monkeyhost.co");
        instance.getLogger().info("");
        saveDefaultConfig();
        reloadConfig();
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new LogListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new ElytraListener(), this);

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
