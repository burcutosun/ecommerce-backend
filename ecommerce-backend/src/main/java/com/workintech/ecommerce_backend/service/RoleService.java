package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.dto.RoleDto;
import com.workintech.ecommerce_backend.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {



    List<RoleDto> getAllRoles();
    Role getRoleById(long id);
    Role saveRole(Role role);
    void deleteRole(long id);
    Role updateRole(long id, Role role);
}
