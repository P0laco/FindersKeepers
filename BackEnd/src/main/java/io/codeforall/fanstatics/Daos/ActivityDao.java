package io.codeforall.fanstatics.Daos;

import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Daos.Interfaces.ActivityDaoInterface;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityDao extends GenericDao<Activity> implements ActivityDaoInterface {


    public ActivityDao() {
        super(Activity.class);
    }
}
