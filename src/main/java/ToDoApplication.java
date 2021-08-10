
import Entity.User;
import repository.UserRepositoryImpl;
import service.UserServiceImpl;
import util.HibernateUtil;

import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

public class ToDoApplication {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory entityMangerFactory = HibernateUtil.entityManagerFactory;
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        menu();
        startApp(userService);
    }

    private static void menu() {
        System.out.println("1) Register: ");
        System.out.println("2) Login");
    }
    private static void startApp(UserServiceImpl userService)
    {
        try {
            System.out.println("which one do you want");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    userService.register();
                    break;
                case 2:
                    userService.loginUser();
                    break;
                default:
                    menu();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            menu();
        }
    }
}
//      EntityManager entityManager = entityMangerFactory.createEntityManager();
//    TestHiber t = new TestHiber();
//  t.addUser(entityManager,new User("ali23","73767"));
//TestHiber.insert(entityManager,new User("mohammd","234554"),new UserActivity("open"));