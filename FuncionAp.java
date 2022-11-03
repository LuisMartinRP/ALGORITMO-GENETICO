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
public class FuncionAp {
    Poblacion p;
    String target;
    int tam;
    String indi;
    int apt=0;
    ArrayList<Integer> aptitudes = new ArrayList<Integer>();
    char[] cart,cari;
    FuncionAp(Poblacion p,String target, int tam){
        this.p=p;
        this.target=target;
        this.tam=tam;
    }
    
    public void calculaptitud(){
        cart=this.target.toCharArray();
        //System.out.println(tam);
        for(int i=0;i<tam;i++){
            indi=p.pob.get(i).ind;
            for(int j=0;j<indi.length();j++){
                cari=indi.toCharArray();
                if(cart[j]==cari[j]){
                    apt++;
                }               
                if(this.target.contains(String.valueOf(cari[j]))){
                    apt++;
                }
            }
            /*if(apt==0){
                apt=(float) (apt+.0001);
                aptitudes.add(apt);           
            }else*/
                aptitudes.add(apt);  
            //System.out.println(apt);
            apt=0;
        }
    }
}
