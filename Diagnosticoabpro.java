package trabajopersonal1;
import java.util.*;

public class Diagnosticoabpro {
public static void main(String[] args) {
		
		// Se declaran las variables globales a utilizar.
		Scanner scan = new Scanner(System.in); // funcion para guardar input del usuario.
		String[][] datos = new String[100][10]; // Lista de String bidimencional para guardar los datos.
		
		menuPrincipal(datos);
		
	}
	
	
// FUNCIONES PRINCIPALES.

	// funcion para mostrar menu principal.
	public static void menuPrincipal(String[][] datos) {
		
		Scanner scan = new Scanner(System.in); // funcion para guardar input del usuario.		
		String input = ""; // Variable para acceder a la funcion del menu principal.

		while (true) {
			// Menu principal con sus funciones. 
			System.out.println("--------------------------------");
			System.out.println("MENU PRINCIPAL: ");
			System.out.println("[1] REGISTRAR USUARIO");
			System.out.println("[2] MOSTRAR USUARIO");
			System.out.println("[3] CONTAR USUARIO POR CATEGORIA");
			System.out.println("[4] MODIFICAR USUARIO");
			System.out.println("[5] ELIMINAR USUARIO");
			System.out.println("[6] SALIR");
			System.out.println("--------------------------------");
			System.out.println("");
			System.out.println("Inserte NUMERO respectivo: ");
			input = scan.nextLine();
			
			// Condicion para acceder a cada funcion. 
			switch (input) {
				case "1" -> RegistroUsuario(datos);
				case "2" -> MostrarUsuario(datos);

//			else if (input.equals("3")) {
//				ContarUsuario(datos);
//			}
				case "4" -> ModificarUsuario(datos);
				case "5" -> EliminarUsuario(datos);
				case "6" -> {
					System.out.println("PROGRAMA FINALIZADO.");
					System.exit(0);
				}
				default -> System.out.println("INPUT INVALIDO.");
			}
			
		}
	}
	
	// funcion de registro de usuarios
	public static void RegistroUsuario(String[][] datos) {
		
		// variables locales de la funcion.
		String input;
		Scanner scan = new Scanner(System.in);

		int indice = BuscarVacio(datos);
		
		// Consulta que tipo de usuario agregar a la lista.
		System.out.println("--------------------------------");
		System.out.println("SELECCIONE TIPO DE USUARIO: ");
		System.out.println("[1] CLIENTE");
		System.out.println("[2] PROFESIONAL");
		System.out.println("[3] ADMINISTRATIVO");
		System.out.println("--------------------------------");
		System.out.println("");
		System.out.println("Inserte NUMERO respectivo: ");
		input = scan.nextLine();
		
		// Datos solicitados para CLIENTE.
		switch (input) {
			case "1" -> {
				System.out.println("--------------------------------");
				System.out.println("NOMBRE CLIENTE: ");
				datos[indice][0] = scan.nextLine();
				System.out.println("FECHA NACIMIENTO CLIENTE: ");
				datos[indice][1] = scan.nextLine();
				System.out.println("RUN CLIENTE: ");
				datos[indice][2] = scan.nextLine();
				System.out.println("DIRECCION CLIENTE: ");
				datos[indice][3] = scan.nextLine();
				System.out.println("TELEFONO CLIENTE: ");
				datos[indice][4] = scan.nextLine();
				System.out.println("CANTIDAD EMPLEADOS CLIENTE: ");
				datos[indice][5] = scan.nextLine();
			}
			// Datos solicitados para PROFESIONAL.
			case "2" -> {
				System.out.println("--------------------------------");
				System.out.println("NOMBRE PROFESIONAL: ");
				datos[indice][0] = scan.nextLine();
				System.out.println("FECHA NACIMIENTO PROFESIONAL: ");
				datos[indice][1] = scan.nextLine();
				System.out.println("RUN PROFESIONAL: ");
				datos[indice][2] = scan.nextLine();
				System.out.println("EXPERIENCIA PROFESIONAL: ");
				datos[indice][6] = scan.nextLine();
				System.out.println("DEPARTAMENTO PROFESIONAL: ");
				datos[indice][7] = scan.nextLine();
			}
			// Datos solicitados para ADMINISTRATIVO.
			case "3" -> {
				System.out.println("--------------------------------");
				System.out.println("NOMBRE ADMINISTRATIVO: ");
				datos[indice][0] = scan.nextLine();
				System.out.println("FECHA NACIMIENTO ADMINISTRATIVO: ");
				datos[indice][1] = scan.nextLine();
				System.out.println("RUN ADMINISTRATIVO: ");
				datos[indice][2] = scan.nextLine();
				System.out.println("FUNCION ADMINISTRATIVA: ");
				datos[indice][8] = scan.nextLine();
				System.out.println("NOMBRE SUPERIOR ADMINISTRATIVO: ");
				datos[indice][9] = scan.nextLine();
			}
			default -> System.out.println("INPUT INVALIDO.");
		}
		
	}
	
	// funcion para mostrar todos los registros.
	public static void MostrarUsuario(String[][] datos) {
		System.out.println("NONBRE" + " " + "FECHA NACIMIENTO" + " " + "RUN" + " " + "DIRECCION" + " " + "TELEFONO" + " " + 
				"CANTIDAD EMPLEADOS" + " " + "EXPERIENCIA" + " " + "DEPARTAMENTO" + " " + "FUNCION" + " " + "NOMBRE SUPERIOR");
		for (String[] dato : datos) {
			if (dato[0] != null) {
				System.out.println(dato[0] + " " + dato[1] + " " + dato[2] + " " + dato[3] + " " + dato[4] + " " +
						dato[5] + " " + dato[6] + " " + dato[7] + " " + dato[8] + " " + dato[9]);
			}
		}
		ContarUsuariosPorCategoria(datos);
	}
	
