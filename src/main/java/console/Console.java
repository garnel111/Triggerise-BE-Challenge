package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Console {
    public static String readLine(String prompt) {
        try {
            System.out.println(prompt);
            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);
            return in.readLine();
        } catch (Exception ex1) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE,
                    null, ex1);
            return null;
        }

    }

    public static int readInteger(String prompt) {
        do {
            try {
                String strInt = readLine(prompt);
                int valor = Integer.parseInt(strInt);

                return valor;
            } catch (NumberFormatException ex) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE,
                        null, ex);
            }

        } while (true);
    }

    public static boolean readBoolean(String prompt) {
        do {
            try {
                String strBool = readLine(prompt).toLowerCase();
                if (strBool.equals("y") || strBool.equals("s")) {
                    return true;
                } else if (strBool.equals("n")) {
                    return false;
                }
            } catch (NumberFormatException ex) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (Exception ex1) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE,
                        null, ex1);
            }
        } while (true);
    }

    public static int readOption(int low, int high, int exit) {
        int option;
        do {
            option = Console.readInteger("Introduza opção: ");
            if (option == exit) {
                break;
            }
        } while (option < low || option > high);
        return option;
    }

    public static Date readDate(String prompt) {
        do {
            try {
                String strDate = readLine(prompt);
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (Exception ex1) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE,
                        null, ex1);
            }

        } while (true);
    }

    public static double readDouble(String prompt) {
        do {
            try {
                String input = readLine(prompt);
                double valor = Double.parseDouble(input);

                return valor;
            } catch (NumberFormatException ex) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (Exception ex1) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE,
                        null, ex1);
            }
        } while (true);
    }

    public static void waitForKey(String prompt) {
        System.out.println(prompt);
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    private Console() {
        // to make sure thi is an utility class
    }
}
