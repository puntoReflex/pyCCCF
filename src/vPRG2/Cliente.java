public class Cliente {

    private int items;

    public Cliente() {
        items = this.generarItems();
    }

    private int generarItems() {
        final int MAXIMO_ITEMS = 15;
        final int MINIMO_ITEMS = 5;
        return (int) (Math.random() * (MAXIMO_ITEMS - MINIMO_ITEMS) + MINIMO_ITEMS);
    }

    public int obtenerItems() {
        return items;
    }
}
