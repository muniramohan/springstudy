package com.bnp.showroom.members;

import javax.persistence.*;

@Entity
public class ProjectMembers {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ID_SEQ")
    @SequenceGenerator(name = "MEMBER_ID_SEQ", sequenceName = "MEMBER_ID_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "PROJECT_ID")
    private long projectID;

    @Column(name = "USER_ID")
    private Long userID;

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

}
