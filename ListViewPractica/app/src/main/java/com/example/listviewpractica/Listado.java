package com.example.listviewpractica;

import java.util.ArrayList;

public class Listado {
    private ArrayList<ListaEntrada> datos;

    public Listado() {
        datos = new ArrayList<>();
        datos.add(new ListaEntrada(R.drawable.nes, "NES", "La primera consola de Nintendo, 8 BITS bien aburridos"));
        datos.add(new ListaEntrada(R.drawable.snes, "SNES", "La SUPER nintendo, con juegazos de kirby"));
        datos.add(new ListaEntrada(R.drawable.n64, "Nintendo 64", "Puedes jugar al Mario 64 y poco más, tampoco es para tanto."));
        datos.add(new ListaEntrada(R.drawable.gamecube, "GameCube", "La CONSOLA CUBO DE NINTENDO"));
        datos.add(new ListaEntrada(R.drawable.wii, "Wii", "Una vez lancé el mando de la wii volando porque no le puse la correa. "));
        datos.add(new ListaEntrada(R.drawable.wiiu, "Wii U", "Soy la unica persona que conozco que disfrutó de tener una WII U."));
        datos.add(new ListaEntrada(R.drawable.nswitch, "Switch", "Sus joycon se rompen con solo mirarlos, pero al menos tiene el zelda"));

        datos.add(new ListaEntrada(R.drawable.gameboy, "GameBoy", "Pilas y brillo de pantalla no incluidos ;)"));
        datos.add(new ListaEntrada(R.drawable.gbc, "GameBoy Color", "Pilas no incluidas, pero color si."));
        datos.add(new ListaEntrada(R.drawable.gba, "GameBoy Advance", "Ahora si es una portatil decente."));
        datos.add(new ListaEntrada(R.drawable.gbm, "GameBoy Micro", "No cabe en mi mano, ni en ninguna"));
        datos.add(new ListaEntrada(R.drawable.ds, "Nintendo DS", "Sin tarjeta R4 te pierdes lo más divertido."));
        datos.add(new ListaEntrada(R.drawable.tresds, "Nintendo 3DS", "Sin la FREESHOP te pierdes lo más divertido."));
        datos.add(new ListaEntrada(R.drawable.alarmo, "Nintendo Alarmo", "Es un despertador sin juegos."));


    }

    public ArrayList<ListaEntrada> getDatos() {
        return datos;
    }
}
