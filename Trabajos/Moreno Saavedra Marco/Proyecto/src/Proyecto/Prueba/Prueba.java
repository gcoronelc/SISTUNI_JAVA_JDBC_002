package Proyecto.Prueba;

/**
 *
 * @author Josué Moreno
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "Moreno Saavedra Marco";
        System.out.println(s);
        int index = s.indexOf(" ");
        String a = s.substring(0, index+1);
        System.out.println(a);
        index = s.lastIndexOf(" ");
        String X = s.substring(a.length(),index+1);
        System.out.println(X);
       String z  = s.substring(index+1, s.length());
        System.out.println(z);
    }

}
