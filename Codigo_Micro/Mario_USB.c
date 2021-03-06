#include <18F2550.h>
#fuses XTPLL,NOWDT,NOPROTECT,NOLVP,NODEBUG,USBDIV,PLL1,CPUDIV1,VREGEN
#use delay(clock=4000000)
#define USB_HID_DEVICE FALSE
#define USB_EP1_TX_ENABLE USB_ENABLE_BULK
#define USB_EP1_RX_ENABLE USB_ENABLE_BULK
#define USB_EP1_TX_SIZE 32
#define USB_EP1_RX_SIZE 32
#include <pic18_usb.h>
#include "header.h"
#include <usb.c>
#use standard_io(B)

// VARIABLES GLOBALES
const INT8 Lenbuf = 32;
int8 dato[Lenbuf];
char Valor0[1] = "0";
char Valor1[1] = "1";
char Valor2[1] = "2";
char Valor3[1] = "3";
int boton;

// FUNCIONES
int Check_Btns();

void main()
{
   
   delay_ms (100);
   usb_init ();
   usb_task ();
   usb_wait_FOR_enumeration ();
   enable_interrupts (global);
   
   WHILE (TRUE)
   {
      IF (usb_enumerated () )
      {
         IF (usb_kbhit (1))
         {
            usb_get_packet (1, dato, Lenbuf);
            
            IF (dato[0] == 1)
            {
               output_high (PIN_B0);
               
               boton = Check_Btns();
               
               delay_ms (10);
               
               if ( boton == 1){
                 usb_put_packet (1, Valor1, 1, USB_DTS_TOGGLE) ; 
               } else if ( boton == 2){
                 usb_put_packet (1, Valor2, 1, USB_DTS_TOGGLE) ; 
               } else if ( boton == 3){
                 usb_put_packet (1, Valor3, 1, USB_DTS_TOGGLE) ; 
               }else{
                 usb_put_packet (1, Valor0, 1, USB_DTS_TOGGLE) ;  
               }
               
               output_low (PIN_B0);
               
               delay_ms (10);
            }
         }
      }
   }
}


int Check_Btns(){
   int id_btn = 0;
   int i;
   
   for (i = 0; i < 10; i++){
      if ( input(PIN_B1) == 1){
         id_btn = 1;
      }else if ( input(PIN_B2) == 1 ){
         id_btn = 2;
      }else if ( input(PIN_B3) == 1 ){
         id_btn = 3;
      }
   }
   return id_btn;
}


