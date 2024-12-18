package io.codeforall.fanstatics.DTO.Converters;

import io.codeforall.fanstatics.DTO.ActivityDTO;
import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Services.ActivityService;
import io.codeforall.fanstatics.Services.Interfaces.ActivityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActivityDTOToActivity implements Converter<ActivityDTO, Activity> {


    private ActivityServiceInterface activityService;

    @Autowired
    public void setActivityService(ActivityServiceInterface activityService){
        this.activityService = activityService;
    }


    @Override
    public Activity convert(ActivityDTO activityDTO) {

        Activity activity = (activityDTO.getId() != null ? activityService.get(activityDTO.getId()) : new Activity());

        activity.setDescription(activityDTO.getDescription());
        activity.setName(activityDTO.getName());

        return activity;

    }
}
