import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class NoteBookData {
    Set<NoteBook> set = new HashSet<>();

    public void loadFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("notebooks.csv"));
            // Считываем первую строку с заголовками таблицы
            String str = bufferedReader.readLine();
            // Считывыаем данные
            while ((str = bufferedReader.readLine()) != null) {
                NoteBook nb = new NoteBook();
                String[] data = str.split(";");
                nb.setManufacturer(data[0]);
                nb.setModel(data[1]);
                nb.setPrice(Integer.parseInt(data[2]));
                nb.setProcessorModel(data[3]);
                nb.setProcessorCoreNumber(Integer.parseInt(data[4]));
                nb.setProcessorCoreFrequency(Float.parseFloat(data[5]));
                nb.setDiscreteVideoType(data[6]);
                nb.setIntegratedVideoType(data[7]);
                nb.setRamSize(Integer.parseInt(data[8]));
                nb.setRamType(data[9]);
                nb.setSsdSize(Integer.parseInt(data[10]));
                nb.setScreenResolution(data[11]);
                nb.setScreenDiagonal(Float.parseFloat(data[12]));
                nb.setScreenType(data[13]);
                nb.setOperationSystem(data[14]);
                set.add(nb);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
