package com.listener;

import com.domain.account.*;
import com.domain.annualFee.AnnualFee;
import com.domain.annualFee.AnnualFeeRepository;
import com.domain.collaborationCategory.CollaborationCategory;
import com.domain.collaborationCategory.CollaborationCategoryRepository;
import com.domain.common.Address;
import com.domain.common.State;
import com.domain.gradePolicy.GradePolicy;
import com.domain.gradePolicy.GradePolicyRepository;
import com.domain.mileageFile.MileageFileRepository;
import com.domain.mileagePolicy.MileagePolicy;
import com.domain.mileagePolicy.MileagePolicyRepository;
import com.domain.companyMileage.CompanyMileage;
import com.domain.companyMileage.CompanyMileageRepository;
import com.domain.security.resource.Resource;
import com.domain.security.resource.ResourceRepository;
import com.domain.security.role.Role;
import com.domain.security.role.RoleRepository;
import com.domain.university.University;
import com.domain.university.UniversityRepository;
import com.security.metadatasource.UrlFilterInvocationSecurityMetadataSource;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Slf4j
@Setter
@ConfigurationProperties(prefix = "property.default-data-loader")
@Component
public class DefaultDataLoader implements  ApplicationListener<ContextRefreshedEvent> {

    private boolean activate = false; // application.yml에 의해 주입됨

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private UrlFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Autowired
    private CompanyMileageRepository companyMileageRepository;

    @Autowired
    private MileageFileRepository mileageFileRepository;

    @Autowired
    private MileagePolicyRepository mileagePolicyRepository;

    @Autowired
    private CollaborationCategoryRepository collaborationCategoryRepository;


    @Autowired
    private AnnualFeeRepository annualFeeRepository;

