package com.demo.user.controller;

import com.demo.user.entity.SysRole;
import com.demo.user.service.SysRoleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/roles")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @GetMapping
    public List<SysRole> list() {
        return sysRoleService.list();
    }

    @GetMapping("/{id}")
    public SysRole getById(@PathVariable Long id) {
        return sysRoleService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody SysRole sysRole) {
        return sysRoleService.save(sysRole);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return sysRoleService.removeById(id);
    }
}
