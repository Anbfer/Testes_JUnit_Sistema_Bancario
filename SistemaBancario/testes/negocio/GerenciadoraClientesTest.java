package negocio;
/* Teste de Classe Aluno ÂNGELO BARACHO FERREIRA */
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest {
	
	private GerenciadoraClientes gerClientes;
	private int idCliente1 = 1;
	private int idCliente2 = 2;
	private int idCliente3 = 3;
	private int idCliente4 = 4;
	
	@Before
	public void setUp() {
		Cliente cliente1 = new Cliente(idCliente1, "João", 31, "joao@gmail.com", 1, true);
		Cliente cliente2 = new Cliente(idCliente2, "Maria", 34, "maria@gmail.com", 1, true);
		Cliente cliente3 = new Cliente(idCliente3, "Pedro", 66, "pedro@gmail.com", 1, true);
		Cliente cliente4 = new Cliente(idCliente4, "Lucas", 17, "lucas@gmail.com", 1, true);
		
		List<Cliente> clientesBanco = new ArrayList<>();
		
		clientesBanco.add(cliente1);
		clientesBanco.add(cliente2);
		clientesBanco.add(cliente3);
		clientesBanco.add(cliente4);
		
		gerClientes = new GerenciadoraClientes(clientesBanco);
	}
	
	@After
	public void terDown() {
		gerClientes.limpa();
	}
	
	@Test
	public void testePesquisaCli() {
		Cliente cliente = gerClientes.pesquisaCliente(idCliente1);
		
		
		assertThat(cliente.getId(), is(idCliente1));
	}
	
	@Test
	public void testeRemoveCli() {
		boolean clienteRemove = gerClientes.removeCliente(idCliente2);
		
		assertThat(clienteRemove, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(3));
		assertNull(gerClientes.pesquisaCliente(idCliente2));
	}
	
	@Test
	public void testeIdadeCli() {
		
		int idadeCliente = gerClientes.pesquisaCliente(idCliente3).getIdade();
		int idadeCliente2 = gerClientes.pesquisaCliente(idCliente4).getIdade();
		
		assertTrue(idadeCliente > 65);
		assertTrue(idadeCliente > 18);
		assertFalse(idadeCliente < 65);
		assertFalse(idadeCliente < 18);
		
		assertTrue(idadeCliente2 < 18);
		assertTrue(idadeCliente2 < 65);
		assertFalse(idadeCliente2 > 65);
		assertFalse(idadeCliente2 > 18);
		
		
	}

}
