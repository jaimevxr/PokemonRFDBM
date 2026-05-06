/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.pokemonrojofuego;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alumnado
 */
@Entity
@Table(name = "Pokemon")
@NamedQueries({
    @NamedQuery(name = "Pokemon.findAll", query = "SELECT p FROM Pokemon p"),
    @NamedQuery(name = "Pokemon.findByIdPokemon", query = "SELECT p FROM Pokemon p WHERE p.idPokemon = :idPokemon"),
    @NamedQuery(name = "Pokemon.findByApodo", query = "SELECT p FROM Pokemon p WHERE p.apodo = :apodo"),
    @NamedQuery(name = "Pokemon.findByEspecie", query = "SELECT p FROM Pokemon p WHERE p.especie = :especie"),
    @NamedQuery(name = "Pokemon.findByNivel", query = "SELECT p FROM Pokemon p WHERE p.nivel = :nivel"),
    @NamedQuery(name = "Pokemon.findBySprite", query = "SELECT p FROM Pokemon p WHERE p.sprite = :sprite"),
    @NamedQuery(name = "Pokemon.findByIdEntrenador", query = "SELECT p FROM Pokemon p WHERE p.idEntrenador = :idEntrenador")})
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_pokemon")
    private Integer idPokemon;
    @Column(name = "apodo")
    private String apodo;
    @Column(name = "especie")
    private String especie;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "sprite")
    private String sprite;
    @Column(name = "id_entrenador")
    private Integer idEntrenador;

    public Pokemon() {
    }

    public Pokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPokemon != null ? idPokemon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pokemon)) {
            return false;
        }
        Pokemon other = (Pokemon) object;
        if ((this.idPokemon == null && other.idPokemon != null) || (this.idPokemon != null && !this.idPokemon.equals(other.idPokemon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.pokemonrojofuego.Pokemon[ idPokemon=" + idPokemon + " ]";
    }
    
}
