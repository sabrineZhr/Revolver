/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveurdepb;

import Probleme.Probleme;
import basedeconnaissances.BaseDeConnaissance;
import basedeconnaissances.Predicat;
import basedeconnaissances.Regle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sabrine
 */
public class ResolveurDePb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       BaseDeConnaissance bc = new BaseDeConnaissance();
       System.out.println("Base des faits");
       bc.setFichierFait("/Users/sabrine/Desktop/Fait.txt");
       bc.chargementFaits();
       System.out.println("Base des regles");
       bc.setFichierRegle("/Users/sabrine/Desktop/Regle.txt");
       
       Probleme p = new Probleme(bc,"pbCruches");
       Algorithme  algorithme = new Algorithme();
       ArrayList<String> tab =(ArrayList<String>) new ArrayList<>(Arrays.asList("0", "0"));
       Predicat pred = new Predicat();
       pred.setNom("cruchesAetB");
       pred.setTableau(tab);
       ArrayList<String> tab1 =(ArrayList<String>) new ArrayList<>(Arrays.asList("2", "0"));
       Predicat pred1 = new Predicat();
       pred1.setNom("cruchesAetB");
       pred1.setTableau(tab1);
       ArrayList<String> regleUtilisees = algorithme.genereOperateursApplicables(p,pred);
       System.out.println("regleUtilisees :" + regleUtilisees);
       //List<Predicat> preds =  algorithme.rtournerPredicat(p,pred);
      Noeud parent = new Noeud(pred,null,null,0);
     //Noeud node= algorithme.Depth_First_Limited(pred, pred1, 6, p);
     Noeud node= algorithme.A(pred, pred1, p);
      //  Noeud node= algorithme.A(pred, pred1, p);
      String result="";
             while (node.getParent()!=null) {
                 result="---"+node.getNombreRegle()/*+" cout: "+node.getH()*/+"--->"+node.getEtat()+result;
                 node=node.getParent();
             }
             result=node.getEtat()+result;
             System.out.println(algorithme.trace);
             System.out.println(result);
             
       /*ArrayList<Regle> regleUtilisees = new ArrayList<>();
       ArrayList<String> tab =(ArrayList<String>) new ArrayList<>(Arrays.asList("4", "0"));
       Predicat pred = new Predicat();
       pred.setNom("cruchesAetB");
       pred.setTableau(tab);
       System.out.println("$$$$$$$$$");
       System.out.println("pred  "+pred);
       Algorithme  algorithme = new Algorithme();
       algorithme.genereOperateursApplicables(p,pred);
        
        System.out.println("Hayaaa ");
       List<String> exp1 = new ArrayList<>();
       exp1.add("4+4");
       exp1.add("4-(4-4");
      
        int valeur = 0;
        for (int i = 0; i < exp1.size(); i++) {
          if (exp1.get(i).contains("(")) {
                String tabb = exp1.get(i).replace("(", "");
                System.out.println("ggg "+ tabb);
                String[] parts =tabb.split("-",2);
                int val1 = Integer.parseInt(parts[0]);
                System.out.println("val1 " + val1);
                String[] tab1 = parts[1].split("-");
                int val2 = Integer.parseInt(tab1[0]);
                int val3 = Integer.parseInt(tab1[1]);
                valeur = val1 - (val2 - val3);
                System.out.println("valll " + valeur);
                exp1.set(i, Integer.toString(valeur));

            }
            if (exp1.get(i).contains("+")) {
                System.out.println("dd " +exp1.get(i).contains("+"));
                String[] tabbb = exp1.get(i).split("\\+");
                int val1 = Integer.parseInt(tabbb[0]);
                int val2 = Integer.parseInt(tabbb[1]);
                valeur = val1 + val2;
                exp1.set(i, Integer.toString(valeur));

            }
      
            System.out.println(exp1);}*/
     
}}