package de.youthclubstage.backend.central.organisation.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("User")
@Data
public class User {

    @Id
    @Indexed
    private Long id;

    @Indexed
    private String firstName;

    @Indexed
    private String lastName;

}
