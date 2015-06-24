/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author fernando
 */
public class Time {
    private final HashMap<String, Jogador> jogadores = new HashMap<>();

    public Time() {
    }

    public HashMap<String, Jogador> getJogadores() {
        return jogadores;
    }
    
    public void addJogador(String posicao, Jogador jogador) {
        jogadores.put(posicao, jogador);
    }
    
    public List<Jogador> ordena(JogadorComparator comparator) {
        List<Jogador> list = new ArrayList<>();
        list.addAll(jogadores.values());
        list.sort(comparator);
        return list;
    }
    
}
