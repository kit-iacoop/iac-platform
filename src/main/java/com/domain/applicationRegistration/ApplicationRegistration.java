package com.domain.applicationRegistration;

import com.domain.common.BaseTimeEntity;
import com.domain.copyright.Copyright;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@SuperBuilder
@Entity
@Table(name = "APPLICATION_REGISTRATION")
public class ApplicationRegistration extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPLICATION_REGISTRATION_ID", nullable = false)
    private Long applicationRegistrationId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "COPYRIGTH_ID")
    private Copyright copyright;

    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    @Column(name = "NUMBER") // 특허 출원번호, 특허 등록번호 ex)10-1999-0025547
    private String number;

    @Column(name = "TYPE") // 출원, 등록 두가지만 있어서 enum으로 빼던가 해도 될 듯. 일단 String
    private String type;

    public void setCopyright(Copyright copyright) {
        if (this.copyright != null) {
            this.copyright.getApplicationRegistrationList().remove(this);
        }
        this.copyright = copyright;
        copyright.getApplicationRegistrationList().add(this);
    }

}
