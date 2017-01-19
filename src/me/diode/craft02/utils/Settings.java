package me.diode.craft02.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Settings {
	
	public static void createSettings() {
		
		File ordner = new File("plugins//EnderCraft02-LobbySystem");
		File file = new File("plugins//EnderCraft02-LobbySystem//settings.yml");
		
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
		
		cfg.set("ActionbarMessage1.Nachricht", "&4&lLobbySystem");
		
		cfg.set("ActionbarMessage2.Nachricht", "&3&lMade with");
		
		cfg.set("ActionbarMessage3.Nachricht", "&a&lLove by DatIsDiode");
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean getSettings() {
		
		File file = new File("plugins//EnderCraft02-LobbySystem//settings.yml");
		
		if(file.exists()) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}

	
}
