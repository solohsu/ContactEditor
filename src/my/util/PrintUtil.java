/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


/**
 *  工具类，用于将 stdout 和 stderr 重定向到JTextArea
 * @author leeing
 */
public class PrintUtil {

    private  static void updateTextArea(final JTextArea textArea,final String text) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                textArea.append(text);
            }
        });
    }

    public  static void redirectSystemStreams(final JTextArea textArea) {
        OutputStream out = new OutputStream() {

            @Override
            public void write(int b) throws IOException {
                updateTextArea(textArea ,String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(textArea,new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }
}
