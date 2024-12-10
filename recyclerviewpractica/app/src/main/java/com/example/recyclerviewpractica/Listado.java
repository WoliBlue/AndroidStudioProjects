package com.example.recyclerviewpractica;

import java.util.ArrayList;

public class Listado {
    private ArrayList<ListaNintendo> datos;

    public Listado() {
        datos = new ArrayList<>();
        datos.add(new ListaNintendo(R.drawable.nes, "NES", "La primera consola de Nintendo, 8 BITS bien aburridos"));
        datos.add(new ListaNintendo(R.drawable.snes, "SNES", "La SUPER nintendo, con juegazos de Kirby"));
        datos.add(new ListaNintendo(R.drawable.n64, "Nintendo 64", "Puedes jugar al Mario 64 y poco más, tampoco es para tanto."));
        datos.add(new ListaNintendo(R.drawable.gamecube, "GameCube", "La CONSOLA CUBO DE NINTENDO"));
        datos.add(new ListaNintendo(R.drawable.wii, "Wii", "Una vez lancé el mando de la wii volando porque no le puse la correa."));
        datos.add(new ListaNintendo(R.drawable.wiiu, "Wii U", "Soy la única persona que conozco que disfrutó de tener una WII U."));
        datos.add(new ListaNintendo(R.drawable.nswitch, "Switch", "Sus joycon se rompen con solo mirarlos, pero al menos tiene el Zelda"));

        datos.add(new ListaNintendo(R.drawable.gameboy, "GameBoy", "Pilas y brillo de pantalla no incluidos ;)"));
        datos.add(new ListaNintendo(R.drawable.gbc, "GameBoy Color", "Pilas no incluidas, pero color sí."));
        datos.add(new ListaNintendo(R.drawable.gba, "GameBoy Advance", "Ahora sí es una portátil decente."));
        datos.add(new ListaNintendo(R.drawable.gbm, "GameBoy Micro", "No cabe en mi mano, ni en ninguna"));
        datos.add(new ListaNintendo(R.drawable.ds, "Nintendo DS", "Sin tarjeta R4 te pierdes lo más divertido."));
        datos.add(new ListaNintendo(R.drawable.tresds, "Nintendo 3DS", "Sin la FREESHOP te pierdes lo más divertido."));
        datos.add(new ListaNintendo(R.drawable.alarmo, "Nintendo Alarmo", "Es un despertador sin juegos."));
    }

    public ArrayList<ListaNintendo> getDatos() {
        return datos;
    }
}
