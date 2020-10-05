import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Calculator {
    public static void main(String[] args) throws IOException, AllExeption {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String User = reader.readLine();
        char[] st1 = User.toCharArray();
         if (Arab.check(st1)){
            Arab.check1(st1);
         }
         else
             throw new AllExeption("Введены параметры недопустимого диапазона");




    }
}

