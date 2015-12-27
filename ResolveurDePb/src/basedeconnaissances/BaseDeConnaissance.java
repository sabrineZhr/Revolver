/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedeconnaissances;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sabrine
 */
public class BaseDeConnaissance {

    String fichierRegle;
    String fichierFait;

    public BaseDeConnaissance() {
    }

    public BaseDeConnaissance(String fichierRegle, String fichierFait) {
        this.fichierRegle = fichierRegle;
        this.fichierFait = fichierFait;
    }

    public String getFichierRegle() {
        return fichierRegle;
    }

    public void setFichierRegle(String fichierRegle) {
        this.fichierRegle = fichierRegle;
    }

    public String getFichierFait() {
        return fichierFait;
    }

    public void setFichierFait(String fichierFait) {
        this.fichierFait = fichierFait;
    }

    public ArrayList<Regle> chargementRegles() {
        ArrayList<Regle> regles = new ArrayList<Regle>();
        try {

            InputStream ips = new FileInputStream(fichierRegle);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            while ((ligne = br.readLine()) != null) {
                Regle regle = new Regle();
                Predicat predicatConclusion = new Predicat();
                Predicat predicatPremisse = new Predicat();
                List<Predicat> listePredicat = new ArrayList<Predicat>();
                List<Item> items = new ArrayList<Item>();
                String[] split = ligne.split(":");
                regle.setNumero(split[0]);
                String[] split1 = split[1].split(" alors ");
                regle.setConclusion(predicatConclusion.extrairePredicat(split1[1]));
                if (!split1[0].contains(" ,et ")) {
                    listePredicat.add(predicatPremisse.extrairePredicat(split1[0]));
                    regle.setPredicats(listePredicat);
                    regle.setItems(items);
                   // System.out.println("num: " + regle.getNumero() + " predicat  "
                           // + regle.getPredicats() + " Conclusion " + regle.getConclusion());
                    regles.add(regle);
                } else {
                    String[] split2 = split1[0].split(" ,et ");
                    listePredicat.add(predicatPremisse.extrairePredicat(split2[0]));
                    regle.setPredicats(listePredicat);
                    String[] split3 = split2[1].split(" et ");
                   // System.out.print("num: " + regle.getNumero() + " predicat  "
                            //+ regle.getPredicats() + "  Conclusion " + regle.getConclusion());
                    for (String element : split3) {
                        Item item = new Item();
                        items.add(item.extraireItem(element));
                        regle.setItems(items);

                    }
                  //  System.out.println(regle.getItems());
                    regles.add(regle); }}
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());}
        return regles;
    }

    public ArrayList<Fait> chargementFaits() {
        ArrayList<Fait> faits = new ArrayList<Fait>();
        try {

            InputStream ips = new FileInputStream(fichierFait);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            while ((ligne = br.readLine()) != null) {
               // System.out.println(ligne);
                Fait fait = new Fait();
                Predicat predicat = new Predicat();
                fait.setPredicat(predicat.extrairePredicat(ligne));
               // System.out.println(fait.toString());
                faits.add(fait);
            }
            br.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return faits;

    }
}
