package com.example.Firstapi.Controllers;

import com.example.Firstapi.Models.CUser;
import com.example.Firstapi.Services.USerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController /*extends USerService*/ {

    @Autowired
    USerService uSerService;

    @GetMapping()
    public ArrayList<CUser> getUsers(){
        return uSerService.getUsers();
    }

    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable int id){
        return uSerService.deleteUser(id);
    }

    @PostMapping(value="/add")
    public CUser saveUser(@RequestBody CUser nuevoUser){
        //https://youtu.be/PyWwm5VjQlU

        /*El formato del JSON que tiene que llegar (en el body del postman, por ejemplo) sería:
        {
            "name" : "ElQueSea",
            "lastName" : "EsoOtro"
        }
         */

        return uSerService.saveUser(nuevoUser);
    }

    @PutMapping(path="/change/{id}")
    public CUser changeUser(@PathVariable int id, @RequestBody CUser usuarioCorregido){

        CUser savedUser=uSerService.changeUser(usuarioCorregido, id);

        return uSerService.saveUser(savedUser);     //Hay que salvar en la base de datos las modificaciones
    }
}
