public class FilaCircular<T> {
    private int topo = -1;
    private int base = 0;
    private T[] dados;

    @SuppressWarnings("unchecked")
    public FilaCircular(int tamanho) {
        dados = (T[]) new Object[tamanho];
    }

    public void adicionar(T item) {
        if (estaCheia()) {
            System.out.println("A fila está cheia. Não é possível adicionar o item.");
            return;
        }
        topo = (topo + 1) % dados.length;
        dados[topo] = item;
    }

    public T remover() {
        if (estaVazia()) {
            System.out.println("A fila está vazia. Não é possível remover o item.");
            return null;
        }
        T item = dados[base];
        dados[base] = null;
        base = (base + 1) % dados.length;
        return item;
    }

    public void limpar() {
        topo = -1;
        base = 0;
        for (int i = 0; i < dados.length; i++) {
            dados[i] = null;
        }
    }

    public boolean estaCheia() {
        return (topo + 1) % dados.length == base && dados[topo] != null;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public static void main(String[] args) {
        FilaCircular<Integer> fila = new FilaCircular<>(5);

        fila.adicionar(10);
        fila.adicionar(20);
        System.out.println(fila.remover()); 
        fila.adicionar(30);
        System.out.println(fila.remover()); 
        System.out.println(fila.remover()); 
        fila.limpar();
        System.out.println(fila.estaVazia()); 
    }
}
