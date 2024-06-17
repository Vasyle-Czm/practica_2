import java.text.SimpleDateFormat;
import java.util.Date;

public class Users {
    private String username,nume,prenume,email,parola,creationDate;
    private int raport;
    private boolean activation;
    private static int buget;
    private int subdivision;
    Users(String email,String username,String nume,String prenume,String parola,int subdivision){
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.activation = false;
        this.subdivision = subdivision;
        creationDate = new SimpleDateFormat("dd-MM-yyyy|HH:mm").format(new Date());
    }

    Users(String email,String username,String nume,String prenume, String parola, String creationDate, String activationStatus, int raport, int subdivision){
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.creationDate = creationDate;
        this.subdivision = subdivision;
        
        if(activationStatus.equals("true"))
            this.activation = true;
        else
            this.activation = false;
        this.raport = raport;
    }
    
    public int getSubdivision() {
        return subdivision;
    }
    public static int getBuget() {
        return buget;
    }
    public int getRaport() {
        return raport;
    }
    public boolean getActivation(){
        return activation;
    }
    public String getParola() {
        return parola;
    }
    public String getEmail() {
        return email;
    }
    public String getNume() {
        return nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public String getUsername() {
        return username;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public void setParola(String parola) {
        this.parola = parola;
    }
    public void setActivation(boolean activation) {
        this.activation = activation;
    }
    public void setRaport(int raport) {
        this.raport = raport;
    }
    public static void setBuget(int buget) {
        Users.buget = buget;
    }
    public void setSubdivision(int subdivision) {
        this.subdivision = subdivision;
    }
}
