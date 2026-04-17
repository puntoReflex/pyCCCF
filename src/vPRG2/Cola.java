public class Cola {

    private Cliente[] clientes;
    private final int CAPACIDAD_MAXIMA = 100;
    private int minutosSinClientes;
    private int tamaño;
    private Console console;

    public Cola() {
        clientes = new Cliente[CAPACIDAD_MAXIMA];
        minutosSinClientes = 0;
        tamaño = 0;
        console = new Console();
    }

    public void registrarEstado() {
        if (tamaño == 0) {
            minutosSinClientes = minutosSinClientes + 1;
        }
    }

    public void añadirCliente(Cliente cliente) {
        clientes[tamaño] = cliente;
        tamaño = tamaño + 1;
    }

    public boolean hayClientes() {
        return tamaño > 0;
    }

    public Cliente quitarCliente() {
        Cliente cliente = clientes[0];
        for (int i = 0; i < tamaño - 1; i++) {
            clientes[i] = clientes[i + 1];
        }
        clientes[tamaño - 1] = null;
        tamaño = tamaño - 1;
        return cliente;
    }

    public void mostrar() {
        final String PERSONA = "_O/";
        console.writeln(PERSONA.repeat(tamaño));
    }

    public int obtenerMinutosSinClientes() {
        return minutosSinClientes;
    }

    public int obtenerCantidadPersonasEnCola() {
        return tamaño;
    }

}
