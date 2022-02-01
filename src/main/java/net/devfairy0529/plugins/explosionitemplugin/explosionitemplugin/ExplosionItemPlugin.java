package net.devfairy0529.plugins.explosionitemplugin.explosionitemplugin;

import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import javax.swing.text.html.parser.DTD;

public final class ExplosionItemPlugin extends JavaPlugin implements Listener{

    private float ExPower;

    @Override
    public void onEnable() {
        // Plugin startup and initialize logic
        ExPower = 4F;

        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ei")){
            if(args[0].equalsIgnoreCase("expow")){
                ExPower = Float.parseFloat(args[1]);
            }
        }
        return true;
    }

    @EventHandler
    public void onGetItem(EntityPickupItemEvent e) {
        LivingEntity ent = e.getEntity();
        ent.getWorld().createExplosion(ent.getEyeLocation(),ExPower);
    }
}
