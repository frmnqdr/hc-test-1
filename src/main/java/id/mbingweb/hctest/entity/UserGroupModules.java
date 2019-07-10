package id.mbingweb.hctest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fqodry
 */
@Getter
@Setter
@Entity
public class UserGroupModules implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ref_id")
    private int refId;
    
    @Column(name = "group_id")
    private int groupId;
    
    @Column(name = "module_id")
    private int moduleId;
    
    @Column(name = "module_order")
    private String moduleOrder;
    
    /*
     * extended column (test)
     */
    @Column(name = "group_name")
    private String groupName;
    
    @Column(name = "module_name")
    private String moduleName;
}
