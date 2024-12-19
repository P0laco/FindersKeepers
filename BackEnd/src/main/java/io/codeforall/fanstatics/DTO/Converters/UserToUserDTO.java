package io.codeforall.fanstatics.DTO.Converters;

import io.codeforall.fanstatics.DTO.UserDTO;
import io.codeforall.fanstatics.Models.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTO extends AbstractConverter<User, UserDTO>{


    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        userDTO.setEmail(user.getEmail());
        userDTO.setLocation(user.getLocation());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
