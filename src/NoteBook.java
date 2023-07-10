import java.util.HashMap;
import java.util.Map;

public class NoteBook {

    // Коллекция данных ноутбука

    private Map<NotebookFields, String> data = new HashMap<>();

    /**
     * Метод для получения описания заданного параметра
     * @param field Параметр ноутбука
     * @return Описание параметра
     */
    public static String getDescription(NotebookFields field){
        switch (field) {
            case MANUFACTURER:          return "Производитель";
            case MODEL:                 return "Модель";
            case OPERATIONSYSTEM:       return "Операционная система";
            case SCREENDIAGONAL:        return "Диагональ экрана";
            case SCREENRESOLUTION:      return "Размер экрана в пикселях";
            case SCREENTYPE:            return "Тип матрицы";
            case PROCESSORMODEL:        return "Модель процессора";
            case PROCESSORCORENUMBER:   return "Количество ядер процессора";
            case PROCESSORCOREFREQUENCY:return "Тактовая частота процессора, ГГц";
            case RAMSIZE:               return "Размер оперативной памяти, ГБ";
            case RAMTYPE:               return "Тип оперативной памяти";
            case INTEGRATEDVIDEOTYPE:   return "Тип встроенной видеокарты";
            case DISCRETEVIDEOTYPE:     return "Тип дискретной видеокарты";
            case SSDSIZE:               return "Размер SSD диска, ГБ";
            case PRICE:                 return "Цена, руб.";
        }
        return "Неизвестный параметр";
    }

    /**
     * Метод для получения значения параметра ноутбука
     * @param field Параметр ноутбука
     * @return Значение параметра
     */
    public String getValue(NotebookFields field){
        return data.get(field);
    }

    /**
     * Метод для задания параметра ноутбука
     * @param field Параметр ноутбука
     * @param value Значение параметра
     */
    public void setValue(NotebookFields field, String value) {
        data.put(field, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NotebookFields field : NotebookFields.values()) {
            sb.append(getDescription(field)).append(": ").append(getValue(field)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return  5 * getValue(NotebookFields.MANUFACTURER).hashCode()
                + 11 * getValue(NotebookFields.MODEL).hashCode()
                + 17 * getValue(NotebookFields.PRICE).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof NoteBook)) return false;
        boolean eq = true;
        NoteBook nb = (NoteBook) o;
        for (NotebookFields field : NotebookFields.values()) {
            if (!(nb.getValue(field).equals(getValue(field)))) eq = false;
        }
        return eq;
    }
}
