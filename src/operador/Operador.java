package operador;

import banco.Banco;
import excecoes.BalancoInvalido;
import excecoes.ClienteNaoExiste;
import excecoes.ContaNaoExiste;
import excecoes.SaldoInsuficiente;

import java.util.Scanner;
/**Classe que representa objetos do tipo Operador
* Responsável por lidar com os inputs do usuário, validando e chamando as operações do banco requeridas, quando possível.
* @author Gabriel Teixeira
*/
public class Operador {

    public static Banco banco;
    public static Scanner scanner;

/**
* Método responsável por invocar a operação listaClientes() do banco.
*/
    public static void listaClientes(){
        banco.listaClientes();
    }
/**
* Método responsável por invocar a operação listaContas() do banco.
*/
    public static void listaContas(){
        banco.listaContas();
    }
/**
* Método responsável pelo input do usuário, validação e invocação da operação saldoCliente() do banco
* @exception ClienteNaoExiste Caso o cliente com o cpf requerido não exista.
*/
    public static void saldoCliente(){

        try {
            int cpf=0;
            System.out.println("Digite o cpf: ");
            cpf = scanner.nextInt();

           if (banco.clienteExiste(cpf)) {
                banco.saldoCliente(cpf);
            } else {
                throw new ClienteNaoExiste();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
/**
* Método responsável pelo input do usuário, validação e invocação da operação saldosConta() do banco
* @exception ContaNaoExiste Caso a conta com o número requerido não exista.
*/
    public static void saldoConta() {
        try {
            System.out.println("Digite o numero: ");
            int num = scanner.nextInt();


            if (banco.contaExiste(num)) {
                banco.saldoConta(num);
            } else {
                throw new ContaNaoExiste();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
/**
* Método responsável pelo input do usuário, validação e invocação da operação extratoCliente() do banco.
* @exception ClienteNaoExiste Caso o cliente com o cpf requerido não exista.
*/
    public static void extratoCliente(){

        try{
            System.out.println("CPF: ");
            int cpf = scanner.nextInt();
            if(banco.clienteExiste(cpf)){
                banco.extratoCliente(cpf);
            }else {
                throw new ClienteNaoExiste();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
/**
* Método responsável por pegar o input do usuário, validar e invocar a operação extratoConta() do banco.
* @exception ContaNaoExiste Caso a conta não exista.
*/
    
    public static void extratoConta(){

        try{
            System.out.println("Numero da Conta: ");
            int num = scanner.nextInt();
            if(banco.contaExiste(num)){
                banco.extratoConta(num);
            }else {
                throw new ContaNaoExiste();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
/**
* Método responsável por pegar o input do usuário, validar e invocar a operação realizaTransferencia() do banco.
* @exception ContaNaoExiste Caso a conta não exista.
* @exception SaldoInsuficiente Caso o saldo da conta de origem seja insuficiente para realizar a transferência.
* @exception BalancoInvalido Casoa o saldo total do banco após a transferência seja diferente do saldo antes da transferência.
*/
    public static void realizaTransferencia(){
        try{
            int saldoAnterior = banco.getSaldo();

            System.out.println("Valor: ");
            final int valor = scanner.nextInt() *  100;

            System.out.println("Numero da Conta de Origem: ");
            final int numOrigem = scanner.nextInt();

            if(!banco.contaExiste(numOrigem)){
                throw new ContaNaoExiste();
            }
            if(!(banco.verificaSaldo(numOrigem, valor))){
                throw new SaldoInsuficiente();
            }

            System.out.println("Numero da Conta de Destino: ");
            final int numDestino = scanner.nextInt();

            if(!banco.contaExiste(numDestino)){
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
/**
* Método responsável por invocar a operação mostraValores() do banco.
*/
    public static void mostraValores(){
        banco.mostraValores();
    }
}
