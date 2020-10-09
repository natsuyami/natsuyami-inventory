package com.natsuyami.inventory.service.services.type;

import com.natsuyami.inventory.dto.RoleDto;
import com.natsuyami.inventory.dto.builder.RoleDtoBuilder;
import com.natsuyami.inventory.model.Role;
import com.natsuyami.inventory.repository.RoleRepository;
import com.natsuyami.inventory.service.impl.DefaultImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements DefaultImpl<RoleDto>  {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<RoleDto> getAll(Pageable pageable) {
        return null;
    }

    /**
     * get role via ID
     * @param id - id of the role to be search
     * @return RoleDto - details of the role searched
     */
    @Override
    public RoleDto getById(long id) {
        LOGGER.info("Initialized RoleService getById() method with roleId={{}}", id);
        Role role = getRoleById(id);

        if (role == null) {
            return null;
        }
        return RoleDtoBuilder.getInstance().build(role);
    }

    @Override
    public List<RoleDto> search(String search) {
        return null;
    }

    /**
     * get role if exist, otherwise null
     * @param id - id of the role to be search
     * @return Role - details of the role searched
     */
    public Role getRoleById(long id) {
        LOGGER.info("Initialized RoleService getRoleById() method with roleId={{}}", id);
        Optional<Role> role = roleRepository.findById(id);

        if (role.isPresent()) {
            LOGGER.info("Found the role with role={{}}", role.get().getRole());
            return role.get();
        } else {
            LOGGER.info("cannot found role");
            return null;
        }
    }
}
