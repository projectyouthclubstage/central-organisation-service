package de.youthclubstage.backend.central.organisation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@ApiModel(value = "Google-Data")
@Data
public class GoogleData {

    @JsonProperty("id")
    private String id;

}