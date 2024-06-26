package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CelebDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CelebDTO.class);
        CelebDTO celebDTO1 = new CelebDTO();
        celebDTO1.setId(1L);
        CelebDTO celebDTO2 = new CelebDTO();
        assertThat(celebDTO1).isNotEqualTo(celebDTO2);
        celebDTO2.setId(celebDTO1.getId());
        assertThat(celebDTO1).isEqualTo(celebDTO2);
        celebDTO2.setId(2L);
        assertThat(celebDTO1).isNotEqualTo(celebDTO2);
        celebDTO1.setId(null);
        assertThat(celebDTO1).isNotEqualTo(celebDTO2);
    }
}
