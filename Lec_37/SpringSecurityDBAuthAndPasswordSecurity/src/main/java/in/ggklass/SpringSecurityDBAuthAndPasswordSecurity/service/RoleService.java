package in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.service;

import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.entity.Role;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
