package pw.hysteria.jobs.framework;

import org.bukkit.entity.Player;

public class Job {

    JobType jobType;
    int level;
    int xp;
    int duration;
    int multiplier;
    Player p;

    public Job(Player p, JobType jobType, int level, int xp, int duration, int multiplier){
        this.p = p;
        this.jobType = jobType;
        this.level = level;
        this.xp = xp;
        this.duration = duration;
        this.multiplier = multiplier;
    }

}
