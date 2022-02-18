package me.dio.desafio_banco_dio;

public class ContaPoupança extends Conta {
	
	public ContaPoupança(Cliente cliente, Banco banco) {
		super(cliente, banco);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("Extrado conta poupança ***");
		
		super.imprimirInfosComuns();
	}

}
