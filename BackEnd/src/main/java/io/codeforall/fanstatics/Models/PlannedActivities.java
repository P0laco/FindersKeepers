package io.codeforall.fanstatics.Models;

import io.codeforall.fanstatics.Models.Interfaces.Model;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "planned_activities")
public class PlannedActivities implements Serializable, Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "activity_participants",
            joinColumns = @JoinColumn(name = "planned_activity_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    // Other fields
    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "number_of_people")
    private Integer numberOfPeople;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "location")
    private String location;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
