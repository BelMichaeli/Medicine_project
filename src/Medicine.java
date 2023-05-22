public abstract class Medicine {

    //Attributes
    private String medicineName;
    private String companyName;
    private String companyEmail;
    private double price;
    private double quantity;
    private int expYear;
    private Type type;

    enum Type{
        PILLS,
        SYRUP,
        INHALER
    }

    //constructors
    public Medicine(){}

    public Medicine(String medicineName, String companyName, String companyEmail, double price, double quantity, int expYear, Type type) throws InvalidEmailAddressException {
        setMedicineName(medicineName);
        setCompanyName(companyName);
        setCompanyEmail(companyEmail);
        setPrice(price);
        setQuantity(quantity);
        setExpYear(expYear);
        setType(type);
    }

    //methods
    @Override
    public String toString() {
        return "Medicine{" +
                "medicineName='" + medicineName+
                ", companyName='" + companyName +
                ", companyEmail='" + companyEmail +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expYear=" + expYear +
                ", type=" + type +
                '}';
    }

    public abstract double totalInventory(); //calculate the total inventory for each medicine type

    public boolean inStock(){  //checks if the quantity >0
        if(quantity>0)
            return true;
        else return false;
    }

    //getters & setters
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        if(medicineName!= null && !(medicineName.isEmpty()))
            this.medicineName = medicineName.toUpperCase(); //Make sure the word is capitalized
        else System.out.println("The medicine name is invalid");
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if(companyName!= null && !(companyName.isEmpty()))
            this.companyName = companyName;
        else System.out.println("The company name is invalid");

    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String comE) throws InvalidEmailAddressException {
        if(comE != null && !(comE.isEmpty())) {  //if the str isn't null
            int index= comE.indexOf('@'); //applying the index of the char @
            if(index< 0)  //אם התו @ לא נמצא כלל בשדה
                throw new InvalidEmailAddressException(comE, "The char '@' have to be in the field");

            if(index == 0)  //אם ה@ נמצא במיקום הראשון
                throw new InvalidEmailAddressException(comE, "The char '@' can't be the first char in the field");

            if (index == comE.length()-1)  //אם ה@ נמצא במיקום האחרון
                throw new InvalidEmailAddressException(comE, "The char '@' can't be the last char in the field");

            if (comE.indexOf('.', index) < 0 || comE.indexOf('.', index) == 0) //בדיקה שהנקודה נמצאת לאחר התו @, ושהיא באה לאחר תו אחד לפחות אחרי ה@
                throw new InvalidEmailAddressException(comE, "The char '.' have to appear after the '@' at least once' and cannot be the first after '@' ");

           /* if(index < 0 && index< comE.length()-1)  //checking: if exist, not first and not last
                if(comE.indexOf('.', index) > 0)  //checking if '.' exist after '@'
                    this.companyEmail  = comE;*/

            System.out.println("The email Address "+comE+" is well!");
            this.companyEmail  = comE;  //אם לא ארעה שגיאה, הפונקציה מכניסה את הערך לשדה המתאים
        }

        else System.out.println("The company email cannot be empty"); //אם המחרוזת ריקה, תוצג הודעה מתאימה
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
