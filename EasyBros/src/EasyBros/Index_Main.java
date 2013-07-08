package EasyBros;

import Core.Thread_GUI;
import Core.Thread_Sound;
import Core.Thread_USB;
import GUI.GUI;

public class Index_Main{

    public GUI G = new GUI();

    public Index_Main() {
        Thread_Sound TS = new Thread_Sound();
        
        Thread_GUI  TG = new Thread_GUI(G,TS);
        TG.start();
        
        Thread_USB TU = new Thread_USB(TG);
        TU.start();
    }

    
    public static void main(String args[]) {
        Index_Main imple = new Index_Main();
    }
}
