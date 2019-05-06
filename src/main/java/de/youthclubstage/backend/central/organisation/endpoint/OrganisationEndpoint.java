package de.youthclubstage.backend.central.organisation.endpoint;

import de.youthclubstage.backend.central.organisation.endpoint.model.OrganisationDto;
import de.youthclubstage.backend.central.organisation.service.OrganisationService;
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
@RequestMapping("/organisations")
@Api(tags = "Organisations")
public class OrganisationEndpoint {

    private final OrganisationService organisationService;

    @Autowired
    public OrganisationEndpoint(OrganisationService organisationService) {

        this.organisationService = organisationService;
    }

    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "A list of organisations",
                    response = OrganisationDto.class,
                    responseContainer = "List"
            ),
            @ApiResponse(
                    code = 403,
                    message = "The request was not sufficient justified"
            )
    })
    @GetMapping(value = "/")
    public ResponseEntity<List<OrganisationDto>> getAllOrganisations() {

        return ResponseEntity.ok(organisationService.getUsers());
    }

    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "A organisation",
                    response = OrganisationDto.class
            ),
            @ApiResponse(
                    code = 403,
                    message = "The request was not sufficient justified"
            ),
            @ApiResponse(
                    code = 404,
                    message = "The organisation does not exist"
            )
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrganisationDto> getOrganisation(@PathVariable(name = "id") Long id) {

        Optional<OrganisationDto> user = organisationService.getUserById(id);

        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
