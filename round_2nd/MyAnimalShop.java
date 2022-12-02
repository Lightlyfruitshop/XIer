package round_2nd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyAnimalShop implements AnimalShop {
    private double balance;
    private double profit = 0;
    private boolean inBusiness;
    private ArrayList<Pet> animals = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Boolean> comingCustomer = new ArrayList<>();
    private Pattern raceDog = Pattern.compile("^(?i)dog$");
    private Pattern raceCat = Pattern.compile("^(?i)cat$");
    private Pattern raceBird = Pattern.compile("^(?i)bird$");

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public boolean isInBusiness() {
        return inBusiness;
    }

    public void setInBusiness(boolean inBusiness) {
        this.inBusiness = inBusiness;
    }

    public ArrayList<Pet> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Pet> animals) {
        this.animals = animals;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Boolean> getComingCustomer() {
        return comingCustomer;
    }

    public void setComingCustomer(ArrayList<Boolean> comingCustomer) {
        this.comingCustomer = comingCustomer;
    }

    @Override
    public void buyAnimal(String name, int age, String gender, double price, String race) {
        Scanner scn = new Scanner(System.in);

        if (raceDog.matcher(race).matches()) {
            try {
                if (getBalance() < 100) {
                    throw new InsufficientBalanceException("Out of balance!");
                } else {
                    Dog dog;

                    dogCreate:
                    while (true) {
                        System.out.println("Is dog injected vaccine?\nY/N");
                        switch (scn.next()) {
                            case "Y":
                            case "y":
                                dog = new Dog(name, age, gender, true);
                                break dogCreate;
                            case "N":
                            case "n":
                                dog = new Dog(name, age, gender, false);
                                break dogCreate;
                            default:
                                System.out.println("Error enter");

                        }

                    }
                    setBalance(getBalance() - 100);
                    setProfit(getProfit() - 100);
                    animals.add(dog);
                }
            } catch (InsufficientBalanceException e) {
                e.printStackTrace();
            }


        } else if (raceCat.matcher(race).matches()) {
            try {
                if (getBalance() < 200) {
                    throw new InsufficientBalanceException("Out of balance!");
                } else {
                    Cat cat = new Cat(name, age, gender);
                    setBalance(getBalance() - 200);
                    setProfit(getProfit() - 200);
                    animals.add(cat);
                }
            } catch (InsufficientBalanceException e) {
                e.printStackTrace();
            }
        } else if (raceBird.matcher(race).matches()) {
            try {
                if (getBalance() < price) {
                    throw new InsufficientBalanceException("Out of balance!");
                } else {
                    System.out.println("Please enter the species");
                    Bird bird = new Bird(name, age, gender, price, scn.next());
                    animals.add(bird);
                    setBalance(getBalance() - price);
                    setProfit(getProfit() - price);
                }
            } catch (InsufficientBalanceException e) {
                e.printStackTrace();
            }
        } else System.out.println("No this race");
    }

    @Override
    public void entertainCustomer(String name, boolean isNew) {

        if (isNew) {
            Customer customer = new Customer(name, LocalDate.now());
            customers.add(customer);
            comingCustomer.add(true);

        } else {
            boolean noMatch = true;
            Scanner scn = new Scanner(System.in);//用arraylist就直接靠名字来认人感觉这样更直观，只要不重名就行，要不行就用下标来当主键
            for (int i = 0; i < customers.size(); i++) {
                if (name.equals(customers.get(i).getName())) {
                    customers.get(i).setTimes(customers.get(i).getTimes() + 1);
                    customers.get(i).setLastComeTime(LocalDate.now());
                    comingCustomer.set(i, true);
                    noMatch = false;

                }
            }
            if (noMatch) {
                System.out.println("No this guy");
                return;
            }
        }

        try {
            if (animals.size() == 0) {
                throw new AnimalNotFoundException("No Animal in the shop!");
            }
            for (int i = 0; i < getAnimals().size(); i++) {
                System.out.println(i + "/n" + getAnimals().get(i));
            }
            System.out.println("Sell which one. Please enter the code");
            Scanner scn = new Scanner(System.in);
            int set = scn.nextInt();
            System.out.println(animals.get(set).toString());
            profit += animals.get(set).getPrice();
            balance += animals.get(set).getPrice();
            animals.remove(set);
        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void outOfBusiness() {

        if (LocalTime.now().isAfter(LocalTime.parse("18:00:00"))) {//设了6点关店
            setInBusiness(false);

            System.out.println("Today's customers:");

            for (int i = 0; i < customers.size(); i++) {
                if (comingCustomer.get(i)) {
                    System.out.println(customers);
                    comingCustomer.set(i, false);
                }
            }
            System.out.println("Today's profit is " + getProfit());
            setProfit(0);
            for (int i = 0; i < customers.size(); i++) {
                comingCustomer.set(i, false);
            }

        }
    }
}

class InsufficientBalanceException extends RuntimeException {
    InsufficientBalanceException(String s) {
        super(s);
    }
}

class AnimalNotFoundException extends RuntimeException {
    AnimalNotFoundException(String s) {
        super(s);
    }
}