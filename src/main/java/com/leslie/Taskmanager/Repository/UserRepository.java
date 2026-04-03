package com.leslie.Taskmanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leslie.Taskmanager.Entity.User;

//Il s'occupe de la base de données
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring gère automatiquement CRUD, plus besoin d'écrire du SQL, à par si l'on veut faire des requetes complexes
}