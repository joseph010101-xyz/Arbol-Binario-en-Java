
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author flore
 */
public class Arbol {
    private Nodo raiz;
    
    public Arbol(){
        raiz=null;
    }
    
    private boolean esHoja(Nodo pr){
        return pr.getHI() == null && pr.getHD() == null;
        
    }
    
    public void insertar (int x){
        Nodo q=new Nodo(x);
        if(raiz==null){
         raiz=q;
         return;
        }
        Nodo p=raiz,ap=null;
        while(p!=null){
            ap=p;
            if (x<p.getElem()){
                p=p.getHI();
            }else{
                if(x>p.getElem()){
                    p=p.getHD();
                }else{
                    return;
                }
            }
            if(x<p.getElem()){
                ap.setHI(q);
            }else{
                ap.setHD(q);
            }    
        }
    }
    /////////////////
    private void preOrden(Nodo pr,JTextArea ta){
        if(pr!=null){
            ta.append(String.valueOf(pr.getElem())+"");
            preOrden(pr.getHI(),ta);
            preOrden(pr.getHD(),ta);
        }
    }
    public void preOrden(JTextArea ta){
        preOrden(raiz,ta);
    }
    /////////////////
    private void inOrden(Nodo pr,JTextArea ta){
        if(pr!=null){
            inOrden(pr.getHI(),ta);
            ta.append(String.valueOf(pr.getElem())+"");
            inOrden(pr.getHD(),ta);
        }
    }
    public void inOrden(JTextArea ta){
        inOrden(raiz,ta);
    }
    //////////////////
    private void postOrden(Nodo pr,JTextArea ta){
        if(pr!=null){
            postOrden(pr.getHI(),ta);
            postOrden(pr.getHD(),ta);
            ta.append(String.valueOf(pr.getElem())+"");
        }
    }
    public void postOrden(JTextArea ta){
        postOrden(raiz,ta);
    }
    ////////METODOS DE LA CLASE ARBOL////////
    private int cantidad(Nodo pr){
        if(pr==null){
            return 0;
        }else{
            if(esHoja(pr)){
                return 1;
            }else{
                int ai=cantidad(pr.getHI());
                int ad=cantidad(pr.getHD());
                return ai+ad+1;
            }
        }  
    }
    public int cantidad(){
        return cantidad(raiz);
    }
    private int sumar(Nodo pr){
        if(pr!=null){
            return 0;
        }else{
            if(esHoja(pr)){
                return pr.getElem();
            }else{
                int s1=sumar(pr.getHI());
                int s2=sumar(pr.getHD());
                return s1+s2+pr.getElem();
            }
        } 
    }
    public int sumar(){
        return sumar(raiz);
    }    
}
