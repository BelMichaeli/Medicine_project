public class Pills extends Medicine{

    //Attributes
    private int numOfPillsInBox;

    //constructors
    public Pills(){}

    public Pills(int numOfPillsInBox, String medicineName, String companyName, String companyEmail, double price, double quantity, int expYear, Type type)throws InvalidEmailAddressException{
        super(medicineName, companyName, companyEmail, price, quantity, expYear, type);
        setNumOfPillsInBox(numOfPillsInBox);
    }

    //methods
    @Override
    public String toString(){
        return super.toString() + ", num of pills in box= "+ numOfPillsInBox;
    }

    @Override
    public double totalInventory(){
        return super.getQuantity()*numOfPillsInBox;
    }

    //getters & setters
    public int getNumOfPillsInBox() {
        return numOfPillsInBox;
    }

    public void setNumOfPillsInBox(int numOfPillsInBox) {
        if(numOfPillsInBox > 0)
           this.numOfPillsInBox = numOfPillsInBox;
        else System.out.println("The box is empty!");
    }
}
