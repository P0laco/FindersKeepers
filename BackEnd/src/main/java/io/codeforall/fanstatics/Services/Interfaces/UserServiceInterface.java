package io.codeforall.fanstatics.Services.Interfaces;

import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Models.User;

public interface UserServiceInterface {

    User get(Integer id);


    User save(User user);

    void delete(Integer id);



    PlannedActivities addPlannedActivities(Integer id, PlannedActivities plannedActivities);
}
