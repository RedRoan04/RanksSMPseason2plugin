package ga.schoolsmpserver.rankssmpseason2;

import jdk.nashorn.internal.ir.Block;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.conversations.ConversationPrefix;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import ga.schoolsmpserver.rankssmpseason2.Ranks;
import me.clip.placeholderapi.PlaceholderAPI;

public class Main extends JavaPlugin implements Listener {
    int x;
    int xnew;
    public void onEnable(){

        register1();
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
        getServer().getPluginManager().registerEvents(new blockbreakListener(), this);


    }

    @Override
    public void onDisable() {

    }
    public void register1(){
        getCommand("rank").setExecutor(new RankCMD());

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        String joinText = "%player_name% &ais de server binnengekomen!";

        /*
         * We parse the placeholders using "setPlaceholders"
         * This would turn %vault_rank% into the name of the Group, that the
         * joining player has.
         */
        joinText = PlaceholderAPI.setPlaceholders(e.getPlayer(), joinText);
        e.setJoinMessage(joinText);
        Player p = e.getPlayer();
        p.setPlayerListName( RankSystem.getRank(p) + p.getName());
        RankSystem.getRank(p);
        p.setDisplayName(RankSystem.getRank(p) + p.getName());

    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        String leaveText = "%player_name% &aheeft de server verlaten :(";
    }






}
