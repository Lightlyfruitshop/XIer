package round_2nd;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyAnimalShop shop = new MyAnimalShop();
        shop.setBalance(20000);
        shop.setInBusiness(true);
        Scanner scn = new Scanner(System.in);
        shop.outOfBusiness();
        shop.buyAnimal(scn.next(), scn.nextInt(), scn.next(), scn.nextDouble(), scn.next());
        for (int i = 0; i < shop.getAnimals().size(); i++) {
            System.out.println(shop.getAnimals().get(i));
        }
        System.out.println("please enter customer's name and new or not");
        shop.entertainCustomer(scn.next(), scn.nextBoolean());

        shop.outOfBusiness();
    }
}
