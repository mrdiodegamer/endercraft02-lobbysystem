package me.diode.craft02.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
	
	@EventHandler
	public void onDamageE(EntityDamageEvent e) {
		
		e.setCancelled(true);
		
	}

}
