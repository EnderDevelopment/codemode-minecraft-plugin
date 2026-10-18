package com.enderdevelopment.plugin.features;

import org.bukkit.entity.Player;
import com.enderdevelopment.plugin.Main;
import java.util.HashMap;
import java.util.Map;

public class FeatureManager {

    private final Map<String, CustomFeature> features;
    private final Main plugin;

    public FeatureManager(Main plugin) {
        this.features = new HashMap<>();
        this.plugin = plugin;
    }

    public void addFeature(String name) {
        // In a real implementation, you would load the feature from a file or database
        features.put(name, new CustomFeature(name));
    }

    public void removeFeature(String name) {
        features.remove(name);
    }

    public void listFeatures(Player player) {
        if (features.isEmpty()) {
            player.sendMessage("No custom features loaded.");
            return;
        }

        player.sendMessage("Custom Features:");
        for (String featureName : features.keySet()) {
            player.sendMessage("- " + featureName);
        }
    }

    public CustomFeature getFeature(String name) {
        return features.get(name);
    }
}