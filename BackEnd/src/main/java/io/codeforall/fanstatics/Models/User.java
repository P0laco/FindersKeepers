package io.codeforall.fanstatics.Models;

import io.codeforall.fanstatics.Models.PlannedActivities;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // This is ManyToOne, as a user belongs to one planned activity
    @ManyToOne
    @JoinColumn(name = "planned_activity_id")  // Foreign key column
    private PlannedActivities plannedActivities;

    // OneToMany to indicate that this user can have many activities (activity participants)
    @OneToMany(mappedBy = "user")
    private Set<ActivityParticipants> activityParticipants;

    public Set<ActivityParticipants> getActivityParticipants() {
        return activityParticipants;
    }

    public void setActivityParticipants(Set<ActivityParticipants> activityParticipants) {
        this.activityParticipants = activityParticipants;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PlannedActivities getPlannedActivities() {
        return plannedActivities;
    }

    public void setPlannedActivities(PlannedActivities plannedActivities) {
        this.plannedActivities = plannedActivities;
    }
}
