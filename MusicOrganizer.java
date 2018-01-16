import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    public void listAllFile(){   
     for(String filename: files){
         System.out.println(filename);
     }
    }
    
    /**
     * Imprimir todos los nombres de los archivos.
     */
    public void listAllFiles(){
     int position=1;   
     for(String filename: files){
         System.out.println(position + "." + filename);
         position++;
     }
    }
    
    /**
     * Enumera los nombres de archivo que se corresponden con la 
     * cadena de búsqueda proporcionada.
     * @param searchString la cadena que hay que buscar.
     */
    public void listMatching(String searchString){
        for(String filename : files){
          if(filename.contains(searchString)){
              //una coincidencia
              System.out.println(filename);
          }
        }
    }
    
      /**
     * Enumera unicamente los archivos que se corresponden con el criterio de
     * búsqueda.Pruebe también el método con una cadena de búsqueda que no se 
     * corresponda con ninguno de los nombres de archivo. ¿Llega a imprimirse
     * algo en este caso?.
     */
    public void listMatchings(String searchString){
        boolean nohayresultado= false;
        for(String filename : files){
            if(filename.contains(searchString)){
                System.out.println(filename);
                nohayresultado=true;
            }
        }
        if(!nohayresultado){
            System.out.println("Error: No se intenta buscar el texto");
        }
        
    }
    
    /**
     * Escriba un metodo en su version del proyecto que reproduzca muestras
     * de todas las canciones de un artista en concreto, una después de otra.
     */
    public void playArtist(String search)
    {
        for(String filename: files){
            if (filename.contains(search)){
                player.playSample(filename);
            }
        }
    }
    
}
    
    