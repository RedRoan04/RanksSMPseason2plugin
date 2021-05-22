package ga.schoolsmpserver.rankssmpseason2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("rank")){
            if(sender instanceof Player){
                if(p.hasPermission("rank.use")){
                    if(args.length == 0) {
                        p.sendMessage("§cTry: §7/rank set <Player> <Rank>");
                    } else if(args[0].equalsIgnoreCase("set")){
                        if(args.length == 1){
                            p.sendMessage("§cTry: §7/rank set <Player> <Rank>");
                        } else if(args.length == 2){
                            p.sendMessage("§cTry: §7/rank set <Player> <Rank>");
                        } else if(args[2].equalsIgnoreCase("stone")){
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if(!(RankSystem.getRank(target) == Ranks.Stone)){
                                RankSystem.setRank(target, (Ranks.Stone));

                                p.sendMessage("§a" + target.getName() + "§7 get the Rank §eStone§7.");
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eStone§7.");
                            }
                        } else if(args[2].equalsIgnoreCase("leather")){
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if(!(RankSystem.getRank(target) == Ranks.Leather)){
                                RankSystem.setRank(target, (Ranks.Leather));

                                p.sendMessage("§a" + target.getName() + "§7 get the Rank §eLeather§7.");
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eLeather§7.");
                            }
                        } else if(args[2].equalsIgnoreCase("Iron")){
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if(!(RankSystem.getRank(target) == Ranks.Iron)){
                                RankSystem.setRank(target, (Ranks.Iron));

                                p.sendMessage("§a" + target.getName() + "§7 get the Rank §eIron§7.");
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eIron§7.");
                            }
                        } else if(args[2].equalsIgnoreCase("gold")){
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if(!(RankSystem.getRank(target) == Ranks.Gold)){
                                RankSystem.setRank(target, (Ranks.Gold));

                                p.sendMessage("§a" + target.getName() + "§7 get the Rank §eGold§7.");
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eGold§7.");
                            }
                        } else if(args[2].equalsIgnoreCase("Diamond")){
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if(!(RankSystem.getRank(target) == Ranks.Diamond)){
                                RankSystem.setRank(target, (Ranks.Diamond));

                                p.sendMessage("§a" + target.getName() + "§7 get the Rank §eDiamond§7.");
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eDiamond§7.");
                            }
                        } else if(args[2].equalsIgnoreCase("Netherite")){
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if(!(RankSystem.getRank(target) == Ranks.Netherite)){
                                RankSystem.setRank(target, (Ranks.Netherite));

                                p.sendMessage("§a" + target.getName() + "§7 get the Rank §eNetherite§7.");
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eNetherite§7.");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
