public class Syrup extends Medicine{

    //attributes
    private double bottleContent;

    //constructors
    public Syrup(){}

    public Syrup(String medicineName, String companyName, String companyEmail, double price, double quantity, int expYear, Type type, double bottleContent)throws InvalidEmailAddressException{
        super(medicineName, companyName, companyEmail, price, quantity, expYear, type);
        setBottleContent(bottleContent);
    }

    @Override
    public String toString(){
        return super.toString() + ", bottle content= "+ bottleContent;
    }

    @Override
    public double totalInventory(){
        return super.getQuantity()*bottleContent;
    }

    //getters & setters
    public double getBottleContent() {
        return bottleContent;
    }

    public void setBottleContent(double bottleContent) {
        if(bottleContent > 0)
            this.bottleContent = bottleContent;
        else System.out.println("The bottle is empty!");
    }
}
