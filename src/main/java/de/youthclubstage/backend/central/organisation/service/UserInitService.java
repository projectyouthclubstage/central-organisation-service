package de.youthclubstage.backend.central.organisation.service;

import de.youthclubstage.backend.central.organisation.entity.User;
import de.youthclubstage.backend.central.organisation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInitService {


    private final UserRepository userRepository;

    @Autowired
    public UserInitService(UserRepository userRepository) {

        this.userRepository = userRepository;


        init();
    }

    private void init() {

        // TODO Extract to initial sql

        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("Vor1");
        user1.setLastName("Nach1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Vor2");
        user2.setLastName("Nach2");
        userRepository.save(user2);

        User user3 = new User();
        user3.setId(3L);
        user3.setFirstName("Vor3");
        user3.setLastName("Nach3");
        userRepository.save(user3);

    }

}
