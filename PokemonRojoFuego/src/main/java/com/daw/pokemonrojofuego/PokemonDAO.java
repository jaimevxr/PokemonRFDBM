/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.pokemonrojofuego;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alumnado
 */
public class PokemonDAO {

    // encontrar un Pokémon por su id
    public Pokemon buscarPorId(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Pokemon pokemon = em.find(Pokemon.class, id);
        em.close();
        return pokemon;
    }

    // buscar un Pokémon por su apodo
    public Pokemon buscarPorApodo(String apodoPokemon) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        javax.persistence.TypedQuery<Pokemon> consulta = em.createQuery("SELECT p FROM Pokemon p WHERE p.apodo = :apodo", Pokemon.class);
        consulta.setParameter("apodo", apodoPokemon);
        List<Pokemon> resultados = consulta.getResultList();
        em.close();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    // Método insert
    public void guardar(Pokemon pokemon) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(pokemon);
        em.getTransaction().commit();
        em.close();
    }

    // Método update
    public void actualizar(Pokemon pokemon) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(pokemon);
        em.getTransaction().commit();
        em.close();
    }

    // Método delete
    public void borrar(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        Pokemon pokemon = em.find(Pokemon.class, id);
        if (pokemon != null) {
            em.remove(pokemon);
        }
        em.getTransaction().commit();
        em.close();
    }

    //devuelve todos los Pokémon que existen
    public List<Pokemon> obtenerTodos() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        javax.persistence.TypedQuery<Pokemon> consulta = em.createQuery("SELECT p FROM Pokemon p", Pokemon.class);
        List<Pokemon> lista = consulta.getResultList();

        em.close();
        return lista;
    }

    //Devuelve solo los Pokémon de un Entrenador concreto
    public List<Pokemon> obtenerPorEntrenador(Entrenador entrenador) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        javax.persistence.TypedQuery<Pokemon> consulta = em.createQuery("SELECT p FROM Pokemon p WHERE p.entrenador = :entrenador", Pokemon.class);
        consulta.setParameter("entrenador", entrenador);
        List<Pokemon> lista = consulta.getResultList();
        em.close();
        return lista;
    }

    public void actualizarSpriteMasivo(String nombrePokemon, byte[] nuevoSprite) {
        javax.persistence.EntityManager em = com.daw.pokemonrojofuego.EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // OJO: Si tu variable en Pokemon.java se llama 'apodo', déjalo así. 
            // Si se llama 'especie' o 'nombre', cámbialo en "p.apodo".
            javax.persistence.Query consulta = em.createQuery(
                    "UPDATE Pokemon p SET p.sprite = :foto WHERE p.apodo = :nombre"
            );
            consulta.setParameter("foto", nuevoSprite);
            consulta.setParameter("nombre", nombrePokemon);

            int actualizados = consulta.executeUpdate(); // Ejecuta el rayo

            em.getTransaction().commit();

            System.out.println("Se han actualizado " + actualizados + " Pokémon de la especie: " + nombrePokemon);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

}
