package Core;

import GUI.GUI;

public class Thread_GUI extends Thread {

    public GUI Ventana = new GUI();
    public Thread_Sound TS = new Thread_Sound();
    public char[] Monedas_Check = {'0', '0', '0', '0', '0', '0','0','0'};
    public int Puntos = 0;

    public Thread_GUI() {
    }

    public Thread_GUI(GUI V, Thread_Sound ts) {
        this.Ventana = V;
        Ventana.setVisible(true);
        this.TS = ts;
        this.TS.start();
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (Exception e) {
            System.out.println("Error en Thread_GUI.Run " + e);
        }
    }

    public void Caminar() {
        try {
            Cambiar_Img(2);
            Thread.sleep(25);
            Mover_Mario();
            Thread.sleep(25);

            Cambiar_Img(3);
            Thread.sleep(25);
            Mover_Mario();
            Thread.sleep(25);

            Cambiar_Img(2);
            Thread.sleep(25);
            Mover_Mario();
            Thread.sleep(25);

            Cambiar_Img(1);
            Thread.sleep(25);
            Mover_Mario();
            Thread.sleep(25);

            Cambiar_Img(0);
        } catch (Exception e) {
            System.out.println("Erro al Intentar Caminar");
        }
    }

    public void Caminar_r() {
        try {
            Cambiar_Img(7);
            Thread.sleep(25);
            Mover_Mario_r();
            Thread.sleep(25);

            Cambiar_Img(8);
            Thread.sleep(25);
            Mover_Mario_r();
            Thread.sleep(25);

            Cambiar_Img(7);
            Thread.sleep(25);
            Mover_Mario_r();
            Thread.sleep(25);

            Cambiar_Img(6);
            Thread.sleep(25);
            Mover_Mario_r();
            Thread.sleep(25);

            Cambiar_Img(5);
        } catch (Exception e) {
            System.out.println("Erro al Intentar Caminar");
        }
    }

    public void Mover_Mario_r() throws InterruptedException {
        int x = Ventana.JL_Mario.getX();
        int y = Ventana.JL_Mario.getY();
        int TipoS = Colision_Check_2(x, y);

        System.out.println("Valor de X = " + x + " Y = " + y + " Tipo = " + TipoS);

        if (TipoS == 1) {
            Ventana.JL_Mario.setLocation(x - 5, y);
        }
    }

    public void Mover_Mario() throws InterruptedException {
        int x = Ventana.JL_Mario.getX();
        int y = Ventana.JL_Mario.getY();
        int TipoS = Colision_Check_2(x, y);

        System.out.println("Valor de X = " + x + " Y = " + y + " Tipo = " + TipoS);

        if (TipoS == 1) {
            Ventana.JL_Mario.setLocation(x + 5, y);
        }
    }

    public void Check_Saltar() {
        int x = Ventana.JL_Mario.getX();
        int y = Ventana.JL_Mario.getY();
        int TipoS = Colision_Check_V(x, y);
        System.out.println("Valor de X = " + x + " Y = " + y + " Tipo = " + TipoS);

        if (TipoS == 1) {
            TS.play_Jump();
            Saltar();
        }
    }

    public int Colision_Check_V(int x, int y) {
        int Check = 1;

        if ((x >= 98 && x <= 185)) {
            Check = 0;
        } else if ((x >= 30 && x <= 70) && (Monedas_Check[0] != 'x')) {
            Check = 2;
            TS.play_Jump();
            Salta_Moneda_1();
            TS.play_Money();
            Ventana.Moneda_1.setVisible(false);
            Salta_Moneda_2();
            Monedas_Check[0] = 'x';
            Puntos ++;
        } else if ((x >= 60 && x <= 90) && (Monedas_Check[1] != 'x')) {
            Check = 2;
            TS.play_Jump();
            Salta_Moneda_1();
            TS.play_Money();
            Ventana.Moneda_2.setVisible(false);
            Salta_Moneda_2();
            Monedas_Check[1] = 'x';
            Puntos ++;
        } else if ((x >= 270 && x <= 300) && (Monedas_Check[6] != 'x')) {
            Check = 2;
            TS.play_Jump();
            Salta_Moneda_1();
            TS.play_Money();
            Ventana.Moneda_8.setVisible(false);
            Salta_Moneda_2();
            Monedas_Check[6] = 'x';
            Puntos ++;
        }else if ((x >= 420 && x <= 455) && (Monedas_Check[7] != 'x')) {
            Check = 2;
            TS.play_Jump();
            Salta_Moneda_1();
            TS.play_Money();
            Ventana.Moneda_7.setVisible(false);
            Salta_Moneda_2();
            Monedas_Check[7] = 'x';
            Puntos ++;
        }else {
            Check = 1;
        }
        return Check;
    }

