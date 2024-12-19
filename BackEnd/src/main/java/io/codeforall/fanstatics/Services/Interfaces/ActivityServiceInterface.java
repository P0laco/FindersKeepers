package io.codeforall.fanstatics.Services.Interfaces;

import io.codeforall.fanstatics.Models.Activity;

import java.util.List;

public interface ActivityServiceInterface {


    Activity listActivity();


    Activity get(Integer id);

    List<Activity> list();

}
