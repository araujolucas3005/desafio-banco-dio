package me.dio.desafio_banco_dio;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente cliente, Banco banco) {
		super(cliente, banco);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("Extrato conta corrente ***");
		
		super.imprimirInfosComuns();
	}

}
