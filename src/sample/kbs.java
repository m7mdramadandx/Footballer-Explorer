package sample;

import jess.JessException;
import jess.Rete;

import javax.swing.*;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class kbs {

    public static Rete engine;

    public static void queryInferenceEngine(String s) {
        // Create a Jess rule engine
        engine = new Rete();
        try {
            engine.reset();

            StringWriter o = new StringWriter();
            engine.addOutputRouter("t", o);
            String result = "";

            // Load the pricing rules
            engine.batch("sample/rules.clp");
            engine.eval(s);
            engine.run();

            result = o.toString();
            engine.clear();
            if (result != null && result.equals("")) {
                result = "No Rules Matching! Please try again";
            }
            JOptionPane.showMessageDialog(null, result);

        } catch (JessException ex) {
            System.out.println("Errrorr!");
            Logger.getLogger(kbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
