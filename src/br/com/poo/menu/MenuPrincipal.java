package br.com.poo.menu;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.poo.entidades.Carro;
import br.com.poo.entidades.Pessoa;
import br.com.poo.util.Util;

public class MenuPrincipal {

	private static final Logger customLogger = Util.setupLogger();
	private static List<Carro> carros = new ArrayList<>();
	private static List<Pessoa> pessoas = new ArrayList<>();
	private static final String arquivoCarros = "bancoDeDados.txt";
	private static final String arquivoPessoas = "bancoDeDadosPessoas.txt";

	public static void main(String[] args) {
		carregarDados();
		exibirMenuPrincipal();
	}

	private static void exibirMenuPrincipal() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			customLogger.log(Level.INFO, () -> "Menu Principal:");
			customLogger.log(Level.INFO, () -> "1. Cadastrar Carro");
			customLogger.log(Level.INFO, () -> "2. Cadastrar Pessoa");
			customLogger.log(Level.INFO, () -> "3. Relatório de carros cadastrados (Console)");
			customLogger.log(Level.INFO, () -> "4. Relatório de carros cadastrados (Impresso)");
			customLogger.log(Level.INFO, () -> "5. Relatório de pessoas cadastradas (Console)");
			customLogger.log(Level.INFO, () -> "6. Relatório de pessoas cadastradas (Impresso)");
			customLogger.log(Level.INFO, () -> "7. Sair");
			int opcao = lerOpcao(scanner);

