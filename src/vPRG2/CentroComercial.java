public class CentroComercial {

    private Cola cola;
    private Caja[] cajas;
    private Tiempo tiempo;
    private boolean llegaClienteEsteMinuto;
    private Console console;
    final private double PROBABILIDAD_LLEGADA = 0.4;

    public CentroComercial() {
        console = new Console();
        cola = new Cola();
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i + 1);
        }
        tiempo = new Tiempo();
    }

    public void simular() {

        do {
            tiempo.avanzar();
            this.procesarLlegadaCliente();
            cola.registrarEstado();
            this.asignarClientesACajas();
            this.procesarAtencionCajas();
            this.mostrarEstado();
            this.pausar();
        } while (!tiempo.haFinalizado());

        this.mostrarResumen();
    }

    private void mostrarResumen() {
        int minutosSinClientes = cola.obtenerMinutosSinClientes();
        int personasEnCola = cola.obtenerCantidadPersonasEnCola();
        int personasAtendidas = this.obtenerPersonasAtendidas();
        int itemsVendidos = this.obtenerItemsVendidos();

        console.writeln("Personas atendidas: " + personasAtendidas);
        console.writeln("Personas en cola al cierre: " + personasEnCola);
        console.writeln("Items vendidos: " + itemsVendidos);
        console.writeln("Minutos sin clientes en cola: " + minutosSinClientes);
    }

    private int obtenerPersonasAtendidas(){
        int totalItems=0;
        for(int numeroCaja=0; numeroCaja<cajas.length; numeroCaja++){
            totalItems= totalItems + cajas[numeroCaja].obtenerPersonasAtendidas();
        }
        return totalItems;
    }

    private int obtenerItemsVendidos(){
        int totalItems=0;
        for(int numeroCaja=0; numeroCaja<cajas.length; numeroCaja++){
            totalItems = totalItems + cajas[numeroCaja].obtenerItemsVendidos();
        }
        return totalItems;
    }

    private void pausar() {
        console.pause(5);
    }

    private void mostrarEstado() {
        tiempo.mostrar(llegaClienteEsteMinuto);
        cola.mostrar();
        this.mostrarCajas();
    }

    private void mostrarCajas(){
        for(int numeroCaja=0; numeroCaja<cajas.length; numeroCaja++){
            cajas[numeroCaja].mostrar();
        }
    }

    private void procesarAtencionCajas() {
        for(int numeroCaja=0; numeroCaja<cajas.length; numeroCaja++){
            cajas[numeroCaja].avanzarAtencion();
        }
    }

    private void asignarClientesACajas() {
        for(int numeroCaja=0; numeroCaja<cajas.length; numeroCaja++){
            if (cajas[numeroCaja].estaLibre() && cola.hayClientes()){
                Cliente cliente = cola.quitarCliente();
                cajas[numeroCaja].asignar(cliente);
            }
        }
    }

    private void procesarLlegadaCliente() {
        llegaClienteEsteMinuto = Math.random() <= PROBABILIDAD_LLEGADA;

        if (llegaClienteEsteMinuto) {
            cola.añadirCliente(new Cliente());
        }

    }
}
