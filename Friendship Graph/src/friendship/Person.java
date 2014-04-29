package friendship;

/**
 * @author Cameron Pascal
 * @author Ari Shaposhnik
 */
public class Person {

    final String NAME;
    final String SCHOOL;


    public Person(String name, String school) {

        NAME = name.toLowerCase();
        SCHOOL = school.toLowerCase();

    }

    @Override
    public int hashCode() {

        String s = NAME + SCHOOL;

        return s.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Person)) {
            return false;
        }

        Person a = (Person) o;

        if (a.NAME == NAME && a.SCHOOL == SCHOOL) {
            return true;
        }

        return false;
    }
}
