import banco.Banco;
import operador.Operador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operador operador = new Operador();
        operador.banco = new Banco();

        Scanner scanner = new Scanner(System.in);
        int opcao=-1;
        while(opcao != 0){

            System.out.println("");
            System.out.println("0 - Encerrar");
            System.out.println("1 - Lista Clientes");
            System.out.println("2 - Lista Contas");
            System.out.println("3 - Saldo do Cliente");
            System.out.println("4 - Saldo da Conta");
            System.out.println("5 - Extrato do Cliente");
            System.out.println("6 - Extrato de Conta");
            System.out.println("7 - Realizara Transferência");
            System.out.println("8 - Mostrar Valores");
            opcao = scanner.nextInt();
            operador.scanner = scanner;

            switch (opcao){
                case 0:
                    break;
                case 1:
                    operador.listaClientes();
                    break;
                case 2:
                    operador.listaContas();
                    break;
                case 3:
                    operador.saldoCliente();
                    break;
                case 4:
                    operador.saldoConta();
                    break;
                case 5:
                    operador.extratoCliente();
                    break;
                case 6:
                    operador.extratoConta();
                    break;
                case 7:
                    operador.realizaTransferencia();
                    break;
                case 8:
                    operador.mostraValores();
                    break;
            }

        }
        scanner.close();
    }
}
