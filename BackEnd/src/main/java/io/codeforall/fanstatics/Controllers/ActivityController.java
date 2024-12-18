package io.codeforall.fanstatics.Controllers;

import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {


    private ActivityService activityService;

    @Autowired
    public void setActivityService(ActivityService activityService){
        this.activityService = activityService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/activity")
    public ResponseEntity<List<Activity>> listActivity() {

        Activity activity = activityService.get();

        if (activity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Activity> activity = activity.getActivities().stream().map(activity.stream().collect());

        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<Activity> get(@PathVariable Integer id) {

        Activity activity = activityService.get(id);

        if(activity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(!activity.getActivity().getId().equals(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(activity, HttpStatus.OK);
    }
}
