/* Trabalho Pr�tico - Sistema de Administra��o de Vendas de M�scaras
*  Programadores: Matheus Ryuji Matsutane
*  Cria��o: 09/12/2020 | �ltima atualiza��o: 15/12/2020
*  */

package ApplicationStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ApplicationStore {

	// C�DIGO PRINCIPAL - main
	// Cria uma flag boolean exitFlag inicialmente falsa, recebe os valores das
	// m�scaras iniciais
	// atrav�s de um vetor masks e ent�o mant�m um loop enquanto a flag com o mesmo
	// valor.
	// True = encerra programa.
	// False = Mant�m o loop.

	public static void main(String[] args) {

		boolean exitFlag = false;

		// Vetor de M�scaras (inclui ID, descri��o em string, pre�o de produ��o, pre�o
		// de vendas)

		Mask[] masks = { new Mask(0, "M�scara Infantil Lisa     ", 5.00f, 8.00f),
				new Mask(1, "M�scara Infantil Estampada", 7.00f, 12.00f),
				new Mask(2, "M�scara Adulto Lisa       ", 8.00f, 13.00f),
				new Mask(3, "M�scara Adulto Estampada  ", 9.00f, 17.00f) };

		// Uso de flag - Determina se o loop de menu da aplica��o continua ou n�o

		while (!exitFlag) {
			exitFlag = mainMenu(masks); // Verifica se return � true ou false
		}

	}

	// M�TODO mainMenu - Menu de Opera��es (inicial)
	// O usu�rio deve escolher a fun��o do menu que deseja.
	// Retorna um valor boolean.
	// True -> Termina o programa. False -> Retorna ao Menu de Opera��es

	public static boolean mainMenu(Mask[] masks) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("----- Selecione a opera��o desejada -----");
		System.out.println("1. Registrar Venda");
		System.out.println("2. Atualizar Estoque");
		System.out.println("3. Atualizar Pre�o de Produ��o");
		System.out.println("4. Atualizar Pre�o de Venda");
		System.out.println("5. Gerar Relat�rio");
		System.out.println("0. Sair \n");

		int operationId = entrada.nextInt(); // Recebe a op��o escolhida pelo usu�rio

		// VERIFICA��O
		// Se a escolha do usu�rio for 0, sai e encerra o programa.
		// Se a escolha do usu�rio for 5, gera o relat�rio.

		if (operationId == 0) {
			return true;
		} else if (operationId == 5) {
			masksReport(masks);
			return false;
		}

		int maskId = maskMenu();

		if (maskId == 0)
			return false;

		// DEFINI��ES DAS FUN��ES DE CADA OP��O DO MENU

		switch (operationId) {
		case 1: {

			// MENU OP��O #1 - Registro de Vendas
			// Recebe do usu�rio a quantidade vendida, atualiza a classe e imprime na tela

			System.out.print("Quantidade vendida: ");
			int quantity = entrada.nextInt();
			System.out.println(masks[maskId - 1].registerDailySale(quantity));
			System.out.println();
			break;
		}
		case 2: {

			// MENU OP��O #2 - Atualiza��o de Estoque
			// Recebe do usu�rio a quantidade em estoque, atualiza a classe e imprime na
			// tela

			System.out.print("Quantidade em estoque: ");
			int quantity = entrada.nextInt();
			System.out.println(masks[maskId - 1].setDailyStock(quantity));
			System.out.println();
			break;

		}
		case 3: {

			// MENU OP��O #3 - Atualiza��o de Pre�o de Produ��o
			// Recebe do usu�rio o pre�o de produ��o, atualiza a classe e imprime na tela

			System.out.print("Pre�o de produ��o: ");
			float price = entrada.nextFloat();
			System.out.println(masks[maskId - 1].setProductionPrice(price));
			System.out.println();
			break;
		}
		case 4: {

			// MENU OP��O #4 - Atualiza��o de Pre�o de Venda
			// Recebe do usu�rio o pre�o de venda, atualiza a classe e imprime na tela

			System.out.print("Pre�o de venda: ");
			float price = entrada.nextFloat();
			System.out.println(masks[maskId - 1].setSalePrice(price));
			System.out.println();
			break;
		}
		}

		return false;
		
	}

	// M�TODO maskMenu - Menu de M�scaras
	// Ap�s a opera��o ser selecionada, o usu�rio deve escolher a m�scara
	// que deseja interagir.
	// Retorna a op��o desejada.

	private static int maskMenu() {

		Scanner entrada = new Scanner(System.in);

		System.out.println("1. M�scara Infantil Lisa");
		System.out.println("2. M�scara Infantil Estampada");
		System.out.println("3. M�scara Adulto Lisa");
		System.out.println("4. M�scara Adulto Estampada");
		System.out.println("0. Retornar \n");

		return entrada.nextInt();

	}

	// M�TODO masksReport - Gera��o de Relat�rios em .TXT
	// Atrav�s do FileWriter, escrever a descri��o, estoque atualizado e vendas
	// atualizadas para cada m�scara no arquivo report.txt.
	// O arquivo ser� salvo no diret�rio ra�z do projeto.
	// Usa try/catch para tratamento de erros b�sico.

	public static void masksReport(Mask[] masks) {
		
		try {
			FileWriter maskReportFile = new FileWriter("report.txt");
			maskReportFile.write("Descri��o                   Estoque   Qte Vendida  Lucro \n");
			for (int i = 0; i < masks.length; i++) {
				maskReportFile.write(masks[i].getDescription() + "     ");
				maskReportFile.write(masks[i].getDailyStock() + "           ");
				maskReportFile.write(masks[i].getDailySale() + "         ");
				float profit = (masks[i].getSalePrice() - masks[i].getProductionPrice()) * masks[i].getDailySale();
				maskReportFile.write(String.valueOf(profit) + "\n");
			}

			maskReportFile.close();
			System.out.println("Relat�rio gerado com sucesso.");
			System.out.println();
		} catch (IOException e) {

			// Ocorrer somente em caso de erros

			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}

/* Trabalho Pr�tico - Sistema de Administra��o de Vendas de M�scaras
*  Programadores: Matheus Ryuji Matsutane
*  Cria��o: 09/12/2020 | �ltima atualiza��o: 15/12/2020
*  */