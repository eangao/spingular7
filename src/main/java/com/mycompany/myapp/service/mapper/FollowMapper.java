package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.FollowDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Follow} and its DTO {@link FollowDTO}.
 */
@Mapper(componentModel = "spring", uses = { AppuserMapper.class, CommunityMapper.class })
public interface FollowMapper extends EntityMapper<FollowDTO, Follow> {
    @Mapping(target = "followed", source = "followed", qualifiedByName = "id")
    @Mapping(target = "following", source = "following", qualifiedByName = "id")
    @Mapping(target = "cfollowed", source = "cfollowed", qualifiedByName = "id")
    @Mapping(target = "cfollowing", source = "cfollowing", qualifiedByName = "id")
    FollowDTO toDto(Follow s);
}
