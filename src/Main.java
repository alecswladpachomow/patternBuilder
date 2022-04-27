public class Main {

    public static void main(String[] args) throws IllegalStateException {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
                   } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
         //  e.printStackTrace();
        }
        Person man = new PersonBuilder()
                .setName("Сергей")
                .setSurname("Петров")
                .build();

        System.out.println("У "+man+ (man.hasAge()?
                " возвраст известен":" возвраст неизвестен"));
        Person manjung = new PersonBuilder()
                .setName("Пётр")
                .setSurname("Крит")
                .setAge(15)
                .build();
        System.out.print("У "+manjung + " в следующем году будет ");
        manjung.happyBirthday();
        System.out.println(manjung.getAge().getAsInt()+ " лет.");
    }
    }

