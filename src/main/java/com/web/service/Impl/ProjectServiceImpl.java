package com.web.service.Impl;

import com.domain.account.CompanyRepository;
import com.domain.account.Professor;
import com.domain.account.ProfessorRepository;
import com.domain.budgetDetail.BudgetDetail;
import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequest.CollaboRequestRepository;
import com.domain.project.Project;
import com.domain.project.ProjectRepository;
import com.domain.projectProfessor.ProjectProfessor;
import com.web.dto.BudgetDetailDTO;
import com.web.dto.ProjectDTO;
import com.web.dto.ProjectProfessorDTO;
import com.web.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final CollaboRequestRepository collaboRequestRepository;
    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;
    private final ProfessorRepository professorRepository;

    public ProjectServiceImpl(
            CollaboRequestRepository collaboRequestRepository,
            ProjectRepository projectRepository, CompanyRepository companyRepository, ProfessorRepository professorRepository) {

        this.collaboRequestRepository = collaboRequestRepository;
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public Page<ProjectDTO> findAllProject(Pageable pageable) {
        Page<Project> all = projectRepository.findAll(pageable);
        return all.map(ProjectDTO::new);
    }

    @Override
    public ProjectDTO makeProjectFormDTO(Long id) {
        Optional<CollaboRequest> maybeRequest = collaboRequestRepository.findById(id);
        if (maybeRequest.isPresent()) {
            CollaboRequest request = maybeRequest.get();
            return new ProjectDTO(request);
        }
        return null;
    }

    @Override
    public Long makeProject(ProjectDTO projectDTO) {

        Optional<CollaboRequest> maybeRequest = collaboRequestRepository.findById(Long.valueOf(projectDTO.getCollaboRequestId().getCollaboRequestId()));
        if (maybeRequest.isEmpty()) {
            return -1L;
        }
        CollaboRequest request = maybeRequest.get();

        BudgetDetailDTO budgetDetailDTO = projectDTO.getBudgetDetail();
        BudgetDetail budgetDetail = BudgetDetail.builder()
                .total(budgetDetailDTO.getTotal())
                .humanCost(budgetDetailDTO.getHumanCostRate())
                .researchActivity(budgetDetailDTO.getResearchActivityRate())
                .indirectCost(budgetDetailDTO.getIndirectCostRate())
                .build();


        Project project = Project.builder()
                .startDate(LocalDate.parse(projectDTO.getStartDate()))
                .endDate(LocalDate.parse(projectDTO.getEndDate()))
                .meetingList(new ArrayList<>())
                .projectOutputList(new ArrayList<>())
                .salesHistoryList(new ArrayList<>())
                .build();

        request.setProjectId(project);
        budgetDetail.setProject(project);

        List<ProjectProfessorDTO> projectProfessorDTOList = projectDTO.getProjectProfessorDTOList();
        List<Professor> professorList = professorRepository.findAllById(
                projectProfessorDTOList.stream().map(e -> {
                    return Long.valueOf(e.getProfessorId());
                }).collect(Collectors.toList())
        );

        List<ProjectProfessor> projectProfessorList = new ArrayList<>();
        for (Professor p : professorList) {
            ProjectProfessor build = ProjectProfessor.builder()
                    .build();
            build.setProject(project);
            build.setProfessor(p);
            projectProfessorList.add(build);
        }
        project.setProfessorList(projectProfessorList);

        projectRepository.save(project);
        return 0L;
    }
}
