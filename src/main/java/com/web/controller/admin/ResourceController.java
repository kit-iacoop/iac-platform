package com.web.controller.admin;

import com.domain.security.resource.Resource;
import com.domain.security.role.Role;
import com.domain.security.role.RoleRepository;
import com.security.metadatasource.UrlFilterInvocationSecurityMetadataSource;
import com.web.dto.ResourceDTO;
import com.web.service.ResourceService;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UrlFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;


	@GetMapping(value="/admin/resource")
	public String getResource(Model model) {

		List<Resource> resource = resourceService.getResource();
		model.addAttribute("resource", resource);

		return "admin/resource/list";
	}

	@PostMapping(value="/admin/resource")
	public String createResource(ResourceDTO resourceDto) {


		Role role = roleRepository.findByRoleName(resourceDto.getRoleName());
		resourceDto.setRoleSet(new HashSet<>());
		resourceDto.getRoleSet().add(role);

		Resource resource = resourceDto.toEntity();

		resourceService.createResource(resource);
		filterInvocationSecurityMetadataSource.reload();

		return "redirect:/admin/resource";
	}

	@GetMapping(value="/admin/resource/register")
	public String viewRoles(Model model) {

		List<Role> roleList = roleService.getRoles();
		model.addAttribute("roleList", roleList);

		ResourceDTO resourceDto = new ResourceDTO();
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(new Role());
		resourceDto.setRoleSet(roleSet);
		model.addAttribute("resource", resourceDto);

		return "admin/resource/detail";
	}

	@GetMapping(value="/admin/resource/{id}")
	public String getResource(@PathVariable String id, Model model){

		List<Role> roleList = roleService.getRoles();
        model.addAttribute("roleList", roleList);
		Resource resource = resourceService.getResource(Long.parseLong(id));

		ResourceDTO resourceDto = resource.toDto();
		model.addAttribute("resource", resourceDto);

		return "admin/resource/detail";
	}

	@GetMapping(value="/admin/resource/delete/{id}")
	public String removeResource(@PathVariable String id) {

		resourceService.deleteResource(Long.parseLong(id));
		filterInvocationSecurityMetadataSource.reload();

		return "redirect:/admin/resource";
	}
}
