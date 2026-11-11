package com.tiendamusica.domain.model.aggregate;

import com.tiendamusica.domain.event.DomainEvent;
import com.tiendamusica.domain.event.ObraMusicalRegistrada;
import com.tiendamusica.domain.model.entity.Pista;
import com.tiendamusica.domain.model.valueobject.AnioPublicacion;
import com.tiendamusica.domain.exception.InvalidMusicalWorkException;
import com.tiendamusica.domain.exception.InvalidTrackException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ObraMusical {

    private final UUID id;
    private String titulo;
    private String genero;
    private AnioPublicacion anioPublicacion;
    private String descripcion;

    private final List<Pista> pistas;
    private final List<DomainEvent> eventosDominio = new ArrayList<>();

    public ObraMusical(
            UUID id,
            String titulo,
            String genero,
            AnioPublicacion anioPublicacion,
            String descripcion) {

        if (id == null) {
            throw new InvalidMusicalWorkException(
            "El ID de la obra es obligatorio");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new InvalidMusicalWorkException(
            "El título de la obra es obligatorio");
        }

        if (anioPublicacion == null) {
            throw new InvalidMusicalWorkException(
            "El año de publicación es obligatorio");
        }

        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.descripcion = descripcion;
        this.pistas = new ArrayList<>();

        eventosDominio.add(
            new ObraMusicalRegistrada(this.id, this.titulo)
        );
    }

    // Agrega una pista al agregado
    public void agregarPista(Pista pista) {

        if (pista == null) {
            throw new InvalidTrackException(
            "La pista no puede ser nula");
        }

        boolean numeroExistente = pistas.stream()
                .anyMatch(p -> p.getNumero() == pista.getNumero());

        if (numeroExistente) {
            throw new InvalidTrackException(
            "Ya existe una pista con ese número");
        }

        pistas.add(pista);
    }

    // Consulta las pistas sin permitir modificaciones externas
    public List<Pista> getPistas() {
        return List.copyOf(pistas);
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public AnioPublicacion getAnioPublicacion() {
        return anioPublicacion;
    }
    
    public List<DomainEvent> obtenerEventosDominio() {
        return List.copyOf(eventosDominio);
    }

    public void limpiarEventosDominio() {
        eventosDominio.clear();
    }
}