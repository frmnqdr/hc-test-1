package id.mbingweb.hctest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AppUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //untuk generate auto-increment
    private Long id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "group")
    private int group;
    
    @Column(name = "active_status")
    private boolean activeStatus;
}
