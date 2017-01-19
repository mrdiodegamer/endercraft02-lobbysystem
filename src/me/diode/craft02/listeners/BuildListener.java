package me.diode.craft02.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.diode.craft02.cmds.BuildCMD;
import me.diode.craft02.main.Main;

public class BuildListener implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		if(!BuildCMD.allow.contains(e.getPlayer())) {
			
			e.setCancelled(true);
			e.getPlayer().sendMessage(Main.prefix + "Du darfst nichts §czerstören");
			
		}
		
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		if(!BuildCMD.allow.contains(e.getPlayer())) {
			
			e.setCancelled(true);
			e.getPlayer().sendMessage(Main.prefix + "Du darfst nichts §cplatzieren");
			
		}
		
	}

}
