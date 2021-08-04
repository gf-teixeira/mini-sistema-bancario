package conta;

import cliente.Cliente;

/**Classe que representa objetos do tipo Conta
* @author Gabriel Teixeira
*/
public class Conta {
    private int numero;
    private int saldo;
    private Cliente cliente;
/**
 * Construtor Vazio da classe Conta
 */
    public Conta(){

    }
/**
 * Construtor da Classe Conta
 * Inicializa os atributos "numero" e "cliente"
 * @param numero Número da Conta 
 * @param cliente Objeto do tipo Cliente
 */
    public Conta(int numero, Cliente cliente){
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 100000;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