    @Autowired
    private GradePolicyRepository gradePolicyRepository;



    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        if (activate) {
            // loadUniversityData();
            // loadRoleData();
            // loadAccountData();
            // loadResourceData();
            // loadGradePolicyData();
            // loadAnnualFeeData();
            // loadCollaborationCategoryData();
            loadMileageData();
        }

    }



    private void loadAnnualFeeData(){
        createAnnualFeeIfNotFound(1L, 2021, 9000L, 1000L, "BRONZE",State.APPROVED, LocalDate.now());
        createAnnualFeeIfNotFound(2L, 2022, 40000L, 10000L, "SILVER",State.PENDING, null);

    }


    private void loadGradePolicyData(){
        createGradePolicyIfNotFound("BRONZE", 10000L);
        createGradePolicyIfNotFound("SILVER", 50000L);
        createGradePolicyIfNotFound("GOLD", 100000L);

    }

    private AnnualFee createAnnualFeeIfNotFound(Long annualFeeId, Integer year,  Long cash, Long point, String grade, State paymentStatus, LocalDate confirmDate){
        // 중복 검사
        AnnualFee annualFee = annualFeeRepository.findByAnnualFeeId(annualFeeId);
        if(annualFee != null){
            return annualFee;
        }
        // 생성 & 삽입


        return annualFeeRepository.save(AnnualFee.builder()
                .annualFeeId(annualFeeId)
                .officer((Officer) accountRepository.findByLoginId("OFFICER0"))
                .company((Company) accountRepository.findByLoginId("COMPANY0"))
                .gradePolicy(gradePolicyRepository.findByGrade(grade))
                .year(year)
                .cash(cash)
                .point(point)
                .paymentStatus(paymentStatus)
                .confirmDate(confirmDate)
                .build());
    }



    private void loadMileageData() {

        createMileagePolicyIfNotFound(1L, "mid 1", 50L, 50L);
        createCompanyMileageIfNotFound(1L, "OFFICER0", "COMPANY0", 1L, 5L, State.PENDING, LocalDate.now(), LocalDate.now());
        createCompanyMileageIfNotFound(2L, "OFFICER0", "COMPANY0", 1L, 3L, State.APPROVED, LocalDate.now(), LocalDate.now());
    }

    private GradePolicy createGradePolicyIfNotFound(String grade, Long price){
        // 중복 검사
        GradePolicy gradePolicy = gradePolicyRepository.findByGrade(grade);
        if(gradePolicy != null){
            return gradePolicy;
        }

        // 생성 & 삽입
        gradePolicy = GradePolicy.builder()
                .grade(grade)
                .price(price)
                .build();

        return gradePolicyRepository.save(gradePolicy);
    }

    private CompanyMileage createCompanyMileageIfNotFound(Long reqId, String officerId, String companyId, Long mileagePolicyId, Long achievementCnt, State stat, LocalDate startDate, LocalDate endDate) {

        // 필요 객체 확인
        MileagePolicy mileagePolicy = mileagePolicyRepository.findByMileagePolicyId(mileagePolicyId);
        Company company = (Company) accountRepository.findByLoginId(companyId);
        Officer officer = (Officer) accountRepository.findByLoginId(officerId);

        if(mileagePolicy == null || company == null || officer == null){
            log.warn("createCompanyMileageIfNotFound() : 필요 객체 null");
            return null;
        }

        CompanyMileage mr = companyMileageRepository.findByCompanyMileageId(reqId);
        if(mr != null){
            log.warn("createCompanyMileageIfNotFound() : 이미 존재하는 객체");
            return mr;
        }

        // 생성 &저장

        mr = CompanyMileage.builder()
                .companyMileageId(reqId)
                .officer(officer)
                .company(company)
                .mileagePolicy(mileagePolicy)
                .achievementCnt(achievementCnt)
                .status(stat)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        return companyMileageRepository.save(mr);
    }

    private void loadCollaborationCategoryData() {
        // 되도록이면 변경하지 말고 추가할 것
        createCollaborationCategoryIfNotFound(1L, null, "big 1", 1);
        createCollaborationCategoryIfNotFound(2L, null, "big 2", 1);
        createCollaborationCategoryIfNotFound(3L, null, "big 3", 1);
        createCollaborationCategoryIfNotFound(4L, 1L, "mid 1", 2);
        createCollaborationCategoryIfNotFound(5L, 1L, "mid 2", 2);
        createCollaborationCategoryIfNotFound(6L, 1L, "mid 3", 2);
    }

    private CollaborationCategory createCollaborationCategoryIfNotFound(Long id, Long parentId, String name, Integer level){

        //부모 존재 확인
        CollaborationCategory parentCategory = collaborationCategoryRepository.findByCollaborationCategoryId(parentId);
        if(parentId != null && parentCategory == null){
            log.warn("createCollaborationCategoryIfNotFound() : 부모 객체 null");
            return null;
        }

        // 중복 검사
        CollaborationCategory collaborationCategory = collaborationCategoryRepository.findByCollaborationCategoryId(id);

        if(collaborationCategory != null){
            log.warn("createMileageRequestIfNotFound() : 이미 존재하는 객체");
            return collaborationCategory;
        }

        collaborationCategory = CollaborationCategory.builder()
                .collaborationCategoryId(id)
                .parentCategory(parentCategory)
                .collaborationName(name)
                .level(level)
                .build();

        return collaborationCategoryRepository.save(collaborationCategory);
    }



    private MileagePolicy createMileagePolicyIfNotFound(Long id, String categoryName, Long mileage, Long point){

        //필요 객체 확인
        CollaborationCategory collaboration = collaborationCategoryRepository.findByCollaborationName(categoryName);
        if(collaboration == null){
            log.warn("createMileagePolicyIfNotFound() : 필요 객체 null");
            return null;
        }

        //중복 확인
        MileagePolicy mileagePolicy = mileagePolicyRepository.findByMileagePolicyId(id);

        if(mileagePolicy != null){
            log.warn("createMileagePolicyIfNotFound() : 이미 존재하는 객체");
            return mileagePolicy;
        }

        // 생성 & 저장

        mileagePolicy = MileagePolicy.builder()
                .mileagePolicyId(id)
                .collaborationCategory(collaboration)
                .mileage(mileage)
                .point(point)
                .build();

        return mileagePolicyRepository.save(mileagePolicy);
    }


    private void loadUniversityData() {
        createUniversityIfNotFound("kit");
        createUniversityIfNotFound("tree");

    }

    private University createUniversityIfNotFound(String universityName) {

        // 중복 검사
        University university = universityRepository.findByUniversityName(universityName);
        if (university != null) {
            return university;
        }

        university = University.builder()
                .universityName(universityName)
                .address(new Address("test city", "test street", 123456L))
                .build();

        return universityRepository.save(university);
    }

    private void loadRoleData() {
        createRoleIfNotFound("ROLE_ADMIN", "admin");
        createRoleIfNotFound("ROLE_COMPANY", "company");
        createRoleIfNotFound("ROLE_PROFESSOR", "professor");
        createRoleIfNotFound("ROLE_OFFICER", "officer");
        createRoleIfNotFound("ROLE_STUDENT", "student");
    }

    private void loadAccountData(){
        createAdminIfNotFound("ADMIN", "1234");
        createCompanyIfNotFound("COMPANY0", "1234", State.NORMAL);
        createCompanyIfNotFound("PENDING_COMPANY0", "1234", State.PENDING);
        createProfessorIfNotFound("PROFESSOR0", "1234");
        createOfficerIfNotFound("OFFICER0", "1234");
        createStudentIfNotFound("STUDENT0", "1234");

    }

    private void loadResourceData() {
        createResourceIfNotFound("/**", "url", "", 0, "ROLE_USER","ROLE_OFFICER","ROLE_STUDENT", "ROLE_ADMIN", "ROLE_COMPANY" );
        createResourceIfNotFound("/admin/**", "url", "", 1000, "ROLE_ADMIN");
        createResourceIfNotFound("/company/**", "url", "", 999, "ROLE_COMPANY");
        createResourceIfNotFound("/professor/**", "url", "", 998, "ROLE_PROFESSOR");
        createResourceIfNotFound("/officer/**", "url", "", 997, "ROLE_OFFICER");
        createResourceIfNotFound("/student/**", "url", "", 996, "ROLE_STUDENT");
        filterInvocationSecurityMetadataSource.reload();

    }


    public Role createRoleIfNotFound(String roleName, String roleDesc) {

        // 중복 검사
        Role role = roleRepository.findByRoleName(roleName);
        if(role != null){
            return role;
        }


        // 생성
        role = Role.builder()
                .roleName(roleName)
                .roleDesc(roleDesc)
                .build();

        return roleRepository.save(role);
    }


    public Resource createResourceIfNotFound(String name, String type, String httpMethod, Integer priority, String... roleNames) {

        // 중복 검사
        Resource resource = resourceRepository.findByResourceNameAndHttpMethod(name, httpMethod);
        if(resource != null) {
            log.warn("createResourceIfNotFound() : 이미 존재하는 객체");
        }

        if (resource != null) {
            return resource;
        }

        // 생성
        resource = Resource.builder()
                .resourceName(name)
                .resourceType(type)
                .httpMethod(httpMethod)
                .orderNum(priority)
                .build();

        for (String roleName : roleNames) {
            Role role = roleRepository.findByRoleName(roleName);
            if (role != null) {
                resource.addRole(role);
            }
        }

        return resourceRepository.save(resource);
    }


    @Transactional
    public Admin createAdminIfNotFound(final String loginId, final String password) {

        // 중복 검사
        Account account = accountRepository.findByLoginId(loginId);
        if (account != null) {
            log.warn("createAdminIfNotFound() : 이미 존재하는 객체");

            return (Admin) account;
        }

        // 생성
        account = Admin.builder()
                .name("Admin")
                .birthDate(LocalDate.now())
                .address(new Address("test city", "test street", 123456L))
                .loginId(loginId)
                .password(password)
                .email(" ")
                .telephone(" ")
                .status(State.NORMAL)
                .build();

        Role role = roleRepository.findByRoleName("ROLE_ADMIN");
        account.addRole(role);

        account = accountRepository.encryptedSave(account);

        return (Admin) account;
    }

    @Transactional
    public Company createCompanyIfNotFound(final String loginId, final String password, final State state) {

        // 중복 검사
        Account account = accountRepository.findByLoginId(loginId);

        if (account != null) {
            log.warn("createCompanyIfNotFound() : 이미 존재하는 객체");

            return (Company) account;
        }


        // 생성
        account = Company.builder()
                .name("test company name")
                .birthDate(LocalDate.now())
                .address(new Address("test city", "test street", 123456L))
                .loginId(loginId)
                .password(password)
                .email("test0@test.com")
                .telephone("010-0000-0000")
                .status(state)
                .businessRegistrationNumber(123456789L)
                .employeeNumber(1234L)
                .sector("sector")
                .owner("test owner")
                .grade("test grade")
                .companyType("test company type")
                .temporaryAddress("test temporary address")
                .mileage(123456L)
                .point(123456L)
                .subscriptionDate(LocalDate.now())
                .currentizationStatus(State.NORMAL)
                .build();


        account = accountRepository.encryptedSave(account);

        Role role = roleRepository.findByRoleName("ROLE_COMPANY");
        account.addRole(role);

        return (Company) account;
    }

    @Transactional
    public Professor createProfessorIfNotFound(final String loginId, final String password) {

        // 중복 검사
        Account account = accountRepository.findByLoginId(loginId);

        if (account != null) {
            log.warn("createProfessorIfNotFound() : 이미 존재하는 객체");

            return (Professor) account;
        }

        // 생성
        account = Professor.builder()
                .name("test Professor name")
                .birthDate(LocalDate.now())
                .address(new Address("test city", "test street", 123456L))
                .loginId(loginId)
                .password(password)
                .email("test1@test.com")
                .telephone("010-0000-0000")
                .status(State.NORMAL)
                .department("test department name")
                .officeLocation("test office location")
                .university(universityRepository.findByUniversityName("kit"))
                .build();


        account = accountRepository.encryptedSave(account);

        Role role = roleRepository.findByRoleName("ROLE_PROFESSOR");
        account.addRole(role);

        return (Professor) account;
    }

    @Transactional
    public Officer createOfficerIfNotFound(final String loginId, final String password) {

        // 중복 검사
        Account account = accountRepository.findByLoginId(loginId);

        if (account != null) {
            log.warn("createOfficerIfNotFound() : 이미 존재하는 객체");

            return (Officer) account;
        }

        // 생성
        account = Officer.builder()
                .name("test Officer name")
                .birthDate(LocalDate.now())
                .address(new Address("test city", "test street", 123456L))
                .loginId(loginId)
                .password(password)
                .email("test2@test.com")
                .telephone("010-0000-0000")
                .status(State.NORMAL)
                .officeLocation("test office location")
                .university(universityRepository.findByUniversityName("kit"))
                .build();


        account = accountRepository.encryptedSave(account);

        Role role = roleRepository.findByRoleName("ROLE_OFFICER");
        account.addRole(role);


        return (Officer) account;
    }


    @Transactional
    public Student createStudentIfNotFound(final String loginId, final String password) {

        // 중복 검사
        Account account = accountRepository.findByLoginId(loginId);

        if (account != null) {
            log.warn("createStudentIfNotFound() : 이미 존재하는 객체");

            return (Student) account;
        }


        // 생성
        account = Student.builder()
                .name("test Student name")
                .birthDate(LocalDate.now())
                .address(new Address("test city", "test street", 123456L))
                .loginId(loginId)
                .password(password)
                .email("test3@test.com")
                .telephone("010-0000-0000")
                .status(State.NORMAL)
                .studentNumber(1234L)
                .department("se")
                .university(universityRepository.findByUniversityName("kit"))
                .build();


        account = accountRepository.encryptedSave(account);

        Role role = roleRepository.findByRoleName("ROLE_OFFICER");
        account.addRole(role);


        return (Student) account;
    }



}