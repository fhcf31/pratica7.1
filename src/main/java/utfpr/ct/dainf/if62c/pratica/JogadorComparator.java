/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;
import java.util.Comparator;

/**
 *
 * @author fernando
 */
public class JogadorComparator implements Comparator<Jogador> {
    
    private boolean ordNum = true;
    private int multNum = 1, multNome = 1;
    
    public JogadorComparator(){
        
    }
    
    public JogadorComparator(boolean ordNum, boolean numAsc, boolean nomeAsc){
        this.ordNum = ordNum;
        this.multNum = numAsc? 1 : -1;
        this.multNome = nomeAsc? 1 : -1;
    }
    
    public boolean isOrdNum(){
        return ordNum;
    }
    public void setOrdNum(boolean ordNum){
        this.ordNum = ordNum;
    }
    
    public boolean isNumAsc(){
        return multNum == 1;
    }
    public void setNumAsc(boolean numAsc){
        this.multNum = numAsc? 1 : -1;
    }
    
    public boolean getNomeAsc(){
        return multNome == 1;
    }
    public void setNomeAsc(boolean nomeAsc){
        this.multNome = nomeAsc? 1 : -1;
    }
    
    private int comparaNumero(Jogador j1, Jogador j2){
        return multNum * (j1.getNumero() - j2.getNumero());
    }
    private int comparaNome(Jogador j1,Jogador j2){
        return multNome * j1.getNome().compareTo(j2.getNome());
    }
    
    @Override
    public int compare(Jogador j1, Jogador j2){
        int comp;
        if(ordNum){
            comp = comparaNumero(j1,j2);
            if(comp == 0) comp = comparaNome(j1,j2);
        }
        else{
            comp = comparaNome(j1,j2);
            if(comp == 0) comp = comparaNumero(j1,j2);
        }
        return comp;
    }
}
