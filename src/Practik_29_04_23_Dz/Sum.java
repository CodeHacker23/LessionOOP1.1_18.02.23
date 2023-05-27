package Practik_29_04_23_Dz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum extends Kassa {
    //созданы конструкторы
    public Sum(double b) {
        super(b);
    }

    public Sum(float a, String produkt) {
        super(a, produkt);
    }
    //продолжение конструкторов


    //  создан метод
    public static void zet() throws NegativeException {
        Scanner csr = new Scanner(System.in);
        boolean a = false;
        boolean b = true;

        do { //создан цикл в цикле doWhile -что бы программа дальше продолжала работать после исключения
            try {
                double c = 0.0; //переменная сканнер 250 руб

                while ( a == false ) {//создан цикл для того чтобы меню повторялось

                    System.out.println("[1]- Если хотите пополнить кошелек для покупок.");

                    System.out.println("[2]- Если хотите проверить баланс. ");

                    System.out.println("[3]- Если хотите  продолжить.");

                    int san1 = csr.nextInt();//создана переменная где программа будет видеть что ввел пользователь

                    if (san1 == 1) {
                        System.out.println("Внесите сумму: ");
                        c = csr.nextDouble(); //250 руб
                        if (c < 0) {
                            throw new NegativeException("Ошибка: Не возможно пополнить баланс на отрицательное число");
                        }
                        MyMy.balance += c;

                    } else if (san1 == 2) {
                        if (MyMy.balance < 0) {
                            throw new NegativeException(  "Ошибка: Баланс не может быть отрицательным, пополните счет!");
                        }
                        System.out.println("На вашем кошельке " + MyMy.balance + " руб");

                    } else if (san1 == 3) {
                        b = a;
                        Karta.Kar();
                        break;
                    } else {
                        System.err.println("Нет такого варианта, попробуйте еще раз!");
                    }



                }
            }catch(InputMismatchException  e) { // поймано название исключения
                System.err.println("Ошибка: Неверный формат числа, по пробуйте еще раз");
                 zet();

            }catch(NegativeException c) {
                System.out.println(c.getMessage());

            }



        }while ( b == true);    // благодрая тру- цикл будет работать бесконечено

    }
}










// создать исключения в методе прайс на отрицательное число
// else if (MyMy.a < 0){
//System.err.println("Ошибка: Цена товара не может быть отрицательной :( ");















