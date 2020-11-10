package com.oldschoolminecraft.osmr;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Plugin extends JavaPlugin
{
    public static Plugin instance;
    
    private Configuration config;
    private File pluginDir = new File("plugins/OSMRewards");
    
    public void onEnable()
    {
        instance = this;
        
        if (!pluginDir.exists())
            pluginDir.mkdirs();
        
        try
        {
            File configFile = new File(pluginDir, "config.json");
            
            if (configFile.exists())
            {
                ObjectMapper mapper = new ObjectMapper();
                config = mapper.readValue(configFile, Configuration.class);
            } else {
                config = new DefaultConfiguration();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            config = new DefaultConfiguration();
        }
        
        System.out.println("OSMRewards enabled.");
    }
    
    public void onDisable()
    {
        System.out.println("OSMRewards disabled.");
    }
    
    public Configuration getConfig()
    {
        return config;
    }
}
