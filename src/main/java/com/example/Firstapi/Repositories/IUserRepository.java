package com.example.Firstapi.Repositories;

import com.example.Firstapi.Models.CUser;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<CUser, Integer> {
}
