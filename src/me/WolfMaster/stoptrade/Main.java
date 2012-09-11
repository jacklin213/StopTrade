package me.WolfMaster.stoptrade;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public final Logger logger = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdfFile;

	public void onEnable() {
		this.pdfFile = getDescription();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		this.getLogger().info(
				this.pdfFile.getName() + " Version: "
						+ this.pdfFile.getVersion() + " has been Enabled!");
	}

	public void onDisable() {
		this.getLogger().info(
				this.pdfFile.getName() + " Version: "
						+ this.pdfFile.getVersion() + " has been Disabled!");
	}

	@EventHandler
	public void onNpcTrade(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		if (event.getRightClicked() instanceof Villager) {
			if (!(player.hasPermission("stoptrade.allowtrade"))) {
				event.setCancelled(true);
				event.getPlayer()
						.sendMessage(
								ChatColor.RED
										+ "You do NOT have the permission to trade with NPC's!");
			}
		}
	}
}
