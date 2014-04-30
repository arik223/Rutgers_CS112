package friendship;

/**
 * Encapsulates the name and school of a person.
 * @author Cameron Pascal
 * @author Ari Shaposhnik
 */
public class Person {

    public final String NAME;
    public final String SCHOOL;


    /**
     * Instantiates a Person with a given name and school.
     * @param name The name of the person.
     * @param school The school the person attends.
     */
    public Person(String name, String school) {

        // We are treating name and school in a case insensitive manner.
        NAME = name.toLowerCase();
        SCHOOL = school.toLowerCase();

    }

    /**
     * Checks if this Person is the same as another Person.
     * @param o The other Person.
     * @return <code>true</code> if the respective NAME and SCHOOL fields are the same; otherwise <code>false</code>.
     */
    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Person)) {
            return false;
        }

        Person a = (Person) o;

        // A Person object is equivalent if it has equivalent NAME and SCHOOL fields.
        return a.NAME.equals(NAME) && a.SCHOOL.equals(SCHOOL);

    }

    @Override
    public int hashCode() {

        // Generate hashcode by concatenating NAME and SCHOOL fields.
        String s = NAME + SCHOOL;

        return s.hashCode();
    }
}
