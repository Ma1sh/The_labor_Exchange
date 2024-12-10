import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
    private static ArrayList<Birja> usersList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить безработного");
            System.out.println("2. Найти безработного по параметру");
            System.out.println("3. Удалить запись о трудоустроенном");
            System.out.println("4. Выход");

            System.out.print("Выберите действие: ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    addbase();
                    break;
                case 2:
                    readbase();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    System.out.println("Выход");
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }

    public static void addbase() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите информацию о вас: ");
            System.out.println("Профессия: ");
            String profession = scanner.nextLine();
            System.out.println("Образование: ");
            String education = scanner.nextLine();
            System.out.println("Место и должность последней работы: ");
            String lastposition = scanner.nextLine();
            System.out.println("Причина увольнения: ");
            String cause = scanner.nextLine();
            System.out.println("Семейное положение: ");
            String family = scanner.nextLine();
            System.out.println("Жилищные условия: ");
            String home = scanner.nextLine();
            System.out.println("Контактные координаты: ");
            String contacts = scanner.nextLine();
            System.out.println("Требования к будущей работе: ");
            String requirements = scanner.nextLine();


            Birja user = new Birja(profession, education, lastposition, cause, family, home, contacts, requirements);
            usersList.add(user);

            File newfile = new File("users.txt");
            if (!newfile.exists()) {
                newfile.createNewFile();
            }
            FileWriter writer = new FileWriter(newfile, true);

            String data =
                    "Профессия: " + user.getProfession() + "\n" +
                            "Образование: " + user.getEducation() + "\n" +
                            "Место и должность последней работы: " + user.getLastposition() + "\n" +
                            "Причина увольнения: " + user.getCause() + "\n" +
                            "Семейное положение: " + user.getFamily() + "\n" +
                            "Жилищные условия: " + user.getHome() + "\n" +
                            "Контактные координаты: " + user.getContacts() + "\n" +
                            "Требования к будушей работе: " + user.getRequirements() + "\n" + "\n";
            writer.write(data);
            writer.flush();
            writer.close();

            System.out.println("Пользователь успешно добавлен в файл ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readbase() {
        System.out.println("Введите для поиска (Профессия,Образование и т.д.):");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(search.toLowerCase())) {
                    System.out.println("Данные найдены: " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Таких данных нет");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при поиски данных: " + e.getMessage());
        }
    }

    private static void remove() {
        System.out.println("Введите параметр трудоустроенного, которого хотите удалить:");
        Scanner scanner= new Scanner(System.in);
        String query = scanner.nextLine();

        List<String> usersList = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;


            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(query.toLowerCase())) {
                    found = true;
                    System.out.println("Удален трудоустроеный: " + line);
                } else {
                    usersList.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при удалении трудоустроеного: " + e.getMessage());
            return;
        }

        if (found) {
            try (FileWriter writer = new FileWriter("users.txt")) {
                for (String profession : usersList) {
                    writer.write(profession + "\n");
                }
                System.out.println("Файл успешно обновлен.");
            } catch (IOException e) {
                System.out.println("Ошибка при обновлении файла: " + e.getMessage());
            }
        } else {
            System.out.println("Трудоустроеный не найден.");
        }

    }
}