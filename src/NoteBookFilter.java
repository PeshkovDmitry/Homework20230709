import java.util.*;

public class NoteBookFilter {
    // Коллекция фильтров
    private Map<NotebookField, Set<String>> data = new HashMap<>();

    /**
     * Метод для добавления фильтра
     * @param field Параметр ноутбука
     * @param value Значение параметра ноутбука
     */
    public void add(NotebookField field, String value) {
        if (data.containsKey(field)) {
            data.get(field).add(value);
        } else {
            Set<String> set = new HashSet<>();
            set.add(value);
            data.put(field, set);
        }
    }

    /**
     * Метод для получения списка значений для заданного параметра ноутбука
     * @param field Параметр ноутбука
     * @return Список значений в фильтре
     */
    public List<String> get(NotebookField field) {
        List<String> out = new ArrayList<>(data.get(field));
        return out;
    }

    /**
     * Метод для удаления фильтра
     * @param field Параметр ноутбука
     */
    public void remove(NotebookField field) {
        data.remove(field);
    }

    /**
     * Метод для удаления одного значения из фильтра
     * @param field Параметр ноутбука
     * @param value Удаляемое значение
     */
    public void remove(NotebookField field, String value) {
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
    public List<NotebookField> getUsedNotebookFields() {
        List<NotebookField> out = new ArrayList<>(data.keySet());
        return out;
    }

    /**
     * Метод, проверяющий, есть ли такой параметр с таким значением в фильтре
     * @param field Параметр ноутбука
     * @param value Значение параметра
     * @return Признак наличия в фильтре
     */
    public boolean inFilter(NotebookField field, String value) {
        return data.get(field).contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NotebookField field : NotebookField.values()) {
            if (data.containsKey(field)) {
                sb.append(field.descritpion()).append(": ");
                for (String str : data.get(field)) {
                    sb.append(str).append("; ");
                }
                sb.append("\n");
            }
        }
        if (sb.length() == 0) return "Фильтр пуст \n";
        return sb.toString();
    }
}
