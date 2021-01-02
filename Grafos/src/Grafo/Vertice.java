package Grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    String nome;
    List<String> verticesAdjacentes;

    public Vertice(){
        verticesAdjacentes = new ArrayList<>();
    }

    public void adicionarVerticeAdjacente(String nomeVertice){
        verticesAdjacentes.add(nomeVertice);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\n      Vertice{" +
                "\n         nome='" + nome +
                "\n         verticesAdjacentes=" + verticesAdjacentes.toString() +
                "\n     }";
    }
}
