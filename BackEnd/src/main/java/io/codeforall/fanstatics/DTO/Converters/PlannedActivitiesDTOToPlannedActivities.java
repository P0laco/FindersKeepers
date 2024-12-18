package io.codeforall.fanstatics.DTO.Converters;

import io.codeforall.fanstatics.DTO.PlannedActivitiesDTO;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Services.Interfaces.PlannedActivitiesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlannedActivitiesDTOToPlannedActivities implements Converter<PlannedActivitiesDTO, PlannedActivities> {

    private PlannedActivitiesServiceInterface plannedActivitiesService;

    @Autowired
    public void setPlannedActivitiesService(PlannedActivitiesServiceInterface plannedActivitiesService) {
        this.plannedActivitiesService = plannedActivitiesService;
    }

    @Override
    public PlannedActivities convert(PlannedActivitiesDTO plannedActivitiesDTO) {

        PlannedActivities plannedActivities = (plannedActivitiesDTO.getId() != null ? plannedActivitiesService.get(plannedActivitiesDTO.getId()) : new PlannedActivities());

        plannedActivities.setDate(plannedActivitiesDTO.getDate());
        plannedActivities.setLocation(plannedActivitiesDTO.getLocation());
        plannedActivities.setTime(plannedActivitiesDTO.getTime());
        plannedActivities.setNumberOfPeople(plannedActivitiesDTO.getNumberOfPeople());

        return plannedActivities;
    }
}
