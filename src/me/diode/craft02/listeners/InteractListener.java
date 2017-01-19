package me.diode.craft02.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.diode.craft02.main.Main;
import me.diode.craft02.utils.Items;
import me.diode.craft02.utils.Navigator;

public class InteractListener implements Listener {
	
	public static ArrayList<Player> players = new ArrayList<>();
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		try {
			
			if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
				
				if(p.getItemInHand().getItemMeta().getDisplayName().equals("§6Spieler §8> §cverstecken")) {
					
					if(p.hasPermission("lobby.hide")) {
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							
							p.hidePlayer(all);
							all.hidePlayer(p);
							players.add(p);
							
						}
						
						p.getInventory().setItem(2, Items.createItem(Material.STICK, 0, "§6Spieler §8> §aanzeigen"));
						p.sendMessage(Main.prefix + "§aDu hast alle Spieler versteckt!");
						
					} else {
					
						p.sendMessage(Main.noperm);
						
					}
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§6Spieler §8> §aanzeigen")) {
					
					if(p.hasPermission("lobby.hide")) {
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							
							p.showPlayer(all);
							all.showPlayer(p);
							players.remove(p);
							
						}
						
						p.getInventory().setItem(2, Items.createItem(Material.BLAZE_ROD, 0, "§6Spieler §8> §cverstecken"));
						p.sendMessage(Main.prefix + "§aDu siehst nun wieder alle Spieler!");
						
					} else {
					
						p.sendMessage(Main.noperm);
						
					}
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§dNick-Namer")) {
					
					if(p.hasPermission("lobby.nick")) {
						
						if(p.getDisplayName() != p.getName()) {
							
							p.setDisplayName(p.getName());
//							zTag.updatePlayer(p);
							
						} else {
							
//							p.setDisplayName(nickname);
//							zTag.updatePlayer(p);
//							p.sendMessage(Main.prefix + "§aDein neuer Nickname: §d" + p.getDisplayName());
							
						}
						
					} else {
						
						p.sendMessage(Main.noperm);
						
					}
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§6Navigator §8> §cöffnen")) {
					
					if(p.hasPermission("lobby.navigator")) {
						
						p.getInventory().clear();
						
						p.getInventory().setItem(1, Items.createItem(Material.MAGMA_CREAM, 0, "§cSpawn"));
						p.getInventory().setItem(3, Items.createItem(Material.IRON_PICKAXE, 0, "§cLeben"));
						p.getInventory().setItem(5, Items.createItem(Material.BOW, 0, "§cOneInTheChamber"));
						p.getInventory().setItem(7, Items.createItem(Material.WOOD_AXE, 0, "§cCreative"));
						p.getInventory().setItem(8, Items.createItem(Material.BARRIER, 0, "§cZurück"));
						
					} else {
						
						p.sendMessage(Main.noperm);
						
					}
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§cSpawn")) {
					
					p.teleport(Navigator.getSpawn(p));
					p.sendMessage(Main.prefix + "Du wurdest teleportiert!");
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§cLeben")) {
					
					p.teleport(Navigator.getLeben(p));
					p.sendMessage(Main.prefix + "Du wurdest teleportiert!");
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§cOneInTheChamber")) {
					
					p.teleport(Navigator.getOneInTheChamber(p));
					p.sendMessage(Main.prefix + "Du wurdest teleportiert!");
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§cCreative")) {
					
					p.teleport(Navigator.getCreative(p));
					p.sendMessage(Main.prefix + "Du wurdest teleportiert!");
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§cZurück")) {
					
					p.getInventory().clear();
					p.getInventory().setItem(2, Items.createItem(Material.BLAZE_ROD, 0, "§6Spieler §8> §cverstecken"));
					p.getInventory().setItem(4, Items.createItem(Material.COMPASS, 0, "§6Navigator §8> §cöffnen"));
					p.getInventory().setItem(6, Items.createItem(Material.CHEST, 0, "§6Gadgets §8> §cöffnen"));
					
				} else if(p.getItemInHand().getItemMeta().getDisplayName().equals("§6Gadgets §8> §cöffnen")) {
					
					Inventory inv = Bukkit.createInventory(null, 2, "§6Gadgets §8> §cöffnen");
					
					p.getInventory().setItem(1, Items.createItem(Material.BARRIER, 0, "§4§lFolgt...."));
					
					p.openInventory(inv);
					
				}
				
			}
			
		} catch(Exception e1) {
			
			e1.getMessage();
			
		}
		
		
		
	}

}
