package com.natsuyami.inventory.dto.builder;

import com.natsuyami.inventory.dto.RoleDto;
import com.natsuyami.inventory.model.Role;
import org.springframework.beans.BeanUtils;

public class RoleDtoBuilder {

    protected static RoleDtoBuilder instance;

    protected RoleDtoBuilder() {}

    public static RoleDtoBuilder getInstance() {
        if (instance == null) {
            instance = new RoleDtoBuilder();
        }

        return instance;
    }

    public RoleDto build(Role role) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(role, roleDto);

        return roleDto;
    }
}
