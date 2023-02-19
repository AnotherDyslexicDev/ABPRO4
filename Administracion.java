import java.util.Scanner;

public class Administracion {
	final static int MAX_ROWS = 100;
	final static int MAX_COLS = 10;

	static String[][] matrizUsuarios = new String[MAX_ROWS][MAX_COLS];

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);

			int opcion;

			do {
				System.out.println("Seleccione una opción:");
				System.out.println("1. Ingresar datos de un cliente.");
				System.out.println("2. Ingresar datos de un profesional.");
				System.out.println("3. Ingresar datos de un administrativo.");
				System.out.println("4. Salir.");
				System.out.println("5. Mostrar Usuarios.");
				opcion = scanner.nextInt();
				scanner.nextLine(); // Limpiar el buffer

				switch (opcion) {
				case 1:
					ingresarDatosCliente(matrizUsuarios, scanner);
					break;
				case 2:
					ingresarDatosProfesional(matrizUsuarios, scanner);
					break;
				case 3:
					ingresarDatosAdministrativo(matrizUsuarios, scanner);
					break;
				case 4:
					System.out.println("Saliendo del programa...");
					break;
				case 5:
					System.out.println("Mostrando usuarios...");
					mostrarUsuarios();
					break;
				default:
					System.out.println("Opción inválida. Inténtelo de nuevo.");
					break;
				}

			} while (opcion != 4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public static void ingresarDatosCliente(String[][] matrizUsuarios, Scanner scanner) {
		try {
			for (int i = 0; i < MAX_ROWS; i++) {
				if (matrizUsuarios[i][0] == null) {
					System.out.println("Ingresando datos para un cliente.");
					System.out.println("Ingrese el nombre:");
					matrizUsuarios[i][0] = scanner.nextLine();
					System.out.println("Ingrese la fecha de nacimiento:");
					matrizUsuarios[i][1] = scanner.nextLine();
					System.out.println("Ingrese el RUN:");
					matrizUsuarios[i][2] = scanner.nextLine();
					System.out.println("Ingrese la dirección:");
					matrizUsuarios[i][3] = scanner.nextLine();
					System.out.println("Ingrese el teléfono:");
					matrizUsuarios[i][4] = scanner.nextLine();
					System.out.println("Ingrese la cantidad de empleados:");
					matrizUsuarios[i][5] = scanner.nextLine();
					break;
				}
				if (i == MAX_ROWS - 1) {
					System.out.println("Se ha alcanzado el límite de registros.");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public static void ingresarDatosProfesional(String[][] matrizUsuarios, Scanner scanner) {
		try {
			for (int i = 0; i < MAX_ROWS; i++) {
				if (matrizUsuarios[i][0] == null) {
					System.out.println("Ingresando datos para un profesional.");
					System.out.println("Ingrese el nombre:");
					matrizUsuarios[i][0] = scanner.nextLine();
					System.out.println("Ingrese la fecha de nacimiento:");
					matrizUsuarios[i][1] = scanner.nextLine();
					System.out.println("Ingrese el RUN:");
					matrizUsuarios[i][2] = scanner.nextLine();
					System.out.println("Ingrese los años de experiencia:");
					matrizUsuarios[i][6] = scanner.nextLine();
					System.out.println("Ingrese el departamento:");
					matrizUsuarios[i][7] = scanner.nextLine();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public static void ingresarDatosAdministrativo(String[][] matrizUsuarios, Scanner scanner) {
		try {
			for (int i = 0; i < MAX_ROWS; i++) {
				if (matrizUsuarios[i][0] == null) {
					System.out.println("Ingresando datos para un administrativo.");
					System.out.println("Ingrese el nombre:");
					matrizUsuarios[i][0] = scanner.nextLine();
					System.out.println("Ingrese la fecha de nacimiento:");
					matrizUsuarios[i][1] = scanner.nextLine();
					System.out.println("Ingrese el RUN:");
					matrizUsuarios[i][2] = scanner.nextLine();
					System.out.println("Ingrese la función");
					matrizUsuarios[i][8] = scanner.nextLine();
					break;
				}
				if (i == MAX_ROWS - 1) {
					System.out.println("Se ha alcanzado el límite de registros.");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public static void mostrarUsuarios() {

		try {
			for (int i = 0; i < MAX_ROWS; i++) {

				if (!(matrizUsuarios[i][0] == null)) {
					// si la posicion no esta vacia imprime los datos
					int optCase = 0;
					if (!(matrizUsuarios[i][4] == null)) {
						optCase = 4;
					}
					if (!(matrizUsuarios[i][6] == null)) {
						optCase = 6;
					}
					if (!(matrizUsuarios[i][8] == null)) {
						optCase = 8;
					}

					switch (optCase) {
					case 4:
						System.out.println("Los datos del usuario son");
						for (int j = 0; j < MAX_COLS; j++) {
							System.out.println(matrizUsuarios[i][j]);
						}
						break;
					case 6:
						System.out.println("Los datos del profecional son");
						for (int j = 0; j < MAX_COLS; j++) {
							System.out.println(matrizUsuarios[i][j]);
						}
						break;

					case 8:
						System.out.println("Los datos del administratuvo son");
						for (int j = 0; j < MAX_COLS; j++) {
							System.out.println(matrizUsuarios[i][j]);
						}
						break;
					default:
					}

				} else {

					break;
				}

				System.out.println();
			}
		} catch (Exception e) {
			
			System.out.println(e);
		}

	}

}
