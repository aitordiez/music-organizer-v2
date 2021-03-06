import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
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
     * cadena de b�squeda proporcionada.
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
     * b�squeda.Pruebe tambi�n el m�todo con una cadena de b�squeda que no se 
     * corresponda con ninguno de los nombres de archivo. �Llega a imprimirse
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
     * de todas las canciones de un artista en concreto, una despu�s de otra.
     */
    public void playArtist(String search)
    {
        for(String filename: files){
            if (filename.contains(search)){
                player.playSample(filename);
            }
        }
    }
    
    /**
     * Localizar el �ndice del primer archivo que se corresponde con
     * la cadena de b�squeda indicada.
     * @param searchString la cadena que hay que buscar.
     * @return El �ndice de la primera aparici�n, es decir -1 si
     * no se encuentra ninguna correspondencia.
     */
    public int findFirst(String searchString){
     int index=0;
     //Indicar que vamos a seguir hasta encontrar una correspondencia
     boolean searching=false;
     while(!searching && index < files.size()){
      String filename= files.get(index);
      if(filename.contains(searchString)){
          searching= true;
      }else{
          index++; 
      }
     }
     if (!searching){
         index = -1;
     }
     return index;
    }
    
    /**
     * Escribir un m�todo de modo que el n�mero de archivos se determine una
     * �nica vez y se almacene en una variable local antes de la ejecuci�n del 
     * bucle.Despu�s, utilice en la condici�n del bucle la variable local, en 
     * lugar de invocar size. Compruebe que esta versi�n proporciona los mismos 
     * resultados. Si tiene problemas para completar este ejercicio, prueba a 
     * utilizar el depurador para ver donde est� fallando el programa.
     */
    public int findFirsts(String searchString){
     int index=files.size();
     //Indicar que vamos a seguir hasta encontrar una correspondencia
     int contador=0;
     boolean searching=true;
     while(searching && contador < index){
      String filename= files.get(contador);
      if(filename.contains(searchString)){
          searching= false;
      }else{
          contador++;
      }
     }
     if (searching){
          return -1;
     }
     return contador;
    }
}

    
    