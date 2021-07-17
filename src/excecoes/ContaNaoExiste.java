package excecoes;

public class ContaNaoExiste extends Exception{

    public ContaNaoExiste(int num){
        super(num + ": Conta Não Existe!");
    }
}
