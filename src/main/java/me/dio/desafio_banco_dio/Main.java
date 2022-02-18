package me.dio.desafio_banco_dio;

public class Main {

	public static void main(String[] args) {
		
		Banco banco = new Banco("Meu Banco", 10);
		
		Cliente cliente = new Cliente("Lucas", "111.111.111-11");
		
		Conta cc = new ContaCorrente(cliente, banco);
		cc.depositar(100);

		Conta poupanca = new ContaPoupança(cliente, banco);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		banco.imprimirListaDeClientesAtivos();
		
		cc.desativar();
		
		banco.imprimirListaDeClientesAtivos();
		
		poupanca.desativar();
		
		banco.imprimirListaDeClientesAtivos();
		
		cc.restaurar();
		
		banco.imprimirListaDeClientesAtivos();
		
		new ContaCorrente(cliente, banco);
		
		banco.imprimirListaDeClientesAtivos();
		
		Cliente cliente2 = new Cliente("Joao", "211.111.111-11");
		
		Conta cc2 = new ContaCorrente(cliente2, banco);
		
		banco.imprimirListaDeClientesAtivos();
		
		cc2.desativar();
		
		banco.imprimirListaDeClientesAtivos();
		
	}

}
