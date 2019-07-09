package id.mbingweb.hctest.service;

import id.mbingweb.hctest.entity.AppUser;
import id.mbingweb.hctest.repository.AppUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fqodry
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired AppUserRepository appUserRepository;
    
    @Override
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }
    
    @Override
    public AppUser getById(Long id) {
        return appUserRepository.getOne(id);
    }
    
    @Override
    public AppUser update(Long id, AppUser appUser) {
        appUser.getId();
        return appUserRepository.save(appUser);
    }
    
    @Override
    public AppUser create(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
    
    @Override
    public void delete(Long id) {
        appUserRepository.deleteById(id);
    }
}
