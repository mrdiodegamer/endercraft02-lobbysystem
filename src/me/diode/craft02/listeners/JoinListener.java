package me.diode.craft02.listeners;


import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.diode.craft02.main.Main;
import me.diode.craft02.utils.Items;

public class JoinListener implements Listener {
	
	ArrayList<String> loreboots = new ArrayList<String>();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
		ItemMeta mboots = boots.getItemMeta();
		mboots.setDisplayName(Main.prefix + "§aPremium-Boots");
		mboots.setLore(loreboots);
		boots.setItemMeta(mboots);
		
		Player p = e.getPlayer();

		e.setJoinMessage(null);
		p.setMaxHealth(2);
		p.setHealth(2);
		
		p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 5, 5);
		
		p.getInventory().clear();
		p.getInventory().setItem(2, Items.createItem(Material.BLAZE_ROD, 0, "§6Spieler §8> §cverstecken"));
		p.getInventory().setItem(4, Items.createItem(Material.COMPASS, 0, "§6Navigator §8> §cöffnen"));
		p.getInventory().setItem(6, Items.createItem(Material.CHEST, 0, "§6Gadgets §8> §cöffnen"));
		if(p.hasPermission("lobby.premium")) {
			p.getInventory().setBoots(boots);
		}
	   }
	
		
	

}
