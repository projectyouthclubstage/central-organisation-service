package de.youthclubstage.backend.central.organisation.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("Organisation")
@Data
public class Organisation {

    @Id
    @Indexed
    private Long id;

    private String name;

    private Long contactUserId;

    private String description;

    private String city;

    private Integer numberOfMembers;

}