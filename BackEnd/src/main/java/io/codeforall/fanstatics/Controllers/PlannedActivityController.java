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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/planned-activities")
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
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<PlannedActivitiesDTO> getPlannedActivity(@PathVariable Integer id){

        PlannedActivities plannedActivities = plannedActivityService.get(id);

        if(plannedActivities == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(plannedActivityToPlannedActivityDTO.convert(plannedActivities), HttpStatus.OK);
    }

    //add activity

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public ResponseEntity<?> addPlannedActivity(@Valid @RequestBody PlannedActivitiesDTO plannedActivitiesDTO, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){

        if(bindingResult.hasErrors() || plannedActivitiesDTO.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

       try {
           PlannedActivities plannedActivities = plannedActivityService.create(plannedActivityDTOToPlannedActivity.convert(plannedActivitiesDTO));
           UriComponents uriComponents = uriComponentsBuilder.path("/api/planned-activities/" + plannedActivities.getId()).build();
           HttpHeaders headers = new HttpHeaders();
           headers.setLocation(uriComponents.toUri());

           return new ResponseEntity<>(headers, HttpStatus.CREATED);

       } catch (Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

    }

    //delete activity

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<PlannedActivities> deletePlannedActivity(@PathVariable Integer id) {

        try {

            plannedActivityService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
