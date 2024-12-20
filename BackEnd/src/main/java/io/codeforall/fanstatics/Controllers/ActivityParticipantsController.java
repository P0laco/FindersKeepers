package io.codeforall.fanstatics.Controllers;

import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Models.User;
import io.codeforall.fanstatics.Services.ActivityParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/activity-participants")
public class ActivityParticipantsController {

    private ActivityParticipantsService activityParticipantsService;

    @Autowired
    public ActivityParticipantsController(ActivityParticipantsService activityParticipantsService) {
        this.activityParticipantsService = activityParticipantsService;
    }

    //getByUserId
    @RequestMapping(method = RequestMethod.GET, path = "/planned-activity/{plannedActivityId}")
    public ResponseEntity<List<User>> listActivityParticipantsByUser(@PathVariable Integer plannedActivityId){

        List<User> activityParticipants = activityParticipantsService.getUsersInPlannedActivity(plannedActivityId);

        if(activityParticipants == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(activityParticipants, HttpStatus.OK);
    }
    //getByPlannedActivityId
    @RequestMapping(method = RequestMethod.GET, path = "/user/{userId}")
    public ResponseEntity<List<PlannedActivities>> listActivityParticipantsByPlannedActivity(@PathVariable Integer userId){

        List<PlannedActivities> activityParticipants = activityParticipantsService.getActivitiesForUser(userId);

        if(activityParticipants == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(activityParticipants, HttpStatus.OK);
    }
    //add
    @RequestMapping(method = RequestMethod.POST, path = "/add/{userId}/{plannedActivityId}")
    public ResponseEntity<?> addActivityParticipants(@Valid @RequestBody @PathVariable Integer userId, @PathVariable Integer plannedActivityId){

        /*
        if (bindingResult.hasErrors() || plannedActivityId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

         */

        try {

            activityParticipantsService.addUserToPlannedActivity(userId, plannedActivityId);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //delete
    @RequestMapping(method = RequestMethod.DELETE, path = "delete/{userId}/{plannedActivityId}")
    public ResponseEntity<?> deleteActivityParticipants(@PathVariable Integer userId, @PathVariable Integer plannedActivityId) {


            try {

                activityParticipantsService.deleteUserFromPlannedActivity(userId, plannedActivityId);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                System.out.println("Error deleting activity participant: " + e.getMessage());
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

}
