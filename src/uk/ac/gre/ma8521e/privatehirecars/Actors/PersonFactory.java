package uk.ac.gre.ma8521e.privatehirecars.Actors;

import java.util.HashMap;

/**
 *
 * @author micael
 */
public class PersonFactory {

    static final HashMap<String, Class> persons = new HashMap<>();

    static {
        persons.put(Driver.class.getSimpleName(), Driver.class);
        persons.put(Passenger.class.getSimpleName(), Passenger.class);
    }

    static public String[] getNames() {
        return persons.keySet().toArray(new String[]{});
    }

    public static PersonI createAccount(String type) {
        try {
            if (persons.containsKey(type)) {
                Class theClass = (Class) persons.get(type);
                return (PersonI) theClass.newInstance();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
