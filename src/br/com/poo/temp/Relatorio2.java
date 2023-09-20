package br.com.poo.temp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.poo.entidades.Pessoa;

public class Relatorio2 {
	public static void salvarPessoasEmArquivo(List<Pessoa> pessoas, String nomeArquivo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
			for (Pessoa pessoa : pessoas) {
				
				String linha = String.format("%s,%s,%s,%s,%s%n", pessoa.getPesTxNome(), pessoa.getPesTxSobrenome(),
						pessoa.getPesTxCpf(), pessoa.getPesTxContato(), pessoa.getPesTxEmail());
				
				writer.write(linha);
			}
			System.out.println("Dados das pessoas foram salvos em " + nomeArquivo);
		} catch (IOException e) {
			System.err.println("Erro ao salvar os dados das pessoas: " + e.getMessage());
		}
	}
}