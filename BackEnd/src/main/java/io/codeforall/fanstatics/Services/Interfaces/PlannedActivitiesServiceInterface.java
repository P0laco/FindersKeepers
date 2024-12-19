package io.codeforall.fanstatics.Services.Interfaces;

import io.codeforall.fanstatics.Models.PlannedActivities;

import java.util.List;

public interface PlannedActivitiesServiceInterface {

    PlannedActivities get(Integer id);

    PlannedActivities create(PlannedActivities plannedActivities);

    void delete( Integer id);

    List<PlannedActivities> list();



}
