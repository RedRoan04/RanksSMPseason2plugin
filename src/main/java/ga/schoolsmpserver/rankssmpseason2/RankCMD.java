package ga.schoolsmpserver.rankssmpseason2;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class RankCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rankup")) {
            if (args.length == 1) {
                Player target = Bukkit.getServer().getPlayerExact(args[0]);
                if (RankSystem.getRank(target) == Ranks.Netherite) {
                    target.sendMessage("Je hebt al de hoogste rank");
                } else if (RankSystem.getRank(target) == Ranks.Diamond) {
                    RankSystem.setRank(target, Ranks.Netherite);
                    target.sendMessage("Je hebt nu de netherite rank, dit is de hoogste rank mogelijk in de server");
                } else if (RankSystem.getRank(target) == Ranks.Gold) {
                    RankSystem.setRank(target, Ranks.Diamond);
                    target.sendMessage("Je hebt nu de diamond rank ");
                } else if (RankSystem.getRank(target) == Ranks.Iron) {
                    RankSystem.setRank(target, Ranks.Gold);
                    target.sendMessage("Je hebt nu de gold rank");
                } else if (RankSystem.getRank(target) == Ranks.Leather) {
                    RankSystem.setRank(target, Ranks.Iron);
                    target.sendMessage("Je hebt nu de iron rank");
                } else if (RankSystem.getRank(target) == Ranks.Stone) {
                    RankSystem.setRank(target, Ranks.Leather);
                    target.sendMessage("Je hebt nu de leather rank");
                }
            }
        }
        return true;
    }
}
