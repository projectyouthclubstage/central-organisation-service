package de.youthclubstage.backend.central.organisation.service.mapper;

import de.youthclubstage.backend.central.organisation.endpoint.model.UserDto;
import de.youthclubstage.backend.central.organisation.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserApiModelMapper {

    public UserDto toDto(User source) {
        UserDto retValue = new UserDto();

        retValue.setId(source.getId());
        retValue.setFirstName(source.getFirstName());
        retValue.setLastName(source.getLastName());

        return retValue;
    }

    public List<UserDto> toDto(Iterable<User> source) {
        List<UserDto> retValue = new ArrayList<>();

        for (User current : source) {
            retValue.add(this.toDto(current));
        }

        return retValue;
    }

}
