package com.oldschoolminecraft.osmr.bot.commands;

import org.bukkit.entity.Player;

import com.oldschoolminecraft.osmr.AliasMap;

import discord4j.core.object.entity.User;

public abstract class Command
{
    public final CommandType type;
    
    public Command(CommandType type)
    {
        this.type = type;
    }
    
    public abstract void executeGame(Player player, String[] args);
    public abstract void executeDiscord(User user, String[] args);
    
    public static AliasMap<String, Command> commands = new AliasMap<String, Command>();
    
    public static void register(String label, Command command, String...aliases)
    {
        commands.put(label, command);
        for (String alias : aliases)
            commands.alias(label, alias);
    }
}
