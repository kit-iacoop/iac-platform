package com.web.service.Impl;

import com.domain.account.CompanyRepository;
import com.domain.account.Professor;
import com.domain.account.ProfessorRepository;
import com.domain.budgetDetail.BudgetDetail;
import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequest.CollaboRequestRepository;
import com.domain.common.State;
import com.domain.project.Project;
import com.domain.project.ProjectRepository;
import com.domain.projectOutput.ProjectOutput;
import com.domain.projectProfessor.ProjectProfessor;
import com.domain.proofFile.ProofFile;
import com.domain.proofFile.ProofFileRepository;
import com.web.dto.BudgetDetailDTO;
import com.web.dto.CollaboRequestDTO;
import com.web.dto.ProjectDTO;
import com.web.dto.ProjectProfessorDTO;
import com.web.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final CollaboRequestRepository collaboRequestRepository;
    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;
    private final ProfessorRepository professorRepository;
    private final ProofFileRepository proofFileRepository;

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

        ProjectOutput midOutput = ProjectOutput.builder()
                .outputType("mid")
                .description("")
                .status(State.APPROVED)
                .proofFileList(new ArrayList<>())
                .build();

        ProjectOutput finalOutput = ProjectOutput.builder()
                .outputType("final")
                .description("")
                .status(State.PENDING)
                .proofFileList(new ArrayList<>())
                .build();


        Project project = Project.builder()
                .company(request.getCompany())
                .startDate(LocalDate.parse(projectDTO.getStartDate()))
                .endDate(LocalDate.parse(projectDTO.getEndDate()))
                .meetingList(new ArrayList<>())
                .projectOutputList(new ArrayList<>())
                .professorList(new ArrayList<>())
                .salesHistoryList(new ArrayList<>())
                .build();

        request.setProjectId(project);
        budgetDetail.setProject(project);
        midOutput.setProject(project);
        finalOutput.setProject(project);

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

        Project newProject = projectRepository.save(project);
        return newProject.getProjectId();
    }

    @Override
    public ProjectDTO getProjectDetail(String id) {
        Optional<Project> byId = projectRepository.findById(Long.valueOf(id));
        ProjectDTO dto = null;
        if (byId.isPresent()) {
            dto = new ProjectDTO(byId.get());
            dto.setCollaboRequestId(new CollaboRequestDTO(byId.get().getCollaboRequest()));
            dto.setBudgetDetail(new BudgetDetailDTO(byId.get().getBudgetDetail()));
        }

        return dto;
    }

    @Override
    public int insertMidOutput(Long projectId, List<MultipartFile> files) {
        Optional<Project> byId = projectRepository.findById(projectId);
        if (byId.isEmpty()) {
            return 0;
        }
        Project project = byId.get();
        ProjectOutput projectOutput = project.getProjectOutputList().get(0);
        List<ProofFile> proofFileList = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                if (file.getSize() > 0) {
                    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                    String filePath = "/Users/lichee55/iac-platform/" + fileName;
                    File saveFile = new File(filePath);
                    file.transferTo(saveFile);
                    ProofFile proofFile = ProofFile.builder()
                            .fileName(fileName)
                            .filePath(filePath)
                            .fileSize(file.getSize() + " bytes")
                            .build();
                    proofFileList.add(proofFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        proofFileList.forEach(e -> {
            e.setProjectOutput(projectOutput);
            proofFileRepository.save(e);
        });
        return 1;
    }

    @Override
    public int insertFinalOutput(Long projectId, List<MultipartFile> files) {
        Optional<Project> byId = projectRepository.findById(projectId);
        if (byId.isEmpty()) {
            return 0;
        }
        Project project = byId.get();
        ProjectOutput projectOutput = project.getProjectOutputList().get(1);
        projectOutput.setStatus(State.PENDING);
        List<ProofFile> proofFileList = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                if (file.getSize() > 0) {
                    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                    String filePath = "/Users/lichee55/iac-platform/" + fileName;
                    File saveFile = new File(filePath);
                    file.transferTo(saveFile);
                    ProofFile proofFile = ProofFile.builder()
                            .fileName(fileName)
                            .filePath(filePath)
                            .fileSize(file.getSize() + " bytes")
                            .build();
                    proofFileList.add(proofFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        proofFileList.forEach(e -> {
            e.setProjectOutput(projectOutput);
            proofFileRepository.save(e);
        });
        return 1;
    }

    @Override
    public ResponseEntity<Resource> downloadFile(String id) {
        try {
            Optional<ProofFile> byId = proofFileRepository.findById(Long.valueOf(id));
            if (byId.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            ProofFile proofFile = byId.get();
            Path path = Paths.get(proofFile.getFilePath());
            String contentType = Files.probeContentType(path);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(proofFile.getFileName(), StandardCharsets.UTF_8).build());
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);

            Resource resource = new InputStreamResource(Files.newInputStream(path));
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
