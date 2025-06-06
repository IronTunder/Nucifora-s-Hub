package src.controllers;

import src.models.Prodotto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsController {
    private static final String PRODUCTS_FILE = "src/files/products.dat";
    private final List<Prodotto> prodotti = new ArrayList<>();

    public ProductsController() {

    }

    public void salvaProdotti() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(PRODUCTS_FILE))) {
            objectOutputStream.writeObject(prodotti);
            System.out.println("Prodotti salvati: " + prodotti);
        } catch (IOException e) {
            throw new RuntimeException("Errore durante il salvataggio dei prodotti", e);
        }
    }



    public void caricaProdotti() {
        prodotti.clear();
        File file = new File(PRODUCTS_FILE);

        if (!file.exists() || file.length() == 0) {
            System.out.println("File non trovato o vuoto: " + file.getAbsolutePath());
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Prodotto> caricati = (List<Prodotto>) ois.readObject();
            prodotti.addAll(caricati);
            for (Prodotto prodotto : prodotti) {
                System.out.println(prodotto.toString());
            }
        }catch (EOFException e){
            System.out.println("File vuoto");
        }
        catch (ClassNotFoundException | IOException e) {
            System.err.println("Errore durante il caricamento: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public boolean aggiungiProdotto(Prodotto prodotto) {
        if (prodotto == null) {
            return false;
        }
        for (Prodotto p : prodotti) {
            if (p.equals(prodotto)) {
                return false;
            }
        }
        prodotti.add(prodotto);
        return true;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }























}