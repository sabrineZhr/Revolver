 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveurdepb;

import Probleme.Probleme;
import basedeconnaissances.Item;
import basedeconnaissances.Predicat;
import basedeconnaissances.Regle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sabrine
 */
public class Algorithme {
    List<Noeud> noeudDevs ;
   public  String trace;

    public List<Noeud> getNoeudDevs() {
        return noeudDevs;
    }

    public void setNoeudDevs(List<Noeud> noeudDevs) {
        this.noeudDevs = noeudDevs;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
    
    public Algorithme() {
        noeudDevs=new ArrayList<Noeud>();
        trace="";
    }
    

    public ArrayList<String> genereOperateursApplicables(Probleme p, Predicat predicat) {
        ArrayList<String> reglesInstanciees = new ArrayList<String>();
        ArrayList<Regle> regles = p.getBaseConnaissance().chargementRegles();
        String res = "";
        String unificateur;
        for (Regle regle : regles) {
            List<String> exp2 = new ArrayList<>(predicat.getTableau());
            List<String> exp1 = new ArrayList<>(regle.getPredicats().get(0).getTableau());
            unificateur = unifier(exp1, exp2);
            //System.out.println("Regle:" + regle.getNumero() + " unificateur " + unificateur);
            if (!unificateur.equals("echec")) {
                int i = 0; boolean test = true;
                while (i < regle.getItems().size() && test) {
                    List<String> exp = new ArrayList<String>(Arrays.asList(regle.getItems().get(i).getArgument1() + 
                            regle.getItems().get(i).getOperateur() + regle.getItems().get(i).getArgument2()));
                    exp = changer(exp, unificateur);
                   // System.out.println("Regle:" + regle.getNumero() + " rsss " + exp);
                    if (regle.getItems().get(i).verifierResultat(exp.get(0))) {
                       // System.out.println("TRUE");
                    } else {
                       // System.out.println("FALSE");
                        test = false;}i++;}
                if (test) {
                    reglesInstanciees.add(regle.getNumero() + ",(" + unificateur + ")");
                }}}
        return reglesInstanciees;}
    
    public List<Predicat> rtournerPredicat(Probleme p, Predicat predicat){
        ArrayList<String> regleAppUnifs = genereOperateursApplicables(p, predicat );
        ArrayList<Regle> regles = p.getBaseConnaissance().chargementRegles();
        List<Predicat> liste = new ArrayList<>();
        for(String regleAppUnif :regleAppUnifs )
        {
        String[] l= regleAppUnif.split(",\\(");
        String numRegle = l[0];
        String unificateur=l[1].replace(")","");
            System.out.println("l1 " +unificateur );
        for(Regle regle : regles )
        {
            if (regle.getNumero().equals(numRegle))
            {Predicat pred = new Predicat();
            //System.out.println("Regle "+ numRegle + regle.getConclusion().getTableau() );
             //   System.out.println("unificateur " + unificateur );
             pred.setTableau(changer(regle.getConclusion().getTableau(), unificateur));
             pred.setNom(predicat.getNom());
                for (int i = 0; i < pred.getTableau().size(); i++) {
                    if (pred.getTableau().get(i).contains("+"))
                    {
                    String ss = pred.getTableau().get(i).replace(" ","");
                    String[] splitt = ss.split("\\+");
                    int val1 = Integer.parseInt(splitt[0]);
                    int val2 = Integer.parseInt(splitt[1]);
                    int som = val1+ val2;
                    pred.getTableau().set(i,Integer.toString(som));
                    }
                    else if(pred.getTableau().get(i).length()>4) 
                    {   String ss = pred.getTableau().get(i).replace(" ","");
                        String ss1 = ss.replace("(","");
                        String val1 =""+ ss1.charAt(0);
                        int valeu1 = Integer.parseInt(val1);
                        String val2 =""+ ss1.charAt(2);
                        int valeu2 = Integer.parseInt(val2);
                        String val3 =""+ ss1.charAt(4);
                        int valeu3 = Integer.parseInt(val3);
                        pred.getTableau().set(i,Integer.toString(valeu1-(valeu2-valeu3)));
                     }}//System.out.println(pred);
                      liste.add(pred);}}}
       // System.out.println("liste: " + liste);
        return liste;}
    
    public List<Noeud> retourNoeud(Noeud parent , Probleme p){
        
        ArrayList<String> regleAppUnifs = genereOperateursApplicables(p, parent.getEtat());
        ArrayList<Regle> regles = p.getBaseConnaissance().chargementRegles();
        List<Noeud> liste = new ArrayList<>();
        for(String regleAppUnif :regleAppUnifs )
        {
        String[] l= regleAppUnif.split(",\\(");
        String numRegle = l[0];
        String unificateur=l[1].replace(")","");
           // System.out.println("l1 " +unificateur );
        for(Regle regle : regles )
        {
            if (regle.getNumero().equals(numRegle))
            {Predicat pred = new Predicat();
            //System.out.println("Regle "+ numRegle + regle.getConclusion().getTableau() );
                //System.out.println("unificateur " + unificateur );
             pred.setTableau(changer(regle.getConclusion().getTableau(), unificateur));
             pred.setNom(parent.getEtat().getNom());
                for (int i = 0; i < pred.getTableau().size(); i++) {
                    if (pred.getTableau().get(i).contains("+"))
                    {
                    String ss = pred.getTableau().get(i).replace(" ","");
                    String[] splitt = ss.split("\\+");
                    int val1 = Integer.parseInt(splitt[0]);
                    int val2 = Integer.parseInt(splitt[1]);
                    int som = val1+ val2;
                    pred.getTableau().set(i,Integer.toString(som));
                    }
                    else if(pred.getTableau().get(i).length()>4) 
                    {   String ss = pred.getTableau().get(i).replace(" ","");
                        String ss1 = ss.replace("(","");
                        String val1 =""+ ss1.charAt(0);
                        int valeu1 = Integer.parseInt(val1);
                        String val2 =""+ ss1.charAt(2);
                        int valeu2 = Integer.parseInt(val2);
                        String val3 =""+ ss1.charAt(4);
                        int valeu3 = Integer.parseInt(val3);
                        pred.getTableau().set(i,Integer.toString(valeu1-(valeu2-valeu3)));
                     }}//System.out.println(pred);
                      Noeud noeud = new Noeud(pred,parent,regle.getNumero(),parent.getProfondeur()+1);
                      if (Integer.parseInt(pred.getTableau().get(0)) ==2) {
                noeud.setF(0+parent.getG());
            } else if (Integer.parseInt(pred.getTableau().get(0))+Integer.parseInt(pred.getTableau().get(1)) <2) {
                noeud.setF(7+parent.getG());
            } else if (Integer.parseInt(pred.getTableau().get(1))  >2) {
                noeud.setF(3+parent.getG());
            } 
            else {
                noeud.setF(1+parent.getG());
            }
                      noeud.setG(parent.getG()+1);
                      liste.add(noeud);}}}
       // System.out.println("liste: " + liste);
        return liste;
    
    }

  public Noeud A(Predicat etat_initial, Predicat etat_final,Probleme p) {
        Noeud result_node = null;
        Noeud initial = new Noeud(etat_initial, null, null, 0);
        initial.setF(0);
        initial.setG(0);
        List<Noeud> node_to_devolop = new ArrayList<Noeud>();
        node_to_devolop.add(initial);
        String nodetoremove;
        while (!node_to_devolop.isEmpty()) {
            nodetoremove = node_to_devolop.get(0).getEtat().toString();
            trace += "Develeoppement du noeud " + node_to_devolop.get(0).getEtat().toString() + "\n";
            System.out.println(node_to_devolop.get(0).getEtat());
            noeudDevs.add(node_to_devolop.get(0));
            if (!Unificateur(etat_final, node_to_devolop.get(0).getEtat()).equals("echec")) {
                trace += "Resultat trouvé \n";
                return node_to_devolop.get(0);} else {trace += "Recherche des fils \n";
                List<Noeud> node_to_add;
                node_to_add = retourNoeud(node_to_devolop.get(0) , p);
                node_to_devolop.remove(0);
                for (int i = node_to_add.size() - 1; i >= 0; i--) {
                    trace += node_to_add.get(i).getEtat().toString() + " trouvé en utilisant " + 
                            node_to_add.get(i).getNombreRegle().toString() + " Verifying if it is alrady developed\n";
                    if (!Exist_Noeud(node_to_add.get(i))) {
                        trace += "Noeud non developper \n";
                        int j = 0;
                        while ((j < node_to_devolop.size()) && (node_to_add.get(i).getF() > node_to_devolop.
                                get(j).getF())) {j++;}
                        node_to_devolop.add(j, node_to_add.get(i));} else {trace += "Ignorer\n";}}}
            trace += "ajouter " + nodetoremove + " dans la liste de noeud\n";}
        return result_node;}
  
  
    public String unifier(List<String> expr1, List<String> expr2) {
        //Tester†si†l'une†des†expressions†est†un†atome
        if (estAtome(expr1) || (estAtome(expr2))) {
            return unifierAtomes(expr1, expr2);
        }
        //rÈcupÈrer†le†premier†element†de†la†premiËre† expression†
        String f1 = expr1.get(0);
        //sauvegarder† les† termes† non† traitÈs† de† la† premiËre†expression†† 
        expr1.remove(0);
        List<String> t1 = expr1;
        //rÈcupÈrer†le†premier†element†de†la†deuxiËme† expression†
        String f2 = expr2.get(0);
        //sauvegarder† les† termes† non† traitÈs† de† la†deuxiËme†expression†† 
        expr2.remove(0);
        List<String> t2 = expr2;

        List<String> e1 = new ArrayList<String>();
        e1.add(f1);
        List<String> e2 = new ArrayList<String>();
        e2.add(f2);
        //unifier†les†tÍtes†de†deux†expressions†† 
        String z1 = unifier(e1, e2);
        //echec†d'unification
        if (z1.equalsIgnoreCase("echec")) {
            return "echec";
        }
        //Application† des† changements† sur† les† termes† non†traitÈs†des†expressions
        List<String> g1 = changer(t1, z1);
        List<String> g2 = changer(t2, z1);
        //unifier† les† termes† non† traitÈs† de† deux† expressions
        String z2 = unifier(g1, g2);
        if (z2.equalsIgnoreCase("echec")) {
            return "echec";
        }
        return z1 + " " + z2;
    }

    public boolean Exist_Noeud(Noeud node) {
        boolean test = false;
        int i = 0;
        while ((i < this.noeudDevs.size()) && (!test)) {
            test = ((node.getEtat()).toString().equals(noeudDevs.get(i).getEtat().toString()) && (noeudDevs.get(i).getProfondeur() <= node.getProfondeur()));
            i++;
        }
        return test;
    }
    
     public Noeud Depth_First_Limited(Predicat etat_initial, Predicat etat_final, int maxdepth, Probleme p) {
        Noeud result_node = null;
        Noeud initial = new Noeud(etat_initial, null, null, 0);
        List<Noeud> node_to_devolop = new ArrayList<Noeud>();
        node_to_devolop.add(initial);
        String nodetoremove;
        while (!node_to_devolop.isEmpty()) {
            nodetoremove = node_to_devolop.get(0).getEtat().toString();
            trace += "Developpement noeud" + node_to_devolop.get(0).getEtat().toString() + "\n";
            System.out.println(node_to_devolop.get(0).getEtat());
            noeudDevs.add(node_to_devolop.get(0));
            if (!Unificateur(etat_final, node_to_devolop.get(0).getEtat()).equals("echec")) {trace += "Trouvé \n";
                return node_to_devolop.get(0);} else if (node_to_devolop.get(0).profondeur< maxdepth) {
                trace += "Recherche d'un noeud fils\n";List<Noeud> node_to_add;
                node_to_add = retourNoeud(node_to_devolop.get(0) , p);node_to_devolop.remove(0);
                for (int i = node_to_add.size() - 1; i >= 0; i--) {
                    trace += node_to_add.get(i).getEtat().toString() + " trouvé " + node_to_add.get(i).getNombreRegle() + 
                            " verifier si déja développé\n";
                    if (!Exist_Noeud(node_to_add.get(i))) {
                        trace += "ajouter au top\n";
                        node_to_devolop.add(0, node_to_add.get(i)); } else {trace += "ignorer noeud\n";}}
            } else {trace += "Stop\n";node_to_devolop.remove(0);}
            trace += "ajout " + nodetoremove + " dans le noeud\n";
        }

        return result_node;}
     
     
     public String Unificateur(Predicat p1, Predicat p2) {
       
        List<String> expr1 = new ArrayList<String>(p1.getTableau());
        List<String> expr2 = new ArrayList<String>(p2.getTableau());
        String unficateur = unifier(expr1, expr2);
        return unficateur;
    }
     
     
    
    public List<String> changer(List<String> t1, String z1) {
        if (!z1.equals(" ")) {
        String[] chg = z1.trim().split("\\s+");
        List<String> b = new ArrayList<String>();
        for (int i = 0; i < chg.length; i++) {
            b.addAll(Arrays.asList(chg[i].split("/")));
        }
        if (!z1.equalsIgnoreCase("")) {
            for (int i = 0; i < t1.size(); i++) {
                for (int j = 0; j < b.size(); j += 2) {
                    t1.set(i, t1.get(i).replaceAll("\\" + b.get(j), b.get(j + 1)));

                }
            }
        }
        }
        return t1;
    }

    public String unifierAtomes(List<String> expr1, List<String> expr2) {
        String e1 = expr1.get(0);
        String e2 = expr2.get(0);
        // e1 et e2 sont identiques
        if (e1.equalsIgnoreCase(e2)) {
            return "";
        }
        //e1 variable
        if (e1.charAt(0) == '?') {
            if (e2.contains(e1)) {
                return "echec";
            } else {
                return e1 + "/" + e2;
            }
        }
        //e2 variable
        if (e2.charAt(0) == '?') {
            if (e1.contains(e2)) {
                return "echec";
            } else {
                return e2 + "/" + e1;
            }
        }
        return "echec";
    }

    public boolean estAtome(List<String> exp) {
        if (exp.size() == 1) {
            return true;
        } else {
            return false;
        }

    }

}