	// funcion para contar usuarios por categoria.
	public static void ContarUsuariosPorCategoria(String[][] datos) {
		int clientes = 0;
		int profesionales = 0;
		int administrativos = 0;

		for (String[] dato : datos) {
			if (dato[3] != null) { //suma todos los no null del atributo DIRECCION.
				clientes++;
			}
			if (dato[7] != null) { //suma todos los no null del atributo DEPARTAMENTO.
				profesionales++;
			}
			if (dato[8] != null) { //suma todos los no null del atributo FUNCION.
				administrativos++;
			}
		}
		System.out.println("CANTIDAD CLIENTES: " + clientes);
		System.out.println("CANTIDAD PROFESIONALES: " + profesionales);
		System.out.println("CANTIDAD ADMINISTRATIVOS: " + administrativos);
	}
	
	// funcion para eliminar usuarios.
	public static void EliminarUsuario(String[][] datos) {
		Scanner scan = new Scanner(System.in);
		int indice = 0;
		String input = "";
		
		System.out.println("Seleccionar RUT a ELIMINAR: ");
		input = scan.nextLine();
		
		for (int i = 0; i < 100; i++) {
			if (datos[i][2] != null && datos[i][2].equals(input)) {
				indice = i;
				for (int j = 0; j < 10; j++) {
					datos[indice][j] = null;
				}
				break;
			}
		}
		System.out.println("El usuario ha sido eliminado.");
		Ordenar(datos);
	}				

	
// FUNCIONES AUXILIARES.
	
	// funcion busqueda de registro vacio.
	public static int BuscarVacio(String[][] datos) {
		int indice = 0;
		// Este bloque de codigo busca la fila vacia de la tabla para insertar el nuevo registro.
		// para que funcione correctamente debe de haber una funcion auxiliar que ordene la tabla al ELIMINAR registros. 
		for (int i = 0; i < datos.length; i++) {
			if (datos[i][0] == null) {
				indice = i;
				break;
			}
		}
		return indice;
	}

	// funcion  para ordenar tabla luego de eliminar registro.
	public static void Ordenar(String[][] datos) {
		for (int i = 0; i < 99; i++) {
			if (datos[i][0] == null && datos[i + 1][0] != null) {
				for (int j = 0; j < 10; j++) {
					datos[i][j] = datos[i + 1][j];
					datos[i + 1][j] = null;
				}
			}
		}
	}
	
	
	public static void ModificarUsuario(String[][] datos) {
		try {
			int tipoUsuario = 0;
			Scanner scan = new Scanner(System.in);
			MostrarUsuario(datos);
			System.out.println("Ingrese el RUT del usuario a modificar");
			String usuarioModificar = scan.nextLine();

			for (int i = 0; i < 100; i++) {
				if (datos[i][2] != null) {
					if (datos[i][3] != null) {
						tipoUsuario = 1;
					}
					if (datos[i][7] != null) {
						tipoUsuario = 2;
					}
					if (datos[i][8] != null) {
						tipoUsuario = 3;
					}

					if ((datos[i][2]).equals(usuarioModificar)) {
						switch (tipoUsuario) {
							case 1 -> {
								System.out.println("--------------------------------");
								System.out.println("NOMBRE CLIENTE: ");
								datos[i][0] = scan.nextLine();
								System.out.println("FECHA NACIMIENTO CLIENTE: ");
								datos[i][1] = scan.nextLine();
								System.out.println("RUN CLIENTE: ");
								datos[i][2] = scan.nextLine();
								System.out.println("DIRECCION CLIENTE: ");
								datos[i][3] = scan.nextLine();
								System.out.println("TELEFONO CLIENTE: ");
								datos[i][4] = scan.nextLine();
								System.out.println("CANTIDAD EMPLEADOS CLIENTE: ");
								datos[i][5] = scan.nextLine();
							}
							case 2 -> {
								System.out.println("--------------------------------");
								System.out.println("NOMBRE PROFESIONAL: ");
								datos[i][0] = scan.nextLine();
								System.out.println("FECHA NACIMIENTO PROFESIONAL: ");
								datos[i][1] = scan.nextLine();
								System.out.println("RUN PROFESIONAL: ");
								datos[i][2] = scan.nextLine();
								System.out.println("EXPERIENCIA PROFESIONAL: ");
								datos[i][6] = scan.nextLine();
								System.out.println("DEPARTAMENTO PROFESIONAL: ");
								datos[i][7] = scan.nextLine();
							}
							case 3 -> {
								System.out.println("--------------------------------");
								System.out.println("NOMBRE ADMINISTRATIVO: ");
								datos[i][0] = scan.nextLine();
								System.out.println("FECHA NACIMIENTO ADMINISTRATIVO: ");
								datos[i][1] = scan.nextLine();
								System.out.println("RUN ADMINISTRATIVO: ");
								datos[i][2] = scan.nextLine();
								System.out.println("FUNCION ADMINISTRATIVA: ");
								datos[i][8] = scan.nextLine();
								System.out.println("NOMBRE SUPERIOR ADMINISTRATIVO: ");
								datos[i][9] = scan.nextLine();
							}
							default -> {
							}
						}

					}

				}
			}
			System.out.println("Cambios realizados correctamente");
			// mostrarUsuario(datos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}}



