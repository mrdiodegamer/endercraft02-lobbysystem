package me.diode.craft02.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.diode.craft02.cmds.BuildCMD;
import me.diode.craft02.main.Main;

public class DisablerListener implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(p.hasPermission("lobby.chat")) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
			p.sendMessage(Main.prefix + "§aDu benötigst den §6Premium Rang§a, um in der Lobby schreiben zu können!");
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		
		if(!BuildCMD.allow.contains(e.getPlayer())) {
			
			e.setCancelled(true);
			e.getPlayer().sendMessage(Main.prefix + "Du darfst nichts §cdroppen");
			
		}
	}
	
	
}