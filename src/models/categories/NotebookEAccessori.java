package src.models.categories;

import src.models.Prodotto;

import javax.swing.*;

public class NotebookEAccessori extends Prodotto {
    private static final long serialVersionUID = 6766098186572259433L;
    private double dimensioneDisplayPollici;
    private final String risoluzione;
    private final boolean touchscreen;
    private final int autonomiaOre;
    private final String cpu;
    private final int ramGB;


    public NotebookEAccessori(String nome, String id, String marca, String categoria, String urlImage, double prezzo, String descrizioneOggetto, double dimensioneDisplayPollici, String risoluzione, boolean touchscreen, int autonomiaOre, String cpu, int ramGB) {
        super(nome, id, marca, categoria, urlImage, prezzo, descrizioneOggetto);

        if (dimensioneDisplayPollici <= 0) {
            throw new IllegalArgumentException("La dimensione del display deve essere maggiore di 0");
        }
        if (risoluzione == null || risoluzione.trim().isEmpty()) {
            throw new IllegalArgumentException("La risoluzione non può essere vuota");
        }
        if (autonomiaOre < 0) {
            throw new IllegalArgumentException("L'autonomia non può essere negativa");
        }
        if (cpu == null || cpu.trim().isEmpty()) {
            throw new IllegalArgumentException("La CPU non può essere vuota");
        }
        if (ramGB <= 0) {
            throw new IllegalArgumentException("La RAM deve essere maggiore di 0");
        }

        this.dimensioneDisplayPollici = dimensioneDisplayPollici;
        this.risoluzione = risoluzione;
        this.touchscreen = touchscreen;
        this.autonomiaOre = autonomiaOre;
        this.cpu = cpu;
        this.ramGB = ramGB;
    }

    public double getDimensioneDisplayPollici() {
        return dimensioneDisplayPollici;
    }

    public void setDimensioneDisplayPollici(double dimensioneDisplayPollici) {
        this.dimensioneDisplayPollici = dimensioneDisplayPollici;
    }

    public String getRisoluzione() {
        return risoluzione;
    }

    public boolean isTouchscreen() {
        return touchscreen;
    }

    public int getAutonomiaOre() {
        return autonomiaOre;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRamGB() {
        return ramGB;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Display: " + dimensioneDisplayPollici + "\"" +
                " | Risoluzione: " + risoluzione +
                " | Touchscreen: " + (touchscreen ? "Sì" : "No") +
                " | Autonomia: " + autonomiaOre + "h" +
                " | CPU: " + cpu +
                " | RAM: " + ramGB + "GB";
    }

}
