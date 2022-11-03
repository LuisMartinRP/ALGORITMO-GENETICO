/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmog;

import java.util.Random;

/**
 *
 * @author Luis Martin R.P
 */
public class Individuo {
    int longitud;
    String ind;
    String alfabeto="abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ ¬!|°#$%&/()=?'¿¡+*~<>,;.:-_\"\\{}[]`^¨";
    Individuo(int longitud){
        this.longitud=longitud;
        this.ind="";
    }
    public void initi(){
        for(int i=0;i<this.longitud;i++){
            Random random = new Random();
            int randomInt = random.nextInt(alfabeto.length());
            ind+=alfabeto.charAt(randomInt);
        }
    }
    public Individuo[] cruza(String padre,String madre){
        String p1="",p2="",m1="",m2="";            
            
        p1+=padre.substring(0, padre.length()/2);
        m1+=madre.substring(0, madre.length()/2);
        p2+=padre.substring(padre.length()/2, padre.length());
        m2+=madre.substring(padre.length()/2, madre.length());
        
        String hijo1="",hijo2="";
        
        hijo1+=p1;
        hijo1+=m2;
        hijo2+=m1;
        hijo2+=p2;
        
        Individuo[] hijos=new Individuo[2];
        
        Individuo h=new Individuo(padre.length());
        h.ind=hijo1;
        hijos[0]=h;
        Individuo h2=new Individuo(padre.length());
        h2.ind=hijo2;
        hijos[1]=h2;
        /*System.out.println(padre);
        System.out.println(madre);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(hijo1);
        System.out.println(hijo2);
        System.out.println();*/
        return hijos;
    }
    
    public String muta(String cromosoma){
        //int tam=cromosoma.length();
        char[] cad;
        cad=cromosoma.toCharArray();
        Random random = new Random();
        String newcromo="";
        int pos= random.nextInt(longitud);
        int genin = random.nextInt(alfabeto.length());
        //System.out.println(pos+" "+genin);
        for(int i=0;i<longitud;i++){
            if(i==pos){
                newcromo+=alfabeto.charAt(genin);
                //System.out.println("ya: "+newcromo);
            }else{
                newcromo+=cad[i];
            }
        }
        return newcromo;
    }
}
