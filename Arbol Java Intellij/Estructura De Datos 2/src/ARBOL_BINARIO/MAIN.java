package ARBOL_BINARIO;

public class MAIN {
        public static void main(String[] args) {
            Arbol arbol=new Arbol();
            arbol.insertar(43);
            arbol.insertar(10);
            arbol.insertar(8);
            arbol.insertar(54);
            arbol.insertar(15);
            arbol.insertar(50);
            arbol.insertar(53);
            System.out.println("PRE ORDEN :");
            arbol.DispararPreOrden();
            System.out.println("IN ORDEN :");
            arbol.DispararInOrden();
            System.out.println("POST ORDEN :");
            arbol.DispararPostOrden();
        }
}


