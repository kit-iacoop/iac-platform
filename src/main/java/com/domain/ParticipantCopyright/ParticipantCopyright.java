package com.domain.ParticipantCopyright;

import com.domain.Account.Student;
import com.domain.Copyright.Copyright;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PARTICIPANT_COPYRIGHT")
public class ParticipantCopyright {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PARTICIPANT_COPYRIGHT_ID", nullable = false)
    private Long participantCopyrightId;

    @ManyToOne
    @JoinColumn(name = "COPYRIGHT_ID")
    private Copyright copyright;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @Column(name = "RATIO")
    private String ratio;

}
