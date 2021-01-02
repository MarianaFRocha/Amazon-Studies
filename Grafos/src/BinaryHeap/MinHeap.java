package BinaryHeap;

public class MinHeap {

    private Integer[] Heap;
    private Integer tamanho;
    private int tamanhoMaximo;

    private static final int FRONT = 1;

    public MinHeap(int maxsize)
    {
        this.tamanhoMaximo = maxsize;
        this.tamanho = 0;
        Heap = new Integer[this.tamanhoMaximo + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    // Retorna a posicao do no pai
    private int noPai(int pos)
    {
        return pos / 2;
    }

    // Retorna a posicao do no filho esquerdo
    private int filhoEsquerdo(int pos)
    {
        return (2 * pos);
    }

    // Retorna a posicao do no filho direito
    private int filhoDireito(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isFolha(int pos)
    {
        if (pos >= (tamanho / 2) && pos <= tamanho) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos)
    {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isFolha(pos)) {
            if (Heap[pos] > Heap[filhoEsquerdo(pos)]
                    || Heap[pos] > Heap[filhoDireito(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (Heap[filhoEsquerdo(pos)] < Heap[filhoDireito(pos)]) {
                    swap(pos, filhoEsquerdo(pos));
                    minHeapify(filhoEsquerdo(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, filhoDireito(pos));
                    minHeapify(filhoDireito(pos));
                }
            }
        }
    }

    public void insere(int element)
    {
        if (tamanho >= tamanhoMaximo) {
            return;
        }
        Heap[++tamanho] = element;
        int noAtual = tamanho;

        while (Heap[noAtual] < Heap[noPai(noAtual)]) {
            swap(noAtual, noPai(noAtual));
            noAtual = noPai(noAtual);
        }
    }

    public void imprimi()
    {
        for (int i = 1; i <= tamanho / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void valorMinimo()
    {
        for (int pos = (tamanho / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[tamanho--];
        minHeapify(FRONT);
        return popped;
    }

//    public static void main(String[] arg)
//    {
//        System.out.println("The Min Heap is ");
//        MinHeap minHeap = new MinHeap(15);
//        minHeap.insere(5);
//        minHeap.insere(3);
//        minHeap.insere(17);
//        minHeap.insere(10);
//        minHeap.insere(84);
//        minHeap.insere(19);
//        minHeap.insere(6);
//        minHeap.insere(22);
//        minHeap.insere(9);
//        minHeap.valorMinimo();
//
//        minHeap.imprimi();
//        System.out.println("The Min val is " + minHeap.remove());
//    }
}
