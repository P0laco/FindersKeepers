package io.codeforall.fanstatics.Services.Interfaces;

import io.codeforall.fanstatics.Models.Activity;

public interface ActivityServiceInterface {


    Activity listActivity();


    Activity get(Integer id);

}
