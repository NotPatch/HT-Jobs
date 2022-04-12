package pw.hysteria.jobs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import pw.hysteria.jobs.data.PlayerData;
import pw.hysteria.jobs.framework.JobType;
import pw.hysteria.jobs.framework.Quest;

import java.util.HashMap;
import java.util.UUID;

public class PlayerProfile {

    Player p;
    FileConfiguration data;
    PlayerData database;

    private static HashMap<UUID, Quest> questMap = new HashMap<UUID, Quest>();

    public PlayerProfile(Player p){
        this.p = p;
        this.database = new PlayerData(p);
        this.data = database.getData();
    }

    public void createProfile(JobType job){
        if(!data.isSet("jobs." + job.getDisplayName())){
            data.set("jobs.point", 0);
            data.set("jobs." + job.getDisplayName() + ".level", 0);
            data.set("jobs." + job.getDisplayName() + ".xp", 0);
            database.saveData(p);
        }
    }

    public int getExperience(){
        return data.getInt("jobs." + getJob() + ".xp");
    }

    public int getLevel(){
        return data.getInt("jobs." + getJob() + ".level");
    }

    public int getExperience(JobType job){
        return data.getInt("jobs." + job.getDisplayName() + ".xp");
    }

    public int getLevel(JobType job){
        return data.getInt("jobs." + job.getDisplayName() + ".level");
    }

    public JobType getJob(){
        return JobType.valueOf(data.getString("jobs.job"));
    }

    public int getPoint(){
        return data.getInt("jobs.point");
    }

    public void addExperience(int experience){
        data.set("jobs." + getJob().getDisplayName() + ".xp", getExperience() + experience);
    }

    public void addLevel(int level){
        data.set("jobs." + getJob().getDisplayName() + ".level", getLevel() + level);
    }

    public void setJob(JobType job){
        createProfile(job);
        data.set("jobs.job", job.getDisplayName());
    }

    public void setQuest(Player p, Quest quest){
        questMap.put(p.getUniqueId(), quest);
    }

    public Quest getQuest(Player p){
        return questMap.get(p.getUniqueId());
    }

}
