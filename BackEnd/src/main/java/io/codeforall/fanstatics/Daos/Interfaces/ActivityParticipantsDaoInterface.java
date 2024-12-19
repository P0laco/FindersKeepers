package io.codeforall.fanstatics.Daos.Interfaces;

import io.codeforall.fanstatics.DTO.ActivityDTO;
import io.codeforall.fanstatics.DTO.UserDTO;
import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Models.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface ActivityParticipantsDaoInterface<T> {

    //getActivityParticipantsByActivityId
    public List<UserDTO> getUsersInPlannedActivity(Integer plannedActivityId);    //getActivityParticipantsByUserId
    public List<ActivityDTO> getActivitiesForUser(Integer userId);
    //addActivityParticipant
    public void addUserToPlannedActivity(Integer userId, Integer plannedActivityId);
    //deleteActivityParticipant
    public void deleteUserFromPlannedActivity(Integer userId, Integer plannedActivityId);
}
