/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.ii;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Itune {

    File file;
    RandomAccessFile codigos;
    RandomAccessFile songs;
    RandomAccessFile download;

    public Itune() throws IOException {
        file = new File("Archivos");
        file.mkdir();

        codigos = new RandomAccessFile(file + "/codigos.itn", "rw");
        songs = new RandomAccessFile(file + "/songs.itn", "rw");
        download = new RandomAccessFile(file + "/downloads.itn", "rw");
        initCodes();
    }

    private void initCodes() throws IOException {
        if (codigos.length() == 0) {
            codigos.writeInt(1);
            codigos.writeInt(1);
        }
    }

    private int getCodigo(long offset) throws IOException {
        codigos.seek(offset);
        int codigos;

        return codigo;
    }

    public void addSong(String name, String author, double price)
            throws IOException {
        songs.seek(songs.length());

        songs.writeUTF(name);
        songs.writeUTF(author);
        songs.writeDouble(price);
    }

}
