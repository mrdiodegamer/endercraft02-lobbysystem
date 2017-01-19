package me.diode.craft02.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Navigator {
	
	public static void createNavigator() {
		
		File ordner = new File("plugins//EnderCraft02-LobbySystem");
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		
		if(!ordner.exists()) {
			
			ordner.mkdirs();
			
		}
		
		if(!file.exists()) {
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set("Spawn.X", "null");
		cfg.set("Spawn.Y", "null");
		cfg.set("Spawn.Z", "null");
		cfg.set("Spawn.World", "null");
		cfg.set("Spawn.Yaw", "null");
		cfg.set("Spawn.Pitch", "null");
		
		cfg.set("Leben.X", "null");
		cfg.set("Leben.Y", "null");
		cfg.set("Leben.Z", "null");
		cfg.set("Leben.World", "null");
		cfg.set("Leben.Yaw", "null");
		cfg.set("Leben.Pitch", "null");
		
		cfg.set("OneInTheChamber.X", "null");
		cfg.set("OneInTheChamber.Y", "null");
		cfg.set("OneInTheChamber.Z", "null");
		cfg.set("OneInTheChamber.World", "null");
		cfg.set("OneInTheChamber.Yaw", "null");
		cfg.set("OneInTheChamber.Pitch", "null");
		
		cfg.set("Creative.X", "null");
		cfg.set("Creative.Y", "null");
		cfg.set("Creative.Z", "null");
		cfg.set("Creative.World", "null");
		cfg.set("Creative.Yaw", "null");
		cfg.set("Creative.Pitch", "null");
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean getNavigator() {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		
		if(file.exists()) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public static void setSpawn(Player p) {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		Location loc = p.getLocation();
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set("Spawn.X", loc.getX());
		cfg.set("Spawn.Y", loc.getY());
		cfg.set("Spawn.Z", loc.getZ());
		cfg.set("Spawn.World", loc.getWorld().getName());
		cfg.set("Spawn.Yaw", loc.getYaw());
		cfg.set("Spawn.Pitch", loc.getPitch());
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setLeben(Player p) {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		Location loc = p.getLocation();
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set("Leben.X", loc.getX());
		cfg.set("Leben.Y", loc.getY());
		cfg.set("Leben.Z", loc.getZ());
		cfg.set("Leben.World", loc.getWorld().getName());
		cfg.set("Leben.Yaw", loc.getYaw());
		cfg.set("Leben.Pitch", loc.getPitch());
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setOneInTheChamber(Player p) {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		Location loc = p.getLocation();
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set("OneInTheChamber.X", loc.getX());
		cfg.set("OneInTheChamber.Y", loc.getY());
		cfg.set("OneInTheChamber.Z", loc.getZ());
		cfg.set("OneInTheChamber.World", loc.getWorld().getName());
		cfg.set("OneInTheChamber.Yaw", loc.getYaw());
		cfg.set("OneInTheChamber.Pitch", loc.getPitch());
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setCreative(Player p) {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		Location loc = p.getLocation();
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set("Creative.X", loc.getX());
		cfg.set("Creative.Y", loc.getY());
		cfg.set("Creative.Z", loc.getZ());
		cfg.set("Creative.World", loc.getWorld().getName());
		cfg.set("Creative.Yaw", loc.getYaw());
		cfg.set("Creative.Pitch", loc.getPitch());
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static Location getSpawn(Player p) {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		Location loc = p.getLocation();
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		loc.setX(cfg.getDouble("Spawn.X"));
		loc.setY(cfg.getDouble("Spawn.Y"));
		loc.setZ(cfg.getDouble("Spawn.Z"));
		loc.setYaw((float)cfg.getDouble("Spawn.Yaw"));
		loc.setPitch((float)cfg.getDouble("Spawn.Pitch"));
		loc.setWorld(Bukkit.getWorld(cfg.getString("Spawn.World")));
		
		return loc;
		
	}
	
	public static Location getLeben(Player p) {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		Location loc = p.getLocation();
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		loc.setX(cfg.getDouble("Leben.X"));
		loc.setY(cfg.getDouble("Leben.Y"));
		loc.setZ(cfg.getDouble("Leben.Z"));
		loc.setYaw((float)cfg.getDouble("Leben.Yaw"));
		loc.setPitch((float)cfg.getDouble("Leben.Pitch"));
		loc.setWorld(Bukkit.getWorld(cfg.getString("Leben.World")));
		
		return loc;
		
	}
	
	public static Location getOneInTheChamber(Player p) {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		Location loc = p.getLocation();
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		loc.setX(cfg.getDouble("OneInTheChamber.X"));
		loc.setY(cfg.getDouble("OneInTheChamber.Y"));
		loc.setZ(cfg.getDouble("OneInTheChamber.Z"));
		loc.setYaw((float)cfg.getDouble("OneInTheChamber.Yaw"));
		loc.setPitch((float)cfg.getDouble("OneInTheChamber.Pitch"));
		loc.setWorld(Bukkit.getWorld(cfg.getString("OneInTheChamber.World")));
		
		return loc;
		
	}
	
	public static Location getCreative(Player p) {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//Navigator.yml");
		Location loc = p.getLocation();
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		loc.setX(cfg.getDouble("Creative.X"));
		loc.setY(cfg.getDouble("Creative.Y"));
		loc.setZ(cfg.getDouble("Creative.Z"));
		loc.setYaw((float)cfg.getDouble("Creative.Yaw"));
		loc.setPitch((float)cfg.getDouble("Creative.Pitch"));
		loc.setWorld(Bukkit.getWorld(cfg.getString("Creative.World")));
		
		return loc;
		
	}
	
	
}
