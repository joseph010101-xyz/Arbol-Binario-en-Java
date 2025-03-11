import javax.swing.JTextArea;

public class ArbolM {
    private Nodo raiz;
    
    public ArbolM(){
        this.raiz=null;
    }
    
    public boolean EsHoja(Nodo P){
        if (P == null) return true;
        
        for (int i=1; i<=P.M; i++){
            if (P.getHijo(i) != null){
                return false;
            }
        }
        return true;
    }
    
    private int getHijoDesc(Nodo P, int x){
        int i=1;
        while (i <= P.M-1){
            if (P.Ocupado(i)) {
                if (x < P.getElemento(i)){
                    return i;
                }
                if (x == P.getElemento(i)){
                    return -1; // Elemento ya existe
                }
            } else {
                // Si encontramos una posición vacía, el elemento va aquí o a la derecha
                return i;
            }
            i++;
        }
        return P.M; // Si llegamos aquí, es mayor que todos los elementos
    }
    
    private void insertarOrd(Nodo P, int x){
        // Caso especial: nodo vacío
        if (P.CantOcupados() == 0) {
            P.setElem(x, 1);
            return;
        }
        
        // Buscar dónde insertar
        int pos = 1;
        while (pos <= P.M-1 && P.Ocupado(pos) && x > P.getElemento(pos)) {
            pos++;
        }
        
        // Verificar si ya existe
        if (pos <= P.M-1 && P.Ocupado(pos) && x == P.getElemento(pos)) {
            return; // Elemento ya existe
        }
        
        // Si hay espacio, desplazamos y insertamos
        if (P.CantOcupados() < P.M-1) {
            // Desplazar elementos a la derecha
            for (int i = P.M-1; i > pos; i--) {
                if (P.Ocupado(i-1)) {
                    P.setElem(P.getElemento(i-1), i);
                }
            }
            
            // Insertar el nuevo elemento
            P.setElem(x, pos);
        }
    }
    
    public void Insertar(int x){
        // Si el árbol está vacío, crear la raíz
        if (raiz == null){
            raiz = new Nodo();
            raiz.setElem(x, 1);
            return;
        }
        
        // Buscar dónde insertar
        Nodo P = raiz;
        Nodo AP = null;
        int i = 0;
        
        while (P != null){
            // Si hay espacio en el nodo actual
            if (!P.Lleno()){
                insertarOrd(P, x);
                return;
            }
            
            // Determinar por qué hijo continuar
            AP = P;
            i = getHijoDesc(P, x);
            
            // Si ya existe, salimos
            if (i == -1){
                return;
            }
            
            // Pasar al siguiente hijo
            P = P.getHijo(i);
        }
        
        // Si llegamos aquí, debemos crear un nuevo nodo
        Nodo Q = new Nodo();
        Q.setElem(x, 1);
        AP.setHijo(Q, i);
    }
    
    private void InOrden(Nodo P, JTextArea jta){
        if (P == null) return;
        
        // Para cada elemento del nodo
        for (int i = 1; i <= P.M-1; i++) {
            // Visitar hijo izquierdo
            InOrden(P.getHijo(i), jta);
            
            // Mostrar elemento si existe
            if (P.Ocupado(i)) {
                jta.append(P.getElemento(i) + " ");
            }
        }
        // Visitar último hijo (derecho)
        InOrden(P.getHijo(P.M), jta);
    }
    
    public void InOrden(JTextArea jta){
        jta.setText(""); // Limpiar el área de texto
        InOrden(raiz, jta);
    }
    
 // Método recursivo preOrden corregido
private void preOrden(Nodo P, JTextArea jta) {
    if (P == null) return;
    
    // 1. Primero mostramos todos los elementos del nodo actual
    for (int i = 1; i <= P.M-1; i++) {
        if (P.Ocupado(i)) {
            jta.append(P.getElemento(i) + " ");
        }
    }
    
    // 2. Luego visitamos cada hijo en orden
    for (int i = 1; i <= P.M; i++) {
        preOrden(P.getHijo(i), jta);
    }
}

// Método público para iniciar el recorrido
    public void preOrden(JTextArea jta) {
        jta.setText(""); // Limpiamos el área de texto antes de comenzar
        preOrden(raiz, jta);
    }
}