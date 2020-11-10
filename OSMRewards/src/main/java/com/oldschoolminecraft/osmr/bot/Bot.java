package com.oldschoolminecraft.osmr.bot;

import com.oldschoolminecraft.osmr.Plugin;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;

public class Bot extends Thread
{   
    private Thread thread;
    
    private DiscordClient client;
    private GatewayDiscordClient gateway;
    
    public void enable()
    {
        thread = new Thread(this);
        thread.start();
    }
    
    public void disable()
    {
        try
        {
            thread.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void run()
    {
        client = DiscordClient.create(Plugin.instance.getConfig().token);
        gateway = client.login().block();
        
        gateway.on(MessageCreateEvent.class).subscribe(event ->
        {
            final Message message = event.getMessage();
            final User author = message.getAuthor().isPresent() ? message.getAuthor().get() : null;
            
            if (message.getContent().startsWith("!"))
            {
                if (author != null && !author.isBot())
                {
                    
                }
            }
        });
    }
}
