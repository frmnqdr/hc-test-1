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
public class MAppUserGroup implements Serializable {
    @Id
    @Column(name = "group_id")
    private String groupId;
    
    @Column(name = "name")
    private String groupName;
    
    @Column(name = "description")
    private String groupDesc;
}
