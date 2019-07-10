package id.mbingweb.hctest.controller;

import id.mbingweb.hctest.service.AppUserService;
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
@RequestMapping(value = "user")
public class AppUserController {
    @Autowired
    AppUserService appUserService;
    
    private String service = "AppUser";
    
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
        response.setData(appUserService.getAll());
        
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }
    
    @GetMapping(value = "id/{id}")
    ResponseEntity<Response> getById(@PathVariable("id") Long id) {
        // informasi nama method
        String nameOfCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();
        
        // memanggil class response yg telah dibuat
        Response response = new Response();
        response.setService(this.getClass().getName() + ":" + nameOfCurrMethod);
        response.setMessage("response successful");
        
        // set data dari database
        response.setData(appUserService.getById(id));
        
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }
}
