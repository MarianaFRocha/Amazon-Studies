package Grafo;

public class Aresta {

    Vertice verticeV;
    Vertice verticeW;
    Integer peso;

    public Aresta(Vertice verticeV, Vertice verticeW, Integer peso){
        this.verticeV = verticeV;
        this.verticeW = verticeW;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "\n      Aresta{" +
                "\n         verticeV=" + verticeV.nome +
                "\n         verticeW=" + verticeW.nome +
                "\n         peso=" + peso +
                "\n     }";
    }
}
