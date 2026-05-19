public class Cliente {

    private int items;
    private Console console;

    public Cliente() {
        items = this.generarItems();
        console = new Console();
    }

    private int generarItems() {
        final int MAXIMO_ITEMS = 15;
        final int MINIMO_ITEMS = 5;
        return (int) (Math.random() * (MAXIMO_ITEMS - MINIMO_ITEMS) + MINIMO_ITEMS);
    }

    public int obtenerItems() {
        return items;
    }

    public void mostrar() {
        console.write("[" + items + "]_O/");
    }
}
