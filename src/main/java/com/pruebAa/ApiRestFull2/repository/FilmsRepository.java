package com.pruebAa.ApiRestFull2.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.pruebAa.ApiRestFull2.modelo.Film;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author JOSÈ LUGO GOMEZ
 */
public interface FilmsRepository extends JpaRepository<Film, Short> {

    @Query("SELECT f FROM Film f")
    List<Film> ListarFilms();

}
