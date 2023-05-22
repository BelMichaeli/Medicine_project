public class InvalidEmailAddressException extends Exception{

    public InvalidEmailAddressException(String comE, String exceptionText){
        System.out.println("email- "+ comE +", Exception- "+ exceptionText);  //מדפיס את האימייל השגוי, כדי שנדע באיזה שדה הוא נפל, ואת ההודעה של השגיאה
    }
}
