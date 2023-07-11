import java.util.HashMap;
import java.util.Map;

public class NoteBook {

    // Коллекция данных ноутбука

    private Map<NotebookField, String> data = new HashMap<>();

    /**
     * Метод для получения значения параметра ноутбука
     * @param field Параметр ноутбука
     * @return Значение параметра
     */
    public String getValue(NotebookField field){
        return data.get(field);
    }

    /**
     * Метод для задания параметра ноутбука
     * @param field Параметр ноутбука
     * @param value Значение параметра
     */
    public void setValue(NotebookField field, String value) {
        data.put(field, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NotebookField field : NotebookField.values()) {
            sb.append(field.descritpion()).append(": ").append(getValue(field)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return  5 * getValue(NotebookField.MANUFACTURER).hashCode()
                + 11 * getValue(NotebookField.MODEL).hashCode()
                + 17 * getValue(NotebookField.PRICE).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof NoteBook)) return false;
        boolean eq = true;
        NoteBook nb = (NoteBook) o;
        for (NotebookField field : NotebookField.values()) {
            if (!(nb.getValue(field).equals(getValue(field)))) eq = false;
        }
        return eq;
    }
}
