package com.example.castanedaperdomo.simonseasons;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;

public class Comunicacion2 extends Observable implements Runnable {

    private Socket s;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private boolean conectado = false;

    private static Comunicacion2 ref;

    private Comunicacion2(){
        conectado =  false;
        System.out.println("CREANDO CONEXION");
        Log.e(">>>>>>>>>>>>", "Creando conexion");
    }

    public static Comunicacion2 getRef() { // Comunicacion2.getRef()
        if(ref == null) {
            ref = new Comunicacion2();
            Thread t = new Thread(ref);
            t.start();
        }
        return ref;
    }

    @Override
    public void run() {
        while(true){
            try {
            if(!conectado){
                Log.e(">>>>", "Enviandoo peticion");
                Log.e(">>>>", "IP" + InetAddress.getByName("192.168.43.149") );

                Log.e(">>>>", "Enviando request");
                s = new Socket(InetAddress.getByName("172.30.182.202"),5000);//esto es lo que el usuario debe escribir
                Log.e(">>>>", "Voy a enviar");

                entrada = new DataInputStream(s.getInputStream());
                salida = new DataOutputStream(s.getOutputStream());

                conectado = true;

                Log.e(">>>>", "Voy a enviar");

            }else{
               recibir();
            }
            Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void recibir() throws IOException {
        String mensaje = entrada.readUTF();
        setChanged();
        notifyObservers(mensaje);
        clearChanged();
    }

    public void enviar(final int id) {
        if (s != null & s.isConnected() && salida != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        salida.writeInt(id);
                        Log.e(">>>>>>>>>", "mensaje enviado");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
