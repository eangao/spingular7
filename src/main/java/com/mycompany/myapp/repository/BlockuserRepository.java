package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Blockuser;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Blockuser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BlockuserRepository extends JpaRepository<Blockuser, Long>, JpaSpecificationExecutor<Blockuser> {}
