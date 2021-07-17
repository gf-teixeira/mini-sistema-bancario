package banco;

import cliente.Cliente;
import conta.Conta;
import transferencia.Transferencia;

import java.util.ArrayList;

public class Banco {
    private int soma;

    public ArrayList<Cliente> clientes = new ArrayList<>();
    public ArrayList<Conta> contas = new ArrayList<>();
    public ArrayList<Transferencia> transferencias = new ArrayList<>();

    Banco(){
        Cliente cliente1 = new Cliente("Gabriel", 421);
        Cliente cliente2 = new Cliente("Adair", 321);

        Conta conta1 = new Conta(1, cliente1);
        Conta conta2 = new Conta(2, cliente1);
        Conta conta3 = new  Conta(3, cliente2);

        clientes.add(cliente1);
        clientes.add(cliente2);

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);

        contas.forEach(conta -> {
            soma += conta.getSaldo();
        });

    }

    public void listaClientes(){
        clientes.forEach(cliente -> {
            System.out.println("CPF:" + cliente.getCpf());
            System.out.println("Nome:" + cliente.getNome());
        });
    }

    public void listaContas(){
        contas.forEach(conta -> {
            System.out.println("Num:" + conta.getNumero());
            System.out.println("Proprietário da Conta: " + conta.getCliente().getNome());
            System.out.println("Saldo: " + conta.getSaldo());
        });
    }

    public void saldoCliente(int cpf){
        int saldoCliente=0;
        for(Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                for (Conta conta : contas) {
                    if (conta.getCliente().getCpf() == cpf){
                        saldoCliente += conta.getSaldo();
                    }
                }
            }
        }
        System.out.println("CPF " + cpf);
        System.out.println("Saldo: " + saldoCliente);
    }

    public void saldoConta(int num) {
        int saldoConta = 0;
        for (Conta conta : contas) {
            if (conta.getNumero() == num) {
                saldoConta += conta.getSaldo();
            }
        }
        System.out.println("num" + num);
        System.out.println("Saldo: " + saldoConta);
    }

    public void extratoCliente(int cpf) {
        transferencias.forEach(transferencia -> {
            if(transferencia.getContaOrigem().getCliente().getCpf() == cpf){
                //debitou
                System.out.println("");
                System.out.println("Valor: -R$ " + transferencia.getValor());
                System.out.println("Enviado para:" + transferencia.getContaDestino().getCliente().getNome());
            }
            if(transferencia.getContaDestino().getCliente().getCpf() == cpf){
                //creditou
                System.out.println("");
                System.out.println("Valor: +R$ " + transferencia.getValor());
                System.out.println("Enviado por:" + transferencia.getContaOrigem().getCliente().getNome());
            }
        });
    }
    public void extratoConta(int num){
        transferencias.forEach(transferencia -> {
           if(transferencia.getContaOrigem().getNumero() == num){
               //debitou
               System.out.println("");
               System.out.println("Valor: -R$ " + transferencia.getValor());
               System.out.println("Enviado para:" + transferencia.getContaDestino().getCliente().getNome());
           }
           if(transferencia.getContaDestino().getNumero() == num){
               System.out.println("");
               System.out.println("Valor: +R$ " + transferencia.getValor());
               System.out.println("Enviado por:" + transferencia.getContaDestino().getCliente().getNome());
           }
        });

    }
    public void realizaTransferencia(int valor, int numContaOrigem, int numContaDestino){
        Conta contaOrigem = new Conta();
        Conta contaDestino = new Conta();

        for(Conta conta : contas) {
            if (conta.getNumero() == numContaOrigem) {
                contaOrigem = conta;
            }
            if (conta.getNumero() == numContaDestino){
                contaDestino = conta;
            }
        }
        Transferencia transferencia = new Transferencia(valor, contaOrigem, contaDestino);

        System.out.println("Transferência realizada com sucesso!");
    }

    public void mostraValores(){
        int total = 0;

        for(Conta conta : contas){
            total += conta.getSaldo();
            System.out.println("");
            System.out.println("Conta: " + conta.getNumero());
            System.out.println("R$ " + conta.getSaldo());
        }

        System.out.println("Total: R$ " + total);
    }
}
