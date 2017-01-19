package me.diode.craft02.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.diode.craft02.cmds.BuildCMD;
import me.diode.craft02.utils.Items;
import me.diode.craft02.utils.Navigator;

public class InventoryClickListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		Player p = (Player)e.getWhoClicked();
			
		if(e.getClickedInventory().contains(Items.createItem(Material.COMPASS, 0, "§6Navigator §8> §cöffnen")) || e.getClickedInventory().contains(Items.createItem(Material.DIAMOND_SWORD, 0, "§cZurück"))) {
			
			if(!BuildCMD.allow.contains((Player)e.getWhoClicked())) {
				
				e.setCancelled(true);
				
			}
		
		
	}
	}
	
}


