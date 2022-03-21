/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.ii;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Calendar;

public class Itunes {

   File file = new File("C:\\Users\\xavie\\OneDrive\\Documents\\NetBeansProjects\\Prueba II\\Itunes");
    RandomAccessFile codigos;
    RandomAccessFile songs;
    RandomAccessFile download;

    public Itunes() throws IOException {
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
        {
            codigos.seek(0);
            int cancion = codigos.readInt();
            int descarga = codigos.readInt();
            if (songs.length() != 0) {
                if (offset == 0) {
                    return ++cancion;
                } else if (offset == 4) {
                    return ++descarga;
                }
            } else if (songs.length() != 0 && download.length() == 0) {
                if (offset == 0) {
                    return ++cancion;
                } else if (offset == 4) {
                    return descarga;
                }
            } else {
                if (offset == 0) {
                    return cancion;
                } else if (offset == 4) {
                    return descarga;
                }
            }
            return -1;
        }
    }

    public void addSong(String name, String author, double price) throws IOException {
        {
            codigos.seek(0);
            int cancion = codigos.readInt();
            int descarga = codigos.readInt();
            if (songs.length() != 0) {
                songs.seek(songs.length());
                songs.writeInt(++cancion);
                songs.writeUTF(name);
                songs.writeUTF(author);
                songs.writeDouble(price);
                songs.writeInt(0);
                songs.writeInt(0);
            } else {
                songs.seek(songs.length());
                songs.writeInt(cancion);
                songs.writeUTF(name);
                songs.writeUTF(author);
                songs.writeDouble(price);
                songs.writeInt(0);
                songs.writeInt(0);
            }
            codigos.seek(0);
            codigos.writeInt(++cancion);
            codigos.writeInt(descarga);
        }
   public void reviewSong(int codigos, int stars) throws IOException, IllegalAccessException {
       
        songs.seek(0);
        while(songs.getFilePointer() < songs.length()) {
            int codigos = songs.readInt();
            String nombre = songs.readUTF();
            String cantante = songs.readUTF();
            double precio = songs.readDouble();
            long pos = songs.getFilePointer(); 
            int estrellas = songs.readInt();
            double review = songs.readDouble();
            
            
            if(codigos == codigos) {
                if(stars <= 0 && stars >= 5) {
                    estrellas += stars;
                    review = ++review;
                    songs.seek(pos);
                    songs.writeInt(estrellas);
                    songs.writeDouble(review);
                } else {
                    //Aca debe tirar el exception
                    throw new IllegalAccessException();
                }
            } else System.err.println("No se encontro : "+ codigos);
        } 
    }
     public void downloadSong(int codeSong, String cliente) throws IOException
    {
        codigos.seek(0);
        int cancion = codigos.readInt();
        int descarga = codigos.readInt();
        
        songs.seek(0);
        while(songs.getFilePointer() < songs.length())
        {
            int c = songs.readInt();
            String n = songs.readUTF();
            String ca = songs.readUTF();
            double p = songs.readDouble();
            int s = songs.readInt();
            int r = songs.readInt();
            if (codeSong == c) 
            {
                download.seek(download.length());
                if (download.length() != 0) 
                {
                    download.writeInt(++descarga);
                    download.writeLong(Calendar.getInstance().getTimeInMillis());
                    download.writeInt(c);
                    download.writeUTF(cliente);
                    download.writeDouble(p);
                }
                else
                {
                    download.writeInt(descarga);
                    download.writeLong(Calendar.getInstance().getTimeInMillis());
                    download.writeInt(c);
                    download.writeUTF(cliente);
                    download.writeDouble(p);
                }
                codigos.seek(0);
                codigos.writeInt(cancion);
                codigos.writeInt(++descarga);
                return;
            }
            else
            {
                System.out.println("Código de canción inválido.");
            }
        }
    }
    
    public void songs(String txtFile) throws FileNotFoundException, IOException 
    {

        PrintWriter escritura = new PrintWriter(txtFile);
        escritura.print("");
        escritura.close();

        FileReader canciones = new FileReader(txtFile);
        
        while(songs.getFilePointer()<songs.length()) 
        {
            int c = songs.readInt();
            String n = songs.readUTF();
            String ca = songs.readUTF();
            double p = songs.readDouble();
            double s = songs.readInt();
            int r = songs.readInt();
            
            Double ratingfinal = s/r;

            System.out.println("");
            System.out.println("Codigo: " + c);
            System.out.println("Cantante: " + ca);
            System.out.println("Cantidad de reviews hechas: " + r);
            System.out.println("Precio: " + p);
            System.out.println("Rating: " + ratingfinal);
        }
    }
    public void infoSong(int codeSong) throws IOException
    {
        int des = 0;
        songs.seek(0);
        download.seek(0);
        
        while(songs.getFilePointer() < songs.length())
        {
            int can = songs.readInt();
            String nam = songs.readUTF();
            String cao = songs.readUTF();
            double posi = songs.readDouble();
            int es = songs.readInt();
            int re = songs.readInt();
            if (codeSong == can) 
            {
                download.seek(0);
                while(download.getFilePointer() < download.length())
                {
                    int cano = download.readInt();
                    long dan = download.readLong();
                    int csgo = download.readInt();
                    String col = download.readUTF();
                    double priz = download.readDouble();
                    if (csgo == codeSong) 
                    {
                        des++;
                    }
                }
                System.out.println("Código: " + can + " Nombre:" + nam + " Author: " + cao  
                        + " Precio: " + posi+ " Estrellas recibidas: " + es + "  reviews : " + re + " - Posicion: " + (es/re));
            }
        }
    }

}

