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
public class Item {
    public String argument1;
    public String argument2;
    public String operateur;

    public String getArgument1() {
        return argument1;
    }

    public void setArgument1(String argument1) {
        this.argument1 = argument1;
    }

    public String getArgument2() {
        return argument2;
    }

    public void setArgument2(String argument2) {
        this.argument2 = argument2;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }
    
    public Item extraireItem(String text)
    {
     Item item = new Item();
     String[] split = text.split(" ");
     item.argument1= split[0];
     item.argument2= split[2];
     item.operateur=split[1];
     return item;
    }     

    @Override
    public String toString() {
        return "Item{" + "argument1=" + argument1 + ", argument2=" + argument2 + ", operateur=" + operateur + '}';
    }
    
    
    public boolean verifierResultat(String exp){
       // System.out.println("exxxx" + exp);
        boolean test = false ;
        if(exp.length()==3){
                    
                    String delims = "[><≤≥ ]+"; // so the delimiters are:  + - * / ^ space
                    String[] tokens = exp.split(delims);
                    int val_arg1 = Integer.parseInt(tokens[0]);
                    int val_arg2 = Integer.parseInt(tokens[1]);
                   
                    if(operateur.equals("<"))
                        test = val_arg1 < val_arg2;
                    if(operateur.equals(">"))
                        test = val_arg1 > val_arg2;
                    if(operateur.equals("≤"))
                        test = val_arg1 <= val_arg2;
                    if(operateur.equals("≥"))
                        test = val_arg1 >= val_arg2;
                   }
                   if(exp.length()>3){
                      // System.out.println("hhh " + exp.length());
                    String delims = "[><≤≥ ]+"; // so the delimiters are:  + - * / ^ space
                    String[] tokens = exp.split(delims);
                    String somme = tokens[0];
                    String[] tokens1 = somme.split("\\+");
                    int val_arg0 = Integer.parseInt(tokens1[0]);
                      // System.out.println("val0 " +val_arg0 );
                    int val_arg1 = Integer.parseInt(tokens1[1]);
                    int som = val_arg0 + val_arg1;
                    int val_arg2 = Integer.parseInt(tokens[1]);
                   
                    if(operateur.equals("<"))
                        test = som < val_arg2;
                    if(operateur.equals(">"))
                        test = som > val_arg2;
                    if(operateur.equals("≤"))
                        test = som <= val_arg2;
                    if(operateur.equals("≥"))
                        test = som >= val_arg2;
                   
                   }  
        return test;
        
        
        
    }
    
    public int operation(String txt )
    {   String[] splitt = txt.split("\\+");
                    int val1 = Integer.parseInt(splitt[0]);
                    int val2 = Integer.parseInt(splitt[1]);
                    int som = val1+ val2;
        return som;
    
    }      
    
     
}
   