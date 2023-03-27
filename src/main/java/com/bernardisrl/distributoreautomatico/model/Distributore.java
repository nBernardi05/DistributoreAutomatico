/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bernardisrl.distributoreautomatico.model;

import java.util.ArrayList;

/**
 *
 * @author nicolabernardi
 */
public class Distributore {
    private ArrayList<Prodotto> prodotti;
    private float credito;
    private String msgDisplay; 

    public Distributore() {
        msgDisplay="";
        prodotti = new ArrayList<>();
        caricaProdotti();
    }
    private void caricaProdotti(){
        prodotti.add(new Prodotto("P001", "Acqua naturale", .80f, 0));
        prodotti.add(new Prodotto("P002", "Tramezzino", 2.20f, 1));
        prodotti.add(new Prodotto("P003", "Pizzetta", 3.80f, 5));
        prodotti.add(new Prodotto("P004", "Bicchiere di Champagne", 5.60f, 6));
        prodotti.add(new Prodotto("P005", "Brasilena", 1.10f, 3));
    }
    
    public void addCredito(float aggiunta){
        credito+=aggiunta;
    }
    public void azzeraCredito(){
        credito = 0;
    }
    public void decurtaCredito(float importo){
        credito-=importo;
    }
    /**
     * Aggiunge algebricamente l'importo al credito
     * @param importo valore da aggiungere algebricamente al credito
     */
    public void modificaCredito(float importo){
        credito+=importo;
        if(credito<0){
            credito=0;
        }
    }
    public void erogaProdotto(String codiceProdotto){
        Prodotto p = cercaProdotto(codiceProdotto);
        p.setGiacenza(p.getGiacenza()-1);
        modificaCredito(p.getPrezzo()*-1);
    }
    /**
     * Restituisce il prodotto con codice passato in input.
     * Se non esiste nessun prodotto con il codice passato in input,
     * restituisce null
     * @param codiceProdotto
     * @return 
     */
    private Prodotto cercaProdotto(String codiceProdotto){
        for(Prodotto p: prodotti){
            if(codiceProdotto.equals(p.getCodice())){
                return p;
            }
        }
        return null;
    }

    public ArrayList<Prodotto> getProdotti() {
        return prodotti;
    }
    
    public Prodotto getProdotto(int i) {
        return prodotti.get(i);
    }

    public float getCredito() {
        return credito;
    }

    public String getMsgDisplay() {
        return msgDisplay;
    }
    
    
}

