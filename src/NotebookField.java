/**
 * Перечень всех параметров ноутбука с описанием
 */

public enum NotebookField {
    MANUFACTURER(0),            // Производитель
    MODEL(1),                   // Модель
    PRICE(2),                   // Цена
    PROCESSORMODEL(3),          // Модель процессора
    PROCESSORCORENUMBER(4),     // Количество ядер процессора
    PROCESSORCOREFREQUENCY(5),  // Тактовая частота процессора
    DISCRETEVIDEOTYPE(6),       // Тип дискретной видеокарты
    INTEGRATEDVIDEOTYPE(7),     // Тип встроенной видеокарты
    RAMSIZE(8),                 // Размер оперативной памяти
    RAMTYPE(9),                 // Тип оперативной памяти
    SSDSIZE(10),                 // Размер SSD диска
    SCREENRESOLUTION(11),        // Размер экрана в пикселях
    SCREENDIAGONAL(12),          // Диагональ экрана
    SCREENTYPE(13),              // Тип  матрицы
    OPERATIONSYSTEM(14);         // Операционная система

    private final int value;

    NotebookField(int value) {
        this.value = value;
    }

    /**
     * Метод для получения описания параметра
     * @return Описание параметра
     */

    String descritpion() {
        switch (value) {
            case 0: return "Производитель";
            case 1: return "Модель";
            case 2: return "Цена, руб.";
            case 3: return "Модель процессора";
            case 4: return "Количество ядер процессора";
            case 5: return "Тактовая частота процессора, ГГц";
            case 6: return "Тип дискретной видеокарты";
            case 7: return "Тип встроенной видеокарты";
            case 8: return "Размер оперативной памяти, ГБ";
            case 9: return "Тип оперативной памяти";
            case 10: return "Размер SSD диска, ГБ";
            case 11: return "Размер экрана в пикселях";
            case 12: return "Диагональ экрана";
            case 13: return "Тип матрицы";
            case 14: return "Операционная система";
        }
        return "Неизвестный параметр";
    }

    /**
     * Метод для определения, содержит ли параметр число
     * @return Признак наличия числа
     */
    boolean isNumber() {
        switch (value) {
            case 2:
            case 4:
            case 5:
            case 8:
            case 10:
            case 12: return true;
        }
        return false;
    }

}