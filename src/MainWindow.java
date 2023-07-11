import java.util.ArrayList;
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
            switch (parseValueFromConsole()) {
                case 1:
                    System.out.println("*** ВСЕ НОУТБУКИ В БАЗЕ ***");
                    noteBookData.showAll();
                    break;
                case 2:
                    System.out.println("*** ВСЕ НОУТБУКИ, УДОВЛЕТВОРЯЮЩИЕ ФИЛЬТРУ ***");
                    noteBookData.showFiltered(filter);
                    break;
                case 3:
                    showFilterMainWindow();
                    break;
                case 4:
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
            switch (parseValueFromConsole()) {
                case 1:
                    System.out.println("*** ТЕКУЩИЕ ПАРАМЕТРЫ ФИЛЬТРА ***");
                    System.out.print(filter);
                    break;
                case 2:
                    showFilterAddWindow();
                    break;
                case 3:
                    showFilterDeleteWindow();
                    break;
                case 4:
                    work = false;
                    break;
                default:
                    System.out.println("Я вас не понял...");
                    break;
            }
        }
    }

    /**
     * Метод для вывода на экран меню добавления параметров в фильтр
     */
    private void showFilterAddWindow() {
        System.out.println("*** ДОБАВЛЕНИЕ ПАРАМЕТРА В ФИЛЬТР ***");
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
        System.out.print(sb);
        // Запрашиваем выбор пользователя
        int selected = parseValueFromConsole();
        // Если полученный параметр в допустимом диапазоне, работаем дальше
        if ((selected >= 0) && (selected < NotebookField.values().length)) {
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
            System.out.print(sb);
            List<Integer> selectedArray = parseArrayFromConsole(selectedField, values);
            if (selectedArray.size() > 0) {
                for (Integer val : selectedArray) {
                    filter.add(selectedField, values.get(val));
                }
                System.out.println("Параметры фильтра изменены");
            } else {
                System.out.println("Фильтр оставлен без изменений");
            }
        }
    }

    /**
     * Метод для вывода на экран меню удаления параметров из фильтра
     */
    private void showFilterDeleteWindow() {
        System.out.println("*** УДАЛЕНИЕ ПАРАМЕТРА ИЗ ФИЛЬТРА ***");
        List<NotebookField> fields = filter.getUsedNotebookFields();
        if (fields.size() == 0) {
            System.out.println("Фильтр пуст, удалять нечего");
            return;
        }
        System.out.println("Параметры для удаления:");
        // Выводим список всех параметров из фильтра
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (NotebookField field : fields) {
            sb.append(i++)
                    .append(" - ")
                    .append(field.descritpion())
                    .append("\n");
        }
        System.out.print(sb);
        // Запрашиваем выбор пользователя
        int selected = parseValueFromConsole();
        // Если полученный параметр в допустимом диапазоне, работаем дальше
        if ((selected >= 0) && (selected < fields.size())) {
            NotebookField selectedField = fields.get(selected);
            // Выводим выбранный параметр и все доступные варианты
            System.out.print("Выбран параметр: ");
            System.out.println(selectedField.descritpion());
            System.out.println("Доступные для удаления значения");
            List<String> values = filter.get(selectedField);
            i = 0;
            sb = new StringBuilder();
            for (String value : values) {
                sb.append(i++)
                        .append(" - ")
                        .append(value)
                        .append("\n");
            }
            System.out.print(sb);
            List<Integer> selectedArray = parseArrayFromConsole(selectedField, values);
            if (selectedArray.size() > 0) {
                for (Integer val : selectedArray) {
                    filter.remove(selectedField, values.get(val));
                }
                System.out.println("Параметры фильтра изменены");
            } else {
                System.out.println("Фильтр оставлен без изменений");
            }
        }
    }

    private NoteBookData noteBookData = new NoteBookData();

    private NoteBookFilter filter = new NoteBookFilter();

    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод, возвращающий одиночное значение, получаемое из командной строки,
     * или -1, если полученное значение распарсить не удалось
     * @return Значение, полученное из строки
     */
    private int parseValueFromConsole() {
        System.out.print("->");
        String text = scanner.nextLine();
        int out = -1;
        try {
            out = Integer.parseInt(text);
        }
        catch (Exception e) {}
        return out;
    }

    /**
     * Метод, возвращающий массив значений, получаемых из командной строки,
     * или пустой массив, если полученную строку распарсить не удалось
     * @param field Параметр ноутбука
     * @param values Список возможных параметров нотбуков
     * @return Массив значений
     */
    private List<Integer> parseArrayFromConsole(NotebookField field, List<String> values) {
        String symbol = "";
        List<Integer> arr = new ArrayList<>();
        System.out.println("Выберите номер или несколько номеров через запятую (например, \"1\" или \"1,3,5\")");
        if (field.isNumber()) System.out.println("Можно использовать конструкции вида \">1\" или \"<7\"");
        System.out.print("->");
        String text = scanner.nextLine();
        // Фиксируем наличие знака больше или меньше
        if (text.contains("<")) {
            text = text.replaceAll("<","");
            symbol = "<";
        }
        else if (text.contains(">")) {
            text = text.replaceAll(">","");
            symbol = ">";
        }
        // Разбиваем строку по знаку запятой и парсим полученные строки
        String[] arrStr = text.split(",");
        for (String s : arrStr) {
            try {
                int v = Integer.parseInt(s);
                if ((v >= 0) && (v < values.size())) arr.add(v);
            }
            catch (Exception e) {}
        }
        // Корректируем значения в случае, если параметр численный,
        // в строке ввода есть символ < или >,
        // а в листе распарсенных значений только одва величина
        if ((field.isNumber()) && (arr.size() == 1) && (!symbol.equals(""))) {
            // Случай, если значения параметров численные
            // Получаем численное значение параметра, номер которого был передан в командной строке
            Float f = -1f;
            try {
                f = Float.parseFloat(values.get(arr.get(0)));
            }
            catch (Exception e) {}
            arr.clear();
            // Просматриваем список values и для каждого его значения
            // проверяем переданное в коммандной строке условие
            for (int i = 0; i < values.size(); i++) {
                try {
                    Float f1 = Float.parseFloat(values.get(i));
                    if ((symbol.equals(">")) && (f1 > f)) arr.add(i);
                    if ((symbol.equals("<")) && (f1 < f)) arr.add(i);
                }
                catch (Exception e) {}
            }
        }
        return arr;
    }

    private String mainMenuText =
            "*** БАЗА ДАННЫХ НОУТБУКОВ ***\n"
            + "1 - Показать все ноутбуки в базе \n"
            + "2 - Показать ноутбуки по фильтру \n"
            + "3 - Изменение параметров фильтра \n"
            + "4 - Выход";

    private String filterMainMenuText =
            "*** РАБОТА С ФИЛЬТРОМ ***\n"
            + "1 - Показать параметры текущего фильтра \n"
            + "2 - Добавление параметра в фильтр \n"
            + "3 - Удаление параметра из фильтра \n"
            + "4 - Назад";

}
