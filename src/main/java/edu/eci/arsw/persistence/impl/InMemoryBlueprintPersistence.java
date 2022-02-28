/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.model.Blueprint;
import edu.eci.arsw.model.Point;
import edu.eci.arsw.persistence.BlueprintNotFoundException;
import edu.eci.arsw.persistence.BlueprintPersistenceException;
import edu.eci.arsw.persistence.BlueprintsPersistence;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
@Component("im")
public class InMemoryBlueprintPersistence extends BlueprintsPersistence{

    public InMemoryBlueprintPersistence() {
        //load stub data
        Point[] pts=new Point[]{new Point(140, 140),new Point(115, 115)};
        Blueprint bp=new Blueprint("Juan", "plano1 ",pts);
        blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        Point[] pts1=new Point[]{new Point(100, 70),new Point(150, 150)};
        Blueprint bp1=new Blueprint("David", "plano_casa ",pts);
        blueprints.put(new Tuple<>(bp1.getAuthor(),bp1.getName()), bp1);
        Point[] pts2=new Point[]{new Point(50, 60),new Point(80, 100)};
        Blueprint bp2=new Blueprint("Juan", "plano2",pts);
        blueprints.put(new Tuple<>(bp2.getAuthor(),bp2.getName()), bp2);
        Point[] pts3=new Point[]{new Point(120, 120),new Point(110, 95)};
        Blueprint bp3=new Blueprint("Carlos", "plano_edificio",pts);
        blueprints.put(new Tuple<>(bp3.getAuthor(),bp3.getName()), bp3);
        Point[] pts4=new Point[]{new Point(180, 160),new Point(15, 15)};
        Blueprint bp4=new Blueprint("Maria", "plano_estadio",pts);
        blueprints.put(new Tuple<>(bp4.getAuthor(),bp4.getName()), bp4);
        
    }

    @Override
    public Map<Tuple<String, String>, Blueprint> getBlueprints() {
        return blueprints;
    }

    @Override
    public Blueprint filtrar(Blueprint bp) {
        return bp;
    }
}
