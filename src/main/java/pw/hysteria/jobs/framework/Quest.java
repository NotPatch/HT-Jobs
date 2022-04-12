package pw.hysteria.jobs.framework;

import java.util.List;

public class Quest {

    private JobType job;
    private int amount;
    private List<String> lores;
    private List<String> rewards;

    public Quest(JobType job, int amount, List<String> lores, List<String> rewards){
        this.job = job;
        this.amount = amount;
        this.lores = lores;
        this.rewards = rewards;
    }

    public JobType getJobType() {
        return job;
    }

    public int getAmount() {
        return amount;
    }

    public List<String> getLores() {
        return lores;
    }

    public List<String> getRewards() {
        return rewards;
    }
}
