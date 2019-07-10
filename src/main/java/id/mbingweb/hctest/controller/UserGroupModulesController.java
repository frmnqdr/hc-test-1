package id.mbingweb.hctest.controller;

import id.mbingweb.hctest.service.UserGroupModulesService;
import id.mbingweb.hctest.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fqodry
 */
@RestController
@RequestMapping("user/modules")
public class UserGroupModulesController {
    @Autowired UserGroupModulesService userGroupModulesService;
    
    @GetMapping
    ResponseEntity<Response> getAll() {
        
        // informasi nama method
        String nameOfCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();
        
        // memanggil class response yg telah dibuat
        Response response = new Response();
        response.setService(this.getClass().getName() + ":" + nameOfCurrMethod);
        response.setMessage("response successful");
        
        // set data dari database
        response.setData(userGroupModulesService.findAll());
        
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }
    
    @GetMapping(value = "userid/{userId}")
    ResponseEntity<Response> getOneByUserId(@PathVariable("userId") Long userId) {
        
        // informasi nama method
        String nameOfCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();
        
        // memanggil class response yg telah dibuat
        Response response = new Response();
        response.setService(this.getClass().getName() + ":" + nameOfCurrMethod);
        response.setMessage("response successful");
        
        // set data dari database
        response.setData(userGroupModulesService.findByUserId(userId));
        
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }
    
    @GetMapping(value = "username/{username}")
    ResponseEntity<Response> getOneByUserId(@PathVariable("username") String username) {
        
        // informasi nama method
        String nameOfCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();
        
        // memanggil class response yg telah dibuat
        Response response = new Response();
        response.setService(this.getClass().getName() + ":" + nameOfCurrMethod);
        response.setMessage("successful");
        
        // set data dari database
        response.setData(userGroupModulesService.findByUsername(username));
        
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }
}
