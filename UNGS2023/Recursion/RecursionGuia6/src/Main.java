import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ejercicio1 ej = new Ejercicio1();
        int[] arreglo = {1, 2, 3};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        ej.recorrerArr(arr,0);
    }
}
