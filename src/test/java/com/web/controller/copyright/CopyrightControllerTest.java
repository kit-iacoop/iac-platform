package com.web.controller.copyright;

import com.domain.account.Account;
import com.domain.common.CopyrightType;
import com.domain.copyright.Copyright;
import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CopyrightController.class)
public class CopyrightControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CopyrightService copyrightService;

    @MockBean
    private Account account;

    @Test
    public void copyright_MVC_TEST() throws Exception {
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
