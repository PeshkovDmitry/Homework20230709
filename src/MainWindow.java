import java.util.List;
import java.util.Scanner;

public class MainWindow {

    /**
     * Метод для вывода на экран главного меню
     */
    public void showMainWindow() {

        boolean work = true;
        while (work) {
            System.out.println(mainMenuText);
            System.out.print("->");
            String in = scanner.nextLine();
            switch (in) {
                case "1":
                    System.out.println("ВСЕ НОУТБУКИ В БАЗЕ");
                    noteBookData.showAll();
                    break;
                case "2":
                    System.out.println("ВСЕ НОУТБУКИ, УДОВЛЕТВОРЯЮЩИЕ ФИЛЬТРУ");
                    noteBookData.showFiltered(filter);
                    break;
                case "3":
                    showFilterMainWindow();
                    break;
                case "4":
                    System.out.println("До свиданья!");
                    work = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Я вас не понял...");
                    break;
            }
        }
    }

    /**
     * Метод для вывода на экран главного меню фильтра
     */

    private void showFilterMainWindow() {
        boolean work = true;
        while (work) {
            System.out.println(filterMainMenuText);
            System.out.print("->");
            String in = scanner.nextLine();
            switch (in) {
                case "1":
                    System.out.println("ТЕКУЩИЕ ПАРАМЕТРЫ ФИЛЬТРА");
                    System.out.println(filter);
                    break;
                case "2":
                    showFilterAddWindow();
                    break;
                case "3":
                    showFilterDeleteWindow();
                    break;
                case "4":
                    work = false;
                    break;
                default:
                    System.out.println("Я вас не понял...");
                    break;
            }
        }
    }

    /**
     * Метод для вывода на экран меню добавления паараметров в фильтр
     */
    private void showFilterAddWindow() {
        System.out.println("ДОБАВЛЕНИЕ ПАРАМЕТРА В ФИЛЬТР");
        System.out.println("Параметры для добавления:");
        // Выводим список всех доступных параметров
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (NotebookField field : NotebookField.values()) {
            sb.append(i++)
                    .append(" - ")
                    .append(field.descritpion())
                    .append("\n");
        }
        System.out.println(sb);
        // Запрашиваем выбор пользователя
        System.out.print("->");
        String in = scanner.nextLine();
        int selected = Integer.parseInt(in.trim());
        NotebookField selectedField = NotebookField.values()[selected];
        // Выводим выбранный параметр и все доступные варианты
        System.out.print("Выбран параметр: ");
        System.out.println(selectedField.descritpion());
        System.out.println("Доступные значения");
        List<String> values = noteBookData.getAllValuesByNotebookField(selectedField);
        i = 0;
        sb = new StringBuilder();
        for (String value : values) {
            sb.append(i++)
                    .append(" - ")
                    .append(value)
                    .append("\n");
        }
        System.out.println(sb);
        System.out.println("Выберите номер или несколько номеров через запятую (например, 1 или 1,3,5)");
        System.out.print("->");
        in = scanner.nextLine();
    }

    /**
     * Метод для вывода на экран меню удаления параметров из фильтра
     */
    private void showFilterDeleteWindow() {
        System.out.println("УДАЛЕНИЕ ПАРАМЕТРА ИЗ ФИЛЬТРА");
    }

    private NoteBookData noteBookData = new NoteBookData();

    private NoteBookFilter filter = new NoteBookFilter();

    private Scanner scanner = new Scanner(System.in);

    private String mainMenuText =
            "БАЗА ДАННЫХ НОУТБУКОВ\n"
            + "1 - Показать все ноутбуки в базе \n"
            + "2 - Показать ноутбуки по фильтру \n"
            + "3 - Изменение параметров фильтра \n"
            + "4 - Выход";

    private String filterMainMenuText =
            "РАБОТА С ФИЛЬТРОМ\n"
                    + "1 - Показать параметры текущего фильтра \n"
                    + "2 - Добавление параметра в фильтр \n"
                    + "3 - Удаление параметра из фильтра \n"
                    + "4 - Назад";

}
