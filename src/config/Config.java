package config;

import bean.Competitor;
import bean.User;

import java.io.Serializable;

public class Config implements Serializable {
    public User user = null;
    public Competitor[] competitors = null;

    public Config(User user) {
        this.user = user;
    }

    public Config() {

    }

    public void setUser(User user) {
        this.user = user;
        Initialization.refreshConfig();
    }

    public User getUser() {
        return user;
    }

    public void setCompetitors(Competitor[] competitors) {
        this.competitors = competitors;
        Initialization.refreshConfig();
    }

    public Competitor[] getCompetitor() {
        return competitors;
    }
}
