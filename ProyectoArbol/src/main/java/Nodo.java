/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author flore
 */
public class Nodo {
    
    private Nodo hijoIzq;
    private int elem;
    private Nodo  hijoDer;
    
    public Nodo(int ele){
        hijoIzq=null;
        elem=ele;
        hijoDer=null; 
    }

    public Nodo getHI() {
        return hijoIzq;
    }

    public void setHI(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public Nodo getHD() {
        return hijoDer;
    }

    public void setHD(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
     
}
