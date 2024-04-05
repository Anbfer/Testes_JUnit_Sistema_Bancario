package negocio;
/* Teste de Classe Aluno ÂNGELO BARACHO FERREIRA */
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;


public class GerenciadoraContasTest {
	
private GerenciadoraContas gerContas;
private int idConta1 = 1;
private int idConta2 = 2;
private int idConta3 = 3;
private int idConta4 = 4;
private int idConta5 = 5;
private int idConta6 = 6;
private int idConta7 = 7;
private int idConta8 = 8;
	
	@Before
	public void setUp() {
		ContaCorrente conta1 = new ContaCorrente(idConta1, 200, true);
		ContaCorrente conta2 = new ContaCorrente(idConta2, 0, true);
		ContaCorrente conta3 = new ContaCorrente(idConta3, 100, true);
		ContaCorrente conta4 = new ContaCorrente(idConta4, 0, true);
		ContaCorrente conta5 = new ContaCorrente(idConta5, -100, true);
		ContaCorrente conta6 = new ContaCorrente(idConta6, 0, true);
		ContaCorrente conta7 = new ContaCorrente(idConta7, -100, true);
		ContaCorrente conta8 = new ContaCorrente(idConta8, -100, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta1);
		contasDoBanco.add(conta2);
		contasDoBanco.add(conta3);
		contasDoBanco.add(conta4);
		contasDoBanco.add(conta5);
		contasDoBanco.add(conta6);
		contasDoBanco.add(conta7);
		contasDoBanco.add(conta8);
		
		
		gerContas = new GerenciadoraContas(contasDoBanco);
	}
	
	@Test
	public void testSaldoSuficienteAmbasContas() {
		assertThat(gerContas.pesquisaConta(idConta1).getSaldo(), is (200.0));
		assertThat(gerContas.pesquisaConta(idConta2).getSaldo(), is (0.0));
		
		boolean sucesso = gerContas.transfereValor(idConta1, 100, idConta2);
		assertTrue(sucesso);
		assertThat(gerContas.pesquisaConta(idConta1).getSaldo(), is(100.0));
		assertThat(gerContas.pesquisaConta(idConta2).getSaldo(), is (100.0));

	}
	
	@Test
	public void testSaldoInsuficientePositivoConta3() {
		
		assertThat(gerContas.pesquisaConta(idConta3).getSaldo(), is (100.0));
		assertThat(gerContas.pesquisaConta(idConta4).getSaldo(), is (0.0));
		
		boolean sucesso = gerContas.transfereValor(idConta3, 200, idConta4);
		assertTrue(sucesso);
		assertThat(gerContas.pesquisaConta(idConta3).getSaldo(), is (-100.0));
		assertThat(gerContas.pesquisaConta(idConta4).getSaldo(), is (200.0));
	}
	
	
	@Test
	public void testSaldoInsuficienteNegativoConta5() {
		assertThat(gerContas.pesquisaConta(idConta5).getSaldo(), is (-100.0));
		assertThat(gerContas.pesquisaConta(idConta6).getSaldo(), is (0.0));
		
		boolean sucesso = gerContas.transfereValor(idConta5, 200, idConta6);
		assertTrue(sucesso);
		assertThat(gerContas.pesquisaConta(idConta5).getSaldo(), is (-300.0));
		assertThat(gerContas.pesquisaConta(idConta6).getSaldo(), is (200.0));
	}
	
	@Test
	public void testSaldoInsuficienteAmbasContas() {
		assertThat(gerContas.pesquisaConta(idConta7).getSaldo(), is (-100.0));
		assertThat(gerContas.pesquisaConta(idConta8).getSaldo(), is (-100.0));
		
		boolean sucesso = gerContas.transfereValor(idConta7, 200, idConta8);
		assertTrue(sucesso);
		assertThat(gerContas.pesquisaConta(idConta7).getSaldo(), is (-300.0));
		assertThat(gerContas.pesquisaConta(idConta8).getSaldo(), is (100.0));
	}
}
