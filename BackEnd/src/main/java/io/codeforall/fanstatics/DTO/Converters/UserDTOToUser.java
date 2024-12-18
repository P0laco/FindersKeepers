package io.codeforall.fanstatics.DTO.Converters;

import io.codeforall.fanstatics.DTO.UserDTO;
import io.codeforall.fanstatics.Models.User;
import io.codeforall.fanstatics.Services.Interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;


@Component
public class UserDTOToUser implements Converter<UserDTO, User> {

    private UserServiceInterface userService;

    @Autowired
    public void setUserService(UserServiceInterface userService){
        this.userService = userService;
    }


    @Override
    public User convert(UserDTO userDTO) {

        User user = (userDTO.getId() != null ? userService.get(userDTO.getId()) : new User());

        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setLocation(userDTO.getLocation());
        user.setPassword(userDTO.getPassword());

        return user;
    }
}
