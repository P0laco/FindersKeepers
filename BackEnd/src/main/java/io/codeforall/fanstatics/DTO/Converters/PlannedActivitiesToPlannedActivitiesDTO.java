package io.codeforall.fanstatics.DTO.Converters;

import io.codeforall.fanstatics.DTO.PlannedActivitiesDTO;
import io.codeforall.fanstatics.Models.PlannedActivities;
import org.springframework.stereotype.Component;

@Component
public class PlannedActivitiesToPlannedActivitiesDTO extends AbstractConverter<PlannedActivities, PlannedActivitiesDTO> {


    @Override
    public PlannedActivitiesDTO convert(PlannedActivities plannedActivities) {

        PlannedActivitiesDTO plannedActivitiesDTO = new PlannedActivitiesDTO();
        plannedActivitiesDTO.setId(plannedActivities.getId());
        plannedActivitiesDTO.setLocation(plannedActivities.getLocation());
        plannedActivitiesDTO.setDate(plannedActivities.getDate());
        plannedActivitiesDTO.setTime(plannedActivities.getTime());
        plannedActivitiesDTO.setNumberOfPeople(plannedActivities.getNumberOfPeople());

        return plannedActivitiesDTO;

    }
}
