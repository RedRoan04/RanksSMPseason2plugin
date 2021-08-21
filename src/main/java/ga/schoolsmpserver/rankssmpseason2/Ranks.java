package ga.schoolsmpserver.rankssmpseason2;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;

public enum Ranks {
    Netherite(ChatColor.BLACK + "Netherite"),
    Diamond(ChatColor.AQUA + "Diamond"),
    Gold(ChatColor.YELLOW + "Gold"),
    Iron(ChatColor.WHITE + "Iron"),
    Leather(ChatColor.GOLD + "Leather"),
    Stone(ChatColor.DARK_GRAY + "Stone" );

    private String prefix;

    Ranks(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix(){
        return prefix;
    }



}
