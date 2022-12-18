package main.java.observer;

import java.util.Observable;

public class Concessionaria extends Observable {
    private String nome;
    private String cidade;
    private String bairro;

    public Concessionaria(String nome, String cidade, String bairro) {
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public void atualizarEstoque(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Concessionária{" +
                "nome=" + nome +
                ", cidade=" + cidade +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
