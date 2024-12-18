package io.codeforall.fanstatics.Controllers;


import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Models.User;
import io.codeforall.fanstatics.Services.ActivityService;
import io.codeforall.fanstatics.Services.PlannedActivityService;
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


    private PlannedActivityService plannedActivityService;

    private ActivityService activityService;

    private UserService userService;


    @Autowired
    public void setPlannedActivityService(PlannedActivityService plannedActivityService){
        this.plannedActivityService = plannedActivityService;
    }

    @Autowired
    public void setActivityService(ActivityService activityService){
        this.activityService = activityService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


    //list activities
    @RequestMapping(method = RequestMethod.GET, path = "/activities")
    public ResponseEntity<PlannedActivities> listPlannedActivities(){

       List<PlannedActivities> plannedActivities = plannedActivityService.list().stream().collect(Collectors.toList());

       return new ResponseEntity<>(plannedActivities, HttpStatus.OK);

    }

    //show activity


    //add activity


    //delete activity
}
