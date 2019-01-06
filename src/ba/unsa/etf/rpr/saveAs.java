package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import net.sf.jasperreports.engine.JRException;

import javax.swing.*;

public class saveAs {
    public ChoiceBox formati;

    public void spremiDugme(ActionEvent actionEvent) throws JRException {
        new GradoviReport().saveAs(formati.getSelectionModel().getSelectedItem().toString());
    }
}
