import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.println(Ex5(1998));
    }

    public static boolean Ex1(int firstNum, int secondNum){
        return firstNum + secondNum >= 10 && firstNum + secondNum <= 20;
    }

    public static void Ex2(int userNum){
        System.out.println(userNum >= 0 ? "Число положительное!" : "Число отрицательное");
    }

    public static boolean Ex3(int userNum){
        return userNum < 0;
    }

    public static void Ex4(String usesStr, int userNum){
        for(int i = 0; i < userNum; i++) System.out.println(usesStr);
    }

    public static boolean Ex5(int userNum){
        return userNum % 100 == 0 ? (userNum % 400 == 0) :
                userNum % 4 == 0;
    }
}
