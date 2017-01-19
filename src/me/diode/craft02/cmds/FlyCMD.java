package me.diode.craft02.cmds;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.diode.craft02.main.Main;

public class FlyCMD implements CommandExecutor{

	public static ArrayList<Player> istfly = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if((sender instanceof Player)) {
			Player p = (Player)sender;
			if(p.hasPermission("endercraft.command.fly")) {
				if(args.length == 0) {
					if(istfly.contains(p)) {
						istfly.remove(p);
						p.setAllowFlight(false);
						p.setFlying(false);
						p.sendMessage(Main.prefix + "Du kannst nun nicht mehr fliegen!");
					} else {
						istfly.add(p);
						p.setAllowFlight(true);
						p.setFlying(true);
						p.sendMessage(Main.prefix + "Du kannst nun fliegen!");
					}
				} else if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						if(istfly.contains(target)) {
							istfly.remove(target);
							target.setAllowFlight(false);
							target.setFlying(false);
							target.sendMessage(Main.prefix + "Du kannst nun nicht mehr fliegen!");
							p.sendMessage(Main.prefix + "Der Spieler §c" + target.getName() + "§a kann nun nicht mehr fliegen.");
						} else {
							istfly.add(target);
							target.setAllowFlight(true);
							target.setFlying(true);
							target.sendMessage(Main.prefix + "Du kannst nun fliegen!");
							p.sendMessage(Main.prefix + "Der Spieler §c" + target.getName() + "§a kann nun fliegen.");
						}
					} else {
						p.sendMessage(Main.prefix + "Ausgewählter Spieler ist offline.");
					}
				} else {
					p.sendMessage(Main.prefix + "Nutze bitte /fly <Spieler>");
				}
			} else{
				p.sendMessage(Main.noperm);
			}
		} else {
			sender.sendMessage(Main.prefix + "Du musst ein Spieler sein.");
		}
		return false;
	}

}
