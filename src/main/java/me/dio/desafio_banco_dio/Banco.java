package me.dio.desafio_banco_dio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Banco implements IBanco {

	private String nome;
	private List<Conta> contas;
	private double taxaDeTransferencia;

	public Banco(String nome, double taxaDeTransferencia) {
		this.nome = nome;
		this.taxaDeTransferencia = taxaDeTransferencia;
		contas = new ArrayList<>();
	}

	@Override
	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	@Override
	public Set<Cliente> listarClientes() {
		return contas
				.stream()
				.map(Conta::getCliente)
				.collect(Collectors.toSet());
	}
	
	@Override
	public List<Conta> listarContasPorStatus(boolean estaAtiva) {
		return contas
				.stream()
				.filter(conta -> conta.isEstaAtiva() && estaAtiva)
				.collect(Collectors.toList());
	}
	
	@Override
	public Set<Cliente> listarClientesComPeloMenosUmaContaAtiva() {
		return listarContasPorStatus(true)
				.stream()
				.map(Conta::getCliente)
				.collect(Collectors.toSet());
	}
	

	@Override
	public void imprimirListaDeClientesAtivos() {
		Set<Cliente> clientesAtivos = listarClientesComPeloMenosUmaContaAtiva();
		
		if (clientesAtivos.size() == 0) {
			System.out.println("Nenhum cliente ativo no momento.");
			return;
		}
		
		System.out.println("Clientes: ");
		listarClientesComPeloMenosUmaContaAtiva().forEach(cliente -> System.out.println(String.format("\t%s", cliente)));
	}

}
