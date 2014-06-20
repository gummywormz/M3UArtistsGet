/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package m3uartistsget;
import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Gets a list of artists from an m3u file and returns it as a set.
 * @author Paul Alves
 */
public class M3UArtistsGet {

    /**
     * Returns a set of the artist in an m3u file
     * @param f The m3u file to parse
     * @return A Set of artists
     * @throws java.io.FileNotFoundException
     */
    public static ArrayList<String> getArtists(File f) throws FileNotFoundException{
        Set<String> artists = new TreeSet<>();
        BufferedReader in = new BufferedReader(new FileReader(f));
        try {
            String ln1;
            while((ln1 = in.readLine()) != null){
             if(ln1.startsWith("#EXTINF:")){
                String a = ln1.split(",")[1];
                 if(a.contains("-")){
                    a = a.split("-")[0];
                }
                artists.add(a);
                }
            }
            
        } catch (IOException ex) {
            System.out.println("Cannot Access File");
        }
        return new ArrayList<>(artists);
    } 
}
