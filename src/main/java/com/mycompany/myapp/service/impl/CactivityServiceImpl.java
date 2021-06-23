package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Cactivity;
import com.mycompany.myapp.repository.CactivityRepository;
import com.mycompany.myapp.service.CactivityService;
import com.mycompany.myapp.service.dto.CactivityDTO;
import com.mycompany.myapp.service.mapper.CactivityMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cactivity}.
 */
@Service
@Transactional
public class CactivityServiceImpl implements CactivityService {

    private final Logger log = LoggerFactory.getLogger(CactivityServiceImpl.class);

    private final CactivityRepository cactivityRepository;

    private final CactivityMapper cactivityMapper;

    public CactivityServiceImpl(CactivityRepository cactivityRepository, CactivityMapper cactivityMapper) {
        this.cactivityRepository = cactivityRepository;
        this.cactivityMapper = cactivityMapper;
    }

    @Override
    public CactivityDTO save(CactivityDTO cactivityDTO) {
        log.debug("Request to save Cactivity : {}", cactivityDTO);
        Cactivity cactivity = cactivityMapper.toEntity(cactivityDTO);
        cactivity = cactivityRepository.save(cactivity);
        return cactivityMapper.toDto(cactivity);
    }

    @Override
    public Optional<CactivityDTO> partialUpdate(CactivityDTO cactivityDTO) {
        log.debug("Request to partially update Cactivity : {}", cactivityDTO);

        return cactivityRepository
            .findById(cactivityDTO.getId())
            .map(
                existingCactivity -> {
                    cactivityMapper.partialUpdate(existingCactivity, cactivityDTO);
                    return existingCactivity;
                }
            )
            .map(cactivityRepository::save)
            .map(cactivityMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CactivityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cactivities");
        return cactivityRepository.findAll(pageable).map(cactivityMapper::toDto);
    }

    public Page<CactivityDTO> findAllWithEagerRelationships(Pageable pageable) {
        return cactivityRepository.findAllWithEagerRelationships(pageable).map(cactivityMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CactivityDTO> findOne(Long id) {
        log.debug("Request to get Cactivity : {}", id);
        return cactivityRepository.findOneWithEagerRelationships(id).map(cactivityMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Cactivity : {}", id);
        cactivityRepository.deleteById(id);
    }
}
