package Practik_29_04_23_Dz;

import java.util.Scanner;

//созданы конструкторы касса
public class Price  extends   Kassa {
    public Price(float a1, String produkt) { // цена и продукт
        super(a1, produkt);
    }


    // создан метод который принимает продукты и цену
    public static void pro() throws   NegativeException {
        Scanner csr = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Введите наименование продукта: ");
        String produkt = csr.nextLine();

        do {
            System.out.println("Введите  цену продукта: ");
            try {
                MyMy.a = csr.nextFloat();// цена продукта
                csr.nextLine();

                if (MyMy.a <= 0) {
                    throw new NegativeException  ("Ошибка: Цена продукта не может быть отрицательной или равна 0 руб"); //1

                } else if (MyMy.a <= MyMy.balance) {
                    System.out.println("Введите код карты вашей скидочной карты:");


                    do {

                        int code = csr.nextInt();//345 ввод в  Karta.v1 = 234
                        csr.nextLine();

                        if ((code == Karta.v1) || (  code ==  Karta.v )) {

                            float b = MyMy.a * Karta.Skidka / 100;

                            MyMy.a = MyMy.a - b;
                            MyMy.balance = MyMy.balance - MyMy.a;

                            System.out.println("Вы купили: " + produkt + " по цене: " + MyMy.a + " руб");
                            System.out.println("Скидка составляет: " + b + " руб");
                            System.out.println("Остаток на кошельке: " + MyMy.balance + " руб");
                            System.out.println(" ");
                            System.out.println("Хотите вернуться в главное меню? нажмите цифру [1]");

                            int r = csr.nextInt();
                            csr.nextLine();

                            if (r == 1) {
                                Sum.zet(); //переход к методу сум
                            } else {
                                System.out.println("Нет такого варианта, попробуйте еще раз! ");
                            }

                        } else if (code != Karta.v1 && code != Karta.v){
                            System.out.println("Ошибка: не верный код карты ");
                            System.out.println(" Попробуйте еще раз! ");

                        }
                    } while ( true );


                } else if (MyMy.a > MyMy.balance) {
                    MyMy.b =  MyMy.a - MyMy.balance;
                    throw new NegativeException("Ошибка: На кошельке недостаточно средств для покупки этого товара  в размере: " + MyMy.b + " руб. Пополните счет и возвращайтесь к нам за покупками! " );
                }
            } catch (NegativeException b) { //цена продукта не может быть отрицательной
                System.out.println(b.getMessage());
                Sum.zet();
            }

        } while (true);
    }


        public static void pro1 () throws NegativeException { // если у покупателя нет карты и он не хочет ее заводить
            Scanner csr1 = new Scanner(System.in);

            System.out.println(" ");
            System.out.println("Введите наименование продукта: ");
            String produkt1 = csr1.nextLine();
            do {
                try{
                System.out.println("Введите  цену продукта: ");
            MyMy.a = csr1.nextFloat();// цена продукта
                  csr1.nextLine();

            if (MyMy.a < 0) {
                throw new NegativeException("Ошибка: Цена продукта не может быть отрицательной");

            } else if (MyMy.a <= MyMy.balance) {
               MyMy.balance =  MyMy.balance - MyMy.a;

               System.out.println( "Вы купили: " + produkt1  + " " + " по цене: " + MyMy.a + " руб");
               System.out.println("Остаток на кошельке: " + MyMy.balance + " руб");
               System.out.println("Хотите вернуться в главное меню? нажмите цифру [1]");

               int r2 = csr1.nextInt();
                csr1.nextLine();

               if(r2 == 1){
                    Sum.zet();
                }else {
                    System.out.println("Нет такого варианта, попробуйте еще раз! ");
                }

            }else if (MyMy.a > MyMy.balance) {
                throw new NegativeException("Ошибка: На кошельке недостаточно средств для покупки этого товара. Пополните счет и возвращайтесь к нам за покупками!");

            }
        }catch (NegativeException  j ){
                    System.out.println(j.getMessage());
        }
            }while (true);

    }
}
