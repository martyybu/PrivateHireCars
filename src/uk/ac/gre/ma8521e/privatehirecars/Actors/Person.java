package uk.ac.gre.ma8521e.privatehirecars.Actors;

/**
 *
 * @author micael
 */
public class Person {

    private final String PERSON_ID;
    private String firstName;
    private String password;
    private String lastName;
    private String phoneNumber;
    private int yob;//year of brith
    private boolean male; //true if man

    public Person(Person person1) {
        this.PERSON_ID = person1.getID();
        this.firstName = person1.getFirstName();
        this.phoneNumber = person1.getPhoneNumber();
        this.password = person1.getPassword();
        this.lastName = person1.getLastName();
        this.yob = person1.getYearOfBirthday();
        this.male = person1.getGender();
    }

    private Person(String PersonID1, String password, String firstName1, String lastName1, int yob1, boolean gender1, String phoneNumber1) {
        this.PERSON_ID = PersonID1;
        this.password = password;
        this.phoneNumber = phoneNumber1;
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
    public String getID() {
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
     * returns passenger phonenumber
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
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
    public Boolean getGender() {
        return this.male;
    }

    public String getPassword() {
        return this.password;
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

    public void setPhoneNumber(String no) {
        this.phoneNumber = no;
    }

    /**
     * Set gender to true if It is a male and false if it is a woman
     *
     * @param newGender
     */
    public void setGender(boolean newGender) {
        this.male = newGender;
    }

    @Override
    public String toString() {
        return "ID: " + this.PERSON_ID + " , FirstName: " + getFirstName() + " , LastName: " + getLastName() + " ,Year of Birth:" + this.getYearOfBirthday() + " ,Gender:" + getGender();
    }

    public static final class Builder {

        private String PersonID;
        private String password;
        private String firstName;
        private String lastName;
        private int yob;//year of brith
        private String phoneNumber;
        private boolean male; //true if man

        public Builder setID(String newID) {
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

        public Builder setPhoneNumber(String no){
            this.phoneNumber=no;
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

        public Builder setPassword(String password) {
            this.password = password;
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
        public Builder setGender(Boolean newGender) {
            this.male = newGender;
            return this;
        }

        public Person build() {
            return new Person(this.PersonID, this.password, this.firstName, this.lastName, this.yob, this.male,this.phoneNumber);
        }

    }
}
