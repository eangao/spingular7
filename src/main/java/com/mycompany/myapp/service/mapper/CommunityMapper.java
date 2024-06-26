package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CommunityDTO;
import java.util.Set;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Community} and its DTO {@link CommunityDTO}.
 */
@Mapper(componentModel = "spring", uses = { AppuserMapper.class })
public interface CommunityMapper extends EntityMapper<CommunityDTO, Community> {
    @Mapping(target = "appuser", source = "appuser", qualifiedByName = "id")
    CommunityDTO toDto(Community s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CommunityDTO toDtoId(Community community);

    @Named("idSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Set<CommunityDTO> toDtoIdSet(Set<Community> community);

    @Named("communityName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "communityName", source = "communityName")
    CommunityDTO toDtoCommunityName(Community community);
}
