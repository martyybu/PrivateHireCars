package uk.ac.gre.ma8521e.privatehirecars.Person;

/**
 *
 * @author micael
 */
public class Person {

    private final int PERSON_ID;
    private String firstName;
    private String lastName;
    private int yob;//year of brith
    private boolean male; //true if man

    public Person(Person person1) {
        this.PERSON_ID = person1.getID();
        this.firstName = person1.getFirstName();
        this.lastName = person1.getLastName();
        this.yob = person1.getYearOfBirthday();
        this.male = person1.getGender();
    }

    private Person(int PersonID1, String firstName1, String lastName1, int yob1, boolean gender1) {
        this.PERSON_ID = PersonID1;
        this.firstName = firstName1;
        this.lastName = lastName1;
        this.yob = yob1;
        this.male = gender1;
    }

    /**
     * Get unique ID
     *
     * @return
     */
    public int getID() {
        return this.PERSON_ID;
    }

    /**
     * Returns first Name
     *
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name
     *
     * @return
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the year of birthday
     *
     * @return
     */
    public int getYearOfBirthday() {
        return this.yob;
    }

    /**
     * Returns true if male and false if female
     *
     * @return
     */
    public boolean getGender() {
        return this.male;
    }

    /**
     * Set First Name
     *
     * @param newName
     */
    public void setFirstName(String newName) {
        this.firstName = newName;
    }

    /**
     * Set last name
     *
     * @param newName
     */
    public void setLastName(String newName) {
        this.lastName = newName;
    }

    /**
     * Set year of birth
     *
     * @param newYob
     */
    public void setYearOfBirth(int newYob) {
        this.yob = newYob;
    }

    /**
     * Set gender to true if It is a male and false if it is a woman
     *
     * @param newGender
     */
    public void setGender(boolean newGender) {
        this.male = newGender;
    }

    public static final class Builder {

        private int PersonID;
        private String firstName;
        private String lastName;
        private int yob;//year of brith
        private boolean male; //true if man

        public Builder setID(int newID) {
            this.PersonID = newID;
            return this;
        }

        /**
         * Set First Name
         *
         * @param newName
         * @return
         */
        public Builder setFirstName(String newName) {
            this.firstName = newName;
            return this;
        }

        /**
         * Set last name
         *
         * @param newName
         * @return
         */
        public Builder setLastName(String newName) {
            this.lastName = newName;
            return this;
        }

        /**
         * Set year of birth
         *
         * @param newYob
         * @return
         */
        public Builder setYearOfBirth(int newYob) {
            this.yob = newYob;
            return this;
        }

        /**
         * Set gender to true if It is a male and false if it is a woman
         *
         * @param newGender
         * @return
         */
        public Builder setGender(boolean newGender) {
            this.male = newGender;
            return this;
        }

        public Person build() {
            return new Person(this.PersonID, this.firstName, this.lastName, this.yob, this.male);
        }

    }
}
