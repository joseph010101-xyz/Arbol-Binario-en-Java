package ARBOL_BINARIO;

public class Arbol {
    private NodoArbol inicial;
    public Arbol(){
        this.inicial=null;
    }

    public void insertar(int valor){
        if (inicial==null){
            this.inicial=new NodoArbol(valor);
        }else{
            this.inicial.Insertar(valor);
        }
    }

    public void DispararPreOrden(){
        this.PreOrden(this.inicial);
    }

    public void PreOrden(NodoArbol nodo){
        if (nodo==null) {
            return;
        }else{
            System.out.print(nodo.getValor() + " ");
            PreOrden(nodo.getIzq());
            PreOrden(nodo.getDer());
        }
    }

    public void DispararInOrden(){
        this.InOrden(this.inicial);
    }

    public void InOrden(NodoArbol nodo){
        if (nodo==null) {
            return;
        }else{
            InOrden(nodo.getIzq());
            System.out.print(nodo.getValor() + " ");
            InOrden(nodo.getDer());
        }
    }

    public void DispararPostOrden(){
        this.PostOrden(this.inicial);
    }

    public void PostOrden(NodoArbol nodo){
        if (nodo==null) {
            return;
        }else{
            PostOrden(nodo.getIzq());
            PostOrden(nodo.getDer());
            System.out.print(nodo.getValor() + " ");
        }
    }
}
