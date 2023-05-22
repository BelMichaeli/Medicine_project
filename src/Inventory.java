import java.util.ArrayList;

public class Inventory {

    ArrayList<Medicine> arrListMed= new ArrayList<Medicine>();

    /* methods */

    //הוספת תרופה
    public void addMedicine(Medicine med) throws MedicineAlreadyExistException{
        for (Medicine m: arrListMed) {  //לולאה שעוברת על כל מערך התרופות לוודא שלא קיימת כבר תרופה זהה לזו שנוסיף
            if(m.equals(med))  //נמצאה תרופה זהה שכבר קיימת במאגר
                throw new MedicineAlreadyExistException(med);
        }

        arrListMed.add(med);  //אם לא ארעה חריגה והתכנית הגיעה לכאן, ניתן להוסיף את התרופה
    }

    //חיפוש תרופה לפי שם
    public Medicine searchMedicineByName(String medName) throws MedicineDoesNotExistException{
        Medicine medicine= null;
        for (Medicine m: arrListMed) {
            if (m.getMedicineName().equalsIgnoreCase(medName))
                medicine=m;
        }

        if(medicine == null)
            throw new MedicineDoesNotExistException(medName);

        //הדפסת הכמות הכוללת של התרופה המבוקשת במאגר ההזמנה
        System.out.println("The total quantity of the medicine '"+medName+"' in the inventory is- "+ medicine.totalInventory());
        return medicine;
    }

    //חיפוש תרופה לפי סוג
    public ArrayList<Medicine> searchMedicineByType(Medicine.Type medType){
        ArrayList<Medicine> arrListByType= new ArrayList<Medicine>();  //הגדרת המערך שיוחזר בפונקציה
        for (Medicine m: arrListMed) {
            if(m.getType().equals(medType))
                arrListByType.add(m);
        }
        /*אפשר להוסיף קטע שיבדוק אם המערך מוחזר ריק*/
        if (arrListByType.isEmpty())
            System.out.println("There is no medicine that compatible with the "+ medType +" type");

        return arrListByType; //יוחזר המערך שנוצר, בו קיימים התרופות השייכות לסוג שנבחר
    }

    //רשימת התרופות שקיימות במלאי
    public ArrayList<Medicine> getMedicinesInStock(){
        ArrayList<Medicine> arrInStock= new ArrayList<Medicine>();
        for (Medicine m: arrListMed) {
            if(m.inStock())  // קריאה לפונקציה שבודקת האם התרופה קיימת במלאי, מחזירה אמת או שקר
                arrInStock.add(m);  //אם התרופה במלאי, הוסף אותה למערך של התרופות הקיימות
        }
        /*אפשר להוסיף קטע שיבדוק אם המערך מוחזר ריק*/
        if (arrInStock.isEmpty())
            System.out.println("The stock is empty! There is no medicine in stock");

        return arrInStock;
    }

}
