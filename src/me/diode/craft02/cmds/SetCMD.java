package me.diode.craft02.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.diode.craft02.main.Main;
import me.diode.craft02.utils.Navigator;

public class SetCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		
		if(p.hasPermission("lobby.set")) {
			
			if(args.length != 1) {
				
				p.sendMessage(Main.prefix + "§aBitte benutze /set <SPAWN, LEBEN, OITC, CREATIVE>");
				
			} else {
				
				if(args[0].equalsIgnoreCase("SPAWN")) {
					
					Navigator.setSpawn(p);
					p.sendTitle(Main.prefix, "§aPunkt §cSpawn§a gesetzt!");
					
				} else if(args[0].equalsIgnoreCase("LEBEN")) {
					
					Navigator.setLeben(p);
					p.sendTitle(Main.prefix, "§aPunkt §cLeben§a gesetzt!");
					
				} else if(args[0].equalsIgnoreCase("OITC")) {
					
					Navigator.setOneInTheChamber(p);
					p.sendTitle(Main.prefix, "§aPunkt §cOneInTheChamber§a gesetzt!");
					
				} else if(args[0].equalsIgnoreCase("CREATIVE")) {
					
					Navigator.setCreative(p);
					p.sendTitle(Main.prefix, "§aPunkt §cCreative§a gesetzt!");
					
				} else {
					
					p.sendMessage(Main.prefix + "§aBitte benutze /set <SPAWN, LEBEN, OITC, CREATIVE>");
					
				}
				
			}
			
		} else {
			
			p.sendMessage(Main.noperm);
			
		}
		
		return false;
	}

}
