package Game;

//importa pacote para selecionar palabra aleatoriamente
import java.util.Random;
import java.util.Scanner;

public class Forca {
	// declaração de variaveis global da classe
	public static String[][] dados = new String[51][51];
	public static Scanner ler = new Scanner(System.in);

	// metodo Main para ser executado
	public static void main(String[] args) {

		// chama metodo para caregar a variavel com dados pre setados
		constroiDados();
		// anucia tela inicial
		System.out.println("                  |''''''''''''''''''''''''''| ");
		System.out.println("                  |BEM VINDO AO JOGO DA FORCA| ");
		System.out.println("                  |,,,,,,,,,,,,,,,,,,,,,,,,,,|\n ");
		// chama o metodo que controi o menu
		menu();

	}

	public static void menu() {
		// apresenta enunciado
		System.out.println("Escolha entre uma das opções abaixo:\n");
		System.out.println("	1. Gerenciar Temas.\n	2. Gerenciar Palavras.\n 	3. Jogar.\n	4. Sair.\n");
		System.out.println("Digite um numero de 1 á 4:");
		// recolhe resposta
		int n1 = ler.nextInt();
		// compara a resposta
		switch (n1) {
		case 1:
			// limpa tela com quebras de linha
			tela();
			gerenciarTema();
			break;
		case 2:
			// limpa tela com quebras de linha
			tela();
			gerenciarPalavras();
			break;
		case 3:
			// limpa tela com quebras de linha
			tela();
			tema();
			break;
		case 4:
			System.out.println("Até logo ;D");
			System.exit(0);
			break;
		default:
			System.out.println("==============Operação inválida==============");
			menu();
		}
	}

