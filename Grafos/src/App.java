import Grafo.Grafo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando a execucao do programa!");

        System.out.println("Lendo dados do Grafo");
        Scanner input = new Scanner(System.in);
        Grafo grafo = new Grafo();

        grafo.setNumeroVertices(input.nextInt());
        grafo.setNumeroArestas(input.nextInt());

        for (int i = 0; i < grafo.getNumeroArestas(); i++) {
            String verticeV = input.next();
            String verticeW = input.next();
            Integer peso = input.nextInt();

            grafo.adicionaAresta(verticeV, verticeW, peso);
        }
        System.out.println("Fim da criação do Grafo");
        System.out.println(grafo.toString());
    }
}
