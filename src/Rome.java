import java.util.ArrayList;
import java.util.HashMap;

public class Rome {
    public static boolean checkRome(char[] st1) throws AllExeption {
        String[] test5 = {"I", "V", "X", "+", "-", "*", "/", " "};
        ArrayList<String> c1 = new ArrayList<>();
        for (char vrd : st1) {
            for (String vrd2 : test5) {
                if (Character.toString(vrd).equals(vrd2)) {
                    c1.add(Character.toString(vrd));
                }
            }

        }
        return c1.size() == st1.length;
    }

    public static void checkRomeTwo(char[] st1) throws AllExeption {
        String[] test2 = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VII", "IX"};
        HashMap<String, Integer> test3 = new HashMap<>();
        test3.put("X", 10);
        test3.put("IX", 9);
        test3.put("VIII", 8);
        test3.put("VII", 7);
        test3.put("VI", 6);
        test3.put("V", 5);
        test3.put("IV", 4);
        test3.put("III", 3);
        test3.put("II", 2);
        test3.put("I", 1);

        if (Arab.checkZnakAndSpace(st1)) {
            String a = ReturningStringFist(st1);
            String b = ReturningStringTwo(st1);
            Character y = st1[chekSimbolArith(st1)];
            String c = Character.toString(st1[chekSimbolArith(st1) - 1]);

            int t2 = test3.get(b);
            int t1 = test3.get(a);

            ArithmeticRome(t1, t2, c);

        } else {
            throw new AllExeption("Введены числа несоответствующие параметрам");
        }
    }

    /* Возвращает номер символа ( 3, 4 или 5) "+-/*"*/
    public static int chekSimbolArith(char[] st1) {

        String[] test1 = {" "};
        int i = 0;

        for (char ss : st1) {
            i++;

            if (Character.toString(ss).equals(" "))
                break;

        }

        return i + 1;
    }

    /* Возвращает сконкатенированную строку перед первой части выражения*/
    public static String ReturningStringFist(char[] st1) {


        String a = "", y;

        int t = chekSimbolArith(st1);
        for (int p = (t - 2); p > 0; p--) {

            y = a;
            a = Character.toString(st1[t - 2 - p]);
            a = y + a;

        }
        return a;


    }

    /* Возвращает сконкатенированную строку второй части выражения*/
    public static String ReturningStringTwo(char[] st1) {


        String a = "", y;
        int t = chekSimbolArith(st1);
        for (int p = t + 1; p < st1.length; p++) {
            y = a;
            a = Character.toString(st1[p]);
            a = y + a;
        }
        return a;


    }

    public static void ArithmeticRome(int a, int b, String c) {

        switch (c) {
            case "+" -> System.out.println(ArithmeticRome(a + b));
            case "-" -> System.out.println(ArithmeticRome(a - b));
            case "*" -> System.out.println(ArithmeticRome(a * b));
            case "/" -> System.out.println(ArithmeticRome(a / b));
            default -> System.out.println("Ошибка в блоке Арифметических операций ArithmetikRome");
        }
    }
    public static String ArithmeticRome(int a) {
        HashMap<Integer, String> AnswerDecRome = new HashMap<>();
        AnswerDecRome.put(100, "C");         AnswerDecRome.put(90, "XC");
        AnswerDecRome.put(80, "LXX");        AnswerDecRome.put(70, "LXX");
        AnswerDecRome.put(60, "LX");         AnswerDecRome.put(50, "L");
        AnswerDecRome.put(40, "XL");         AnswerDecRome.put(30, "XXX");
        AnswerDecRome.put(20, "XX");         AnswerDecRome.put(10, "X");
        AnswerDecRome.put(1, "I");           AnswerDecRome.put(2, "II");
        AnswerDecRome.put(3, "III");         AnswerDecRome.put(4, "IV");
        AnswerDecRome.put(5, "V");           AnswerDecRome.put(6, "VI");
        AnswerDecRome.put(7, "VII");         AnswerDecRome.put(8, "VIII");
        AnswerDecRome.put(9, "IX");          AnswerDecRome.put(0, "");
        AnswerDecRome.put(500, "0");

        String s = "";
        if (a == 100) {
            s=AnswerDecRome.get(100);
        }
        else if (a < 11) {
              if (a ==0){
                  s=AnswerDecRome.get(a+500);}
              else
                  s=AnswerDecRome.get(a);
        }
        else if (a < 100) {
           int Desytky = (a / 10)*10;
           int Edinitcy = a % 10;
           s=AnswerDecRome.get(Desytky) + AnswerDecRome.get(Edinitcy);
        }
        return s;

    }
    




}