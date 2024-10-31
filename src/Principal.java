import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("*****************************");
            System.out.println("Bienvenid@ al conversor de Moneda!");
            System.out.println("By: Diego Rodriguez");
            System.out.println("\n");
            System.out.println("1.) COP -----> USD ");
            System.out.println("2.) USD -----> COP ");
            System.out.println("3.) COP -----> EUR ");
            System.out.println("4.) COP -----> MXN ");
            System.out.println("5.) COP -----> ARS ");
            System.out.println("6.) COP -----> GBP ");
            System.out.println("7. Salir");
            System.out.println("Elija una opción válida");
            System.out.println("*****************************");

            int opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    Conversor.convertirCOPaUSD();
                    break;
                case 2:
                    Conversor.convertirUSDaCOP();
                    break;
                case 3:
                    Conversor.convertirCOPaEUR();
                    break;
                case 4:
                    Conversor.convertirCOPaMXN();
                    break;
                case 5:
                    Conversor.convertirCOPaARS();
                    break;
                case 6:
                    Conversor.convertirCOPaGBP();
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        lectura.close();
    }
}
