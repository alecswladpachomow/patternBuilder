public class PersonBuilder {
    private String name = "non";
    private String surname = "non";
    private int age;
    private String address;


    public String getName() {

        return name;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {

        return surname;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст недопустимый.");
        }
        this.age = age;

        return this;
    }

    public String getAddress() {
        return address;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {

            throw new IllegalArgumentException("Не хватает обязательных полей имя и фамилия.");
        }
        return new Person(this);

    }


}
