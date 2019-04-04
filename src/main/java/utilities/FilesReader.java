package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesReader {

    public static List<String> leituradeCsvFile(String file) throws FileNotFoundException {

        List<String> linhasFicheiro = new ArrayList<String>();
        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            /**
             * Guarda os dados do ficheiro num array
             */
            String line;
            while ((line = lerArq.readLine()) != null) {
                linhasFicheiro.add(line);
            }
            arq.close();
        } catch (FileNotFoundException a) {
            System.err.printf("\nFicheiro não encontrado.\n", a.getMessage());
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo\n", e.getMessage());
        }
        return linhasFicheiro;

    }
}
