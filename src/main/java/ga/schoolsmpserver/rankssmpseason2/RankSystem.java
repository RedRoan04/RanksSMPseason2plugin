package ga.schoolsmpserver.rankssmpseason2;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RankSystem {

    static File file = new File("plugins//RankSystem", "ranks.yml");
    static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setRank(Player target, Ranks rank) {
        cfg.set("Ranks." + target.getUniqueId(), rank.toString());

        try {
            cfg.save(file);
        } catch(IOException e){
            e.printStackTrace();
        }


        if(RankSystem.getRank(target) == Ranks.Netherite){
            target.setPlayerListName(ChatColor.BLACK + rank.toString() + ": " + ChatColor.RESET + target.getName());
            target.setDisplayName(ChatColor.BLACK + rank.toString() + ": " + ChatColor.RESET + target.getName());
        } else if(RankSystem.getRank(target) == Ranks.Diamond){
            target.setPlayerListName(ChatColor.AQUA + rank.toString() + ": " + ChatColor.RESET + target.getName());
            target.setDisplayName(ChatColor.AQUA + rank.toString() + ": " + ChatColor.RESET + target.getName());
        } else if(RankSystem.getRank(target) == Ranks.Gold){
            target.setPlayerListName(ChatColor.YELLOW + rank.toString() + ": " + ChatColor.RESET + target.getName());
            target.setDisplayName(ChatColor.YELLOW + rank.toString() + ": " + ChatColor.RESET + target.getName());

        } else if(RankSystem.getRank(target) == Ranks.Iron){
            target.setPlayerListName(ChatColor.WHITE + rank.toString() + ": " + ChatColor.RESET + target.getName());
            target.setDisplayName(ChatColor.WHITE + rank.toString() + ": " + ChatColor.RESET + target.getName());

        } else if(RankSystem.getRank(target) == Ranks.Leather){
            target.setPlayerListName(ChatColor.GOLD + rank.toString() + ": " + ChatColor.RESET + target.getName());
            target.setDisplayName(ChatColor.GOLD + rank.toString() + ": " + ChatColor.RESET + target.getName());

        } else if(RankSystem.getRank(target) == Ranks.Stone){
            target.setPlayerListName(ChatColor.DARK_GRAY + rank.toString() + ": " + ChatColor.RESET + target.getName());
            target.setDisplayName(ChatColor.DARK_GRAY + rank.toString() + ": " + ChatColor.RESET + target.getName());

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
