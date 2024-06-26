package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConfigVariablesDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConfigVariablesDTO.class);
        ConfigVariablesDTO configVariablesDTO1 = new ConfigVariablesDTO();
        configVariablesDTO1.setId(1L);
        ConfigVariablesDTO configVariablesDTO2 = new ConfigVariablesDTO();
        assertThat(configVariablesDTO1).isNotEqualTo(configVariablesDTO2);
        configVariablesDTO2.setId(configVariablesDTO1.getId());
        assertThat(configVariablesDTO1).isEqualTo(configVariablesDTO2);
        configVariablesDTO2.setId(2L);
        assertThat(configVariablesDTO1).isNotEqualTo(configVariablesDTO2);
        configVariablesDTO1.setId(null);
        assertThat(configVariablesDTO1).isNotEqualTo(configVariablesDTO2);
    }
}
