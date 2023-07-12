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
        return shortInfo();
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

    /**
     * Метод для вывода полной информации о ноутбуке
     * @return Строка с описанием
     */

    private String fullInfo() {
        StringBuilder sb = new StringBuilder();
        for (NotebookField field : NotebookField.values()) {
            sb.append(field.descritpion()).append(": ").append(getValue(field)).append("\n");
        }
        return sb.toString();
    }

    /**
     * Метод для вывода информации о ноутбуке в краткой форме
     * @return Строка с описанием
     */
    private String shortInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getValue(NotebookField.MANUFACTURER)).append(" ")
                .append(getValue(NotebookField.MODEL)).append(" (")
                .append(getValue(NotebookField.SCREENDIAGONAL)).append("\" ")
                .append(getValue(NotebookField.SCREENRESOLUTION)).append("/")
                .append(getValue(NotebookField.PROCESSORMODEL)).append(" ")
                .append(getValue(NotebookField.PROCESSORCORENUMBER)).append("x")
                .append(getValue(NotebookField.PROCESSORCOREFREQUENCY)).append("ГГц/")
                .append(getValue(NotebookField.RAMSIZE)).append("Гб/")
                .append(getValue(NotebookField.SSDSIZE)).append("Гб) - ")
                .append(getValue(NotebookField.PRICE)).append(" руб.");
        return sb.toString();
    }
}
