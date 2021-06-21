/* Trabalho Prático - Sistema de Administração de Vendas de Máscaras
*  Programadores: Matheus Ryuji Matsutane
*  Criação: 09/12/2020 | Última atualização: 15/12/2020
*  */

package ApplicationStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ApplicationStore {

	// CÓDIGO PRINCIPAL - main
	// Cria uma flag boolean exitFlag inicialmente falsa, recebe os valores das
	// máscaras iniciais
	// através de um vetor masks e então mantém um loop enquanto a flag com o mesmo
	// valor.
	// True = encerra programa.
	// False = Mantém o loop.

	public static void main(String[] args) {

		boolean exitFlag = false;

		// Vetor de Máscaras (inclui ID, descrição em string, preço de produção, preço
		// de vendas)

		Mask[] masks = { new Mask(0, "Máscara Infantil Lisa     ", 5.00f, 8.00f),
				new Mask(1, "Máscara Infantil Estampada", 7.00f, 12.00f),
				new Mask(2, "Máscara Adulto Lisa       ", 8.00f, 13.00f),
				new Mask(3, "Máscara Adulto Estampada  ", 9.00f, 17.00f) };

		// Uso de flag - Determina se o loop de menu da aplicação continua ou não

		while (!exitFlag) {
			exitFlag = mainMenu(masks); // Verifica se return é true ou false
		}

	}

	// MÉTODO mainMenu - Menu de Operações (inicial)
	// O usuário deve escolher a função do menu que deseja.
	// Retorna um valor boolean.
	// True -> Termina o programa. False -> Retorna ao Menu de Operações

	public static boolean mainMenu(Mask[] masks) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("----- Selecione a operação desejada -----");
		System.out.println("1. Registrar Venda");
		System.out.println("2. Atualizar Estoque");
		System.out.println("3. Atualizar Preço de Produção");
		System.out.println("4. Atualizar Preço de Venda");
		System.out.println("5. Gerar Relatório");
		System.out.println("0. Sair \n");

		int operationId = entrada.nextInt(); // Recebe a opção escolhida pelo usuário

		// VERIFICAÇÃO
		// Se a escolha do usuário for 0, sai e encerra o programa.
		// Se a escolha do usuário for 5, gera o relatório.

		if (operationId == 0) {
			return true;
		} else if (operationId == 5) {
			masksReport(masks);
			return false;
		}

		int maskId = maskMenu();

		if (maskId == 0)
			return false;

		// DEFINIÇÕES DAS FUNÇÕES DE CADA OPÇÃO DO MENU

		switch (operationId) {
		case 1: {

			// MENU OPÇÃO #1 - Registro de Vendas
			// Recebe do usuário a quantidade vendida, atualiza a classe e imprime na tela

			System.out.print("Quantidade vendida: ");
			int quantity = entrada.nextInt();
			System.out.println(masks[maskId - 1].registerDailySale(quantity));
			System.out.println();
			break;
		}
		case 2: {

			// MENU OPÇÃO #2 - Atualização de Estoque
			// Recebe do usuário a quantidade em estoque, atualiza a classe e imprime na
			// tela

			System.out.print("Quantidade em estoque: ");
			int quantity = entrada.nextInt();
			System.out.println(masks[maskId - 1].setDailyStock(quantity));
			System.out.println();
			break;

		}
		case 3: {

			// MENU OPÇÃO #3 - Atualização de Preço de Produção
			// Recebe do usuário o preço de produção, atualiza a classe e imprime na tela

			System.out.print("Preço de produção: ");
			float price = entrada.nextFloat();
			System.out.println(masks[maskId - 1].setProductionPrice(price));
			System.out.println();
			break;
		}
		case 4: {

			// MENU OPÇÃO #4 - Atualização de Preço de Venda
			// Recebe do usuário o preço de venda, atualiza a classe e imprime na tela

			System.out.print("Preço de venda: ");
			float price = entrada.nextFloat();
			System.out.println(masks[maskId - 1].setSalePrice(price));
			System.out.println();
			break;
		}
		}

		return false;
		
	}

	// MÉTODO maskMenu - Menu de Máscaras
	// Após a operação ser selecionada, o usuário deve escolher a máscara
	// que deseja interagir.
	// Retorna a opção desejada.

	private static int maskMenu() {

		Scanner entrada = new Scanner(System.in);

		System.out.println("1. Máscara Infantil Lisa");
		System.out.println("2. Máscara Infantil Estampada");
		System.out.println("3. Máscara Adulto Lisa");
		System.out.println("4. Máscara Adulto Estampada");
		System.out.println("0. Retornar \n");

		return entrada.nextInt();

	}

	// MÉTODO masksReport - Geração de Relatórios em .TXT
	// Através do FileWriter, escrever a descrição, estoque atualizado e vendas
	// atualizadas para cada máscara no arquivo report.txt.
	// O arquivo será salvo no diretório raíz do projeto.
	// Usa try/catch para tratamento de erros básico.

	public static void masksReport(Mask[] masks) {
		
		try {
			FileWriter maskReportFile = new FileWriter("report.txt");
			maskReportFile.write("Descrição                   Estoque   Qte Vendida  Lucro \n");
			for (int i = 0; i < masks.length; i++) {
				maskReportFile.write(masks[i].getDescription() + "     ");
				maskReportFile.write(masks[i].getDailyStock() + "           ");
				maskReportFile.write(masks[i].getDailySale() + "         ");
				float profit = (masks[i].getSalePrice() - masks[i].getProductionPrice()) * masks[i].getDailySale();
				maskReportFile.write(String.valueOf(profit) + "\n");
			}

			maskReportFile.close();
			System.out.println("Relatório gerado com sucesso.");
			System.out.println();
		} catch (IOException e) {

			// Ocorrer somente em caso de erros

			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}

/* Trabalho Prático - Sistema de Administração de Vendas de Máscaras
*  Programadores: Matheus Ryuji Matsutane
*  Criação: 09/12/2020 | Última atualização: 15/12/2020
*  */