package com.example.gymjavaproject.service.impl;


import com.example.gymjavaproject.exception.notFoundExceptionPer;
import com.example.gymjavaproject.model.dto.userModelDto;
import com.example.gymjavaproject.model.userModel;
import com.example.gymjavaproject.repository.userRepository;
import com.example.gymjavaproject.service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    public final userRepository userRepository;

    @Override
    public ArrayList<userModel> getUsers() {
        return (ArrayList<userModel>)userRepository.findAll();
    }

    @Override
    public userModel getUserByDocument(int numeroDocumento) {
        return userRepository.getUserBynumeroDocumento(numeroDocumento);
    }

    //Este servicio es para la creacion de nuevos usuarios
    @Override
    public userModel createUser(userModel user) {

        Optional<userModel> existingUserOtp = userRepository.findByNumeroDocumento(user.getNumeroDocumento());
        if(existingUserOtp.isPresent()){
            throw new RuntimeException("Usuario Registrado");
        }

        if(user.getTipoDocumento().isEmpty()){
            throw new notFoundExceptionPer("El tipo de documento se encuentra vacio.");
        }

        if(user.getNumeroDocumento() == 0){
            throw new notFoundExceptionPer("El numero de documento es incorrecto");
        }

        if(user.getPrimerNombre() == null || user.getPrimerNombre().isEmpty()){
            throw new notFoundExceptionPer("El primer nombre se encuentra vacío.");
        }

        if(user.getSegundoNombre() == null || user.getSegundoNombre().isEmpty()){
            throw new notFoundExceptionPer("El segundo nombre se encuentra vacío.");
        }

        if(user.getPrimerApellido() == null || user.getPrimerApellido().isEmpty()){
            throw new notFoundExceptionPer("El primer apellido se encuentra vacío.");
        }

        if(user.getSegundoApellido() == null || user.getSegundoApellido().isEmpty()){
            throw new notFoundExceptionPer("El segundo apellido se encuentra vacío.");
        }

        if(user.getDireccion() == null || user.getDireccion().isEmpty()){
            throw new notFoundExceptionPer("La dirección se encuentra vacía.");
        }

        if(user.getCiudad() == null || user.getCiudad().isEmpty()){
            throw new notFoundExceptionPer("La ciudad se encuentra vacía.");
        }

        if(user.getPeso() <= 0){
            throw new notFoundExceptionPer("El peso es incorrecto.");
        }

        if(user.getMensualidad() == null){
            throw new notFoundExceptionPer("La mensualidad es incorrecta.");
        }

        if(user.getEmail() == null || user.getEmail().isEmpty()){
            throw new notFoundExceptionPer("El email se encuentra vacío.");
        }

        if(!user.getEmail().contains("@")){
            throw new notFoundExceptionPer("El email no es valido.");
        }

        user = userRepository.save(user);
        return user;
    }

    // Este servicio esta especializado en actualiar la informacion de los usuarios o cambiar su estado
    @Override
    public userModel updateUser(int numeroDocumento, userModelDto userModelDto) {

        Optional<userModel> existingUserOtp = userRepository.findByNumeroDocumento(numeroDocumento);

        if(existingUserOtp.isEmpty()){
          throw new RuntimeException("Usuario no encontrado");
        }

        userModel existingUser = existingUserOtp.get();

        existingUser.setTipoDocumento(userModelDto.getTipoDocumento());
        existingUser.setNumeroDocumento(userModelDto.getNumeroDocumento());
        existingUser.setPrimerNombre(userModelDto.getPrimerNombre());
        existingUser.setSegundoNombre(userModelDto.getSegundoNombre());
        existingUser.setPrimerApellido(userModelDto.getPrimerApellido());
        existingUser.setSegundoApellido(userModelDto.getSegundoApellido());
        existingUser.setDireccion(userModelDto.getDireccion());
        existingUser.setCiudad(userModelDto.getCiudad());
        existingUser.setPeso(userModelDto.getPeso());
        existingUser.setMensualidad(userModelDto.getMensualidad());
        existingUser.setEmail(userModelDto.getEmail());

        return userRepository.save(existingUser);

    }

    @Override
    public Boolean deleteUser(int numeroDocumento) {
        Optional<userModel> existingUserOtp = userRepository.findByNumeroDocumento(numeroDocumento);
        if (existingUserOtp.isPresent()){
            userRepository.delete(existingUserOtp.get());
            return true;
        }
        return false;
    }


}
