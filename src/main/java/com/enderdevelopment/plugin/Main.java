package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import com.enderdevelopment.plugin.commands.CustomFeatureCommand;
import com.enderdevelopment.plugin.features.FeatureManager;

public class Main extends JavaPlugin {

    private static Main instance;
    private FeatureManager featureManager;

    @Override
    public void onEnable() {
        instance = this;
        featureManager = new FeatureManager(this);
        getCommand("customfeature").setExecutor(new CustomFeatureCommand(this));
        getLogger().info("CustomFeaturesPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomFeaturesPlugin has been disabled!");
    }

    public static Main getInstance() {
        return instance;
    }

    public FeatureManager getFeatureManager() {
        return featureManager;
    }
}