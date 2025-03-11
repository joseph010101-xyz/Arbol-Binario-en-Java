public class Nodo {
    public static int M=3;//Vias
    private int Elemento[];
    private Nodo Hijo[];
    private boolean Estado[];
    
    public Nodo(){
        this.Elemento= new int[M-1];
        this.Estado= new boolean[M-1];
        this.Hijo= new Nodo[M];
            for(int i=0; i< M-1 ;i++){
                this.Estado[i]=false;
                this.Hijo[i]=null;
            }
            this.Hijo[M-1]=null;
    }
    public int getElemento(int i) {
        return Elemento[i-1];
    }
    public Nodo getHijo(int i) {
        return Hijo[i-1];
    }
    
    public boolean Ocupado(int i){
        return Estado[i-1];
    }
    
    // Corregimos este método para que realmente verifique si está vacío
    public boolean Vacio(int i){
        return !Estado[i-1];
    }
    
    public void setElem(int x,int i){
        this.Elemento[i-1]=x;
        this.Estado[i-1]=true;
    }
    
    public void setHijo(Nodo P,int i){
        this.Hijo[i-1]=P;
    }
    
    public void setVacio(int i){
        this.Estado[i-1]=false;
    }
    
    public int CantVacias(){
        int C=0;
        for(int i=0;i< Estado.length; i++ ){
            if (Estado[i] == false){
                C++;
            }
        }
        return C;
    }
    
    public int CantOcupados(){
        return ((M-1)-CantVacias());
    }
    
    public boolean Lleno(){
        return (CantVacias()==0);
    }
}