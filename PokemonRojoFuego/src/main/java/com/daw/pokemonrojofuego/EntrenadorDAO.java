package com.daw.pokemonrojofuego;

import com.daw.pokemonrojofuego.EntityManagerUtil;
import com.daw.pokemonrojofuego.Entrenador;
import java.util.List;
import javax.persistence.EntityManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Kuroiryuudev
 */
public class EntrenadorDAO {

    // Metodo select, encontrar entrenador de la base de datos por su id
    public Entrenador buscarPorId(int id) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        Entrenador entrenador = em.find(Entrenador.class, id);
        em.close();

        return entrenador;
    }
    // Metodo select, encontrar entrenadores de la base de datos por su nombre
    public java.util.List<Entrenador> buscarPorNombre(String nombreAbuscar) {
        javax.persistence.EntityManager em = com.daw.pokemonrojofuego.EntityManagerUtil.getEntityManager();
        try {
            javax.persistence.TypedQuery<Entrenador> consulta = em.createQuery(
                    "SELECT e FROM Entrenador e WHERE LOWER(e.nombreEntrenador) = LOWER(:nombre)", Entrenador.class);
            consulta.setParameter("nombre", nombreAbuscar);

            // Devolvemos la lista entera. Si no hay ninguno, devolverá una lista vacía.
            return consulta.getResultList();

        } finally {
            em.close();
        }
    }

    // metodo insert
    public void guardar(Entrenador entrenador) {
        javax.persistence.EntityManager em = com.daw.pokemonrojofuego.EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entrenador);
        em.getTransaction().commit();
        em.close();
    }

    // metodo update
    public void actualizar(Entrenador entrenador) {
        javax.persistence.EntityManager em = com.daw.pokemonrojofuego.EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entrenador);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw e;
        } finally {
            em.close();
        }
    }

// metodo delete
    public void borrar(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Entrenador entrenador = em.find(Entrenador.class, id);

            if (entrenador != null) {
                // 1. Eliminamos primero todos sus Pokémon para que no queden huérfanos en la BD
                em.createQuery("DELETE FROM Pokemon p WHERE p.entrenador.idEntrenador = :id")
                        .setParameter("id", id)
                        .executeUpdate();

                // 2. Una vez limpia la relación, eliminamos al entrenador de forma segura
                em.remove(entrenador);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Si algo falla, revertimos los cambios
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    // metodo para obtener todos los pokemons
    public List<Entrenador> obtenerTodos() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        javax.persistence.TypedQuery<Entrenador> consulta = em.createQuery("SELECT e FROM Entrenador e", Entrenador.class);
        List<Entrenador> lista = consulta.getResultList();
        em.close();
        return lista;
    }
}
