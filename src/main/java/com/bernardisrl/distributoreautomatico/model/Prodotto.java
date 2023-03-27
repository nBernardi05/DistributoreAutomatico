package com.bernardisrl.distributoreautomatico.model;

/**
 *
 * @author nicolabernardi
 */
public class Prodotto {
    private String codice;
    private String nome;
    private float prezzo;
    private int giacenza;

    public Prodotto(String codice, String nome, float prezzo, int giacenza) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.giacenza = giacenza;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
        if(this.giacenza<0){
            this.giacenza=0;
        }
    }
    
}