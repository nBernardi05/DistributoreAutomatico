package com.bernardisrl.distributoreautomatico;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.bernardisrl.distributoreautomatico.model.Distributore;
import com.bernardisrl.distributoreautomatico.model.Prodotto;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PrimaryController implements Initializable {
    private Distributore d;
    ArrayList<String> cronologia = new ArrayList();
    ArrayList<Button> price = new ArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        d = new Distributore();
        ArrayList<Label> pr = new ArrayList();
        
        pr.add(pr1);
        pr.add(pr2);
        pr.add(pr3);
        pr.add(pr4);
        pr.add(pr5);
        price.add(price1);
        price.add(price2);
        price.add(price3);
        price.add(price4);
        price.add(price5);
        int i=0;
        for(Object p: pr){  // scrive il nome del prodotto nelle label
            ((Label)p).setText(d.getProdotti().get(i).getNome());
            i++;
        }
        i=0;
        checkGiacenza();        // Controlla la giacenza e assegna il prezzo al bottone
        
        
    }
    public void checkGiacenza(){
        int i=0;
        for(Object p: price){
            ((Button)p).setText(d.getProdotti().get(i).getPrezzo() + "");
            if(((Prodotto)(d.getProdotti()).get(i)).getGiacenza() == 0){
                ((Button)p).setDisable(true);
            }
            i++;
        }
    }
    public boolean checkCredito(double c) {
        if(c > d.getCredito())
            return false;
        return true;
    }
    
    
    @FXML
    private Label pr1;

    @FXML
    private Label pr2;

    @FXML
    private Label pr3;

    @FXML
    private Label pr4;

    @FXML
    private Label pr5;
    
    



    
    
    
    public void cambiaDisplay(){
        double credito = d.getCredito();
        if(credito != 0){
            display.setText("CREDITO: " + credito);
        }else{
            display.setText("INSERIRE CREDITO");
        }
    }
    
    public void aggiornaCronologia() {
        String s = "";
        for(int i=0; i<cronologia.size(); i++){
            history.setText(s + "; " + cronologia.get(i));
            s = history.getText();
        }
        checkGiacenza();
    }
    @FXML
    private Button price1;

    @FXML
    private Button price2;

    @FXML
    private Button price3;

    @FXML
    private Button price4;

    @FXML
    private Button price5;
    
    @FXML
    private TextField history;

    
    
    
    @FXML
    public TextField display;
    
    @FXML
    void add1(MouseEvent event) {
        d.addCredito(1);
        cambiaDisplay();
    }

    @FXML
    void add10(MouseEvent event) {
        d.addCredito(0.10f);
        cambiaDisplay();
    }

    @FXML
    void add2(MouseEvent event) {
        d.addCredito(2);
        cambiaDisplay();
    }

    @FXML
    void add20(MouseEvent event) {
        d.addCredito(0.20f);
        cambiaDisplay();
    }

    @FXML
    void add50(MouseEvent event) {
        d.addCredito(0.50f);
        cambiaDisplay();
    }

    @FXML
    void buy1(ActionEvent event) {
        if(!checkCredito(d.getProdotto(0).getPrezzo()))
            return;
        d.erogaProdotto(d.getProdotto(0).getCodice());
        cronologia.add(d.getProdotto(0).getNome());
        cambiaDisplay();
        aggiornaCronologia();
    }

    @FXML
    void buy2(ActionEvent event) {
        if(!checkCredito(d.getProdotto(1).getPrezzo()))
            return;
        d.erogaProdotto(d.getProdotto(1).getCodice());
        cronologia.add(d.getProdotto(1).getNome());
        cambiaDisplay();
        aggiornaCronologia();
    }

    @FXML
    void buy3(ActionEvent event) {
        if(!checkCredito(d.getProdotto(2).getPrezzo()))
            return;
        d.erogaProdotto(d.getProdotto(2).getCodice());
        cronologia.add(d.getProdotto(2).getNome());
        cambiaDisplay();
        aggiornaCronologia();
    }

    @FXML
    void buy4(ActionEvent event) {
        if(!checkCredito(d.getProdotto(3).getPrezzo()))
            return;
        d.erogaProdotto(d.getProdotto(3).getCodice());
        cronologia.add(d.getProdotto(3).getNome());
        cambiaDisplay();
        aggiornaCronologia();
    }

    @FXML
    void buy5(ActionEvent event) {
        if(!checkCredito(d.getProdotto(4).getPrezzo()))
            return;
        d.erogaProdotto(d.getProdotto(4).getCodice());
        cronologia.add(d.getProdotto(4).getNome());
        cambiaDisplay();
        aggiornaCronologia();
    }

}
