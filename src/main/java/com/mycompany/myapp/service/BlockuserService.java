package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.BlockuserDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.Blockuser}.
 */
public interface BlockuserService {
    /**
     * Save a blockuser.
     *
     * @param blockuserDTO the entity to save.
     * @return the persisted entity.
     */
    BlockuserDTO save(BlockuserDTO blockuserDTO);

    /**
     * Partially updates a blockuser.
     *
     * @param blockuserDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BlockuserDTO> partialUpdate(BlockuserDTO blockuserDTO);

    /**
     * Get all the blockusers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BlockuserDTO> findAll(Pageable pageable);

    /**
     * Get the "id" blockuser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BlockuserDTO> findOne(Long id);

    /**
     * Delete the "id" blockuser.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
