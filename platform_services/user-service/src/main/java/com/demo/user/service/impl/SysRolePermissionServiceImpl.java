package com.demo.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.user.entity.SysRolePermission;
import com.demo.user.mapper.SysRolePermissionMapper;
import com.demo.user.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {
}
