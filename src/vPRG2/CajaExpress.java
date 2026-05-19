public class CajaExpress extends Caja {

    Console console;

    public CajaExpress(int numero){
        super(numero);
        console = new Console();
    }
    
    @Override
    public void mostrar() {
        console.write("CajaE["+numero+"] ");
        console.writeln("[:]".repeat(itemsRestantes));
    }

    @Override
    public boolean puedeAtender(Cliente cliente){
        return cliente.obtenerItems()<=10;
    }

}
