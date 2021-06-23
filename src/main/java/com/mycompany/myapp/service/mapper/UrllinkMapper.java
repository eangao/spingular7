package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.UrllinkDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Urllink} and its DTO {@link UrllinkDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UrllinkMapper extends EntityMapper<UrllinkDTO, Urllink> {}
