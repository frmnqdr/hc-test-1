package id.mbingweb.hctest.repository;

import id.mbingweb.hctest.entity.UserGroupModules;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface UserGroupModulesRepository extends JpaRepository<UserGroupModules, Long> {
    @Override
    @Query(value = "SELECT ugm.ref_id AS ref_id, ugm.group_id AS group_id, ugm.module_id AS module_id, mug.name AS group_name, mam.name AS module_name, ugm.order AS module_order " +
            "FROM ref_user_group_modules ugm " +
            "JOIN m_app_user_group mug ON ugm.group_id = mug.group_id " +
            "JOIN m_app_modules mam ON ugm.module_id = mam.module_id " +
            "ORDER BY ugm.ref_id ASC", nativeQuery = true)
    List<UserGroupModules> findAll();
    
    @Query(value = "SELECT ugm.ref_id AS ref_id, ugm.group_id AS group_id, ugm.module_id AS module_id, mug.name AS group_name, mam.name AS module_name, ugm.order AS module_order\n" +
            "FROM ref_user_group_modules ugm\n" +
            "JOIN app_user au ON ugm.group_id = au.group\n" +
            "JOIN m_app_user_group mug ON ugm.group_id = mug.group_id\n" +
            "JOIN m_app_modules mam ON ugm.module_id = mam.module_id\n" +
            "WHERE au.user_id = ?1\n" +
            "ORDER BY ugm.order ASC", nativeQuery = true)
    List<UserGroupModules> getOneByUserId(Long userId);
    
    @Query(value = "SELECT ugm.ref_id AS ref_id, ugm.group_id AS group_id, ugm.module_id AS module_id, mug.name AS group_name, mam.name AS module_name, ugm.order AS module_order\n" +
            "FROM ref_user_group_modules ugm\n" +
            "JOIN app_user au ON ugm.group_id = au.group\n" +
            "JOIN m_app_user_group mug ON ugm.group_id = mug.group_id\n" +
            "JOIN m_app_modules mam ON ugm.module_id = mam.module_id\n" +
            "WHERE au.username = ?1\n" +
            "ORDER BY ugm.order ASC", nativeQuery = true)
    List<UserGroupModules> getOneByUsername(String username);
}
