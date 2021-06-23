package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.AppphotoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Appphoto} and its DTO {@link AppphotoDTO}.
 */
@Mapper(componentModel = "spring", uses = { AppuserMapper.class })
public interface AppphotoMapper extends EntityMapper<AppphotoDTO, Appphoto> {
    @Mapping(target = "appuser", source = "appuser", qualifiedByName = "id")
    AppphotoDTO toDto(Appphoto s);
}