	public static void gerenciarPalavras() {
		System.out.println("GERENCIADOR DE PALAVRAS\n");
		System.out.println("	1. Cadastrar Palavra.");
		System.out.println("	2. Excluir Palavra.");
		System.out.println("	3. Buscar Palavra.");
		System.out.println("	4. Listar Palavras.\n");

		int opcao;
		do {
			System.out.println("Selecione uma opção ou digite 0 para voltar ao menu principal.\n");
			opcao = ler.nextInt();
		} while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 0 && opcao != 4);
		if (opcao == 0) {
			// limpa tela com quebras de linha
			tela();
			menu();
		} else if (opcao == 1) {
			// limpa tela com quebras de linha
			tela();
			cadastraPalavra();
		} else if (opcao == 2) {
			// limpa tela com quebras de linha
			tela();
			excluiPalavra();
		} else if (opcao == 3) {
			buscaPalavra();
		} else if (opcao == 4) {
			listar();
		}
	}

	private static void listar() {
		System.out.println("LISTAGEM DE PALAVRAS\n");
		System.out.println("Selecione um tema que deseja listar as palavras ou digite 0 para voltar.\n");
		for (int j = 0; j < 51; j++) {
			if (dados[j][0] != null) {
				System.out.println("	" + (j + 1) + ". " + dados[j][0] + ". ");
			}
		}
		System.out.println("\ndigite o numero correspondente ao tema de sua escolha:");
		int n2, n1 = ler.nextInt();
		if (n1 == 0) {
			// limpa tela com quebras de linha
			tela();
			gerenciarPalavras();
		} else if (n1 > 0 && n1 < 52 && dados[n1 - 1][0] != null) {
			System.out.println("\nPalavras em " + dados[n1 - 1][0] + ":\n");
			for (int j = 1; j < 51; j++) {
				if (dados[n1 - 1][j] != null) {
					System.out.println("	" + (j) + ". " + dados[n1 - 1][j] + ". ");
				}
			}
			System.out.println("\ndigite 0 para voltar ou qualquer numero para selecionar outro tema:\n");
			n2 = ler.nextInt();
			if (n2 == 0) {
				// limpa tela com quebras de linha
				tela();
				gerenciarPalavras();
				;
			} else {
				listar();
			}
		} else {
			System.out.println("==============Operação inválida==============");
			listar();
		}

	}

	private static void buscaPalavra() {
		System.out.println("BUSCA DE PALAVRA\n");
		int n1 = 0;
		System.out.println("Digite o tema que deseja buscar:");
		String tema = ler.next();
		for (int j = 0; j < 51; j++) {
			for (int i = 1; i < 51; i++) {
				if (tema.equals(dados[j][i])) {
					// limpa tela com quebras de linha
					tela();
					System.out.println("==============Palavra encontrada no tema  " + (j + 1) + " - " + dados[j][0]
							+ "==============");
					n1 = 1;
					break;
				}
			}
		}
		if (n1 == 0) {
			// limpa tela com quebras de linha
			tela();
			System.out.println("==============Palavra não encontrada==============");
		}
		gerenciarPalavras();
	}

	private static void excluiPalavra() {
		System.out.println("EXCLUSÃO DE PALAVRA\n");
		System.out.println(
				"Selecione um tema que deseja excluir uma palavra ou digite 0 para voltar ao menu principal.\n");
		for (int j = 0; j < 51; j++) {
			if (dados[j][0] != null) {
				System.out.println("	" + (j + 1) + ". " + dados[j][0] + ". ");
			}
		}
		System.out.println("\ndigite o numero correspondente ao tema de sua escolha:");
		int n2, n1 = ler.nextInt();
		if (n1 == 0) {
			// limpa tela com quebras de linha
			tela();
			gerenciarPalavras();
		} else if (n1 > 0 && n1 < 52 && dados[n1 - 1][0] != null) {
			System.out.println("\nPalavras em " + dados[n1 - 1][0] + ".\n");
			for (int j = 1; j < 51; j++) {
				if (dados[n1 - 1][j] != null) {
					System.out.println("	" + (j) + ". " + dados[n1 - 1][j] + ". ");
				}
			}
			System.out.println("\ndigite o numero correspondente a palavra que deseja excluir ou 0 para voltar:");
			n2 = ler.nextInt();
			if (n2 == 0) {
				// limpa tela com quebras de linha
				tela();
				excluiPalavra();
			} else if (n2 > 0 && n2 < 52 && dados[n1 - 1][n2] != null) {
				// limpa tela com quebras de linha
				tela();
				dados[n1 - 1][n2] = null;
				System.out.println("==============Palavra excluida com sucesso!.==============");
				gerenciarPalavras();
			} else {
				System.out.println("==============Operação inválida==============");
				excluiPalavra();
			}
		} else {
			System.out.println("==============Operação inválida==============");
			excluiPalavra();
		}
	}

	private static void cadastraPalavra() {
		System.out.println("CADASTRO DE PALAVRA\n");
		System.out.println(
				"Selecione um tema que deseja cadastrar uma palavra ou digite 0 para voltar ao menu principal.\n");
		for (int j = 0; j < 51; j++) {
			if (dados[j][0] != null) {
				System.out.println("	" + (j + 1) + ". " + dados[j][0] + ". ");
			}
		}
		System.out.println("\ndigite o numero correspondente ao tema de sua escolha:");
		int n2, n1 = ler.nextInt();
		if (n1 == 0) {
			// limpa tela com quebras de linha
			tela();
			gerenciarPalavras();
		} else if (n1 > 0 && n1 < 52 && dados[n1 - 1][0] != null) {
			String palavra;
			do {
				n2 = 1;
				System.out.println(
						"Digite a palavra que deseja cadastrar:\n	Obs:. não pode ser igual a uma já cadastrado.\n");
				palavra = ler.next();
				for (int j = 1; j < 51; j++) {
					if (palavra.equals(dados[n1 - 1][j])) {
						n2 = 0;
					}
				}
			} while (n2 == 0);
			for (int j = 1; j < 51; j++) {
				if (dados[n1 - 1][j] == null) {
					dados[n1 - 1][j] = palavra;
					break;
				}
			}
			// limpa tela com quebras de linha
			tela();
			System.out.println("==============Palavra cadastrada com sucesso!==============");
			gerenciarPalavras();
		} else {
			// limpa tela com quebras de linha
			tela();
			System.out.println("==============Operação inválida==============");
			cadastraPalavra();
		}

	}

	public static void gerenciarTema() {
		System.out.println("GERENCIADOR DE TEMAS\n");
		System.out.println("	1. Cadastrar tema.");
		System.out.println("	2. Excluir tema.");
		System.out.println("	3. Buscar tema.\n");

		int opcao;
		do {
			System.out.println("Selecione uma opção ou digite 0 para voltar ao menu principal.\n");
			opcao = ler.nextInt();
		} while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 0);
		if (opcao == 0) {
			// limpa tela com quebras de linha
			tela();
			menu();
		} else if (opcao == 1) {
			// limpa tela com quebras de linha
			tela();
			cadastraTema();
		} else if (opcao == 2) {
			// limpa tela com quebras de linha
			tela();
			excluiTema();
		} else if (opcao == 3) {
			buscaTema();
		}
	}

	private static void buscaTema() {
		System.out.println("BUSCA DE TEMA\n");
		int n1 = 0;
		System.out.println("Digite o tema que deseja buscar:");
		String tema = ler.next();
		for (int j = 0; j < 51; j++) {
			if (tema.equals(dados[j][0])) {
				// limpa tela com quebras de linha
				tela();
				System.out
						.println("==============Tema " + (j + 1) + " - " + dados[j][0] + " encontrado.==============");
				n1 = 1;
				break;
			}
		}
		if (n1 == 0) {
			// limpa tela com quebras de linha
			tela();
			System.out.println("==============Tema não encontrado==============");
		}
		gerenciarTema();
	}

	private static void excluiTema() {
		System.out.println("EXCLUSÃO DE TEMA\n");
		int n2 = 1;
		for (int j = 0; j < 51; j++) {
			if (dados[j][0] != null) {
				System.out.println("	" + (j + 1) + ". " + dados[j][0] + ". ");
			}
		}
		System.out.println("\ndigite o numero correspondente ao tema que deseja excluir ou 0 para voltar:");
		int n1 = ler.nextInt();
		if (n1 == 0) {
			// limpa tela com quebras de linha
			tela();
			gerenciarTema();
		} else if (n1 > 0 && n1 < 52 && dados[n1 - 1][0] != null) {
			for (int j = 1; j < 51; j++) {
				if (dados[n1 - 1][j] != null) {
					n2 = 0;
					break;
				}
			}
			if (n2 == 0) {
				// limpa tela com quebras de linha
				tela();
				System.out.println(
						"==============Não foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema.==============");
				excluiTema();
			} else {
				// limpa tela com quebras de linha
				tela();
				dados[n1 - 1][0] = null;
				System.out.println("==============Tema excluido com sucesso!==============");
				gerenciarTema();
			}
		} else {
			System.out.println("==============Operação inválida==============");
			excluiTema();
		}

	}

	private static void cadastraTema() {
		System.out.println("CADASTRO DE TEMA\n");
		int n1;
		String tema;
		do {
			n1 = 1;
			System.out
					.println("Digite o tema que deseja cadastrar:\n	Obs:. não pode ser igual a um já cadastrado.\n");
			tema = ler.next();
			for (int j = 0; j < 51; j++) {
				if (tema.equals(dados[j][0])) {
					n1 = 0;
				}
			}
		} while (n1 == 0);
		for (int j = 0; j < 51; j++) {
			if (dados[j][0] == null) {
				dados[j][0] = tema;
				break;
			}
		}
		// limpa tela com quebras de linha
		tela();
		System.out.println("==============Tema cadastrado com sucesso!==============");
		gerenciarTema();

	}

	public static void tema() {

		System.out.println("Selecione um tema para iniciar o ou digite 0 para voltar ao menu principal.\n");
		for (int j = 0; j < 51; j++) {
			if (dados[j][0] != null) {
				System.out.println("	" + (j + 1) + ". " + dados[j][0] + ". ");
			}
		}
		System.out.println("\ndigite o numero correspondente ao tema de sua escolha:");
		int n1 = ler.nextInt();
		if (n1 == 0) {
			// limpa tela com quebras de linha
			tela();
			menu();
		} else if (n1 > 0 && n1 < 52 && dados[n1 - 1][0] != null) {
			// limpa tela com quebras de linha
			tela();
			game(n1 - 1);
		} else {
			System.out.println("==============Operação inválida==============");
			tema();
		}
	}

	public static void game(int t) {
		int n1 = 5, n2 = 0, n3 = 0, n4 = 0;
		char[] pl = sorte(t);
		char[] resp = new char[pl.length];
		char[] letraDigitada = new char[20];
		char le;
		for (int i = 0; i < resp.length; i++) {
			resp[i] = '_';
		}
		while (n1 > 0) {
			n4 = 0;
			apresenta(resp, n1, letraDigitada);
			le = verificaLetra(letraDigitada);
			letraDigitada[n2] = le;
			n2++;
			n3 = 1;
			for (int j = 0; j < pl.length; j++) {
				if (pl[j] == le) {
					n4 = 1;
					resp[j] = le;
				}
				if (resp[j] == '_')
					n3 = 0;
			}
			if (n3 == 1)
				break;
			if (n4 == 0)
				n1--;

		}
		if (n3 == 1) {
			System.out.println("Parabéns! Você acertou a palavra! Deseja jogar novamente?");
			int fica = 0;
			do {
				System.out.println("Digite 1 para sim ou 2 para não:");
				fica = ler.nextInt();
			} while (fica != 1 && fica != 2);
			if (fica == 1) {
				// limpa tela com quebras de linha
				tela();
				tema();
			} else {
				// limpa tela com quebras de linha
				tela();
				menu();
			}
		} else {
			System.out.println("Você perdeu! Deseja Deseja jogar novamente?");
			int fica = 0;
			do {
				System.out.println("Digite 1 para sim ou 2 para não:");
				fica = ler.nextInt();
			} while (fica != 1 && fica != 2);
			if (fica == 1) {
				// limpa tela com quebras de linha
				tela();
				tema();
			} else {
				// limpa tela com quebras de linha
				tela();
				menu();
			}
		}

	}

	// metodo recebe a letra escolhida e verifica se ja tinha sido escolhida
	public static char verificaLetra(char[] le) {
		// ler a letra
		String a1 = ler.next();
		// passa por todas as letras ja escolhidas
		for (int j = 0; j < le.length; j++) {
			// se a letra for repetida pede outra
			if (le[j] == a1.charAt(0)) {
				System.out.println("Tente outra letra!: ");
				verificaLetra(le);
			}
		}
		// reporna a letra
		return a1.charAt(0);
	}

	// Metodo que monta a apresentação do game
	public static void apresenta(char[] resp, int vid, char[] letras) {
		// limpa tela com quebras de linha
		tela();
		System.out.println("	              |'''''''''''''''| ");
		System.out.println("	              | JOGO DA FORCA | ");
		// imprime vidas/jogadas restantes
		System.out.println("	 ______       |,,,,,,,,,,,,,,,|        Vidas: " + vid);
		System.out.println("	|      |");
		System.out.print("	|                       ");
		// imprime letras ja jogadas
		for (int i = 0; i < letras.length; i++) {
			System.out.print(letras[i] + " ");
		}
		System.out.println("\n	|");
		System.out.println("	|");
		System.out.println("	|");
		System.out.print("	| ");
		// imprime resultado das escolhas
		for (int i = 0; i < resp.length; i++) {
			System.out.print(resp[i] + " ");
		}
		System.out.println("	");
		System.out.println("Digite uma letra: ");
	}

	/*
	 * metodo que recebe um inteiro equivalente a um tema, e sorteia um numero
	 * aleatorio que equivale a uma palavra e a retorna em tipo char
	 */
	public static char[] sorte(int t) {
		int n1 = 0, n2;
		// contas quantas palavras estão cadastradas
		for (int j = 1; j < 51; j++) {
			if (dados[t][j] != null) {
				n1++;
			}
		}
		// gera novo objeto de sorteio
		Random gerador = new Random();
		// sorteia
		n2 = gerador.nextInt(n1 - 1);
		n2++;
		n1 = 0;
		// verifica qual foi a palavra sorteada
		for (int j = 1; j < 51; j++) {
			if (dados[t][j] != null) {
				n1++;
				if (n1 == n2) {
					n1 = j;
					break;
				}
			}
		}
		// converte a palavra sorteada String em Char
		char[] palavra = dados[t][n1].toCharArray();
		// retorna a palavra
		return palavra;
	}

	// metodo que imprime quebras de linha para limpar a tela
	public static void tela() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	// metodo que preenche a variavel matrix do tipo String com palavras
	public static void constroiDados() {
		dados[0][0] = "frutas";
		dados[0][1] = "banana";
		dados[0][2] = "abacaxi";
		dados[0][3] = "tomate";
		dados[0][4] = "laranja";
		dados[0][5] = "graviola";
		dados[0][6] = "abacate";
		dados[0][7] = "lichia";
		dados[0][8] = "uva";
		dados[0][9] = "pera";
		dados[0][10] = "manga";
		dados[1][0] = "animais";
		dados[1][1] = "girafa";
		dados[1][2] = "hipopotamo";
		dados[1][3] = "dragao-de-komodo";
		dados[1][4] = "cachorro";
		dados[1][5] = "cobra";
		dados[1][6] = "veado";
		dados[1][7] = "vaca";
		dados[1][8] = "jabuti";
		dados[1][9] = "piriquito";
		dados[1][10] = "condor";
		dados[2][0] = "cores";
		dados[2][1] = "amarelo";
		dados[2][2] = "marrom";
		dados[2][3] = "preto";
		dados[2][4] = "vermelho";
		dados[2][5] = "azul";
		dados[2][6] = "branco";
		dados[2][7] = "verde";
		dados[2][8] = "roxo";
		dados[2][9] = "rosa";
		dados[2][10] = "azul-marinho";
		dados[3][0] = "profissoes";
		dados[3][1] = "cozinheiro";
		dados[3][2] = "professor";
		dados[3][3] = "engenheiro";
		dados[3][4] = "programador";
		dados[3][5] = "encanador";
		dados[3][6] = "fachineiro";
		dados[3][7] = "advogado";
		dados[3][8] = "eletricista";
		dados[3][9] = "motorista";
		dados[3][10] = "presidente";
		dados[4][0] = "esportes";
		dados[4][1] = "futbool";
		dados[4][2] = "corrida";
		dados[4][3] = "volei";
		dados[4][4] = "futsal";
		dados[4][5] = "salto-com-vara";
		dados[4][6] = "luta";
		dados[4][7] = "basquete";
		dados[4][8] = "ciclismo";
		dados[4][9] = "alpinismo";
		dados[4][10] = "ginastica";

	}

}
