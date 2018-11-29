import java.util.Random;

/**
 * MAPA PROGRAMAÇÃO DE SISTEMAS I: Disponível em https://github.com/KleberBarcarollo/contagem-de-votos-em-java
 * @author Kleber Barcarollo
 *Instituição: UNICESUMAR
 *Curso: Bacharelado em EngenhariA DE Software		
 * @version 1.0.0 
 * 
 */
class Mapa {
    // Aqui fica o número de candidatos
    static final int numeroCandidatos = 6;

    //Aqui fica o Número de eleitores
    static final int numeroEleitores = 10000;
    // Aqui fica os votos por candidato
    static int[] candidatos = new int[numeroCandidatos];

    //Aqui inicializa os votos dos candidatos
     
    static void Inicializar() {
        for (int i = 0; i < numeroCandidatos; i++) {
            candidatos[i] = 0;
        }
    }

    //Aqui gera os votos
   
    static void GerarVotos() {

        // Aqui inicializa o gerador de números randômicos
        Random gerador = new Random();

        // Aqui atribui votos aos candidatos
        for (int i = 0; i < numeroEleitores; i++) {
            candidatos[gerador.nextInt(numeroCandidatos)]++;
        }
    }


    /**
     * Identifica o vencedor ou vencedores da eleição Para verificar mais facilmente
     * um empate, basta usar um número baixo de eleitores, como 10, por exemplo.
     */
    static void IdentificarVencedor() {
        int maxVotos = 0;
        String vencedores = "";
        for (int i = 0; i < numeroCandidatos; i++) {
            System.out.printf("Candidato #%d = %d votos\n", i, candidatos[i]);
            if (candidatos[i] > maxVotos) {
                maxVotos = candidatos[i];
                vencedores = String.valueOf(i);
            } else if (candidatos[i] == maxVotos) {
                vencedores = vencedores + " " + String.valueOf(i);
            }
        }
        if (vencedores.length() == 1) {
            System.out.printf("O candidato %s venceu, com %d votos!\n", vencedores, maxVotos);
        } else {
            System.out.printf("Houve empate entre os candidatos %s, com %d votos cada um!",
                    vencedores.replace(" ", " e "), maxVotos);
        }

    }

    public static void main(String[] args) {
        Inicializar();
        GerarVotos();
        IdentificarVencedor();
    }
}