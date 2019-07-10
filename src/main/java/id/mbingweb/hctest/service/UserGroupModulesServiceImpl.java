package id.mbingweb.hctest.service;

import id.mbingweb.hctest.entity.UserGroupModules;
import id.mbingweb.hctest.repository.UserGroupModulesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fqodry
 */
@Service
public class UserGroupModulesServiceImpl implements UserGroupModulesService {
    @Autowired
    UserGroupModulesRepository userGroupModulesRepository;
    
    @Override
    public List<UserGroupModules> findAll() {
        return userGroupModulesRepository.findAll();
    }
    
    @Override
    public List<UserGroupModules> findByUserId(Long userId) {
        return userGroupModulesRepository.getOneByUserId(userId);
    }
    
    @Override
    public List<UserGroupModules> findByUsername(String username) {
        return userGroupModulesRepository.getOneByUsername(username);
    }
}