			switch (opcao) {
			case 1:
				cadastrarCarro(scanner);
				break;
			case 2:
				cadastrarPessoa(scanner);
				break;
			case 3:
				relatorioCarrosCadastradosConsole();
				break;
			case 4:
				relatorioCarrosCadastradosArquivo();
				break;
			case 5:
				relatorioPessoasCadastradasConsole();
				break;
			case 6:
				gerarRelatorioPessoasImpresso();
				break;
			case 7:
				salvarDados();
				customLogger.log(Level.INFO, () -> "Saindo do programa. Adeus!");
				return;
			default:
				customLogger.log(Level.INFO, () -> "Opção inválida. Tente novamente.");
			}
		}
	}

	private static int lerOpcao(Scanner scanner) {
		int opcao = -1;

		while (opcao < 1 || opcao > 7) {
			try {
				customLogger.log(Level.INFO, () -> "Escolha uma opção: ");
				opcao = scanner.nextInt();
				scanner.nextLine();
				if (opcao < 1 || opcao > 7) {
					customLogger.log(Level.INFO, () -> "Opção inválida. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				customLogger.log(Level.INFO, () -> "Opção inválida. Tente novamente.");
				scanner.nextLine();
			}
		}

		return opcao;
	}

	private static void carregarDados() {
		carros = lerCarrosDoArquivo(arquivoCarros);
		pessoas = lerPessoasDoArquivo(arquivoPessoas);
	}

	private static void salvarDados() {
		salvarCarrosEmArquivo(arquivoCarros);
		salvarPessoasEmArquivo(arquivoPessoas);
	}

	private static void cadastrarCarro(Scanner scanner) {
		try {
			customLogger.log(Level.INFO, () -> "Modelo do Carro: ");
			String modelo = scanner.nextLine();
			customLogger.log(Level.INFO, () -> "Disponibilidade: ");
			String disponibilidade = scanner.nextLine();
			customLogger.log(Level.INFO, () -> "Marca do Carro: ");
			String marca = scanner.nextLine();
			customLogger.log(Level.INFO, () -> "Placa do Carro: ");
			String placa = scanner.nextLine();
			customLogger.log(Level.INFO, () -> "Cor do Carro: ");
			String cor = scanner.nextLine();
			customLogger.log(Level.INFO, () -> "Preço do Carro: ");
			double preco = scanner.nextDouble();

			Carro carro = new Carro(modelo, disponibilidade, marca, placa, cor, preco);
			carros.add(carro);

			customLogger.log(Level.INFO, () -> "Deseja continuar? (1 - Sim, 2 - Não): ");
			int escolha = scanner.nextInt();
			scanner.nextLine();
			if (escolha == 2) {
				return;
			}

			customLogger.log(Level.INFO, () -> "Carro cadastrado com sucesso!");
		} finally {
		}

	}

	private static void cadastrarPessoa(Scanner scanner) {
		customLogger.log(Level.INFO, () -> "Nome da Pessoa: ");
		String nome = scanner.nextLine();
		customLogger.log(Level.INFO, () -> "Sobrenome da Pessoa: ");
		String sobrenome = scanner.nextLine();
		customLogger.log(Level.INFO, () -> "CPF da Pessoa: ");
		String cpf = scanner.nextLine();
		customLogger.log(Level.INFO, () -> "Contato da Pessoa: ");
		String contato = scanner.nextLine();
		customLogger.log(Level.INFO, () -> "Email da Pessoa: ");
		String email = scanner.nextLine();

		Pessoa pessoa = new Pessoa(nome, sobrenome, cpf, contato, email);
		pessoas.add(pessoa);
		customLogger.log(Level.INFO, () -> "Pessoa cadastrada com sucesso!");

		customLogger.log(Level.INFO, () -> "Deseja continuar? (1 - Sim, 2 - Não): ");
		int escolha = scanner.nextInt();
		scanner.nextLine();
		if (escolha == 2) {
			return;
		}
	}

	private static void relatorioCarrosCadastradosConsole() {
		customLogger.log(Level.INFO, () -> "----- Relatório de Carros Cadastrados -----");
		if (carros.isEmpty()) {
			customLogger.log(Level.INFO, () -> "Nenhum carro cadastrado.");
		} else {
			for (Carro carro : carros) {
				customLogger.log(Level.INFO, () -> carro.toString());
			}
		}
		customLogger.log(Level.INFO, () -> "Total de carros cadastrados: " + carros.size());
	}

	private static void relatorioCarrosCadastradosArquivo() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_carros.txt"))) {
			writer.write("----- Relatório de Carros Cadastrados -----\n");
			if (carros.isEmpty()) {
				writer.write("Nenhum carro cadastrado.\n");
			} else {
				for (Carro carro : carros) {
					writer.write(carro.toString() + "\n");
				}
				writer.write("Total de carros cadastrados: " + carros.size() + "\n");
			}
			customLogger.log(Level.INFO, () -> "Relatório de carros gerado em arquivo com sucesso.");
		} catch (IOException e) {
			customLogger.log(Level.INFO, () -> "Erro ao gerar relatório de carros em arquivo: " + e.getMessage());
		}
	}

	private static void relatorioPessoasCadastradasConsole() {
		customLogger.log(Level.INFO, () -> "----- Relatório de Pessoas Cadastradas -----");
		if (pessoas.isEmpty()) {
			customLogger.log(Level.INFO, () -> "Nenhuma pessoa cadastrada.");
		} else {
			for (Pessoa pessoa : pessoas) {
				customLogger.log(Level.INFO, () -> pessoa.toString());
			}
		}
		customLogger.log(Level.INFO, () -> "Total de pessoas cadastradas: " + pessoas.size());
	}

	private static void gerarRelatorioPessoasImpresso() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("relatorio_pessoas_impresso.txt"))) {
			writer.println("----- Relatório de Pessoas Cadastradas (Impresso) -----");
			if (pessoas.isEmpty()) {
				writer.println("Nenhuma pessoa cadastrada.");
			} else {
				for (Pessoa pessoa : pessoas) {
					writer.println(pessoa.toString());
				}
				writer.println("Total de pessoas cadastradas: " + pessoas.size());
			}
			customLogger.log(Level.INFO, () -> "Relatório de pessoas impresso com sucesso.");
		} catch (IOException e) {
			customLogger.log(Level.INFO, () -> "Erro ao gerar relatório de pessoas impresso: " + e.getMessage());
		}
	}

	public static List<Carro> lerCarrosDoArquivo(String nomeArquivo) {
		List<Carro> carros = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha;
			boolean primeiraLinha = true;
			while ((linha = reader.readLine()) != null) {
				if (primeiraLinha) {
					primeiraLinha = false;
					continue;
				}

				String[] partes = linha.split(",");
				if (partes.length == 6) {
					String modelo = partes[0].trim();
					String disponibilidade = partes[1].trim();
					String marca = partes[2].trim();
					String placa = partes[3].trim();
					String cor = partes[4].trim();
					try {
						double preco = Double.parseDouble(partes[5].trim());
						Carro carro = new Carro(modelo, disponibilidade, marca, placa, cor, preco);
						carros.add(carro);
					} catch (NumberFormatException e) {
						customLogger.log(Level.INFO, () -> "Erro ao converter preço: " + e.getMessage());
					}
				} else {
					customLogger.log(Level.INFO, () -> " ");
				}
			}
		} catch (IOException e) {
			customLogger.log(Level.INFO, () -> "Erro ao ler o arquivo: " + e.getMessage());
		}

		return carros;
	}

	public static List<Pessoa> lerPessoasDoArquivo(String nomeArquivo) {
		List<Pessoa> pessoas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha;
			boolean primeiraLinha = true;
			while ((linha = reader.readLine()) != null) {
				if (primeiraLinha) {
					primeiraLinha = false;
					continue;
				}

				String[] partes = linha.split(",");
				if (partes.length == 5) {
					String nome = partes[0].trim();
					String sobrenome = partes[1].trim();
					String cpf = partes[2].trim();
					String contato = partes[3].trim();
					String email = partes[4].trim();
					Pessoa pessoa = new Pessoa(nome, sobrenome, cpf, contato, email);
					pessoas.add(pessoa);
				} else {
					customLogger.log(Level.INFO, () -> " ");
				}
			}
		} catch (IOException e) {
			customLogger.log(Level.INFO, () -> "Erro ao ler o arquivo: " + e.getMessage());
		}

		return pessoas;
	}

	public static void salvarCarrosEmArquivo(String nomeArquivo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

			writer.write("Modelo,Disponibilidade,Marca,Placa,Cor,Preco");
			writer.newLine();

			for (Carro carro : carros) {
				writer.write(carro.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			customLogger.log(Level.INFO, () -> "Erro ao salvar carros no arquivo: " + e.getMessage());
		}
	}

	public static void salvarPessoasEmArquivo(String nomeArquivo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

			writer.write("Nome,Sobrenome,CPF,Contato,Email");
			writer.newLine();

			for (Pessoa pessoa : pessoas) {
				writer.write(pessoa.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			customLogger.log(Level.INFO, () -> "Erro ao salvar pessoas no arquivo: " + e.getMessage());
		}
	}
}
