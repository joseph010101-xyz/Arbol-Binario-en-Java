package ARBOL_BINARIO;

public class NodoArbol {
    private int valor;
    private NodoArbol Izq;
    private NodoArbol Der;

    NodoArbol(int valor){
        this.valor=valor;
        this.Izq=null;
        this.Der=null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoArbol getIzq() {
        return Izq;
    }

    public NodoArbol getDer() {
        return Der;
    }

    public void Insertar(int _valor){
        if (_valor<this.valor) {
            //Insertar a la izquierda
            if (this.Izq==null){
                this.Izq=new NodoArbol(_valor);
            }else{
                this.Izq.Insertar(_valor);
            }
        }else{
            //Insertar a la derecha
            if (this.Der==null){
                this.Der=new NodoArbol(_valor);
            }else{
                this.Der.Insertar(_valor);
            }
        }
    }
}
