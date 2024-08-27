package Entidades;

public class MainTest {
    public static void main(String[] args) {
        int[] array = {1,2,2,4,55,1,1213,12,52,132};
        for(int n: array){
            System.out.print(n+"-");
        }
        System.out.println("");
        Ordenação.insectionSort(array);
        for(int n: array){
            System.out.print(n+"-");
        }
    }
}
