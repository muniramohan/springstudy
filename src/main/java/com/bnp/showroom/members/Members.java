package com.bnp.showroom.members;

import java.util.List;

/**
 * Created by CS8593 on 31.07.2018.
 */
public class Members{

    private long id;

    private long projectID;

    private List<Long> userID;

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public List<Long> getUserID() {
        return userID;
    }

    public void setUserID(List<Long> userID) {
        this.userID = userID;
    }

}
