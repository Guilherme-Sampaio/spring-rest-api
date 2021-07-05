package project.guilherme.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "project")
    private List<AppointmentModel> appointments;

    @ManyToMany
    @JoinTable(
            name = "user_in_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnoreProperties(value = {"users"}, allowSetters = true)
    private List<UserModel> users;

    @Override
    public String toString() {
        return "ProjectModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public ProjectModel() {

    }

    public ProjectModel(long id, String name, List<AppointmentModel> appointments, List<UserModel> users) {
        this.id = id;
        this.name = name;
        this.appointments = appointments;
        this.users = users;
    }

    public List<AppointmentModel> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentModel> appointments) {
        this.appointments = appointments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
