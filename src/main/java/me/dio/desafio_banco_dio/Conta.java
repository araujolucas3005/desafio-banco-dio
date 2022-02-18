package me.dio.desafio_banco_dio;

import java.util.Date;

import lombok.Data;

@Data
public abstract class Conta implements IConta {
	
	private int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;
	private Banco banco;
	private Date dataDeCriacao;
	private Date dataDeDelecao;
	private boolean estaAtiva;

	public Conta(Cliente cliente, Banco banco) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.banco = banco;
		this.banco.adicionarConta(this);
		this.dataDeCriacao = new Date();
		this.estaAtiva = true;
	}
	
	@Override
	public void sacar(double valor) {
		if (saldo - valor < 0) return;
		
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		double valorFinal = valor;
		
		if (contaDestino.getBanco() != banco) {
			valorFinal += banco.getTaxaDeTransferencia();
		}
		
		if (saldo - valorFinal < 0) return;
		
		sacar(valorFinal);
		contaDestino.depositar(valor);
	}
	
	@Override
	public void desativar() {
		if (!estaAtiva) return;
		
		dataDeDelecao = new Date();
		estaAtiva = false;
	}
	
	@Override
	public void restaurar() {
		estaAtiva = true;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", cliente.getNome()));
		System.out.println(String.format("Agencia: %d", agencia));
		System.out.println(String.format("Numero: %d", numero));
		System.out.println(String.format("Saldo: %.2f", saldo));
	}
	
}
