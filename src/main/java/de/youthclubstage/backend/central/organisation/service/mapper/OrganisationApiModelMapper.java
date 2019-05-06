package de.youthclubstage.backend.central.organisation.service.mapper;

import de.youthclubstage.backend.central.organisation.endpoint.model.OrganisationDto;
import de.youthclubstage.backend.central.organisation.entity.Organisation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganisationApiModelMapper {

    public OrganisationDto toDto(Organisation source) {
        OrganisationDto retValue = new OrganisationDto();

        retValue.setId(source.getId());
        retValue.setCity(source.getCity());
        retValue.setContactUserId(source.getContactUserId());
        retValue.setDescription(source.getDescription());
        retValue.setName(source.getName());
        retValue.setNumberOfMembers(source.getNumberOfMembers());

        retValue.setUserIsMember(isUserMember(retValue.getId()));

        return retValue;
    }

    public List<OrganisationDto> toDto(Iterable<Organisation> source) {
        List<OrganisationDto> retValue = new ArrayList<>();

        for (Organisation current : source) {
            retValue.add(this.toDto(current));
        }

        return retValue;
    }

    private boolean isUserMember(Long organisationId) {
        // TODO
        return true;
    }

}
