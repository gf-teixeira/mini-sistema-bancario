package conta;

import cliente.Cliente;

public class Conta {
    private int numero;
    private int saldo;
    private Cliente cliente;

    public Conta(){

    }
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
