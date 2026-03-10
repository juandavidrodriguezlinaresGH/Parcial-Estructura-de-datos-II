public class Recursividad {
    
      public static String invertirCadena(String texto) {
       //Recorre la palabra desde su primer indice y va decrementando 
       //almacenando cada caracter en la variable invertida
        String invertida="";
        for(int i =texto.length() -1 ; i>=0 ;i--   ){
            invertida+=texto.charAt(i);
          
        
    }    
      return invertida;
      }
     
    public static void main(String[] args) {
        
 
        String original = "Recursividad";
        String invertida = invertirCadena(original);
        System.out.println("Original: " + original);
        System.out.println("Invertida: " + invertida); 
    }
}