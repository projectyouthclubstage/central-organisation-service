package de.youthclubstage.backend.central.organisation.endpoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;


//TODO Delete whole class - just here while there is no token

@ApiModel(value = "User")
@Data
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

}