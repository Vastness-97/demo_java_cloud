package com.demo.user.controller;

import com.demo.user.entity.SysRolePermission;
import com.demo.user.service.SysRolePermissionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/role-permissions")
public class SysRolePermissionController {

    private final SysRolePermissionService sysRolePermissionService;

    public SysRolePermissionController(SysRolePermissionService sysRolePermissionService) {
        this.sysRolePermissionService = sysRolePermissionService;
    }

    @GetMapping
    public List<SysRolePermission> list() {
        return sysRolePermissionService.list();
    }

    @GetMapping("/{id}")
    public SysRolePermission getById(@PathVariable Long id) {
        return sysRolePermissionService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody SysRolePermission sysRolePermission) {
        return sysRolePermissionService.save(sysRolePermission);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return sysRolePermissionService.removeById(id);
    }
}
