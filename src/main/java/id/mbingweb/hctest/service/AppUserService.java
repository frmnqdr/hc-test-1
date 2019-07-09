package id.mbingweb.hctest.service;

import id.mbingweb.hctest.entity.AppUser;
import java.util.List;

/**
 *
 * @author fqodry
 */
public interface AppUserService {
    List<AppUser> getAll();
    
    AppUser getById(Long id);
    
    AppUser update(Long id, AppUser appUser);
    
    AppUser create(AppUser appUser);
    
    void delete(Long id);
}
