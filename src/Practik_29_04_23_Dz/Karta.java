package Practik_29_04_23_Dz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Karta extends Kassa {
    public static int Skidka = 5; // скидка

    public static long v = 0; // код карты после регистрации

    public static int v1 = 0;// код карты без регистрации


    public static void Kar() throws NegativeException {
        Scanner csr = new Scanner(System.in);


        while (true) {

            System.out.println("Есть ли у вас Скидочная карта?");
            System.out.println("Да/нет");
            String a = csr.nextLine();

            try {
                switch (a) {
                    case "да" -> {
                        while (true) {
                            System.out.println("Введите код карты: 3 цифры c оборота карточки ");
                            Karta.v1 = csr.nextInt();
                            csr.nextLine();
                            String c = String.valueOf(Karta.v1);
                            int length = c.length();
                            Karta.v1 = Integer.parseInt(csr.nextLine());

                            if (Karta.v1 < 0) {
                                throw new NegativeException("Ошибка: код карты не может быть отрицательным числом");


                            }else if (c.length() == 3) {
                                int d = Integer.parseInt(c);
                                Karta.v1 = d;
                                System.out.println("у вас" + " " + Skidka + "% скидка");
                                Price.pro();
                                break;

                            } else {
                                System.err.println("Не верная длина номера карты :( ");
                                csr.nextLine();
                                continue;
                            }
                        }



                    }
                    case "нет" -> {
                        System.out.println("Хотите завести скидочную карту? ");
                        System.out.println("да/нет");
                        String f = csr.nextLine();

                        switch (f) {


                            case "да" -> {

                                System.out.println("Введите номер телефона:");
                                long h = csr.nextLong();// номер телефона
                                csr.nextLine();//что бы строка следуящая читалась
                                System.out.println("Введите Имя");
                                String name = csr.nextLine(); //ввод имени
                                System.out.println("Карта успешна зарегистрирована, хороших вам " + name + " покупок!");
                                System.out.println("Ваша скидка составляет: " + Skidka + "%"); //выводит скидку
                                Karta.v = h % 1000; // записывается 3 последние цифры номера телефона - это и есть код карты
                                System.out.println("Ваш код карты: " + Karta.v);
                                // System.out.println(" ");//пробел
                                Price.pro();// создан метод котоырй идет со скидкой


                            }
                            case "нет" -> {
                                System.out.println("Хороших вам покупок!");
                                Price.pro1();// создан метод который идет без скидки

                            }
                            default -> { // если вариант не правиельный
                                System.err.println("Такого варианта не существует, попробуйте еще раз!");
                                System.out.println("Да/нет");


                            }
                        }
                    }
                    default -> {
                        System.err.println("Такого варианта не существует, попробуйте еще раз!");
                        Kar();

                    }
                }
            } catch (NumberFormatException f) {
                System.err.println("Ошибка: неверный формат ввода! Код карты должен содержать 3 цифры.");
            } catch (NegativeException e) {
                System.err.println(e.getMessage());
                System.out.println("Введите код карты: 3 цифры c оборота карточки");

                continue;
            } catch (InputMismatchException g) {
                System.err.println("Ошибка: не верный формат кода карты! ");
                csr.nextLine(); //
            }

        }
    }
}




