package me.dio.desafio_banco_dio;

import java.util.List;
import java.util.Set;

public interface IBanco {
	
	Set<Cliente> listarClientes();
	
	Set<Cliente> listarClientesComPeloMenosUmaContaAtiva();
	
	List<Conta> listarContasPorStatus(boolean estaAtiva);
	
	void imprimirListaDeClientesAtivos();
	
	void adicionarConta(Conta conta);

}
