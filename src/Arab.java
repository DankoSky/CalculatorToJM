import java.util.ArrayList;

public class Arab {


    public static boolean check(char[]st1){
        /* Первоначальная проверка введенной строки посимвольно. Сравниваем со всеми возможными доступными символами.
        * Если все верно, переходим к методу следубщему. Если нет, ошибка.*/
        String[] test0 = {"1","2","3","4","5","6","7","8","9","0","I","V","X","+","-","*","/", " "};
        ArrayList<String> c1= new ArrayList<>();
        for (char vrd:st1)
        {
            for (String vrd2:test0)
            {
                if (Character.toString(vrd).equals(vrd2))
                {
                    c1.add(Character.toString(vrd));
                }
            }

        }
        return c1.size() == st1.length;

    }

    public static void check1(char[] st1) throws AllExeption {
        /*Второй этап проверки. Здесь проверяются какие цифры у нас используются Арабские или Латинские.
        * Если совпадают размеры, значит Арабские. Если нет, то латинские, так как проверка номер 1 отсеяла иные варианты*/
        String[] test1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "/", " "};
        ArrayList<String> c2= new ArrayList<>();
        for (char vrd : st1) {
            for (String vrd2 : test1) {
                if (Character.toString(vrd).equals(vrd2)) {
                    c2.add(Character.toString(vrd));
                }
            }

        }
        if ((c2.size() == st1.length)){
            if ((st1.length>4)& (st1.length<8)){        // 5,6,7 длинна строки возможная для Арабских цифр
                check2(st1);
            }
            else
                throw new AllExeption("Ошибка! Числа должны быть от 1 до 10");}
        else {
           if (Rome.checkRome(st1))
               Rome.checkRomeTwo(st1);
           else
               throw new AllExeption("Нельзя использовать и Арабские и Римские цифры одновременно");
        }
    }

    public static boolean checkZnakAndSpace(char[]st1)  {
        // Проверяю чтобы был один знак Арифметический, и два пробела.
        String[] test0 = {"+", "-", "*", "/"};
        String[] test1 = {" "};

        int i =0, k =0;
            for (char ss:st1) {

                for (String ss1:test0) {
                    if  (Character.toString(ss).equals(ss1)){
                        i++;
                    }
                }
            }
        for (char ss:st1) {

            for (String ss1:test1) {
                if  (Character.toString(ss).equals(ss1)){
                    k++;
                }
            }
        }

        return i == 1 & k == 2;

        }

    public static void check2(char[]st1) throws AllExeption {
        if (checkZnakAndSpace(st1)){

            if (st1.length == 5) {
                int a =Integer.parseInt(Character.toString(st1[0])),
                    b =Integer.parseInt(Character.toString(st1[4]));
                String c = Character.toString(st1[2]);
                ArithmeticArab(a,b,c);

            }
            else if (st1.length == 7) {
            int a =Integer.parseInt(st1[0] +Character.toString(st1[1])),
                b =Integer.parseInt(st1[5] +Character.toString(st1[6]));
                String c = Character.toString(st1[3]);
                if (a ==10& b == 10){
                ArithmeticArab(a,b,c);}
                else {
                    throw new AllExeption("Введено число больше 10");
                }
            }
            else if (st1.length ==6){
                if (Character.toString(st1[2]).equals(" ")){
                int a =Integer.parseInt(st1[0] +Character.toString(st1[1])),
                    b =Integer.parseInt(Character.toString(st1[5]));
                String c = Character.toString(st1[3]);
                    if (a<11){
                        ArithmeticArab(a,b,c);
                    }
                    else {
                     new AllExeption("Число на вход не может быть больше 10");
                    }
                }
                else {
                    int a =Integer.parseInt(Character.toString(st1[0])),
                            b =Integer.parseInt(st1[4] +Character.toString(st1[5]));
                    String c = Character.toString(st1[2]);
                        if (b<11){
                        ArithmeticArab(a,b,c);
                        }
                        else {
                            new AllExeption("Число на вход не может быть больше 10");
                        }
                }
            }
        else {
            throw new AllExeption("Введены числа несоответствующие параметрам");
            }

        }
    }

    public static void ArithmeticArab(int a, int b, String c) {

        switch (c) {
            case "+" -> System.out.println(a + b);
            case "-" -> System.out.println(a - b);
            case "*" -> System.out.println(a * b);
            case "/" -> System.out.println(a / b);
            default -> System.out.println("Ошибка в блоке Арифметических операций ArithmetikArab");
        }
    }



}
/* В данном методе нужно проверить правильный порядок написания строки. И чтобы числа были не больше 10
 * Получится три правильных варианта с разной длинной строки Все a_+_b  длинна будет 5. и (a_+_aa) или (aa_+_a) длинна будет 6,
 *  и aa_+_aa длинна будет 7. Соответственно нужно проверить правильно положение арифметического знака, пробелов,
 * т.к. на более ранних этапах не проверялось*/