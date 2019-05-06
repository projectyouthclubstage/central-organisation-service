package de.youthclubstage.backend.central.organisation.service;

import de.youthclubstage.backend.central.organisation.endpoint.model.UserDto;
import de.youthclubstage.backend.central.organisation.entity.User;
import de.youthclubstage.backend.central.organisation.repository.UserRepository;
import de.youthclubstage.backend.central.organisation.service.mapper.UserApiModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    private final UserApiModelMapper userApiModelMapper;

    @Autowired
    public UserService(
            UserRepository userRepository,
            UserApiModelMapper userApiModelMapper) {

        this.userRepository = userRepository;

        this.userApiModelMapper = userApiModelMapper;

    }

    public List<UserDto> getUsers() {
        return userApiModelMapper.toDto(userRepository.findAll());
    }

    public Optional<UserDto> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        System.err.println(user);
        System.err.println(user.get()   );

        return user.map(userApiModelMapper::toDto);
    }



}
