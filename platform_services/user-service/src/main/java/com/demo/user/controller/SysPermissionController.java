package com.demo.user.controller;

import com.demo.user.entity.SysPermission;
import com.demo.user.service.SysPermissionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/permissions")
public class SysPermissionController {

    private final SysPermissionService sysPermissionService;

    public SysPermissionController(SysPermissionService sysPermissionService) {
        this.sysPermissionService = sysPermissionService;
    }

    @GetMapping
    public List<SysPermission> list() {
        return sysPermissionService.list();
    }

    @GetMapping("/{id}")
    public SysPermission getById(@PathVariable Long id) {
        return sysPermissionService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody SysPermission sysPermission) {
        return sysPermissionService.save(sysPermission);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return sysPermissionService.removeById(id);
    }
}
