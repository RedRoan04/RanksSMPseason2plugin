package ga.schoolsmpserver.rankssmpseason2;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;


public class blockbreakListener implements Listener {

    public int blokkenGebroken;
    public int blocksPlaced;
    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
        String playerBreaking = event.getPlayer().getName();
        String command = "lps expgive " + playerBreaking + "1";
        Player p = event.getPlayer();
        blokkenGebroken += 1;
        String bbroken = "%statz_blocks_broken%";
        bbroken = PlaceholderAPI.setPlaceholders(event.getPlayer(), bbroken);
        if (blokkenGebroken >= 100) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            p.sendMessage("XP gegeven, " + bbroken + " blokken gebroken");
            blokkenGebroken = 0;
        }


    }
    @EventHandler
    public void onAdvancementMade(PlayerAdvancementDoneEvent e){
        Player p = e.getPlayer();
        String NamePlayer = p.getName();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lps expgive " + NamePlayer + "0.1");
        p.sendMessage("Advancement made" + e.getAdvancement().getKey().getKey());

    }

    @EventHandler
    public void blockPlacedEvent(BlockPlaceEvent e){
        Player p = e.getPlayer();
        String namePlayer = p.getName();
        String command = "lps expgive " + namePlayer + "0.1";
        blocksPlaced += 1;
        String bplaced = "%statz_blocks_placed%";
        bplaced = PlaceholderAPI.setPlaceholders(e.getPlayer(), bplaced);
        if (blocksPlaced >= 100) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            p.sendMessage("XP gegeven, " + bplaced + " blokken geplaatst");
            blokkenGebroken = 0;
        }
    }


}
