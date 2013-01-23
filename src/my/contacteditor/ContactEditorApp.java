/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 *
 * @author xsl
 */
public class ContactEditorApp extends SingleFrameApplication{

    @Override
    protected void startup() {
        show(new ContactEditorUI());
    }
    
    public ContactEditorApp getApplication(){
        return Application.getInstance(ContactEditorApp.class);
    }
    
    public static void main(String[] args){
        launch(ContactEditorApp.class, args);
    }
}
