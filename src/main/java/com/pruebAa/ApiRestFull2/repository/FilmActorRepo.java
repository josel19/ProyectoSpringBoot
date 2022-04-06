package com.pruebAa.ApiRestFull2.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.pruebAa.ApiRestFull2.modelo.FilmActor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JOSÈ LUGO GOMEZ
 */
public interface FilmActorRepo extends JpaRepository<FilmActor, Short> {
    //----------------- Consultas Jpql --------------------------
     @Query("SELECT f FROM FilmActor f")
     List<FilmActor>ListarTodo();
    // @Query("SELECT  f  FROM FilmActor f WHERE f.film.filmId = :IdFilm")
    // List<FilmActor>ListarActoresDePelicula(@Param("IdFilm") Short IdFilm);
     
     
     
     
     //// ------------- Consultas Nativas ---------------------------------
     @Query(value = "select  A.actor_id, A.first_name, A.last_name\r\n"
			+ "from film_actor as FA, actor A, film F\r\n"
			+ "where FA.actor_id = A.actor_id and\r\n"
			+ "FA.film_id = F.film_id and F.film_id = ?\r\n",nativeQuery = true)
     List<Object>ListarActoresDePelicula(@Param("IdFilm") Short IdFilm);
}
