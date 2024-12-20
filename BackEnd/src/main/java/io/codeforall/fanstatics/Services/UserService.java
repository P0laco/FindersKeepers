package io.codeforall.fanstatics.Services;

import io.codeforall.fanstatics.Daos.Interfaces.PlannedActivitiesDaoInterface;
import io.codeforall.fanstatics.Daos.Interfaces.UserDaoInterface;
import io.codeforall.fanstatics.Daos.UserDao;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Models.User;
import io.codeforall.fanstatics.Services.Interfaces.UserServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {


    private UserDaoInterface userDao;

    private PlannedActivitiesDaoInterface plannedActivitiesDao;


    @Autowired
    public void setUserDao(UserDaoInterface userDao){
        this.userDao = userDao;
    }

    @Autowired
    public void setPlannedActivitiesDao(PlannedActivitiesDaoInterface plannedActivitiesDao){
        this.plannedActivitiesDao = plannedActivitiesDao;
    }

    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }


    @Transactional
    @Override
    public User save(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        User user = Optional.ofNullable(userDao.findById(id))
                .orElseThrow(Error::new);

        if(!user.getPlannedActivities().isEmpty()) {
            throw new RuntimeException("U have activities");
        }

        userDao.delete(id);
    }

    @Override
    public PlannedActivities addPlannedActivities(Integer id, PlannedActivities plannedActivities) {

        return plannedActivitiesDao.saveOrUpdate(plannedActivities);
    }
}
