package ga.schoolsmpserver.rankssmpseason2;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RankSystem {

    static File file = new File("plugins//RankSystem", "ranks.yml");
    static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setRank(Player p, Ranks rank) {
        cfg.set("Ranks." + p.getUniqueId(), rank.toString());

        try {
            cfg.save(file);
        } catch(IOException e){
            e.printStackTrace();
        }


        if(RankSystem.getRank(p) == Ranks.Netherite){
            p.setPlayerListName(ChatColor.DARK_BLUE + rank.toString() + ": " + ChatColor.RESET + p.getName());
            p.setDisplayName(ChatColor.DARK_BLUE + rank.toString() + ": " + ChatColor.RESET + p.getName());
        } else if(RankSystem.getRank(p) == Ranks.Diamond){
            p.setPlayerListName(ChatColor.AQUA + rank.toString() + ": " + ChatColor.RESET + p.getName());
            p.setDisplayName(ChatColor.AQUA + rank.toString() + ": " + ChatColor.RESET + p.getName());
        } else if(RankSystem.getRank(p) == Ranks.Gold){
            p.setPlayerListName(ChatColor.GOLD + rank.toString() + ": " + ChatColor.RESET + p.getName());
            p.setDisplayName(ChatColor.GOLD + rank.toString() + ": " + ChatColor.RESET + p.getName());

        } else if(RankSystem.getRank(p) == Ranks.Iron){
            p.setPlayerListName(ChatColor.WHITE + rank.toString() + ": " + ChatColor.RESET + p.getName());
            p.setDisplayName(ChatColor.WHITE + rank.toString() + ": " + ChatColor.RESET + p.getName());

        } else if(RankSystem.getRank(p) == Ranks.Leather){
            p.setPlayerListName(ChatColor.GRAY + rank.toString() + ": " + ChatColor.RESET + p.getName());
            p.setDisplayName(ChatColor.GRAY + rank.toString() + ": " + ChatColor.RESET + p.getName());

        } else if(RankSystem.getRank(p) == Ranks.Stone){
            p.setPlayerListName(ChatColor.DARK_GRAY + rank.toString() + ": " + ChatColor.RESET + p.getName());
            p.setDisplayName(ChatColor.DARK_GRAY + rank.toString() + ": " + ChatColor.RESET + p.getName());

        }
    }

    public static Ranks getRank(Player p){
        String value = cfg.getString("Ranks." + p.getUniqueId());
        return (value == null ? Ranks.Stone : Ranks.valueOf(value));
    }

    public boolean hasRank(Player p, Ranks rank){
        return (getRank(p).compareTo(Ranks.valueOf(String.valueOf(rank))) <= 0);
    }
}
