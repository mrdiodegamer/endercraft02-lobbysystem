package me.diode.craft02.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	
	public static ItemStack createItem(Material material, int subid, String displayname) {
		
		ItemStack item = new ItemStack(material, 1, (short) subid);
		ItemMeta mitem = item.getItemMeta();
		mitem.setDisplayName(displayname);
		item.setItemMeta(mitem);
		
		return item;
	}

}
