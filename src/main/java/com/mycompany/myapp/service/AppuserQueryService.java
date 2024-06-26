package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.*; // for static metamodels
import com.mycompany.myapp.domain.Appuser;
import com.mycompany.myapp.repository.AppuserRepository;
import com.mycompany.myapp.service.criteria.AppuserCriteria;
import com.mycompany.myapp.service.dto.AppuserDTO;
import com.mycompany.myapp.service.mapper.AppuserMapper;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Appuser} entities in the database.
 * The main input is a {@link AppuserCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AppuserDTO} or a {@link Page} of {@link AppuserDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AppuserQueryService extends QueryService<Appuser> {

    private final Logger log = LoggerFactory.getLogger(AppuserQueryService.class);

    private final AppuserRepository appuserRepository;

    private final AppuserMapper appuserMapper;

    public AppuserQueryService(AppuserRepository appuserRepository, AppuserMapper appuserMapper) {
        this.appuserRepository = appuserRepository;
        this.appuserMapper = appuserMapper;
    }

    /**
     * Return a {@link List} of {@link AppuserDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<AppuserDTO> findByCriteria(AppuserCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Appuser> specification = createSpecification(criteria);
        return appuserMapper.toDto(appuserRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link AppuserDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AppuserDTO> findByCriteria(AppuserCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Appuser> specification = createSpecification(criteria);
        return appuserRepository.findAll(specification, page).map(appuserMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AppuserCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Appuser> specification = createSpecification(criteria);
        return appuserRepository.count(specification);
    }

    /**
     * Function to convert {@link AppuserCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Appuser> createSpecification(AppuserCriteria criteria) {
        Specification<Appuser> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Appuser_.id));
            }
            if (criteria.getCreationDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreationDate(), Appuser_.creationDate));
            }
            if (criteria.getBio() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBio(), Appuser_.bio));
            }
            if (criteria.getFacebook() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFacebook(), Appuser_.facebook));
            }
            if (criteria.getTwitter() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTwitter(), Appuser_.twitter));
            }
            if (criteria.getLinkedin() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLinkedin(), Appuser_.linkedin));
            }
            if (criteria.getInstagram() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInstagram(), Appuser_.instagram));
            }
            if (criteria.getBirthdate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBirthdate(), Appuser_.birthdate));
            }
            if (criteria.getUserId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getUserId(), root -> root.join(Appuser_.user, JoinType.LEFT).get(User_.id))
                    );
            }
            if (criteria.getBlogId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getBlogId(), root -> root.join(Appuser_.blogs, JoinType.LEFT).get(Blog_.id))
                    );
            }
            if (criteria.getCommunityId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getCommunityId(),
                            root -> root.join(Appuser_.communities, JoinType.LEFT).get(Community_.id)
                        )
                    );
            }
            if (criteria.getNotificationId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getNotificationId(),
                            root -> root.join(Appuser_.notifications, JoinType.LEFT).get(Notification_.id)
                        )
                    );
            }
            if (criteria.getCommentId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCommentId(), root -> root.join(Appuser_.comments, JoinType.LEFT).get(Comment_.id))
                    );
            }
            if (criteria.getPostId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getPostId(), root -> root.join(Appuser_.posts, JoinType.LEFT).get(Post_.id))
                    );
            }
            if (criteria.getFollowedId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getFollowedId(), root -> root.join(Appuser_.followeds, JoinType.LEFT).get(Follow_.id))
                    );
            }
            if (criteria.getFollowingId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getFollowingId(), root -> root.join(Appuser_.followings, JoinType.LEFT).get(Follow_.id))
                    );
            }
            if (criteria.getBlockeduserId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getBlockeduserId(),
                            root -> root.join(Appuser_.blockedusers, JoinType.LEFT).get(Blockuser_.id)
                        )
                    );
            }
            if (criteria.getBlockinguserId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getBlockinguserId(),
                            root -> root.join(Appuser_.blockingusers, JoinType.LEFT).get(Blockuser_.id)
                        )
                    );
            }
            if (criteria.getAppphotoId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getAppphotoId(), root -> root.join(Appuser_.appphoto, JoinType.LEFT).get(Appphoto_.id))
                    );
            }
            if (criteria.getInterestId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getInterestId(), root -> root.join(Appuser_.interests, JoinType.LEFT).get(Interest_.id))
                    );
            }
            if (criteria.getActivityId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getActivityId(),
                            root -> root.join(Appuser_.activities, JoinType.LEFT).get(Activity_.id)
                        )
                    );
            }
            if (criteria.getCelebId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCelebId(), root -> root.join(Appuser_.celebs, JoinType.LEFT).get(Celeb_.id))
                    );
            }
        }
        return specification;
    }
}
