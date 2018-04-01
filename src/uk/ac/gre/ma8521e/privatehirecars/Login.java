package uk.ac.gre.ma8521e.privatehirecars;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.PersonDaoImpl;

/**
 *
 * @author micae
 */
public class Login {

    String username;
    String password;
    List<String> errorMessage;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public List<String> getMessage(){
        return errorMessage;
    }
    
    public boolean validateLogin() {
        boolean didItWork = false;
        errorMessage = new ArrayList<>();
        Person person = getPerson();
        if (person == null) {
            errorMessage.add("Your username or password are wrong!");
        }else try {
            if (PasswordHash.validatePassword(password, person.getPassword())){
             errorMessage.add("Login was succeful");
             didItWork = true;
            }else{
                errorMessage.add("Your username or password are wrong!");
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return didItWork;
    }
    
    public Person getPerson(){
        return new PersonDaoImpl().getPerson(username);
    }

}
