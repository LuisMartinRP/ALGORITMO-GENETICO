/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 *
 * @author Luis Martin R.P
 */
public class Seleccion {
    FuncionAp ap;
    Poblacion p;
    ArrayList<Individuo> ip = new ArrayList<Individuo>();
    ArrayList<Individuo> im = new ArrayList<Individuo>();
    ArrayList<Individuo> hijos = new ArrayList<Individuo>();
    int total=0,grados,aux;
    Seleccion(FuncionAp ap,Poblacion p){
        this.ap=ap;
        this.p=p;
    }
    public void selinds(){
        int parejas;
        float mayor;
        //float[] proba=new float[this.ap.aptitudes.size()];
        mayor=Collections.max(this.ap.aptitudes);
        //System.out.println(mayor);
        if(mayor==0){
            if(this.ap.aptitudes.size()%2!=0){
                parejas=(this.ap.aptitudes.size()-1)/2;
                for(int i=0;i<this.ap.aptitudes.size();i++){
                    if(this.ap.aptitudes.get(i)==mayor){
                        hijos.add(this.p.pob.get(i));
                        break;
                    }
                }
                //Individuo e=new Individuo(this.p.pob.get(0).ind.length());
                //e.initi();
                //hijos.add(e);
            }else{
                parejas=this.ap.aptitudes.size()/2;
            }
            for(int i=0;i<parejas;i++){
                ip.add(p.pob.get(i));
                im.add(p.pob.get(i+parejas));
            }
        }else{
            for(int i=0;i<this.ap.aptitudes.size();i++){
                total+=ap.aptitudes.get(i);
            }

            if(this.ap.aptitudes.size()%2!=0){
                parejas=(this.ap.aptitudes.size()-1)/2;
                for(int i=0;i<this.ap.aptitudes.size();i++){
                    if(this.ap.aptitudes.get(i)==mayor){
                        hijos.add(this.p.pob.get(i));
                        break;
                    }
                }
                //Individuo e=new Individuo(this.p.pob.get(0).ind.length());
                //e.initi();
                //hijos.add(e);
            }else{
                parejas=this.ap.aptitudes.size()/2;
            }
            for(int i=0;i<parejas;i++){
                for(int j=0;j<2;j++){
                    Random randomp = new Random();
                    int ranp = randomp.nextInt(parejas+1);

                    Random randomm = new Random();
                    int ranm = randomm.nextInt(parejas+1);
                    
                    int ap1=ap.aptitudes.get(ranp);
                    int ap2=ap.aptitudes.get(ranm);
                    
                    if(j==0){                        
                        if(ap1>ap2){
                            ip.add(p.pob.get(ranp));
                        }if(ap2>ap1){
                            ip.add(p.pob.get(ranm));
                        }if(ap1==ap2){
                            ip.add(p.pob.get(ranp));
                        }
                    }else{
                        if(ap1>ap2){
                            im.add(p.pob.get(ranp));
                        }if(ap2>ap1){
                            im.add(p.pob.get(ranm));
                        }if(ap1==ap2){
                            im.add(p.pob.get(ranp));
                        }
                    }
                }
            }
        }
        
        Individuo[] hij=new Individuo[2];
        for(int i=0;i<ip.size();i++){
            
            String cp=ip.get(i).ind;
            String cm=im.get(i).ind;
            
            Individuo in=new Individuo(cp.length());
            hij=in.cruza(cp, cm);
            hijos.add(hij[0]);
            hijos.add(hij[1]);
        }
        int porc=(int) (hijos.size()*.05);
        if (porc==0)
            porc=1;
        for(int i=0;i<porc;i++){
            Random random = new Random();
            float randomInt = random.nextInt()*hijos.size();
            hijos.get(i).ind=hijos.get(i).muta(hijos.get(i).ind);
        }  
    }
}