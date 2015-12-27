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
public class Fait {

    private Predicat predicat;

    public Fait() {
    }

    
    
    
    public Fait(Predicat predicat) {
        this.predicat = predicat;
    }
   
    
    public Predicat getPredicat() {
        return predicat;
    }

    public void setPredicat(Predicat predicat) {
        this.predicat = predicat;
    }

    @Override
    public String toString() {
        return "Fait{" + "predicat=" + predicat + '}';
    }

   
}
