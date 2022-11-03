/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmog;

import java.util.ArrayList;

/**
 *
 * @author Luis Martin R.P
 */
public class Poblacion {
    int tam;
    int longi;
    ArrayList<Individuo> pob = new ArrayList<Individuo>();
    Poblacion(int tam,int longi){
        this.tam=tam;
        this.longi=longi;
    }
    public void initp(){
        for(int i=0;i<tam;i++){
            Individuo in=new Individuo(longi);
            in.initi();
            pob.add(in);
        }
    }
}
