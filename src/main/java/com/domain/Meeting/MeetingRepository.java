package com.domain.Meeting;

import com.domain.Project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    List<Meeting> findByProject(Project project);
}
