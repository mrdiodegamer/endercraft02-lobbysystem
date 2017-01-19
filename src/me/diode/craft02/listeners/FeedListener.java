package me.diode.craft02.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FeedListener implements Listener {
	
	@EventHandler
	public void onLoseFeed(FoodLevelChangeEvent e) {
		
		e.setCancelled(true);
		
	}

}
