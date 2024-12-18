package io.codeforall.fanstatics.Services;

import io.codeforall.fanstatics.Daos.ActivityDao;
import io.codeforall.fanstatics.Daos.Interfaces.ActivityDaoInterface;
import io.codeforall.fanstatics.Daos.Interfaces.PlannedActivitiesDaoInterface;
import io.codeforall.fanstatics.Daos.Interfaces.UserDaoInterface;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Services.Interfaces.PlannedActivitiesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlannedActivitiesService implements PlannedActivitiesServiceInterface {

    private PlannedActivitiesDaoInterface plannedActivitiesDao;
    private ActivityDaoInterface activityDao;
    private UserDaoInterface userDao;


    @Autowired
    public void setPlannedActivitiesDao(PlannedActivitiesDaoInterface plannedActivitiesDao) {
        this.plannedActivitiesDao = plannedActivitiesDao;
    }

    @Autowired
    public void setActivityDao(ActivityDaoInterface activityDao) {
        this.activityDao = activityDao;
    }

    @Autowired
    public void setUserDao(UserDaoInterface userDao) {
        this.userDao = userDao;
    }

    @Override
    public PlannedActivities get(Integer id) {
        return plannedActivitiesDao.findById(id);
    }

    @Override
    public PlannedActivities create(PlannedActivities plannedActivities) {
        return null;
    }

    @Override
    public PlannedActivities delete(PlannedActivities plannedActivities, Integer id) {
        return null;
    }

    @Override
    public List<PlannedActivities> list() {
        return plannedActivitiesDao.findAll();
    }
}
