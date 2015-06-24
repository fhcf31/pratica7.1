/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
import java.util.Collections;
import java.util.List;
import utfpr.ct.dainf.if62c.pratica.Jogador;
import utfpr.ct.dainf.if62c.pratica.JogadorComparator;
import utfpr.ct.dainf.if62c.pratica.Time;


public class Pratica71 {

    public static void main(String[] args) {
        
        Time time = new Time();

        time.addJogador("Lateral direito", new Jogador(4, "Ciclano"));
        time.addJogador("Goleiro", new Jogador(1, "Fulano"));
        time.addJogador("Lateral esquerdo", new Jogador(10, "Beltrano"));
        time.addJogador("Meia direita", new Jogador(4, "Beltrano"));
        time.addJogador("Zagueiro", new Jogador(10, "Mário"));
        time.addJogador("Meia esqueda", new Jogador(7, "José"));

        List<Jogador> jogadores = time.ordena(new JogadorComparator(false, true, true));        
        String format = "%3d %-20s";
        System.out.println("Time ordenado por número (asc) e nome (desc)");
        System.out.println("Num Nome");
        for (Jogador j: jogadores) {
            System.out.println(String.format(format, j.getNumero(), j.getNome()));
        }

        // para buscar por número é necessário reordenar
        JogadorComparator comparador = new JogadorComparator();
        jogadores.sort(comparador);
        System.out.println("Time ordenado por número (asc) e nome (asc)");
        System.out.println("Num Nome");
        for (Jogador j: jogadores) {
            System.out.println(String.format(format, j.getNumero(), j.getNome()));
        }
        int pos = Collections.binarySearch(jogadores, new Jogador(10, "Beltrano"), comparador);
        if (pos >= 0) {
            System.out.print("Jogador encontrado: ");
            System.out.println(jogadores.get(pos));
        } else {
            System.out.println("Jogador não encontrado. Posição: " + (-pos-1));
        }
    }
}
