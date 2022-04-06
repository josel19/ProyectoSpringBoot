package com.pruebAa.ApiRestFull2.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.pruebAa.ApiRestFull2.modelo.Actor;
import com.pruebAa.ApiRestFull2.modelo.Film;
import com.pruebAa.ApiRestFull2.modelo.FilmActor;
import com.pruebAa.ApiRestFull2.repository.ActorRepository;
import com.pruebAa.ApiRestFull2.repository.FilmActorRepo;
import com.pruebAa.ApiRestFull2.repository.FilmsRepository;
import com.pruebAa.ApiRestFull2.repository.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JOSÈ LUGO GOMEZ
 */
@RestController
public class ApiController {
// ------ Inyeccion De Repositorios
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private FilmsRepository filmsRepository;

    @Autowired
    private FilmActorRepo filmActorRepository;
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    
    
    
// ------ Mapeos/EndPoints -----------
    //1#Crear En La Tabla Actor ✓
    @PostMapping("/actor/create")
    Actor crearActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    //2# Crear En La Tabla Film ✓
    @PostMapping("/film/create")
    Film crearFilm(@RequestBody Film film) {
        return filmsRepository.save(film);
    }

    //3# Crear En La Tabla Film_Actor ✓
    @PostMapping("/film-actor/create")
    FilmActor crearFilmActor(@RequestBody FilmActor filmActor) {
        return filmActorRepository.save(filmActor);
    }

    //#4 Listar Actores Por Pelicula ✓
    @GetMapping("/actor/film/{IdFilm}")
    List<Object> ListarActoresDePelicula(@PathVariable("IdFilm") Short IdFilm) {
        return filmActorRepository.ListarActoresDePelicula(IdFilm);
    }
    
    //#5 Listar Clientes, Pagos Recibidos Por Staff ✓
    @GetMapping("/payment/{IdStaff}")
    List<Object> ListarClientesyPagosPorStaff(@PathVariable("IdStaff") Short IdStaff) {
        return paymentRepository.listarClientesyPagosPorStaff(IdStaff);
    }
    
    //#6 Listar Peliculas Por Categoria ✓
    /*
    @GetMapping("/Films/Category{IdCategory}")
    List<Object> ListarClientesyPagosPorStaff(@PathVariable("IdStaff") Short IdStaff) {
        return filmActorRepository.ListarActoresDePelicula(IdStaff);
    }
    */
    //-------        EndPoints Para Probar    ----------
    //- Listar Tabla Actor
    @GetMapping("/actor/all")
    List<Actor> ListarActor() {
        return actorRepository.ListarActores();
    }

    //- Listar Tabla Film
    @GetMapping("/film/all")
    List<Film> ListarFilm() {
        return filmsRepository.ListarFilms();
    }

    //- Listar Tabla Film_actor
    @GetMapping("film-actor/all")
    List<FilmActor> ListarAll() {
        return filmActorRepository.ListarTodo();
    }
 

}
