//package com.dchristofolli.checkpoint.v1.service;
//
//import com.dchristofolli.checkpoint.domain.repository.TimeRegistrationRepository;
//import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationRequestDto;
//import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationResponseDto;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//class TimeServiceTest {
//    @MockBean
//    TimeRegistrationRepository repository;
//    @InjectMocks
//    TimeService service;
//
//    TimeRegistrationRequestDto requestDto = new TimeRegistrationRequestDto(
//        "07683807079",
//        "22-02-2021",
//        "08:00");
//
//    TimeRegistrationRequestDto weekendRequestDto = new TimeRegistrationRequestDto(
//        "07683807079",
//        "21-02-2021",
//        "08:00");
//
//    TimeRegistrationResponseDto responseDto = new TimeRegistrationResponseDto(
//        "07683807079",
//        "22-02-2021",
//        "08:00");
//
//
//    @Test
//    void timeRegistration() {
//        TimeRegistrationResponseDto timeRegistrationResponseDto = service.timeRegistration(requestDto);
//        Assertions.assertEquals(responseDto, timeRegistrationResponseDto);
//    }
//}