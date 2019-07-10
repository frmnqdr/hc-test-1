package id.mbingweb.hctest.service;

import id.mbingweb.hctest.entity.UserGroupModules;
import java.util.List;

/**
 *
 * @author fqodry
 */
public interface UserGroupModulesService {
    List<UserGroupModules> findAll();
    
    List<UserGroupModules> findByUserId(Long userId);
    
    List<UserGroupModules> findByUsername(String username);
}
