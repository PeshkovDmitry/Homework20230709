import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class NoteBookData {
    Set<NoteBook> set = new HashSet<>();

    public NoteBookData() {
        loadFromFile();
    }

    public void loadFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("notebooks.csv"));
            String str = "";
            // Считывыаем данные
            while ((str = bufferedReader.readLine()) != null) {
                NoteBook nb = new NoteBook();
                String[] data = str.split(";");
                for (int i = 0; i < NoteBook.NotebookFields.values().length; i++) {
                    nb.setValue(NoteBook.NotebookFields.values()[i], data[i]);
                }
                set.add(nb);
                System.out.println(nb);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }




}
