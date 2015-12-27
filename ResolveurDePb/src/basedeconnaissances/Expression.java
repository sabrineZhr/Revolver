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
public class Expression {
    public List<String> operateurs;
    public List<Integer> valeurs;

    public Expression() {
    }

    public Expression(List<String> operateurs, List<Integer> valeurs) {
        this.operateurs = operateurs;
        this.valeurs = valeurs;
    }

    public List<String> getOperateurs() {
        return operateurs;
    }

    public void setOperateurs(List<String> operateurs) {
        this.operateurs = operateurs;
    }

    public List<Integer> getValeurs() {
        return valeurs;
    }

    public void setValeurs(List<Integer> valeurs) {
        this.valeurs = valeurs;
    }

    int CacluerValeur(String expression)
    {   if(expression.contains("("))
        expression = expression.replace("(", "");
        List<Integer> vals = new ArrayList<Integer>();
        String delims = "[+\\-*/\\^ ]+"; // so the delimiters are:  + - * / ^ space
        String[] tokens = expression.split(delims); 
        for (int i = 0; i < tokens.length; i++) {
            
            vals.add(Integer.parseInt(tokens[i]));
            
        }
        return 0;
        
    }
        
    
    
    
}
