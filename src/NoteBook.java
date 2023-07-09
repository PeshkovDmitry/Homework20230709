public class NoteBook {
    private String manufacturer;            // Производитель
    private String model;                   // Модель
    private String operationSystem;         // Операционная система
    private float screenDiagonal;           // Диагональ экрана
    private String screenResolution;        // Размер экрана в пикселях
    private String screenType;              // Тип  матрицы
    private String processorModel;          // Модель процессора
    private int processorCoreNumber;        // Количество ядер процессора
    private float processorCoreFrequency;   // Тактовая частота процессора
    private int ramSize;                    // Размер оперативной памяти
    private String ramType;                 // Тип оперативной памяти
    private String integratedVideoType;     // Тип встроенной видеокарты
    private String discreteVideoType;       // Тип дискретной видеокарты
    private int ssdSize;                    // Размер SSD диска
    private int price;                      // Цена


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public float getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(float screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String processorModel) {
        this.processorModel = processorModel;
    }

    public int getProcessorCoreNumber() {
        return processorCoreNumber;
    }

    public void setProcessorCoreNumber(int processorCoreNumber) {
        this.processorCoreNumber = processorCoreNumber;
    }

    public float getProcessorCoreFrequency() {
        return processorCoreFrequency;
    }

    public void setProcessorCoreFrequency(float processorCoreFrequency) {
        this.processorCoreFrequency = processorCoreFrequency;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public String getIntegratedVideoType() {
        return integratedVideoType;
    }

    public void setIntegratedVideoType(String integratedVideoType) {
        this.integratedVideoType = integratedVideoType;
    }

    public String getDiscreteVideoType() {
        return discreteVideoType;
    }

    public void setDiscreteVideoType(String discreteVideoType) {
        this.discreteVideoType = discreteVideoType;
    }

    public int getSsdSize() {
        return ssdSize;
    }

    public void setSsdSize(int ssdSize) {
        this.ssdSize = ssdSize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Производитель: ").append(manufacturer).append("\n");
        sb.append("Модель: ").append(model).append("\n");
        sb.append("Операционная система: ").append(operationSystem).append("\n");
        sb.append("Диагональ экрана: ").append(screenDiagonal).append("\n");
        sb.append("Размер экрана в пикселях: ").append(screenResolution).append("\n");
        sb.append("Тип  матрицы: ").append(screenType).append("\n");
        sb.append("Модель процессора: ").append(processorModel).append("\n");
        sb.append("Количество ядер процессора: ").append(processorCoreNumber).append("\n");
        sb.append("Тактовая частота процессора: ").append(processorCoreFrequency).append("\n");
        sb.append("Размер оперативной памяти: ").append(ramSize).append("\n");
        sb.append("Тип оперативной памяти: ").append(ramType).append("\n");
        sb.append("Тип встроенной видеокарты: ").append(integratedVideoType).append("\n");
        sb.append("Тип дискретной видеокарты: ").append(discreteVideoType).append("\n");
        sb.append("Размер SSD диска: ").append(ssdSize).append("\n");
        sb.append("Цена: ").append(price).append("\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return 5 * manufacturer.hashCode() + 11 * model.hashCode() + 17 * price;
    }
}
