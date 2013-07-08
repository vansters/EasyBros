package Core;

import jPicUsb.iface;

public class Thread_USB extends Thread {

    public Thread_GUI TG = new Thread_GUI();
    public byte Comando = 1;
    byte[] b_response;
    String s_response;

    public Thread_USB(Thread_GUI tg) {
        this.TG = tg;

        try {
            iface.load();   // CARGAMOS LA LIBRERIA 
        } catch (Exception e) {
            System.out.println("Error al Intentar Cargar USB " + e);
        }
        iface.set_vidpid("id_04d8&pid_000b");
        iface.set_instance(0);
    }

    @Override
    public void run() {
        try {
            while (true) {
                usb_Set(Comando);
                b_response = usb_Get(1);
                s_response = new String(b_response);
                s_response = s_response.trim();

                if (s_response.equals("1")) {
                    TG.Caminar();
                } else if (s_response.equals("2")) {
                    TG.Check_Saltar();
                } else if (s_response.equals("3")) {
                    TG.Caminar_r();
                }
                sleep(25);

                TG.Ventana.JL_Marcador.setText(" " + TG.Puntos);
                if (TG.Puntos == 8) {
                    TG.Ventana.JL_Puff.setText("Yeah Ganaste");
                    Thread.sleep(3000);
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el Thread_USB.Run " + e);
        }
    }

    //  RECIBIR DATOS
    public byte[] usb_Get(int tamano) {
        return iface.QRead(tamano, 100);
    }

    //  ENVIAR DATOS
    public void usb_Set(byte datos) {
        byte[] out = {datos};
        iface.QWrite(out, 1, 100);
    }
}
