public class MedicineDoesNotExistException extends Exception{

    public MedicineDoesNotExistException(String medName){
        System.out.println("NOTE! The medicine '"+medName+"' does not exist in the inventory");
    }
}
