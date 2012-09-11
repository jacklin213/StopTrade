package me.WolfMaster.stoptrade;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
    public void onEnable(){ 
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		this.logger.info("[StopTrade] has been Enabled!");
    }
    
    
    public void onDisable(){ 
    this.logger.info("[StopTrade] Has Been Disabled!");
    }
	@EventHandler
	public void onNpcTrade(PlayerInteractEntityEvent event){
		if (event.getRightClicked() instanceof Villager){
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "Trading With NPC's Has Been Disabled!");
		}
	}
}
