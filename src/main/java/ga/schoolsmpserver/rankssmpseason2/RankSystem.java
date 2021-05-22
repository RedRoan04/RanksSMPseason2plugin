package ga.schoolsmpserver.rankssmpseason2;

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
    }

    public static Ranks getRank(Player p){
        String value = cfg.getString("Ranks." + p.getUniqueId());
        return (value == null ? Ranks.Stone : Ranks.valueOf(value));
    }

    public boolean hasRank(Player p, Ranks rank){
        return (getRank(p).compareTo(Ranks.valueOf(String.valueOf(rank))) <= 0);
    }
}
