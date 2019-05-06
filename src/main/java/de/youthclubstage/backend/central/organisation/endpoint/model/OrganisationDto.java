package de.youthclubstage.backend.central.organisation.endpoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@ApiModel(value = "Organisation")
@Data
public class OrganisationDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("contact_user_id")
    private Long contactUserId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("city")
    private String city;

    @JsonProperty("number_of_members")
    private Integer numberOfMembers;

    @JsonProperty("user_is_member")
    private Boolean userIsMember;

}