/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.pokemonrojofuego;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author Kuroiryuudev
 */
@Entity
@Table(name = "Entrenador")
@NamedQueries({
    @NamedQuery(name = "Entrenador.findAll", query = "SELECT e FROM Entrenador e"),
    @NamedQuery(name = "Entrenador.findByNombreEntrenador", query = "SELECT e FROM Entrenador e WHERE e.nombreEntrenador = :nombreEntrenador"),
    @NamedQuery(name = "Entrenador.findByIdEntrenador", query = "SELECT e FROM Entrenador e WHERE e.idEntrenador = :idEntrenador"),
    @NamedQuery(name = "Entrenador.findByClase", query = "SELECT e FROM Entrenador e WHERE e.clase = :clase"),
    @NamedQuery(name = "Entrenador.findByDinero", query = "SELECT e FROM Entrenador e WHERE e.dinero = :dinero")})
public class Entrenador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_entrenador")
    private String nombreEntrenador;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenador")
    private Integer idEntrenador;

    @Column(name = "clase")
    private String clase;

    @Column(name = "dinero")
    private Integer dinero;

    public Entrenador() {
    }

    public Entrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @OneToMany
    @JoinColumn(name = "id_entrenador", referencedColumnName = "id_entrenador", insertable = false, updatable = false)
    protected List<Pokemon> pokemon;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrenador != null ? idEntrenador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrenador)) {
            return false;
        }
        Entrenador other = (Entrenador) object;
        if ((this.idEntrenador == null && other.idEntrenador != null) || (this.idEntrenador != null && !this.idEntrenador.equals(other.idEntrenador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.pokemonrojofuego.Entrenador[ idEntrenador=" + idEntrenador + " ]";
    }

}
