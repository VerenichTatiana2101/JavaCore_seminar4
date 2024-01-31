package PasswordRead.src.domen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import PasswordRead.src.exceptions.WrongLoginException;
import PasswordRead.src.exceptions.WrongPasswordException;

public class PasswordReader {

    static boolean checkInputData(String file, String path) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            while (reader.ready()) {
                String line = reader.readLine();

                String array[] = line.split(" ");
                if (array[0].length() > 20)
                    throw new WrongLoginException("Введённый логин, больше 20 символов");
                if (!(array[1].equals(array[2])))
                    throw new WrongPasswordException(
                            "Введенный пароль не совпадает, ввели " + array[1] + " и " + array[2]);
                if (array[1].length() > 20)
                    throw new WrongPasswordException("Введённый пароль, больше 20 символов");
            }

        } catch (IOException | WrongLoginException | WrongPasswordException e) {
            loggingReader(e.getMessage(), path);
            return false;
        }
        loggingReader("Пароли совпадают, данные сохранены ", path);
        return true;
    }

    public static void loggingReader(String msg, String path2) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) { //без true старую строку стирает
            bw.write(msg);
            bw.newLine();
            System.out.println(msg + " Date " + LocalDate.now());
            System.out.println("Log записан успешно");
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
