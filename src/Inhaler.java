public class Inhaler extends Medicine{

    //attributes
    private int amountOfClick;

    //constructors
    public Inhaler(){}

    public Inhaler(int amountOfClick, String medicineName, String companyName, String companyEmail, double price, double quantity, int expYear, Type type)throws InvalidEmailAddressException{
        super(medicineName, companyName, companyEmail, price, quantity, expYear, type);
        setAmountOfClick(amountOfClick);
    }

    //methods
    @Override
    public String toString(){
        return super.toString() + ", amount of clicks= "+ amountOfClick;
    }

    @Override
    public double totalInventory(){
        return super.getQuantity()*amountOfClick;
    }

    //getters & setters
    public int getAmountOfClick() {
        return amountOfClick;
    }

    public void setAmountOfClick(int amountOfClick) {
        if (amountOfClick > 0)
            this.amountOfClick = amountOfClick;
        else System.out.println("The box is empty!");
    }
}
