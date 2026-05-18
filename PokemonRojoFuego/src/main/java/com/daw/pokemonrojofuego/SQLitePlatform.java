/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.pokemonrojofuego;
import org.eclipse.persistence.platform.database.DatabasePlatform;
import org.eclipse.persistence.queries.ValueReadQuery;

/**
 *
 * @author Jbelc
 */


public class SQLitePlatform extends DatabasePlatform {

    @Override
    public boolean supportsIdentity() {
        // Le decimos a EclipseLink: "Oye, que mi base de datos SÍ hace autoincrementos solos"
        return true;
    }

    @Override
    public ValueReadQuery buildSelectQueryForIdentity() {
        ValueReadQuery query = new ValueReadQuery();
        // Le enseñamos el comando nativo de SQLite para leer el último ID que acaba de generar
        query.setSQLString("SELECT last_insert_rowid()");
        return query;
    }
}
