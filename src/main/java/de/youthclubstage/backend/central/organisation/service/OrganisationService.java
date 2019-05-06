package de.youthclubstage.backend.central.organisation.service;

import de.youthclubstage.backend.central.organisation.endpoint.model.OrganisationDto;
import de.youthclubstage.backend.central.organisation.entity.Organisation;
import de.youthclubstage.backend.central.organisation.repository.OrganisationRepository;
import de.youthclubstage.backend.central.organisation.service.mapper.OrganisationApiModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationService {


    private final OrganisationRepository organisationRepository;

    private final OrganisationApiModelMapper organisationApiModelMapper;

    @Autowired
    public OrganisationService(
            OrganisationRepository organisationRepository,
            OrganisationApiModelMapper organisationApiModelMapper) {

        this.organisationRepository = organisationRepository;

        this.organisationApiModelMapper = organisationApiModelMapper;

    }

    public List<OrganisationDto> getUsers() {
        return organisationApiModelMapper.toDto(organisationRepository.findAll());
    }

    public Optional<OrganisationDto> getUserById(Long id) {
        Optional<Organisation> organisation = organisationRepository.findById(id);

        return organisation.map(organisationApiModelMapper::toDto);
    }



}
