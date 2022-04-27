import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String city;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;

    }

    public Person(PersonBuilder builder) {
        this.name = builder.getName();
        this.surname = builder.getSurname();
        this.age = builder.getAge();
        this.city = builder.getAddress();
    }


    public boolean hasAge() {
        return (this.age > 0) ? true : false;
    }

    public boolean hasAddress() {
        return this.city != null ? true : false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {
        this.city = address;
    }

    public void happyBirthday() {
        if (getAge().isPresent()) this.age = getAge().getAsInt() + 1;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(getSurname())
                .setAddress(getAddress());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("человек по имени ").append(name)
                .append(",с фамилией  ").append(surname);
        if (hasAge()) builder.append(", возрастом ").append(age);
        if (hasAddress())builder.append(", живущим в ").append(city);
        return builder.toString(); }

    @Override
    public int hashCode() { return Objects.hash(name, surname); }
}
