public class MedicineAlreadyExistException extends Exception{

    public MedicineAlreadyExistException(Medicine med){
        System.out.println("NOTE! the medicine '"+med.getMedicineName()+"' is exist in the inventory.");
    }
}
