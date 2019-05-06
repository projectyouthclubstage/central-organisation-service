package de.youthclubstage.backend.central.organisation.endpoint;

import de.youthclubstage.backend.central.organisation.endpoint.model.UserDto;
import de.youthclubstage.backend.central.organisation.service.UserInitService;
import de.youthclubstage.backend.central.organisation.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@Api(tags = "Users")
public class UsersEndpoint {

    private final UserService userService;

    @Autowired
    public UsersEndpoint(
            UserInitService externalUserService,
            UserService userService) {

        this.userService = userService;
    }

    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "A list of users",
                    response = UserDto.class,
                    responseContainer = "List"
            )
    })
    @GetMapping(value = "/")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return ResponseEntity.ok(userService.getUsers());
    }

    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "A users",
                    response = UserDto.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "The user does not exist"
            )
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") Long id) {

        Optional<UserDto> user = userService.getUserById(id);

        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
