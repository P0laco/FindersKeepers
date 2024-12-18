package io.codeforall.fanstatics.Services.Interfaces;

import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Services.ActivityService;

public interface PlannedActivityServiceInterface {

    PlannedActivities get(Integer id);

    PlannedActivities create(PlannedActivities plannedActivities);

    PlannedActivities delete(PlannedActivities plannedActivities, Integer id);



}
