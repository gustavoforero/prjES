/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgLogica;

/**
 *
 * @author kiritoxcii
 */
public class clsArbol {
    class Nodo
      {
        boolean estadoSintoma;
        Nodo izq, der;
      }
      Nodo raiz;

      public clsArbol() {
          raiz=null;
      }
      
      public void insertar (boolean estadoSintoma)
      {
          Nodo nuevo;
          nuevo = new Nodo ();
          nuevo.estadoSintoma = estadoSintoma;
          nuevo.izq = null;
          nuevo.der = null;
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null, reco;
              reco = raiz;
              while (reco != null)
              {
                  anterior = reco;
                  if (estadoSintoma == reco.estadoSintoma)
                      reco = reco.izq;
                  else
                      reco = reco.der;
              }
              if (estadoSintoma == anterior.estadoSintoma)
                  anterior.izq = nuevo;
              else
                  anterior.der = nuevo;
          }
      }


      private void imprimirPre (Nodo reco)
      {
          if (reco != null)
          {
              System.out.print(reco.estadoSintoma + " ");
              imprimirPre (reco.izq);
              imprimirPre (reco.der);
          }
      }

      public void imprimirPre ()
      {
          imprimirPre (raiz);
          System.out.println();
      }

      private void imprimirEntre (Nodo reco)
      {
          if (reco != null)
          {    
              imprimirEntre (reco.izq);
              System.out.print(reco.estadoSintoma + " ");
              imprimirEntre (reco.der);
          }
      }

      public void imprimirEntre ()
      {
          imprimirEntre (raiz);
          System.out.println();
      }


      private void imprimirPost (Nodo reco)
      {
          if (reco != null)
          {
              imprimirPost (reco.izq);
              imprimirPost (reco.der);
              System.out.print(reco.estadoSintoma + " ");
          }
      }


      public void imprimirPost ()
      {
          imprimirPost (raiz);
          System.out.println();
      }

      public static void main (String [] ar)
      {
          clsArbol abo = new clsArbol();
          abo.insertar (true);
          abo.insertar (true);
          abo.insertar (true);
          abo.insertar (false);
          abo.insertar (false);
          System.out.println ("Impresion preorden: ");
          abo.imprimirPre ();
          System.out.println ("Impresion entreorden: ");
          abo.imprimirEntre ();
          System.out.println ("Impresion postorden: ");
          abo.imprimirPost ();        
      }      
}

