package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.eci.arsw.blueprints.persistence.impl.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class BluePrintsServices {

    @Autowired
    @Qualifier("inMemory")
    BlueprintsPersistence bpp;

    public void addNewBlueprint(Blueprint bp){
        try {
            bpp.saveBlueprint(bp);
        } catch (BlueprintPersistenceException e) {
            System.out.println("No es posible guardar el plano");
        }
    }

    public Set<Blueprint> getAllBlueprints(){
        Map<Tuple<String, String>, Blueprint> collecion = bpp.getBlueprints();
        Set<Tuple<String,String>> llaves = collecion.keySet();
        HashSet<Blueprint> result = new HashSet<>();
        for (Tuple<String,String> t: llaves) {
            result.add(collecion.get(t));
        }
        return result;
    }

    /**
     *
     * @param author blueprint's author
     * @param name blueprint's name
     * @return the blueprint of the given name created by the given author
     * @throws BlueprintNotFoundException if there is no such blueprint
     */
    public Blueprint getBlueprint(String author,String name) throws BlueprintNotFoundException{
        Blueprint respuesta = bpp.getBlueprint(author, name);
        if (respuesta == null){
            throw new BlueprintNotFoundException("Plano no encontrado");
        }
        else {
            return respuesta;
        }
    }

    /**
     *
     * @param author blueprint's author
     * @return all the blueprints of the given author
     * @throws BlueprintNotFoundException if the given author doesn't exist
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{
        Set<Blueprint> respuesta = bpp.getBlueprintsByAuthor(author);
        if (respuesta.isEmpty()){
            throw new BlueprintNotFoundException("Autor no encontrado");
        }
        else {
            return respuesta;
        }
    }

}

