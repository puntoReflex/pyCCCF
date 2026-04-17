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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarResumen'");
    }

    private void pausar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pausar'");
    }

    private void mostrarEstado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarEstado'");
    }

    private void procesarAtencionCajas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procesarAtencionCajas'");
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
