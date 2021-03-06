package com.example.elk.controller;

import com.example.elk.model.Role;
import com.example.elk.service.RoleService;
import com.example.elk.swagger.user.api.RoleApi;
import com.example.elk.swagger.user.model.RoleRequest;
import com.example.elk.swagger.user.model.RoleResponse;
import com.example.elk.swagger.user.model.RolesResponse;
import com.example.elk.util.Util;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class RoleController implements RoleApi {

    private RoleService roleService;

    @Override
    public ResponseEntity<RoleResponse> addRole(RoleRequest roleRequest) {
        log.info("Request add a new role: {}", roleRequest);
        Role role = roleService.saveRole(Util.dtoToModel(roleRequest));
        return new ResponseEntity<>(Util.modelToDtoBasic(role), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RolesResponse> getRoles() {
        List<Role> roles = roleService.getRoles();

        RolesResponse rolesResponse = new RolesResponse();
        rolesResponse.setSize(roles.size());
        rolesResponse.setRoles(roles.stream()
                                    .map(Util::modelToDtoBasic)
                                    .collect(Collectors.toList()));
        return new ResponseEntity<>(rolesResponse, HttpStatus.OK);
    }

}
