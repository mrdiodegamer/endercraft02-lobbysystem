package me.diode.craft02.cmds;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.diode.craft02.main.Main;
import me.diode.craft02.utils.Items;

public class BuildCMD implements CommandExecutor {

	public static ArrayList<Player> allow = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		
		if(p.hasPermission("lobby.build")) {
			
			if(allow.contains(p)) {
				
				allow.remove(p);
				p.sendTitle(Main.prefix, "§eDu kannst nun nicht mehr §cbauen & abbauen§e!");
				p.setGameMode(GameMode.ADVENTURE);
				ItemsGeben(p);
				
			} else {
				
				allow.add(p);
				p.sendTitle(Main.prefix, "§eDu kannst nun §cbauen & abbauen§e!");
				p.setGameMode(GameMode.CREATIVE);
				p.getInventory().clear();
				
			}
			
		} else {
			p.sendMessage(Main.noperm);
		}
				
		return false;
	}
	
	public void ItemsGeben(Player e) {
		
		Player p = e.getPlayer();
		
		p.getInventory().clear();
		p.getInventory().setItem(2, Items.createItem(Material.BLAZE_ROD, 0, "§6Spieler §8> §cverstecken"));
		p.getInventory().setItem(4, Items.createItem(Material.COMPASS, 0, "§6Navigator §8> §cöffnen"));
		p.getInventory().setItem(6, Items.createItem(Material.CHEST, 0, "§6Gadgets §8> §cöffnen"));
		p.setFoodLevel(30);
		}
}

