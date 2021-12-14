package Utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class FakeData {

    public static String generateEmailAddress(){
        Faker faker=new Faker();
       String emailAddress= faker.internet().emailAddress();
       return emailAddress;
    }
    public static String generatePreferedStore(){
        Faker faker=new Faker();
       String load= faker.number().digits(3);
        return load;
    }
    public static String generateCustomerId(){
        Faker faker=new Faker();

        String pin= faker.number().digits(2);
        return pin;
    }
    public static String generateEmail(){
        Faker faker=new Faker();
        String email= faker.internet().emailAddress();
        return email;
    }

    public static String generateDuplicateEmail(){
        Faker faker=new Faker();
        String email= "vijayb@gmail.com";
        return email;
    }
    public static String generatePersonalMessage() {
        Faker faker = new Faker();
        String permessage = faker.lorem().sentence(7);
        return permessage;
    }
    public static String generateBrand() {
        Faker faker = new Faker();
        String brand = "twl";
        return brand;
    }
    public static String generateName() {
        Faker faker = new Faker();
        String fname = faker.name().firstName();
        return fname;
    }

    public static String generateLastName() {
        Faker faker = new Faker();
        String fname = faker.name().lastName();
        return fname;
    }
    public static String generateRandomToken() {
        Faker faker = new Faker();
        String token = "dqwe32";
        return token;
    }
        public static String generateorderNumber(){
            Faker faker=new Faker();

            Integer ordernum=  faker.number().numberBetween(1000000000,1899999999);
            String order=ordernum.toString();
            return order;
    }
    public static String generatePassword() {
        Faker faker = new Faker();


        String password = faker.numerify("ldkb#lnd#lkd#jt###ffr####");
        
        return password;
    }
    public static String generateStatus() {
        Faker faker = new Faker();

        String status = "New";
        return status;
    }

    public static String generatePurchaserID(){

        Random random = new Random();
        int number = random.nextInt(999999999);

        return String.format("%09d", number);
    }


}
