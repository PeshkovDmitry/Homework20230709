import java.util.*;

public class NoteBookFilter {
    // Коллекция фильтров
    private Map<NotebookFields, List<String>> data = new HashMap<>();

    /**
     * Метод для добавления фильтра
     * @param field Параметр ноутбука
     * @param value Значение параметра ноутбука
     */
    public void add(NotebookFields field, String value) {
        if (data.containsKey(field)) {
            data.get(field).add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            data.put(field, list);
        }
    }

    /**
     * Метод для удаления фильтра
     * @param field Параметр ноутбука
     */
    public void remove(NotebookFields field) {
        data.remove(field);
    }

    /**
     * Метод для удаления одного значения из фильтра
     * @param field Параметр ноутбука
     * @param value Удаляемое значение
     */
    public void remove(NotebookFields field, String value) {
        if (data.containsKey(field)) {
            data.get(field).remove(value);
        }
    }

    /**
     * Метод для очищения всей коллекции фильтров
     */
    public void clear() {
        data.clear();
    }

    /**
     * Метод для получения множества применяемых в фильтре параметров полей
     * @return
     */
    public Set<NotebookFields> getUsedNotebookFields() {
        return data.keySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NotebookFields field : NotebookFields.values()) {
            if (data.containsKey(field)) {
                sb.append(NoteBook.getDescription(field)).append(": ");
                for (String str : data.get(field)) {
                    sb.append(str).append("; ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
