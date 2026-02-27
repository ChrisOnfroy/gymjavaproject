package com.example.gymjavaproject.controller;

import com.example.gymjavaproject.model.dto.userModelDto;
import com.example.gymjavaproject.model.userModel;
import com.example.gymjavaproject.service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class userController {

    private final userService userService;

    @GetMapping
    public ResponseEntity<Object>getUsers(){
        ArrayList<userModel> usermodel = userService.getUsers();
        return new ResponseEntity<>(usermodel, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody  userModelDto user) {

        userModel userToSave = new userModel();

        userToSave.setTipoDocumento(user.getTipoDocumento());
        userToSave.setNumeroDocumento(user.getNumeroDocumento());
        userToSave.setPrimerNombre(user.getPrimerNombre());
        userToSave.setSegundoNombre(user.getSegundoNombre());
        userToSave.setPrimerApellido(user.getPrimerApellido());
        userToSave.setSegundoApellido(user.getSegundoApellido());
        userToSave.setDireccion(user.getDireccion());
        userToSave.setCiudad(user.getCiudad());
        userToSave.setPeso(user.getPeso());
        userToSave.setMensualidad(user.getMensualidad());
        userToSave.setEmail(user.getEmail());

        userModel saveUser = userService.createUser(userToSave);

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/{numeroDocumento}")
    public ResponseEntity<Object> getUserNumeroDocumento(@PathVariable int numeroDocumento){

        userModel usermodel = userService.getUserByDocument(numeroDocumento);

        return new ResponseEntity<>(usermodel, HttpStatus.OK);

    }
    @DeleteMapping("/{numeroDocumento}")
    public ResponseEntity<Object>deleteUser(@PathVariable int numeroDocumento){

        Boolean usermodel = userService.deleteUser(numeroDocumento);

        return new ResponseEntity<>(usermodel, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{numeroDocumento}")
    public  ResponseEntity<Object>updateUser(@RequestBody userModelDto user, @PathVariable int numeroDocumento){
        try{
            userModel updated = userService.updateUser(numeroDocumento, user);
            if (updated != null){
                return new ResponseEntity<>("Usuario Actualizado correctamente. ", HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>("Usuario no encontrado con los datos correspondientes.", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar el Usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
