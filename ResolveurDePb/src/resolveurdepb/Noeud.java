/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resolveurdepb;

import basedeconnaissances.Predicat;

/**
 *
 * @author sabrine
 */
public class Noeud {
    Predicat etat;
    Noeud parent;
    String nombreRegle;
    int profondeur;
    int f;
    int g;

    public Noeud() {
    }

    
    
    
    public Noeud(Predicat etat, Noeud parent, String nombreRegle, int profondeur) {
        this.etat = etat;
        this.parent = parent;
        this.nombreRegle = nombreRegle;
        this.profondeur = profondeur;
       
    }

    public Predicat getEtat() {
        return etat;
    }

    public void setEtat(Predicat etat) {
        this.etat = etat;
    }

    public Noeud getParent() {
        return parent;
    }

    public void setParent(Noeud parent) {
        this.parent = parent;
    }

    public String getNombreRegle() {
        return nombreRegle;
    }

    public void setNombreRegle(String nombreRegle) {
        this.nombreRegle = nombreRegle;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    @Override
    public String toString() {
        return "Noeud{" + "etat=" + etat + ", parent=" + parent + ", nombreRegle=" + nombreRegle + ", profondeur=" + profondeur + ", f=" + f + ", g=" + g + '}';
    }
    
    
    
    
}
