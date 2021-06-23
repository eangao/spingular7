package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CelebDTO;
import java.util.Set;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Celeb} and its DTO {@link CelebDTO}.
 */
@Mapper(componentModel = "spring", uses = { AppuserMapper.class })
public interface CelebMapper extends EntityMapper<CelebDTO, Celeb> {
    @Mapping(target = "appusers", source = "appusers", qualifiedByName = "idSet")
    CelebDTO toDto(Celeb s);

    @Mapping(target = "removeAppuser", ignore = true)
    Celeb toEntity(CelebDTO celebDTO);
}
