package com.web.controller.copyright;

import com.domain.account.Account;
import com.domain.account.Professor;
import com.domain.common.Address;
import com.domain.common.CopyrightType;
import com.domain.common.State;
import com.domain.copyright.Copyright;
import com.domain.university.University;
import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CopyrightController.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@WebMvcTest(CopyrightController.class)
@Transactional
public class CopyrightControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CopyrightService copyrightService;


    @Test
    @DisplayName("기술 조회 테스트")
    public void copyright_MVC_TEST() throws Exception {
        University university = University.builder()
                .universityName("대학이름스")
                .address(new Address())
                .build();


        Account account = Professor.builder()
                .name("이름스")
                .university(university)
                .department("학과스")
                .officeLocation("위치스")
                .birthDate(LocalDate.now())
                .address(new Address())
                .email("email.email")
                .loginId("idid")
                .password("pwpw")
                .status(State.APPROVED)
                .telephone("01010101010")
                .build();

        Copyright copyright = Copyright.builder()
                .accountId(account)
                .declarationYear("2022")
                .cooperation("협업회사")
                .copyrightType(CopyrightType.PAPER)
                .state("출원")
                .title("제목스")
                .representor("땡땡박사")
                .professorDepartment("컴퓨터공학")
                .professorName("땡땡박사")
                .professorRatio(10)
                .keyword("띠용띠용워익워익")
                .description("어쩌구어쩌구입니다.")
                .maintenanceState("몰루")
                .applicationRegistrationList(new ArrayList<>())
                .build();

        PageRequest pageable = PageRequest.of(0, 10);
        List<CopyrightDTO> list = new ArrayList<>();
        list.add(new CopyrightDTO(copyright));
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());

        Page<CopyrightDTO> page = new PageImpl<>(list.subList(start, end), pageable, list.size());

        given(copyrightService.findCopyright(pageable)).willReturn(page);

        mvc.perform(get("/copyrights/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("copyright/copyright-list"))
                .andExpect(model().attributeExists("copyrightDtos"))
                .andExpect(model().attribute("copyrightDtos", contains(list)));

    }
}
