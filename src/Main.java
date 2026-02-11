import java.util.ArrayList;
import java.util.Scanner;

    public class Main {

        static ArrayList<Juego> juegos = new ArrayList<>();
        static ArrayList<Cliente> clientes = new ArrayList<>();
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {

            int opcion;

            do {
                mostrarMenu();
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        altaJuego();
                        break;
                    case 2:
                        listarJuegos();
                        break;
                    case 3:
                        altaCliente();
                        break;
                    case 4:
                        listarClientes();
                        break;
                    case 5:
                        alquilarJuego();
                        break;
                }

            } while (opcion != 6);

            System.out.println("Programa finalizado.");
        }

        static void mostrarMenu() {
            System.out.println("\n===== TIENDA VIDEOJUEGOS =====");
            System.out.println("1. Alta juego");
            System.out.println("2. Listar juegos");
            System.out.println("3. Alta cliente");
            System.out.println("4. Listar clientes");
            System.out.println("5. Alquilar juego");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
        }

        static void altaJuego() {
            System.out.print("Título: ");
            String titulo = sc.nextLine();

            System.out.print("Precio alquiler: ");
            double precio = sc.nextDouble();
            sc.nextLine();

            System.out.print("Género: ");
            String genero = sc.nextLine();

            juegos.add(new Juego(titulo, precio, genero));
            System.out.println("Juego añadido correctamente.");
        }

        static void listarJuegos() {
            for (int i = 0; i < juegos.size(); i++) {
                System.out.print(i + " - ");
                juegos.get(i).mostrarInfo();
            }
        }

        static void altaCliente() {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();
            sc.nextLine();

            clientes.add(new Cliente(nombre, id, saldo));
            System.out.println("Cliente añadido.");
        }

        static void listarClientes() {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.print(i + " - ");
                clientes.get(i).mostrarInfo();
            }
        }

        static void alquilarJuego() {

            listarClientes();
            System.out.print("Seleccione cliente: ");
            int c = sc.nextInt();

            listarJuegos();
            System.out.print("Seleccione juego: ");
            int j = sc.nextInt();

            Cliente cliente = clientes.get(c);
            Juego juego = juegos.get(j);

            if (juego.isAlquilado()) {
                System.out.println("El juego ya está alquilado.");
                return;
            }

            if (cliente.pagar(juego.getPrecio())) {
                juego.alquilar();
                System.out.println("Alquiler realizado con éxito.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
    }