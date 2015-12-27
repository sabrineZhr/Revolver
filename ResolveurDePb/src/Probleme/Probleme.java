/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Probleme;

import basedeconnaissances.BaseDeConnaissance;

/**
 *
 * @author sabrine
 */
public class Probleme {
    BaseDeConnaissance baseConnaissance;
    String nom;

    public Probleme() {
    }

    public Probleme(BaseDeConnaissance baseConnaissance, String nom) {
        this.baseConnaissance = baseConnaissance;
        this.nom = nom;
    }

    public BaseDeConnaissance getBaseConnaissance() {
        return baseConnaissance;
    }

    public void setBaseConnaissance(BaseDeConnaissance baseConnaissance) {
        this.baseConnaissance = baseConnaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}
