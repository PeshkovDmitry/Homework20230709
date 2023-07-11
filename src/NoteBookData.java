import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NoteBookData {

    // Множество ноутбуков
    Set<NoteBook> set = new HashSet<>();

    public NoteBookData() {
        loadFromFile();
    }

    /**
     * Метод для считывания данных из имеющегося файла
     */
    public void loadFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("notebooks.csv"));
            String str = "";
            // Считываем данные. Порядок столбцов в файле совпадают с порядком значений в NotebookFields
            while ((str = bufferedReader.readLine()) != null) {
                NoteBook nb = new NoteBook();
                String[] data = str.split(";");
                for (int i = 0; i < NotebookField.values().length; i++) {
                    nb.setValue(NotebookField.values()[i], data[i]);
                }
                set.add(nb);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Метод для вывода всего множества ноутбуков на экран
     */
    public void showAll() {
        show(set);
    }

    /**
     * Метод для вывода множества соответсвующих фильтру ноутбуков на экран
     */
    public void showFiltered(NoteBookFilter filter) {
        Set<NoteBook> set  = getFiltered(filter);
        if (set.isEmpty()) {
            System.out.println("Ничего не найдено :(");
        } else {
            show(getFiltered(filter));
        }
    }

    /**
     * Метод для получения списка доступных значений для заданного параметра ноутбука
     * @param field Параметр ноутбука
     * @return Список доступных значений
     */
    public List<String> getAllValuesByNotebookField(NotebookField field) {
        List<String> out = new ArrayList<>();
        for (NoteBook nb : set) {
            if (!out.contains(nb.getValue(field))) {
                out.add(nb.getValue(field));
            }
        }
        Collections.sort(out);
        return out;
    }

    /**
     * Метод для получения множества ноутбуков, удовлетворяющих заданному фильтру
     * @param filter
     * @return
     */
    private Set<NoteBook> getFiltered(NoteBookFilter filter) {
        Set<NoteBook> res = new HashSet<>();
        List<NotebookField> filterFields = filter.getUsedNotebookFields();
        for (NoteBook nb : set) {
            boolean addToResult = !filterFields.isEmpty();
            for (NotebookField field : filterFields) {
                addToResult = addToResult && filter.inFilter(field, nb.getValue(field));
            }
            if (addToResult) res.add(nb);
        }
        return res;
    }

    /**
     * Метод для вывода заданного множества ноутбуков на экран
     * @param outSet Множество ноутбуков для вывода
     */
    private void show(Set<NoteBook> outSet) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (NoteBook nb : outSet) {
            sb.append(i++)
                    .append(": ")
                    .append(nb)
                    .append("\n");
        }
        System.out.print(sb);
    }
}
