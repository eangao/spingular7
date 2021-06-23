package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ConfigVariables;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ConfigVariables entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConfigVariablesRepository extends JpaRepository<ConfigVariables, Long>, JpaSpecificationExecutor<ConfigVariables> {}
