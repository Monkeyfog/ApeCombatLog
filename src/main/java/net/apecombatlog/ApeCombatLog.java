package net.apecombatlog;

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
        instance.getLogger().info("Hybro Wont LOG Anymore!");

        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new LogListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new ElytraListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ApeCombatLog getInstance() {
        return instance;
    }



}
