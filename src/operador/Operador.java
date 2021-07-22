package operador;

import banco.Banco;
import excecoes.BalancoInvalido;
import excecoes.ClienteNaoExiste;
import excecoes.ContaNaoExiste;
import excecoes.SaldoInsuficiente;

import java.util.Scanner;

public class Operador {

    public static Banco banco;
    public static Scanner scanner;


    public static void listaClientes(){
        banco.listaClientes();
    }

    public static void listaContas(){
        banco.listaContas();
    }
    public static void saldoCliente(){

        Utils utils = new Utils();
        try {
            int cpf=0;
            System.out.println("Digite o cpf: ");
            cpf = scanner.nextInt();

           if (utils.clienteExiste(cpf, banco.clientes)) {
                banco.saldoCliente(cpf);
            } else {
                throw new ClienteNaoExiste();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    public static void saldoConta() {
        try {
            System.out.println("Digite o numero: ");
            int num = scanner.nextInt();
            Utils utils = new Utils();

            if (utils.contaExiste(num, banco.contas)) {
                banco.saldoConta(num);
            } else {
                throw new ContaNaoExiste();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void extratoCliente(){

        Utils utils = new Utils();
        try{
            System.out.println("CPF: ");
            int cpf = scanner.nextInt();
            if(utils.clienteExiste(cpf, banco.clientes)){
                banco.extratoCliente(cpf);
            }else {
                throw new ClienteNaoExiste();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void extratoConta(){

        Utils utils = new Utils();
        try{
            System.out.println("Numero da Conta: ");
            int num = scanner.nextInt();
            if(utils.contaExiste(num, banco.contas)){
                banco.extratoConta(num);
            }else {
                throw new ContaNaoExiste();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void realizaTransferencia(){
        Utils utils = new Utils();
        try{
            int saldoAnterior = banco.getSaldo();

            System.out.println("Valor: ");
            final int valor = scanner.nextInt() *  100;

            System.out.println("Numero da Conta de Origem: ");
            final int numOrigem = scanner.nextInt();

            if(!utils.contaExiste(numOrigem, banco.contas)){
                throw new ContaNaoExiste();
            }
            if(!(utils.verificaSaldo(numOrigem, valor, banco.contas))){
                throw new SaldoInsuficiente();
            }

            System.out.println("Numero da Conta de Destino: ");
            final int numDestino = scanner.nextInt();

            if(!utils.contaExiste(numDestino, banco.contas)){
                throw new ContaNaoExiste();
            }
            banco.realizaTransferencia(valor, numOrigem, numDestino);
            int saldoPosterior = banco.getSaldo();

            if(saldoAnterior != saldoPosterior){
                throw new BalancoInvalido();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void mostraValores(){
        banco.mostraValores();
    }
}
