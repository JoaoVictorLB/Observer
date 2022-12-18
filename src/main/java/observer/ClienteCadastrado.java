package main.java.observer;

import java.util.Observable;
import java.util.Observer;

public class ClienteCadastrado implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public ClienteCadastrado(String nome){
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void cadastrar(Concessionaria concessionaria) {
        concessionaria.addObserver(this);
    }

    public void update(Observable concessionaria, Object arg1) {
        this.ultimaNotificacao = this.nome + ", estoque de veículos atualizado na " + concessionaria.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
