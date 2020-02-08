import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

public class aula1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Alunos aluno1 = new Alunos();
		aluno1.nome = sc.next();
		aluno1.matricula = sc.nextInt();
		aluno1.faltas = sc.nextInt();
		aluno1.nota1 = sc.nextDouble();
		aluno1.nota2 = sc.nextDouble();
		aluno1.nota3 = sc.nextDouble();
		
		double media = aluno1.calcularMedia();
		System.out.println(media);
		
		String aprovacao = aluno1.aprovacao();
		System.out.println(aprovacao);
		
		//Salvando a TAD em arquivo
		File f = new File("Alunos.txt");
		FileWriter imp;
		
		try {
			imp = new FileWriter(f,true);
			imp.write(String.valueOf(media));
			imp.write("\r\n");
			imp.write(String.valueOf(aprovacao));
			imp.write("\r\n");
			imp.close();
		} catch(Exception e) {
			System.out.println("Não foi possível escrever no arquivo.");
		}
	}
	
	public static class Alunos {
		String nome;
		int matricula;
		int faltas;
		double nota1;
		double nota2;
		double nota3;
		
		double calcularMedia() {
			double n = (nota1+nota2+nota3) / 3; 
			return n;
		}
		String aprovacao() {
			boolean resultado = (calcularMedia() >= 6 && faltas < 25);
			if(resultado == true) {
				String aprovado = "Aprovado";
				return aprovado;
			}
			else {
				String reprovado = "Reprovado";
				return reprovado;
				
			}
		}
	}

}