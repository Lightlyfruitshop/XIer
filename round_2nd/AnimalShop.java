package round_2nd;

public interface AnimalShop {
    public void buyAnimal(String name, int age, String gender, double price, String race);
    public void entertainCustomer(String name, boolean isNew);
    public void outOfBusiness();
}
