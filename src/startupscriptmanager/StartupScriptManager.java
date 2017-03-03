
package startupscriptmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartupScriptManager {
    public static String mainScript = "/home/yanano/Documents/Programming/Java/StartupScriptManager/startups.sh";
    public static void main(String[] args) {
        System.out.println("#Starting.");
        ManagerGUI gui = new ManagerGUI();
        System.out.println("#Done.");
    }
    
    /**
     * Adds a script to the master scripts file.
     * @param script 
     */
    public static void addScript(String script){
        ArrayList<String> scripts;
        scripts = new ArrayList<>();
        
        try (FileReader fr = new FileReader(mainScript); BufferedReader br = new BufferedReader(fr)) {
            String line;
            boolean eof = false;
            while(!eof){
                line = br.readLine();
                eof = (line == null);
                if(!eof){
                    scripts.add(line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(StartupScriptManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        scripts.add(script);
        
        try (FileWriter fw = new FileWriter(mainScript); BufferedWriter bw = new BufferedWriter(fw)) {
            for(int i=0;i<scripts.size();i++){
                bw.write(scripts.get(i)+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(StartupScriptManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void gatherSettings(){
        
    }
}