package com.example.gymjavaproject.service;


import com.example.gymjavaproject.model.dto.userModelDto;
import com.example.gymjavaproject.model.userModel;

import java.util.ArrayList;

public interface userService {

    ArrayList<userModel>getUsers();

    userModel getUserByDocument(int numeroDocumento);

    userModel createUser(userModel numeroDocumento);

    userModel updateUser(int numeroDocumento, userModelDto userModelDto);

    Boolean deleteUser(int numeroDocumento);
}
