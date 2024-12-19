package io.codeforall.fanstatics.Services;

import io.codeforall.fanstatics.Daos.ActivityParticipantsDao;
import io.codeforall.fanstatics.Daos.Interfaces.ActivityParticipantsDaoInterface;
import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Models.User;
import io.codeforall.fanstatics.Services.Interfaces.ActivityParticipantsInterface;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityParticipantsService implements ActivityParticipantsInterface {

    private ActivityParticipantsDaoInterface activityParticipantsDao;

    @Autowired
    public void setActivityParticipantsDao(ActivityParticipantsDaoInterface activityParticipantsDao) {
        this.activityParticipantsDao = activityParticipantsDao;
    }

    @Override
    public List<User> getUsersInPlannedActivity(Integer plannedActivityId) {
        return new ArrayList<>(activityParticipantsDao.getUsersInPlannedActivity(plannedActivityId));
    }

    @Override
    public List<PlannedActivities> getActivitiesForUser(Integer userId) {
        return new ArrayList<>(activityParticipantsDao.getActivitiesForUser(userId));
    }

    @Override
    public void addUserToPlannedActivity(Integer userId, Integer plannedActivityId) {
       activityParticipantsDao.addUserToPlannedActivity(userId, plannedActivityId);
    }

    @Override
    public void deleteUserFromPlannedActivity(Integer userId, Integer plannedActivityId) {
        activityParticipantsDao.deleteUserFromPlannedActivity(userId, plannedActivityId);
    }
}
