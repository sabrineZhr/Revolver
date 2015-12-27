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
public class Regle {

    private String numero;
    private Predicat conclusion;
    private List<Predicat> predicats;
    private List<Item> items;

    public Regle() {
    }

    public Regle(String numero, Predicat conclusion, List<Predicat> predicats, List<Item> items) {
        this.numero = numero;
        this.conclusion = conclusion;
        this.predicats = predicats;
        this.items = items;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Predicat getConclusion() {
        return conclusion;
    }

    public void setConclusion(Predicat conclusion) {
        this.conclusion = conclusion;
    }

    public List<Predicat> getPredicats() {
        return predicats;
    }

    public void setPredicats(List<Predicat> predicats) {
        this.predicats = predicats;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Regle{" + "numero=" + numero + ", conclusion=" + conclusion + ", predicats=" + predicats + ", items=" + items + '}';
    }

    public void chargementRegles(String fichier) {
        try {

            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            while ((ligne = br.readLine()) != null) {
                Regle regle = new Regle();
                Predicat predicatConclusion = new Predicat();
                Predicat predicatPremisse = new Predicat();

                String[] split = ligne.split(":");
                regle.numero = split[0];
                String[] split1 = split[1].split(" alors ");
                regle.conclusion = predicatConclusion.extrairePredicat(split1[1]);
                String[] split2 = split1[0].split(" ,et ");
                regle.predicats.add(predicatPremisse.extrairePredicat(split2[0]));
                String[] split3 = split2[1].split(" et ");
                for (String element : split3) {
                    Item item = new Item();
                    System.out.print(element);
                    regle.items.add(item.extraireItem(element));

                }

            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
