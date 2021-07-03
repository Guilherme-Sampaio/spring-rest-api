package project.guilherme.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties({"appointments"})
    private ProjectModel project;

    public AppointmentModel() {

    }

    public AppointmentModel(Date startDate, Date finishDate, UserModel user, ProjectModel project) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.user = user;
        this.project = project;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public ProjectModel getProject() {
        return project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}