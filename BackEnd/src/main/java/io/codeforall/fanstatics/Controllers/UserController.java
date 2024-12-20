package io.codeforall.fanstatics.Controllers;

import io.codeforall.fanstatics.DTO.Converters.UserDTOToUser;
import io.codeforall.fanstatics.DTO.Converters.UserToUserDTO;
import io.codeforall.fanstatics.DTO.UserDTO;
import io.codeforall.fanstatics.Models.User;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private UserService userService;
    private UserToUserDTO userToUserDTO;
    private UserDTOToUser userDTOToUser;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Autowired
    public void setUserToUserDTO(UserToUserDTO userToUserDTO){
        this.userToUserDTO = userToUserDTO;
    }

    @Autowired
    public void setUserDTOToUser(UserDTOToUser userDTOToUser){
        this.userDTOToUser = userDTOToUser;
    }



    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){

        User user = userService.get(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userToUserDTO.convert(user), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){

        if(bindingResult.hasErrors() || user.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User savedUser = userService.save(user);

        UriComponents uriComponents = uriComponentsBuilder.path("/api/user/" + savedUser.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<User> editUser(@Valid @RequestBody User user, BindingResult bindingResult, @PathVariable Integer id){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (user.getId() != null && !user.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setId(id);

        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {

        try {

            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

