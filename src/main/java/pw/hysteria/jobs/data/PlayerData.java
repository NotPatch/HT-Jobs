package pw.hysteria.jobs.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import pw.hysteria.jobs.Jobs;

import java.io.File;

public class PlayerData {

    Jobs main;
    Player p;
    File file;
    FileConfiguration config;

    public PlayerData(Player p){
        this.p = p;
        this.file = new File(main.getDataFolder() + "/playerdata/", p.getName() + ".yml");
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getData(){
        return config;
    }

    public void saveData(Player p){
        try {
            config.save(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
