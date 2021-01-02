package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Grafo Bidirecional
 */
public class Grafo {

    List<Aresta> arestas;
    List<Vertice> vertices;

    Integer numeroArestas;
    Integer numeroVertices;

    public Grafo(){
        arestas = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    public void adicionaAresta(String vertice1, String vertice2, Integer peso){

        Vertice verticeV = buscaVertice(vertice1);
        verticeV.adicionarVerticeAdjacente(vertice2);

        Vertice verticeW = buscaVertice(vertice2);
        verticeW.adicionarVerticeAdjacente(vertice1);

        arestas.add(new Aresta(verticeV, verticeW, peso));
    }

    public Vertice buscaVertice(String nomeVertice){

        if(!vertices.isEmpty()) {
            for (int i = 0; i < vertices.size(); i++) {
                if (vertices.get(i).nome.equals(nomeVertice)) {
                    return vertices.get(i);
                }
            }
        }

        return adicionaVertice(nomeVertice);
    }

    public Vertice adicionaVertice(String nomeVertice){
        Vertice vertice = new Vertice();
        vertice.setNome(nomeVertice);
        vertices.add(vertice);

        return vertice;
    }

    public Integer getNumeroArestas() {
        return numeroArestas;
    }

    public void setNumeroArestas(Integer numeroArestas) {
        this.numeroArestas = numeroArestas;
    }

    public void setNumeroVertices(Integer numeroVertices) {
        this.numeroVertices = numeroVertices;
    }

    @Override
    public String toString() {
        return "Grafo{" +
                "\n     numeroArestas=" + numeroArestas +
                "\n     numeroVertices=" + numeroVertices +
                "\n\n   arestas=" + arestas.toString() +
                "\n\n   vertices=" + vertices.toString() +
                '}';
    }
}