    public int Colision_Check_2(int x, int y) {
        int Check = 1;

        if ((x >= 165 && x <= 195) && (Monedas_Check[2] != 'x')) {
            Check = 2;
            TS.play_Money();
            Ventana.Moneda_3.setVisible(false);
            Monedas_Check[2] = 'x';
            Puntos ++;
        } else if ((x >= 200 && x <= 230) && (Monedas_Check[3] != 'x')) {
            Check = 2;
            TS.play_Money();
            Ventana.Moneda_4.setVisible(false);
            Monedas_Check[3] = 'x';
            Puntos ++;
        } else if ((x >= 315 && x <= 345) && (Monedas_Check[4] != 'x')) {
            Check = 2;
            TS.play_Money();
            Ventana.Moneda_5.setVisible(false);
            Monedas_Check[4] = 'x';
            Puntos ++;
        } else if ((x >= 350 && x <= 390) && (Monedas_Check[5] != 'x')) {
            Check = 2;
            TS.play_Money();
            Ventana.Moneda_6.setVisible(false);
            Monedas_Check[5] = 'x';
            Puntos ++;
        }
        return Check;
    }

    public void Salta_Moneda_1() {
        try {
            Cambiar_Img(0);
            Thread.sleep(75);
            Cambiar_Img(4);
            Thread.sleep(75);

            for (int i = 0; i < 10; i++) {
                Mover_Saltar(false);
                Thread.sleep(10);
            }
        } catch (Exception e) {
            System.out.println("Erro al Intentar Saltar por Moneda");
        }
    }

    public void Salta_Moneda_2() {
        try {
            Cambiar_Img(0);
            Thread.sleep(75);
            Cambiar_Img(4);
            Thread.sleep(75);

            for (int i = 0; i < 5; i++) {
                Mover_Saltar(false);
                Thread.sleep(10);
            }

            Thread.sleep(100);

            for (int i = 0; i < 15; i++) {
                Mover_Saltar(true);
                Thread.sleep(10);
            }

        } catch (Exception e) {
            System.out.println("Erro al Intentar Saltar por Moneda");
        }
    }

    public void Saltar() {
        try {
            Cambiar_Img(0);
            Thread.sleep(75);
            Cambiar_Img(4);
            Thread.sleep(75);
            for (int i = 0; i < 30; i++) {
                Mover_Saltar(false);
                Thread.sleep(10);
            }
            Thread.sleep(100);
            for (int i = 0; i < 30; i++) {
                Mover_Saltar(true);
                Thread.sleep(10);
            }
            Cambiar_Img(0);
        } catch (Exception e) {
            System.out.println("Erro al Intentar Saltar");
        }
    }

    public void Mover_Saltar(Boolean B) {
        int x = Ventana.JL_Mario.getX();
        int y = Ventana.JL_Mario.getY();
        if (B) {
            Ventana.JL_Mario.setLocation(x, y + 3);
        } else {
            Ventana.JL_Mario.setLocation(x, y - 3);
        }
    }

    public void Cambiar_Img(int histograma) {
        switch (histograma) {
            case 0:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Static.png")));
                break;
            case 1:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Walk_1.png")));
                break;
            case 2:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Walk_2.png")));
                break;
            case 3:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Walk_3.png")));
                break;
            case 4:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Jump.png")));
                break;
            case 5:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Static_r.png")));
                break;
            case 6:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Walk_1_r.png")));
                break;
            case 7:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Walk_2_r.png")));
                break;
            case 8:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Walk_3_r.png")));
                break;
            case 9:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Jump_r.png")));
                break;
            default:
                Ventana.JL_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Static.png")));
                break;
        }
    }
}
