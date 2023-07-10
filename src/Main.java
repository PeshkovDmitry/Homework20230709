/*
1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
Реализовать в java.
2. Создать множество ноутбуков.
3. Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев -
сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */

public class Main {
    public static void main(String[] args) {
        NoteBookData noteBookData = new NoteBookData();
//        noteBookData.showAll();
        NoteBookFilter filter = new NoteBookFilter();
        filter.add(NotebookFields.MODEL, "Хороший ноутбук");
        filter.add(NotebookFields.MODEL, "Так себе ноутбук");
        filter.add(NotebookFields.OPERATIONSYSTEM, "Windows");
        System.out.println(filter);
    }
}