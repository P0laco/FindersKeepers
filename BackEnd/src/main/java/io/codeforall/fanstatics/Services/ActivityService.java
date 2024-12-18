package io.codeforall.fanstatics.Services;

import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Services.Interfaces.ActivityServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class ActivityService implements ActivityServiceInterface {


    @Override
    public Activity listActivity() {
        return null;
    }

    @Override
    public Activity get(Integer id) {
        return null;
    }
}
