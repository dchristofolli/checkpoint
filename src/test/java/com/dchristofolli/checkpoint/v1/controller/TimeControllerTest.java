package com.dchristofolli.checkpoint.v1.controller;

import com.dchristofolli.checkpoint.domain.repository.TimeRegistrationRepository;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationRequestDto;
import com.dchristofolli.checkpoint.v1.service.TimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TimeController.class)
class TimeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    TimeRegistrationRepository repository;
    @InjectMocks
    TimeController controller;

    TimeRegistrationRequestDto requestDto = new TimeRegistrationRequestDto(
        "07683807079",
        "22-02-2021",
        "08:00");

    TimeRegistrationRequestDto weekendRequestDto = new TimeRegistrationRequestDto(
        "07683807079",
        "21-02-2021",
        "08:00");

    @Test
    void weekendTimeRegistration_shouldThrowsBadRequest() throws Exception {
        controller.timeRegistration(weekendRequestDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/time/registration")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(weekendRequestDto)))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}