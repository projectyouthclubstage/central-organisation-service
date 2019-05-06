package de.youthclubstage.backend.central.organisation.repository;

import de.youthclubstage.backend.central.organisation.entity.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganisationRepository extends CrudRepository<Organisation, Long> {

    Optional<Organisation> findById(Long id);

}
