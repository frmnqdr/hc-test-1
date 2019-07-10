package id.mbingweb.hctest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class MAppModules implements Serializable {
    @Id
    @Column(name = "module_id")
    private String moduleId;
    
    @Column(name = "name")
    private String moduleName;
    
    @Column(name = "description")
    private String moduleDesc;
}
