import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ConsoleNotebookView implements NotebookView {
    private Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Записей не найдено.");
        } else {
            for (Note note : notes) {
                System.out.println(note);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() {
        System.out.println("Введите дату и время (дд-ММ-гггг чч:мм):");
        while (true) {
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input, DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат. Пожалуйста, введите дату и время в формате дд-ММ-гггг чч:мм:");
            }
        }
    }

    @Override
    public String getDescriptionInput() {
        System.out.println("Введите описание записи:");
        return scanner.nextLine();
    }

    @Override
    public String getFileNameInput() {
        System.out.println("Введите имя файла:");
        return scanner.nextLine();
    }
}
