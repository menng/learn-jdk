package demo.stream;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<Integer> o = Optional.ofNullable(null);
        System.out.println(o.isPresent());
        System.out.println(o.orElse(1));

//        Optional<Integer> onull = Optional.of(null);

        User userN = new User("name", "123@gmail.com");

        Optional<User> opt = Optional.ofNullable(userN);
        opt.ifPresent(user -> printUser(user, "s"));

        User userNull = null;
        User user = Optional.ofNullable(userNull).orElse(userN);
        User user1 = Optional.ofNullable(userNull).orElseGet(() -> userN);
        System.out.println(user.getName());
        System.out.println(user1.getName());

        System.out.println("Using orElse");
        Optional.ofNullable(userN).orElse(createuser());
        System.out.println("Using orElseGet");
        Optional.ofNullable(userN).orElseGet(() -> createuser());
//        Optional.ofNullable(null).orElseThrow(() -> new RuntimeException("ss"));

        User map = new User("name-map", null);
        String s = Optional.ofNullable(map).map(User::getEmail).orElse("email@123.com");
        System.out.println(s);
        User flatmap = new User("name-flatmap", "nul@l");
        String s1 = Optional.ofNullable(flatmap).flatMap(User::getOptionalEmail).orElse("flat-email@123.com");
        System.out.println(s1);
        Optional<User> user3 = Optional.ofNullable(flatmap).filter(user2 -> user2.getEmail() != null && user2.getEmail().contains("@"));
        System.out.println(user3.isPresent());

        Consumer<String> ss = System.out::println;
        ss.accept("dd");


        Country country = new Country();
        Address address = new Address();
        address.setCountry(country);
        People people = new People();
        people.setAddress(address);
        String sss = Optional.ofNullable(people)
                .map(People::getAddress)
                .map(Address::getCountry)
                .map(Country::getIsocode)
                .orElse("sss");
        System.out.println(sss);
    }


    private static User createuser() {
        System.out.println("create user");
        return new User();
    }

    private static void printUser(User user, String abc) {
        System.out.println(abc);
        System.out.println(user.getEmail());

    }
}

class User {
    private String name;
    private String email;

    public User(){}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public Optional<String> getOptionalEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


class People {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

class Country {
    private String isocode;

    public String getIsocode() {
        return isocode;
    }

    public void setIsocode(String isocode) {
        this.isocode = isocode;
    }
}