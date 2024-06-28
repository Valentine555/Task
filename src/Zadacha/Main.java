package Zadacha;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager(20);

        manager.mainMenu();


    }
}


    class Task {

        private String name;

        private String description;

        Task (String name, String description){

            this.name=name;

            this.description=description;

        }



        public String getName (){

            return name;

        }

        public void setName (String name){

            this.name=name;

        }


        public String getDescription (){

            return description;

        }

        public void setDescription (String description){

            this.description=description;

        }


        public String toString(){

            return name+ " - "+description;

        }

    }



    class TaskManager{

        private Task [] tasks;

        private Scanner scaner;



        public TaskManager (int size){

            this.tasks=new Task [size];

            this.scaner=new Scanner (System.in);



        }



        public void addTask (Task t) {

            for (int i=0; i<tasks.length;i++){

                if (tasks[i]==null){

                    tasks [i]=t;

                    System.out.println("Задача добавлена");

                    return;

                }

            }

            System.out.println("Не удалось добавить задачу");



        }

        public void removeTask(String name){

            for(int i=0; i<tasks.length;i++){

                if (tasks[i]!=null && tasks[i].getName().equals(name)){

                    tasks[i]=null;

                    return;

                }

            }

            System.out.println("Задача с таким именем не найдена");

        }





        public void viewTask() {

            boolean hasTasks = false; // Флаг для проверки наличия задач

            for (int i = 0; i < tasks.length; i++) {

                Task t = tasks[i];

                if (t != null) {

                    System.out.println((i + 1) + ". " + t);
                    hasTasks = true;
                }


            }

            if (!hasTasks) { // Если задач нет, выводим сообщение
                System.out.println("Список задач пуст.");


            }
        }


        public void mainMenu () {

            while (true){

                System.out.print("Меню:\n1. Создать задачу\n2. Удалить задачу\n3. Посмотреть все задачи\n4. Выход\nВведите номер действия: ");

                int i=scaner.nextInt();
                scaner.nextLine();



                switch (i){

                    case 1:

                        System.out.print("Введите имя задачи: ");

                        String s1=scaner.nextLine();

                        System.out.print("Введите описание задачи: ");

                        String s2=scaner.nextLine();

                        addTask(new Task(s1,s2));

                        break;



                    case 2:

                        System.out.print("Введите имя задачи, которую вы хотите удалить: ");

                        String s3=scaner.nextLine();

                        removeTask(s3);

                        break;

                    case 3:
                        System.out.println("     Список задач:");
                        viewTask();
                        System.out.println();
                        System.out.println("Для выхода в главное меню нажмите Enter");
                        String s4=scaner.nextLine();
                        break;


                    case 4:
                        System.out.println("Выход из программы...");
                        return;

                    default: System.out.println("Неверный выбор. Попробуйте снова");





                }

            }

        }}