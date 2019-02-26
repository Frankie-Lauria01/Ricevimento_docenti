/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentodocenti;

/**
 *
 * @author lauria_francesco
 */
public class Prof {
    public String ID;
    public String nome;
    public String giorno;
    public int ora;
    public String note;
    
    public Prof(String ID, String nome, String giorno, int ora, String note){
        this.ID=ID;
        this.nome=nome;
        this.giorno=giorno;
        this.ora=ora;
        this.note=note;
    }
    
    public String to_string(){
        String s;
        s= nome+" riceve "+giorno+" alla "+ora+" ora;"+note;
        return s;
    }
    
    
}
