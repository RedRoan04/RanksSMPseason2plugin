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
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("rank")) {
            if (sender instanceof Player) {
                if (p.hasPermission("rank.use")) {
                    if (args.length == 0) {
                        p.sendMessage("§cTry: §7/rank set <Player> <Rank>");
                    } else if (args[0].equalsIgnoreCase("set")) {
                        if (args.length == 1) {
                            p.sendMessage("§cTry: §7/rank set <Player> <Rank>");
                        } else if (args.length == 2 && args[2].equalsIgnoreCase("")) {
                            p.sendMessage("§cTry: §7/rank set <Player> <Rank>");
                        } else if (args[2].equalsIgnoreCase("stone")) {
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if (!(RankSystem.getRank(target) == Ranks.Stone)) {
                                RankSystem.setRank(target, (Ranks.Stone));
                                String rank = ChatColor.DARK_GRAY + "" + RankSystem.getRank(p);

                                p.sendMessage("§a" + target.getName() + "§7 heeft de volgende rank gekregen: §eStone§7.");
                                p.setPlayerListName(ChatColor.DARK_GRAY + rank.toString() + ": " + ChatColor.RESET + p.getName());
                                p.setDisplayName(ChatColor.DARK_GRAY + rank.toString() + ": " + ChatColor.RESET + p.getName());
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eStone§7.");
                            }
                        } else if (args[2].equalsIgnoreCase("leather")) {
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if (!(RankSystem.getRank(target) == Ranks.Leather)) {
                                RankSystem.setRank(target, (Ranks.Leather));
                                String rank = ChatColor.GOLD + "" + RankSystem.getRank(p);
                                p.sendMessage("§a" + target.getName() + "§7 heeft de volgende rank gekregen: §eLeather§7.");
                                p.setPlayerListName(ChatColor.GOLD + rank.toString() + ": " + ChatColor.RESET + p.getName());
                                p.setDisplayName(ChatColor.GOLD + rank.toString() + ": " + ChatColor.RESET + p.getName());
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eLeather§7.");
                            }
                        } else if (args[2].equalsIgnoreCase("Iron")) {
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if (!(RankSystem.getRank(target) == Ranks.Iron)) {
                                RankSystem.setRank(target, (Ranks.Iron));
                                String rank = ChatColor.WHITE + "" + RankSystem.getRank(p);

                                p.sendMessage("§a" + target.getName() + "§7 heeft de volgende rank gekregen: §eIron§7.");
                                p.setPlayerListName(ChatColor.WHITE + rank.toString() + ": " + ChatColor.RESET + p.getName());
                                p.setDisplayName(ChatColor.WHITE + rank.toString() + ": " + ChatColor.RESET + p.getName());
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 heeft de volgende rank gekregen: §eIron§7.");
                            }
                        } else if (args[2].equalsIgnoreCase("gold")) {
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if (!(RankSystem.getRank(target) == Ranks.Gold)) {
                                RankSystem.setRank(target, (Ranks.Gold));
                                String rank = ChatColor.YELLOW + "" + RankSystem.getRank(p);
                                p.sendMessage("§a" + target.getName() + "§7 heeft de volgende rank gekregen: §eGold§7.");
                                p.setPlayerListName(ChatColor.YELLOW + rank.toString() + ": " + ChatColor.RESET + p.getName());
                                p.setDisplayName(ChatColor.YELLOW + rank.toString() + ": " + ChatColor.RESET + p.getName());
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eGold§7.");
                            }
                        } else if (args[2].equalsIgnoreCase("Diamond")) {
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if (!(RankSystem.getRank(target) == Ranks.Diamond)) {
                                RankSystem.setRank(target, (Ranks.Diamond));
                                String rank = ChatColor.AQUA + "" + RankSystem.getRank(p);

                                p.sendMessage("§a" + target.getName() + "§7 heeft de volgende rank gekregen: §eDiamond§7.");
                                p.setPlayerListName(ChatColor.AQUA + rank.toString() + ": " + ChatColor.RESET + p.getName());
                                p.setDisplayName(ChatColor.AQUA + rank.toString() + ": " + ChatColor.RESET + p.getName());
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eDiamond§7.");
                            }
                        } else if (args[2].equalsIgnoreCase("Netherite")) {
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);

                            if (!(RankSystem.getRank(target) == Ranks.Netherite)) {
                                RankSystem.setRank(target, (Ranks.Netherite));
                                String rank = ChatColor.DARK_BLUE + "" + RankSystem.getRank(p);

                                p.sendMessage("§a" + target.getName() + "§7 heeft de volgende rank gekregen: §eNetherite§7.");
                                p.setPlayerListName(ChatColor.DARK_BLUE + rank.toString() + ": " + ChatColor.RESET + p.getName());
                                p.setDisplayName(ChatColor.DARK_BLUE + rank.toString() + ": " + ChatColor.RESET + p.getName());
                            } else {
                                p.sendMessage("§a" + target.getName() + "§7 already has the Rank §eNetherite§7.");
                            }
                        }
                    }
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("rankup")) {

            if (args.length == 1) {
                Player target = Bukkit.getServer().getPlayerExact(args[0]);
                if (RankSystem.getRank(p) == Ranks.Netherite) {
                    target.sendMessage("Je hebt al de hoogste rank");
                } else if (RankSystem.getRank(p) == Ranks.Diamond) {
                    RankSystem.setRank(target, Ranks.Netherite);
                    target.sendMessage("Je hebt nu de netherite rank, dit is de hoogste rank mogelijk in de server");
                } else if (RankSystem.getRank(p) == Ranks.Gold) {
                    RankSystem.setRank(target, Ranks.Diamond);
                    target.sendMessage("Je hebt nu de diamond rank ");
                } else if (RankSystem.getRank(p) == Ranks.Iron) {
                    RankSystem.setRank(target, Ranks.Gold);
                    target.sendMessage("Je hebt nu de gold rank");
                } else if (RankSystem.getRank(p) == Ranks.Leather) {
                    RankSystem.setRank(target, Ranks.Iron);
                    target.sendMessage("Je hebt nu de iron rank");
                } else if (RankSystem.getRank(p) == Ranks.Stone) {
                    RankSystem.setRank(target, Ranks.Leather);
                    target.sendMessage("Je hebt nu de leather rank");
                }
            }
        }
        return true;
    }
}
