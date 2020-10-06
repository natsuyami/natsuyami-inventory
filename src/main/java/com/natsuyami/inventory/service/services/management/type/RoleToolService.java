package com.natsuyami.inventory.service.services.management.type;

import com.natsuyami.inventory.dto.RoleDto;
import com.natsuyami.inventory.dto.builder.RoleDtoBuilder;
import com.natsuyami.inventory.model.Role;
import com.natsuyami.inventory.repository.RoleRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.service.services.type.RoleService;
import com.natsuyami.inventory.validation.RoleValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleToolService extends RoleService implements ManagementImpl<RoleDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleToolService.class);

    @Autowired
    private RoleRepository roleRepository;

    /**
     * create a new role
     * @param roleDto - role details to be save
     * @return RoleDto - details of the saved role
     */
    @Override
    public RoleDto create(RoleDto roleDto) {
        LOGGER.info("Initialized RoleToolService create() method with param={{}}", roleDto);
        RoleValidation.getInstance().validate(roleDto);
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);

        LOGGER.info("Saving role role={{}}", role.getRole());
        role = roleRepository.save(role);

        return RoleDtoBuilder.getInstance().build(role);
    }

    @Override
    public RoleDto update(RoleDto obj) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
