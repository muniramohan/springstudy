package com.bnp.showroom.prototypes;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "PROJECT_PROTOTYPES")
public class Prototypes {

    @Id
    @Column(name = "PROTOTYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROTOTYPE_ID_SEQ")
    @SequenceGenerator(name = "PROTOTYPE_ID_SEQ", sequenceName = "PROTOTYPE_ID_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    @Column(name="CREATED_DATE")
    @CreationTimestamp
    private Date createdDate;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="URL")
    private String URL;

    @Column(name="PROJECT_ID")
    @NotNull
    private long projectId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
