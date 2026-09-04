package aula03;

public class CacheInteger {
    public static void main(String [] args) {

        Integer x1 = 128;
        Integer x2 = 128;

        System.out.println("Par dentro da faixa(== ): " + (x1 == x2) );
        System.out.println("Par dentro da faixa (.equal()): " + x1.equals(x2));

        Integer y1 = 200;
        Integer y2 = 200;

        System.out.println("Par dentro da faixa(== ): " + (y1 == y2) );
        System.out.println("Par dentro da faixa (.equal()): " + y1.equals(y2));
    }

}
