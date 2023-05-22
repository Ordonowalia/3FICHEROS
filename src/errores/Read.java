package errores;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Read {

	private final static String FICHERO1 = "C:\\Users\\nukep\\desktop\\ficherosprog\\ST1.txt";
	private final static String FICHERO2 = "C:\\Users\\nukep\\desktop\\ficherosprog\\ST2.txt";
	private final static String FICHERO3 = "C:\\Users\\nukep\\desktop\\ficherosprog\\ST3.txt";

	private HashMap<String, Producto> tienda = new HashMap<>();

	public void mezclarDatos() {

		BufferedReader ficheroEntrada;
		BufferedWriter ficheroSalida;

		try {
			// BufferedReader enlaza con un fichero; para ello en java hay que crear un
			// FileReader
			ficheroEntrada = new BufferedReader(new FileReader(FICHERO1));

			// leo una linea del fichero

			String partesProducto = ficheroEntrada.readLine();

			// mientras que las lineas existan y no leamos null

			while (partesProducto != null) {
				Producto producto = new Producto(partesProducto);
				producto.setNombre(ficheroEntrada.readLine());
				producto.setCantidad(Integer.parseInt(ficheroEntrada.readLine()));
				producto.setPrecio(Double.parseDouble(ficheroEntrada.readLine()));
				tienda.put(partesProducto, producto);
				partesProducto = ficheroEntrada.readLine();
			}
			ficheroEntrada = new BufferedReader(new FileReader(FICHERO2));

			partesProducto = ficheroEntrada.readLine();

			// mientras que las lineas existan y no leamos null

			while (partesProducto != null) {
				Producto producto = new Producto(partesProducto);
				producto.setNombre(ficheroEntrada.readLine());
				producto.setCantidad(Integer.parseInt(ficheroEntrada.readLine()));
				producto.setPrecio(Double.parseDouble(ficheroEntrada.readLine()));
				if (tienda.containsKey(partesProducto)) {

					Producto productoTienda = tienda.get(partesProducto);
					if (productoTienda.getPrecio() == producto.getPrecio()) {
						productoTienda.setCantidad(productoTienda.getCantidad() + producto.getCantidad());
						tienda.put(partesProducto, productoTienda);
					} else {
						throw new PrecioException(partesProducto);
					}
				} else {
					tienda.put(partesProducto, producto);
				}

				tienda.put(partesProducto, producto);
				partesProducto = ficheroEntrada.readLine();
			}

			ficheroEntrada.close();

			ficheroSalida = new BufferedWriter(new FileWriter(FICHERO3));
			for (String id : tienda.keySet()) {
				ficheroSalida.write(id);
				ficheroSalida.newLine();
				Producto productoActual = tienda.get(id);
				ficheroSalida.write(productoActual.getNombre());
				ficheroSalida.newLine();
				ficheroSalida.write(productoActual.getCantidad()+"");
				ficheroSalida.newLine();
				ficheroSalida.write(productoActual.getPrecio()+"");
				ficheroSalida.newLine();
			
			}
			ficheroSalida.close();

		} catch (IOException e) {
			System.out.println("Problemas: " + e.getMessage());
		} catch (Exception e) {
			// Otro fallos
			e.printStackTrace();
		}

	}

}
