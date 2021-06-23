package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CinterestDTO;
import java.util.Set;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cinterest} and its DTO {@link CinterestDTO}.
 */
@Mapper(componentModel = "spring", uses = { CommunityMapper.class })
public interface CinterestMapper extends EntityMapper<CinterestDTO, Cinterest> {
    @Mapping(target = "communities", source = "communities", qualifiedByName = "idSet")
    CinterestDTO toDto(Cinterest s);

    @Mapping(target = "removeCommunity", ignore = true)
    Cinterest toEntity(CinterestDTO cinterestDTO);
}
