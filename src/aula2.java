import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class aula2 {

	public static void main(String[] args) throws Exception {

		// Abre o arquivo original para exibir o conteudo e recuperar a quantidade de
		// linhas
		LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream("C://test.txt")));
		String nextLine = null;

		try {
			// Exibe o conteudo do arquivo
			while ((nextLine = lineCounter.readLine()) != null) {
				System.out.println(nextLine);
			}
			// Pega a quantidade de linhas
			int qtde_linha = lineCounter.getLineNumber();
			System.out.println("Total de linhas no arquivo." + qtde_linha);

			// Abre novamente o arquivo original para realizar a copia
			LineNumberReader lineCounter2 = new LineNumberReader(
					new InputStreamReader(new FileInputStream("C://test.txt")));
			String nextLine2 = null;

			// Cria o arquivo copia
			File f = new File("C://aluno-copia.txt");
			FileWriter imprimir;
			imprimir = new FileWriter(f, false);
			String novoConteudo = "";
			// Realiza a copia do conteudo, menos a ultima linha
			while ((nextLine2 = lineCounter2.readLine()) != null) {
				imprimir.write(nextLine2 + "\r\n");
				novoConteudo += nextLine2 + "\r\n";
				if (lineCounter2.getLineNumber() + 1 == qtde_linha)
					break;
			}
			imprimir.close();

			// Sobrescreve o arquivo original pela copia
			File f2 = new File("C://test.txt");
			FileWriter imp2 = new FileWriter(f2, false);
			imp2.write(novoConteudo);
			imp2.close();

		} catch (Exception done) {
			done.printStackTrace();
		}
	}
}
