import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
                for (int i = 0; i < NotebookFields.values().length; i++) {
                    nb.setValue(NotebookFields.values()[i], data[i]);
                }
                set.add(nb);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод для вывода заданного множества ноутбуков на экран
     * @param outSet Множество ноутбуков для вывода
     */
    public void show(Set<NoteBook> outSet) {
        for (NoteBook nb : outSet) {
            System.out.println(nb);
        }
    }

    /**
     * Метод для вывода всего множества ноутбуков на экран
     */
    public void showAll() {
        show(set);
    }

    /**
     * Метод для получения множества ноутбуков, удовлетворяющих заданному фильтру
     * @param filter
     * @return
     */
    public Set<NoteBook> getFiltered(NoteBookFilter filter) {
        Set<NoteBook> res = new HashSet<>();
        Set<NotebookFields> fields = filter.getUsedNotebookFields();
        for (NoteBook nb : set) {
            boolean addToResult = true;
            for (NotebookFields field : fields) {

            }
        }
        return res;
    }






}
