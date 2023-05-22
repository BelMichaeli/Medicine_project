import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Inventory inventory = new Inventory();

        try {  //לתפוס שגיאה בשדה של companyEmail
            Pills p1 = new Pills(30, "Ferantal", "Altman", "@office@altman.co.il", 45.90, 500, 2027, Medicine.Type.PILLS);
            Pills p2= new Pills(90, "Acamol", "Teva", "office@teva.co.il@", 19.90, 1000, 2025, Medicine.Type.PILLS);
            Pills p3= new Pills(28, "Aspirin", "Bayer", "officebayer.org", 17.50, 800, 2024, Medicine.Type.PILLS);
            Syrup s1= new Syrup("Acamoli", "Teva", "office@tevacoil", 31.90, 400, 2026, Medicine.Type.SYRUP, 180);
            Syrup s2= new Syrup("Nurofen", "NOC", "office@noc.org", 42.9, 400, 2023, Medicine.Type.SYRUP, 220);
            Syrup s3= new Syrup("Novimol", "Teva", "office@teva.co.il", 43.9, 600, 2027, Medicine.Type.SYRUP,15);
            Inhaler i1= new Inhaler(10, "Doofamin", "Bayer", "officebayer.org", 21.5, 120, 2024, Medicine.Type.INHALER);
            Inhaler i2= new Inhaler(30, "Ventolin", "fizter", "office@fizter.org", 42.3,0, 2022, Medicine.Type.INHALER);
            Inhaler i3= new Inhaler(22, "Bodzonaid", "Teva", "office@teva.co.il", 15.3, 1, 2023, Medicine.Type.INHALER);
            Inhaler i4= new Inhaler(22, "Bodzonaid", "Teva", "office@teva.co.il", 15.3, 1, 2023, Medicine.Type.INHALER);

            //הוספת ערכי התרופות למערך ההזמנה. עטיפה בtry&catch לשם בדיקה האם התרופה שנוספה קיימת כבר
            try {
                inventory.addMedicine(p1);
                inventory.addMedicine(p2);
                inventory.addMedicine(p3);
                inventory.addMedicine(s1);
                inventory.addMedicine(s2);
                inventory.addMedicine(s3);
                inventory.addMedicine(i1);
                inventory.addMedicine(i2);
                inventory.addMedicine(i3);
                inventory.addMedicine(i3);
            }
            catch (MedicineAlreadyExistException e){
                e.printStackTrace();
            }
        }
        catch (InvalidEmailAddressException e){
            e.printStackTrace();  //הדפס  את טקסט השגיאה
        }

        try {  //לתפוס שגיאה כאשר בחיפוש התרופה לפי שם לא קיימת התרופה
            System.out.println(inventory.searchMedicineByName("Acamol").toString());
            System.out.println(inventory.searchMedicineByName("Ventolin").toString());
            //System.out.println(inventory.searchMedicineByName("Optalgin").toString());
            System.out.println(inventory.searchMedicineByName("Novimol").toString());
        }
        catch (MedicineDoesNotExistException e){
            e.printStackTrace();
        }
/*

        //הדפסת מערך של תרופות מסוג מסויים
        ArrayList<Medicine> arrListByType= new ArrayList<>();
        arrListByType= inventory.searchMedicineByType(Medicine.Type.PILLS);
        for (Medicine m: arrListByType) {
            System.out.println(m.toString());
        }

        //הדפסת מערך התרופות הקיימות במלאי
        ArrayList<Medicine> arrListStockMad= new ArrayList<>();
        arrListStockMad= inventory.getMedicinesInStock();
        for (Medicine m: arrListStockMad) {
            System.out.println(m.toString());
        }

*/

    }
}
