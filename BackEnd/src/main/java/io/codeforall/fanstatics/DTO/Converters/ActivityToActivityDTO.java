package io.codeforall.fanstatics.DTO.Converters;

import io.codeforall.fanstatics.DTO.ActivityDTO;
import io.codeforall.fanstatics.Models.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityToActivityDTO extends AbstractConverter<Activity, ActivityDTO> {


    @Override
    public ActivityDTO convert(Activity activity) {

        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activity.getId());
        activityDTO.setName(activity.getName());
        activityDTO.setDescription(activity.getDescription());

        return activityDTO;
    }
}
