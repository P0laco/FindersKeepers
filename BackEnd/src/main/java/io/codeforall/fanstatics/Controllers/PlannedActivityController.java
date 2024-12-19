package io.codeforall.fanstatics.Controllers;


import io.codeforall.fanstatics.DTO.Converters.PlannedActivitiesDTOToPlannedActivities;
import io.codeforall.fanstatics.DTO.Converters.PlannedActivitiesToPlannedActivitiesDTO;
import io.codeforall.fanstatics.DTO.PlannedActivitiesDTO;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Services.ActivityService;
import io.codeforall.fanstatics.Services.Interfaces.ActivityServiceInterface;
import io.codeforall.fanstatics.Services.Interfaces.PlannedActivitiesServiceInterface;
import io.codeforall.fanstatics.Services.Interfaces.UserServiceInterface;
import io.codeforall.fanstatics.Services.PlannedActivitiesService;
import io.codeforall.fanstatics.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/planned-activities")
public class PlannedActivityController {


    private PlannedActivitiesServiceInterface plannedActivityService;

    private ActivityServiceInterface activityService;

    private UserServiceInterface userService;

    private PlannedActivitiesToPlannedActivitiesDTO plannedActivityToPlannedActivityDTO;
    private PlannedActivitiesDTOToPlannedActivities plannedActivityDTOToPlannedActivity;


    @Autowired
    public void setPlannedActivityService(PlannedActivitiesServiceInterface plannedActivityService){
        this.plannedActivityService = plannedActivityService;
    }

    @Autowired
    public void setActivityService(ActivityServiceInterface activityService){
        this.activityService = activityService;
    }

    @Autowired
    public void setUserService(UserServiceInterface userService){
        this.userService = userService;
    }

    @Autowired
    public void setPlannedActivityToPlannedActivityDTO(PlannedActivitiesToPlannedActivitiesDTO plannedActivityToPlannedActivityDTO){
        this.plannedActivityToPlannedActivityDTO = plannedActivityToPlannedActivityDTO;
    }

    @Autowired
    public void setPlannedActivityDTOToPlannedActivity(PlannedActivitiesDTOToPlannedActivities plannedActivityDTOToPlannedActivity){
        this.plannedActivityDTOToPlannedActivity = plannedActivityDTOToPlannedActivity;
    }


    //list activities
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<PlannedActivitiesDTO>> listPlannedActivities(){

       List<PlannedActivitiesDTO> plannedActivitiesDTO = plannedActivityService.list().stream()
               .map(plannedActivity -> plannedActivityToPlannedActivityDTO.convert(plannedActivity))
               .collect(Collectors.toList());

       return new ResponseEntity<>(plannedActivitiesDTO, HttpStatus.OK);

    }


    //show activity


    //add activity


    //delete activity
}
