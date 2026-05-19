public class Caja {

    protected int numero;
    private Cliente cliente;
    private int itemsVendidos;
    private int personasAtendidas;
    protected int itemsRestantes;
    private Console console;

    public Caja(int numero) {
        this.numero = numero;
        itemsVendidos = 0;
        personasAtendidas = 0;
        itemsRestantes = 0;
        console = new Console();
    }

    public boolean estaLibre() {
        return cliente == null;
    }

    public void asignar(Cliente cliente) {
        this.cliente = cliente;
        itemsRestantes = cliente.obtenerItems();
    }

    public void avanzarAtencion() {
        if (!this.estaLibre()) {
            itemsRestantes = itemsRestantes - 1;
            if (itemsRestantes == 0) {
                personasAtendidas = personasAtendidas + 1;
                itemsVendidos = itemsVendidos + cliente.obtenerItems();
                cliente = null;
            }
        }
    }

    public void mostrar() {
        console.write("Caja ["+numero+"] ");
        console.writeln("[:]".repeat(itemsRestantes));
    }

    public int obtenerPersonasAtendidas() {
        return personasAtendidas;
    }

    public int obtenerItemsVendidos() {
        return itemsVendidos;
    }

    public boolean puedeAtender(Cliente cliente){
        return true;
    }

}
