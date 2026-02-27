package com.example.gymjavaproject.repository;

import com.example.gymjavaproject.model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<userModel, String> {

    userModel getUserBynumeroDocumento(int numeroDocumento);

    Optional<userModel> findByNumeroDocumento(int numeroDocumento);
}
