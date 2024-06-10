import java.text.SimpleDateFormat;
import java.util.Date;

public class Users {
    private String username,nume,prenume,email,parola,creationDate;

    Users(String email,String username,String nume,String prenume,String parola){
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        creationDate = new SimpleDateFormat("dd-MM-yyyy|HH:mm").format(new Date());
    }

    Users(String email,String username,String nume,String prenume, String parola, String creationDate){
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.creationDate = creationDate;
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
}
