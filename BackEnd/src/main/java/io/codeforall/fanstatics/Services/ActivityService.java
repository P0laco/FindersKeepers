package io.codeforall.fanstatics.Services;

import io.codeforall.fanstatics.Daos.ActivityDao;
import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Services.Interfaces.ActivityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class ActivityService implements ActivityServiceInterface {

    private ActivityDao activityDao;

    @Autowired
    public void setActivityDao(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public Activity listActivity() {
        return null;
    }

    @Override
    public Activity get(Integer id) {
        return null;
    }

    @Override
    public List<Activity> list() {

        return activityDao.findAll();
    }
}
