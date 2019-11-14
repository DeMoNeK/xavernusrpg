package demonek.xavernusrpg.core.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ChatUtil {

	public static String fixColor(String text)
	{
	  return ChatColor.translateAlternateColorCodes('&', text.replace(">>", ">").replace("<<", "<").replace("*", "*").replace("{O}", "[]"));
	}
	public static void sendTitle(Player player, String text) {

		IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

		PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(5, 20, 5);


		((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);
	}

	public static void sendSubTitle(Player player, String text) {

		IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

		PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(5, 20, 5);


		((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);
	}

	public static void sendActionBar(Player player, String text) {
		IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\"}");
		PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte) 2);

		((CraftPlayer) player).getHandle().playerConnection.sendPacket(bar);
	}
}
