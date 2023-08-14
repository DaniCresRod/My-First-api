package com.example.Firstapi.Services;

import com.example.Firstapi.Repositories.IUserRepository;
import com.example.Firstapi.Models.CUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class USerService {

    @Autowired
    IUserRepository iUserRepository;

    public CUser getById(int id){
        return iUserRepository.findById(id).orElse(null);
    }

    public CUser saveUser(CUser user){
        return iUserRepository.save(user);
    }

    public ArrayList<CUser> getUsers(){
        return (ArrayList<CUser>) iUserRepository.findAll();
    }

    public String deleteUser(int userId){
        try{
            iUserRepository.deleteById(userId);
            return "Deleted" + userId;
        }
        catch(Exception Error){
            return "Not Deleted" + Error.getMessage();
        }
    }

    public CUser changeUser(CUser userModificado, int id){
        CUser userQueYaExiste=iUserRepository.findById(id).get();   //Busca el usuario y nos deja usarlo

        userQueYaExiste.setName(userModificado.getName());
        userQueYaExiste.setLastName(userModificado.getLastName());

        return userQueYaExiste; //Ya tiene las modificaciones pertinentes hechas
    }
}
