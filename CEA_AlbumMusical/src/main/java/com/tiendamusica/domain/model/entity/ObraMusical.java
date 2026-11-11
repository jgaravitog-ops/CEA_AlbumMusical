package com.tiendamusica.domain.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ObraMusical {

    private final UUID id;
    private String titulo;
    private String genero;
    private int anioPublicacion;
    private String descripcion;
    private final List<Pista> pistas;

    public ObraMusical(
            UUID id,
            String titulo,
            String genero,
            int anioPublicacion,
            String descripcion) {

        if (id == null) {
            throw new IllegalArgumentException("El ID es obligatorio");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }

        if (anioPublicacion <= 0 ||
                anioPublicacion > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("Año de publicación inválido");
        }

        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.descripcion = descripcion;
        this.pistas = new ArrayList<>();
    }

    public void agregarPista(Pista pista) {
        if (pista == null) {
            throw new IllegalArgumentException("La pista no puede ser nula");
        }

        boolean numeroRepetido = pistas.stream()
                .anyMatch(p -> p.getNumero() == pista.getNumero());

        if (numeroRepetido) {
            throw new IllegalArgumentException(
                    "Ya existe una pista con ese número");
        }

        pistas.add(pista);
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Pista> getPistas() {
        return List.copyOf(pistas);
    }
}
