public class FilaEstatica {
    private int topo = -1;
    private int base = 0;   
    private int[] dados;   

    public FilaEstatica(int tamanho) {
        dados = new int[tamanho];
    }

    public void adicionar(int item) {
        if (estaCheia()) {
            System.out.println("A fila está cheia. Não é possível adicionar o item.");
            return;
        }
        topo++;
        dados[topo] = item;
    }

    public int remover() {
        if (estaVazia()) {
            System.out.println("A fila está vazia. Não é possível remover o item.");
            return -1;
        }
        int item = dados[base];
        dados[base] = 0; 
        base++;
        return item;
    }

    public void limpar() {
        for (int i = base; i <= topo; i++) {
            dados[i] = 0;
        }
        topo = -1;
        base = 0;
    }

    public boolean estaCheia() {
        return topo == dados.length - 1;
    }

    public boolean estaVazia() {
        return topo < base;
    }

    public static void main(String[] args) {
        FilaEstatica fila = new FilaEstatica(5);

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
