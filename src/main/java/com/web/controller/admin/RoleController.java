package com.web.controller.admin;

import com.domain.security.role.Role;
import com.web.dto.RoleDTO;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping(value="/admin/roles")
	public String getRoles(Model model) {

		List<Role> roles = roleService.getRoles();
		model.addAttribute("roles", roles);

		return "admin/role/list";
	}

	@GetMapping(value="/admin/roles/register")
	public String viewRoles(Model model) {

		RoleDTO role = new RoleDTO();
		model.addAttribute("role", role);

		return "admin/role/detail";
	}

	@PostMapping(value="/admin/roles")
	public String createRole(RoleDTO roleDto) {


		Role role = roleDto.toEntity();
		roleService.createRole(role);

		return "redirect:/admin/roles";
	}

	@GetMapping(value="/admin/roles/{id}")
	public String getRole(@PathVariable String id, Model model) {

		Role role = roleService.getRole(Long.parseLong(id));

		RoleDTO roleDto = role.toDto();
		model.addAttribute("role", roleDto);

		return "admin/role/detail";
	}

	@GetMapping(value="/admin/roles/delete/{id}")
	public String removeResources(@PathVariable String id, Model model){

		Role role = roleService.getRole(Long.parseLong(id));
		roleService.deleteRole(Long.parseLong(id));

		return "redirect:/admin/resources";
	}
}
