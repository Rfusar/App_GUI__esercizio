package progetto;

import progetto.componenti.Schermo;
//import progetto.astrazione.Database;


public class Main{

    public static void main(String[] args){ 
    new Schermo().login();
    
        
    /*Database database = new Database();
    try {
        database.createTable();
        database.insert__DB("NomeUtente", "Password123");
    } catch (Exception e) {
        e.printStackTrace();
    }*/
    }
}