package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.CelebRepository;
import com.mycompany.myapp.service.CelebQueryService;
import com.mycompany.myapp.service.CelebService;
import com.mycompany.myapp.service.criteria.CelebCriteria;
import com.mycompany.myapp.service.dto.CelebDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Celeb}.
 */
@RestController
@RequestMapping("/api")
public class CelebResource {

    private final Logger log = LoggerFactory.getLogger(CelebResource.class);

    private static final String ENTITY_NAME = "celeb";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CelebService celebService;

    private final CelebRepository celebRepository;

    private final CelebQueryService celebQueryService;

    public CelebResource(CelebService celebService, CelebRepository celebRepository, CelebQueryService celebQueryService) {
        this.celebService = celebService;
        this.celebRepository = celebRepository;
        this.celebQueryService = celebQueryService;
    }

    /**
     * {@code POST  /celebs} : Create a new celeb.
     *
     * @param celebDTO the celebDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new celebDTO, or with status {@code 400 (Bad Request)} if the celeb has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/celebs")
    public ResponseEntity<CelebDTO> createCeleb(@Valid @RequestBody CelebDTO celebDTO) throws URISyntaxException {
        log.debug("REST request to save Celeb : {}", celebDTO);
        if (celebDTO.getId() != null) {
            throw new BadRequestAlertException("A new celeb cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CelebDTO result = celebService.save(celebDTO);
        return ResponseEntity
            .created(new URI("/api/celebs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /celebs/:id} : Updates an existing celeb.
     *
     * @param id the id of the celebDTO to save.
     * @param celebDTO the celebDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated celebDTO,
     * or with status {@code 400 (Bad Request)} if the celebDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the celebDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/celebs/{id}")
    public ResponseEntity<CelebDTO> updateCeleb(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CelebDTO celebDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Celeb : {}, {}", id, celebDTO);
        if (celebDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, celebDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!celebRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CelebDTO result = celebService.save(celebDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, celebDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /celebs/:id} : Partial updates given fields of an existing celeb, field will ignore if it is null
     *
     * @param id the id of the celebDTO to save.
     * @param celebDTO the celebDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated celebDTO,
     * or with status {@code 400 (Bad Request)} if the celebDTO is not valid,
     * or with status {@code 404 (Not Found)} if the celebDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the celebDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/celebs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<CelebDTO> partialUpdateCeleb(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody CelebDTO celebDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Celeb partially : {}, {}", id, celebDTO);
        if (celebDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, celebDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!celebRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CelebDTO> result = celebService.partialUpdate(celebDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, celebDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /celebs} : get all the celebs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of celebs in body.
     */
    @GetMapping("/celebs")
    public ResponseEntity<List<CelebDTO>> getAllCelebs(CelebCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Celebs by criteria: {}", criteria);
        Page<CelebDTO> page = celebQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /celebs/count} : count all the celebs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/celebs/count")
    public ResponseEntity<Long> countCelebs(CelebCriteria criteria) {
        log.debug("REST request to count Celebs by criteria: {}", criteria);
        return ResponseEntity.ok().body(celebQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /celebs/:id} : get the "id" celeb.
     *
     * @param id the id of the celebDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the celebDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/celebs/{id}")
    public ResponseEntity<CelebDTO> getCeleb(@PathVariable Long id) {
        log.debug("REST request to get Celeb : {}", id);
        Optional<CelebDTO> celebDTO = celebService.findOne(id);
        return ResponseUtil.wrapOrNotFound(celebDTO);
    }

    /**
     * {@code DELETE  /celebs/:id} : delete the "id" celeb.
     *
     * @param id the id of the celebDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/celebs/{id}")
    public ResponseEntity<Void> deleteCeleb(@PathVariable Long id) {
        log.debug("REST request to delete Celeb : {}", id);
        celebService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
