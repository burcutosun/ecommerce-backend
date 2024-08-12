package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.dto.RoleDto;
import com.workintech.ecommerce_backend.entity.Role;
import com.workintech.ecommerce_backend.exception.RoleAlreadyExistsException;
import com.workintech.ecommerce_backend.exception.RoleNotFoundException;
import com.workintech.ecommerce_backend.repo.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            throw new RoleNotFoundException("No roles found");
        }
        return roles.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Role getRoleById(long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found with id: " + id));
    }

    @Override
    public Role saveRole(Role role) {
        if (roleRepository.existsById(role.getId())) {
            throw new RoleAlreadyExistsException("Role already exists with id: " + role.getId());
        }
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(long id) {
        if (!roleRepository.existsById(id)) {
            throw new RoleNotFoundException("Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
    }

    @Override
    public Role updateRole(long id, Role role) {
        Role existingRole = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found with id: " + id));
        existingRole.setName(role.getName());
        existingRole.setCode(role.getCode());
        return roleRepository.save(existingRole);
    }

    private RoleDto convertToDto(Role role) {
        return new RoleDto(role.getId(), role.getName(), role.getCode());
    }
}
