package test.java.observer;

import main.java.observer.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Cliente {

    @Test
    void deveNotificarUmCliente() {
        Concessionaria concessionaria = new Concessionaria("Toyota Osaka", "Juiz de Fora", "Salvaterra");
        ClienteCadastrado cliente = new ClienteCadastrado("Cliente 1");
        cliente.cadastrar(concessionaria);
        concessionaria.atualizarEstoque();
        assertEquals("Cliente 1, estoque de veículos atualizado na Concessionária{nome=Toyota Osaka, cidade=Juiz de Fora, bairro='Salvaterra'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarOsClientes() {
        Concessionaria concessionaria = new Concessionaria("Toyota Osaka", "Juiz de Fora", "Salvaterra");
        ClienteCadastrado cliente1 = new ClienteCadastrado("Cliente 1");
        ClienteCadastrado cliente2 = new ClienteCadastrado("Cliente 2");
        cliente1.cadastrar(concessionaria);
        cliente2.cadastrar(concessionaria);
        concessionaria.atualizarEstoque();
        assertEquals("Cliente 1, estoque de veículos atualizado na Concessionária{nome=Toyota Osaka, cidade=Juiz de Fora, bairro='Salvaterra'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, estoque de veículos atualizado na Concessionária{nome=Toyota Osaka, cidade=Juiz de Fora, bairro='Salvaterra'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Concessionaria concessionaria = new Concessionaria("Toyota Osaka", "Juiz de Fora", "Salvaterra");
        ClienteCadastrado cliente1 = new ClienteCadastrado("Cliente 1");
        concessionaria.atualizarEstoque();
        assertEquals(null, cliente1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteOsaka(){
        Concessionaria concessionaria1 = new Concessionaria("Toyota Osaka", "Juiz de Fora", "Salvaterra");
        Concessionaria concessionaria2 = new Concessionaria("Volkswagen Thema", "Juiz de Fora", "Salvaterra");
        ClienteCadastrado cliente1 = new ClienteCadastrado("Cliente 1");
        ClienteCadastrado cliente2 = new ClienteCadastrado("Cliente 2");
        cliente1.cadastrar(concessionaria1);
        cliente2.cadastrar((concessionaria2));
        concessionaria1.atualizarEstoque();
        assertEquals("Cliente 1, estoque de veículos atualizado na Concessionária{nome=Toyota Osaka, cidade=Juiz de Fora, bairro='Salvaterra'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
