package br.com.poo.temp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.poo.entidades.Carro;


public class Relatorio1 {

	public static void salvarCarrosEmArquivo(List<Carro> carros, String nomeArquivo) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
	        for (Carro carro : carros) {
	            
	            String linha = String.format("%s,%s,%s,%s,%s,%.2f%n", 
	                carro.getCarTxModelo(), 
	                carro.getCarTxDisponibilidade(), 
	                carro.getCarTxMarca(), 
	                carro.getCarTxPlaca(), 
	                carro.getCarTxCor(), 
	                carro.getCarTxPreco()
	            );
	            
	            writer.write(linha);
	        }
	        System.out.println("Dados dos carros foram salvos em " + nomeArquivo);
	    } catch (IOException e) {
	        System.err.println("Erro ao salvar os dados dos carros: " + e.getMessage());
	    }
	}

		

	

}
