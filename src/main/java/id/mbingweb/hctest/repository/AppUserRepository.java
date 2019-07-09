package id.mbingweb.hctest.repository;

import id.mbingweb.hctest.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fqodry
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    
}
