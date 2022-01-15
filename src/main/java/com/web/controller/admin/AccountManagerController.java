package com.web.controller.admin;


import com.domain.account.Account;
import com.domain.security.role.Role;
import com.web.dto.AccountRolesDto;
import com.web.service.AccountService;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountManagerController {
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private RoleService roleService;


	@GetMapping(value="/admin/accounts")
	public String getAccounts(Model model) {

		List<Account> accounts = accountService.getAllAccounts();

		accounts.forEach(Account::deletePassword);

		model.addAttribute("accounts", accounts);

		return "admin/account/list";
	}


	@PostMapping(value="/admin/accounts")
	public String updateAccountRoles(AccountRolesDto accountRolesDto) {

		accountService.updateAccountRoles(accountRolesDto);

		return "redirect:/admin/accounts";
	}


	@GetMapping(value = "/admin/accounts/{id}")
	public String getAccount(@PathVariable(value = "id") Long id, Model model) {

		AccountRolesDto accountDto = accountService.getAccountRolesDtoById(id);
		List<Role> roleList = roleService.getRoles();
		
		model.addAttribute("account", accountDto);
		model.addAttribute("roleList", roleList);

		return "admin/account/detail";
	}


	@GetMapping(value = "/admin/accounts/delete/{id}")
	public String removeAccount(@PathVariable(value = "id") Long id) {

		accountService.deleteAccountById(id);

		return "redirect:/admin/accounts";
	}
}
