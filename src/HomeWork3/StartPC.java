/*
4*.Симулятор загрузки ПК:
 4.1 Сценарий: При запуске программы происходит включение воображаемого ПК. Тестируется и запускаеся оборудование в следующем порядке:
  4.1.1 центральный процессор
  4.1.2 проверка контрольной суммы программы ПЗУ
  4.1.3 первые 64 байта ОЗУ (для рагрузки резидентных программ)
  4.1.4 контроллер графического адаптера
  4.1.5 ОЗУ
  4.1.6 БИОС
  4.1.7 контроллер COM-портов
  4.1.8 контроллер накопителей на жеских магнитных дисках

  КАК РЕАЛИЗОВАНО:
  В заданной последовательности проводятся тесты и запуск проверенного оборудования, с выводом на экран сообщений
  об успехе или провале теста / запуска.
  Тест оборудования вручную настроен на успех, но при желании можно здесь указать, какое из оборудования
  не прошло тест или не запускается. Программа это отработает.
  После успешного тестирования и запуска всего оборудования - пробуем запустить операционную систему.
  В случае успешного запуска - система вернёт код ошибки "0", в случае неудачного запуска - вернёт код ошибки.
  Успешность запуска системы настроена на вероятность 50%.
 */
package HomeWork3;

public class StartPC {
    public static void main(String[] args) {
        CPU cpu1 = new CPU(); // ЦПУ
        PZU pzu1 = new PZU(); // программа ПЗУ
        RezidentOZU rezOZU = new RezidentOZU(); // область ОЗУ для резидентных программ
        CGAdapter cga1 = new CGAdapter();  // контроллер графического адаптера
        OZU ozu1 = new OZU();              // ОЗУ
        BIOS bios1 = new BIOS();           // БИОС
        ContrCOMPort com1 = new ContrCOMPort(); // контроллер СОМ-портов
        ContrHDD chdd1 = new ContrHDD();    // контроллер HDD
        OS os1 = new OS();                  // операционная система

        int pr = 0;

        //pzu1.test_result = false;  // для отладки и проверки работы программы
        // pzu1.test_result = true; // для отладки и проверки работы программы
        //rezOZU.test_result = false; // для отладки и проверки работы программы
        // bios1.run_result = false; // для отладки и проверки работы программы

        boolean test_result = true;
        boolean run_result = true;
        boolean test_equip = false; // для контроля успешности запуска оборудования: если что-либо из оборудования не пройдёт тест или не запустится - заблокируем запуск ОС

        do {
            pr++; // признак, для предотвращения зацикливания
            // проверим и запустим ЦПУ
            test_equip = cpu1.test();
            System.out.println(cpu1.getMessage());
            if (!test_equip) break;
            test_equip = cpu1.run();
            System.out.println(cpu1.getMessage());
            if (!test_equip) break;
            // проверим и запустим ПЗУ
            test_equip = pzu1.test();
            System.out.println(pzu1.getMessage());
            if (!test_equip) break;
            test_equip = pzu1.run();
            System.out.println(pzu1.getMessage());
            if (!test_equip) break;
            // проверим и запустим память ОЗУ для резидентных программ
            test_equip = rezOZU.test();
            System.out.println(rezOZU.getMessage());
            if (!test_equip) break;
            test_equip = rezOZU.run();
            System.out.println(rezOZU.getMessage());
            if (!test_equip) break;
            // проверим и запустим контроллер графического адаптера
            test_equip = cga1.test();
            System.out.println(cga1.getMessage());
            if (!test_equip) break;
            test_equip = cga1.run();
            System.out.println(cga1.getMessage());
            if (!test_equip) break;
            // проверим и запустим ОЗУ
            test_equip = ozu1.test();
            System.out.println(ozu1.getMessage());
            if (!test_equip) break;
            test_equip = ozu1.run();
            System.out.println(ozu1.getMessage());
            if (!test_equip) break;
            // проверим и запустим БИОС
            test_equip = bios1.test();
            System.out.println(bios1.getMessage());
            if (!test_equip) break;
            test_equip = bios1.run();
            System.out.println(bios1.getMessage());
            if (!test_equip) break;
            // проверим и запустим контроллер COM-портов
            test_equip = com1.test();
            System.out.println(com1.getMessage());
            if (!test_equip) break;
            test_equip = com1.run();
            System.out.println(com1.getMessage());
            if (!test_equip) break;
            // проверим и запустим контроллер HDD
            test_equip = chdd1.test();
            System.out.println(chdd1.getMessage());
            if (!test_equip) break;
            test_equip = chdd1.run();
            System.out.println(chdd1.getMessage());
            if (!test_equip) break;

            // если мы дошли до этой строки и не вышли из цикла, значит всё оборудование проверено и запущено
            // пробуем запускать операционную систему
            int error_os = os1.run(); // получим код ошибки при запуске ОС. Если ноль, значит успешно запустили
            if (error_os == 0) {
                System.out.println("Операционная система успешно запущена");
            } else {
                System.out.println("СИНИЙ ЭКРАН СМЕРТИ");
                System.out.println("Ошибка запуска операционной системы!");
                System.out.println("Код ошибки " + error_os);
            }
        } while (pr == 0);
    }
}
