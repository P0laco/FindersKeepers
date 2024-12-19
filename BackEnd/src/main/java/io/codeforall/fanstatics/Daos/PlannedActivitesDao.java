package io.codeforall.fanstatics.Daos;

import io.codeforall.fanstatics.Daos.Interfaces.PlannedActivitiesDaoInterface;
import io.codeforall.fanstatics.Models.PlannedActivities;
import org.springframework.stereotype.Repository;

@Repository
public class PlannedActivitesDao extends GenericDao<PlannedActivities> implements PlannedActivitiesDaoInterface {

    public PlannedActivitesDao() {
        super(PlannedActivities.class);
    }
}
