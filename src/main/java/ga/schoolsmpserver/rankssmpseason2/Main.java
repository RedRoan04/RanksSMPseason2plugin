package ga.schoolsmpserver.rankssmpseason2;


import org.bukkit.Bukkit;
//import entities
import org.bukkit.entity.Player;
//import events
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
//import plugin
import org.bukkit.plugin.java.JavaPlugin;
//import ranks
import ga.schoolsmpserver.rankssmpseason2.Ranks;
//import Placeholder API
import me.clip.placeholderapi.PlaceholderAPI;

public class Main extends JavaPlugin implements Listener {
    public void onEnable(){
        //Print start plugin
        System.out.println("Starting RankSystem plugin.");
        //Call commands listener
        register1();

        //check for placeholder api
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new rankExpansion(this).register();
        }

        //Disabled blockbreaklistener but still calling for register event.
        getServer().getPluginManager().registerEvents(new blockbreakListener(), this);

        //Print plugin started
        System.out.println("RankSystem plugin has started");
    }

    @Override
    public void onDisable() {
        System.out.println("RankSystem plugin disabled");

    }
    public void register1(){
        getCommand("rank").setExecutor(new RankCMD());

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        //set jointext
        String joinText = "%player_name% &ais de server binnengekomen!";
        joinText = PlaceholderAPI.setPlaceholders(e.getPlayer(), joinText);
        e.setJoinMessage(joinText);

        //set player display and playerlistname
        Ranks Rank = RankSystem.getRank(p);
        p.setPlayerListName(Rank.getPrefix() + ": " + p.getName());
        p.setDisplayName(Rank.getPrefix() + ": " + p.getName());

    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){

        //set leavetext
        String leaveText = "%player_name% &aheeft de server verlaten :(";
        leaveText = PlaceholderAPI.setPlaceholders(e.getPlayer(), leaveText);
        e.setQuitMessage(leaveText);
    }






}
