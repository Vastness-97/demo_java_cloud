package com.demo.user.controller;

import com.demo.user.entity.SysUserRole;
import com.demo.user.service.SysUserRoleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/user-roles")
public class SysUserRoleController {

    private final SysUserRoleService sysUserRoleService;

    public SysUserRoleController(SysUserRoleService sysUserRoleService) {
        this.sysUserRoleService = sysUserRoleService;
    }

    @GetMapping
    public List<SysUserRole> list() {
        return sysUserRoleService.list();
    }

    @GetMapping("/{id}")
    public SysUserRole getById(@PathVariable Long id) {
        return sysUserRoleService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody SysUserRole sysUserRole) {
        return sysUserRoleService.save(sysUserRole);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return sysUserRoleService.removeById(id);
    }
}
