package advancdexercise;

public class PersonDao {

    private Person person;

    public Person getPerson() {
        return person;
    }

    @InjectPerson(name="shaw", age=20)
    public void setPerson(Person person) {
        this.person = person;
    }
}
