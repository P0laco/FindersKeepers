package io.codeforall.fanstatics.Services.Interfaces;

import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Models.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface ActivityParticipantsInterface {


    public List<User> getUsersInPlannedActivity(Integer plannedActivityId);

    public List<PlannedActivities> getActivitiesForUser(Integer userId);

    public void addUserToPlannedActivity(Integer userId, Integer plannedActivityId);

    public void deleteUserFromPlannedActivity(Integer userId, Integer plannedActivityId);
}
