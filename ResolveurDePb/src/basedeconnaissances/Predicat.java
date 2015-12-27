/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedeconnaissances;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sabrine
 */
public class Predicat {

    private String nom;
    private List<String> tableau;

    public Predicat() {
    }

    public Predicat(String nom, ArrayList<String> tableau) {
        this.nom = nom;
        this.tableau = tableau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getTableau() {
        return tableau;
    }

    public void setTableau(List<String> tableau) {
        this.tableau = tableau;
    }

    public Predicat extrairePredicat(String text) {
        Predicat predicat = new Predicat();
        String[] split1 = text.split("\\(", 2);
        predicat.setNom(split1[0]);
        split1[1] = split1[1].replace(")", "");
        String[] split2 = split1[1].split(",");
        ArrayList<String> tableau = new ArrayList<String>();
        for (String element : split2) {
            element = element.replace(" ","");
            tableau.add(element);
        }
        predicat.setTableau(tableau);
        return predicat;
    }

    @Override
    public String toString() {
        return "Predicat{" + "nom=" + nom + ", tableau=" + tableau+'}';
    }

    

}
