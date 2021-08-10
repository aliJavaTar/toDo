package service;
import Entity.User;
import Entity.UserActivity;
import repository.UserActivityRepositoryImpl;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import repository.base.BaseRepository;
import service.base.BaseServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserServiceImpl extends BaseServiceImpl
        <User, Long, UserRepository> implements UserService {
    static Scanner input = new Scanner(System.in);

    public UserServiceImpl(BaseRepository UserInterface) {
        super((UserRepository) UserInterface);
    }

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    Long userIdAuth;

    public void register() {
        try {
            User user = new User();
            User userField = inputUserField(user);
            //bug
            User insertUser = save(userField);
            //fix this bug ali you can do this jop , i can do that
            System.out.println("insertUser: " + insertUser);

            User byUserName = repository.findByUserName(insertUser);
            System.out.println("my user >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(byUserName.toString());
            userIdAuth = byUserName.getId();
            System.out.println(" you can creat new activity " +
                    "(if you want click number...)\n 1) createNewActivity  2) exit");
            try {
                int numberClick = input.nextInt();
                switch (numberClick) {
                    case 1:
                        System.out.println("create new activity ");
                        createNewActivity();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                register();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createNewActivity() {
        System.out.println(userIdAuth + " my id");
        User user = findById(userIdAuth);
        System.out.println("my user findById");
        System.out.println(user.toString());
        List<UserActivity> activities = new ArrayList<>();
        System.out.println("how mach activity do you have ? ");
        int number = 0;
        try {
            number = input.nextInt();
            System.out.println("number: " + number);
        } catch (Exception e) {
            System.out.println("we have problem");
            System.out.println(e.getMessage());
            createNewActivity();
        }
        int cont = 1;
        for (int i = 0; i < number; i++) {
            System.out.println("Enter your Activity: " + cont++);
            activities.set(i, new UserActivity("open"));
        }
        user.setActivity(activities);
    }

//    private void choiceActivity(User user) {
//        menuShowActivity();
//        try {
//            int select = input.nextInt();
//            switch (select) {
//                case 1:
//                    user.setActivity();
//                    break;
//                case 2:
//                    activity.setStatus("In Progress");
//                    break;
//                case 3:
//                    activity.setStatus("Completed");
//                    break;
//                default:
//                    createNewActivity();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            createNewActivity();
//        }
//    }
//    private void menuShowActivity() {
//        System.out.println("Enter number between 1 and 3 (which one do you want ? ) ");
//        System.out.println(" 1) Open ");
//        System.out.println(" 2) In Progress ");
//        System.out.println(" 3) Completed ");
//    }

    boolean cheek = false, isUsername = false, isPassword = false;

    private User inputUserField(User user) {
        do {
            if (!isUsername) {
                System.out.println("enter your username: ");
                String username = input.next();
                isUsername = cheekUserName(username);
                if (isUsername) {
                    user.setUsername(username);
                } else System.out.println("username false .. try again");
            }
            if (!isPassword) {
                System.out.println("enter your password: ");
                String password = input.next();
                isPassword = cheekPassword(password);
                if (isPassword) {
                    user.setPassword(password);
                } else System.out.println("password false .. try again");
            }
            if (isPassword && isUsername)
                cheek = true;
        } while (!cheek);

        return user;
    }

    long authId = 0;

    public void loginUser() {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = new User();
        User userLogin = inputUserLogin(user);
        user = userRepository.findByUserName(userLogin);
        System.out.println("find " + user.getUsername() + " " + user.getPassword());
        authId = user.getId();
        System.out.println("id: " + authId);
        if (user.getId() == 0) {
            System.out.println("user not exist");
            System.exit(0);
        }
        if (userLogin.getPassword().equals(user.getPassword())) {
            //list activity
            List<UserActivity> activity = userLogin.getActivity();
            for (int i = 0; i < activity.size(); i++) {
                System.out.println(activity.get(i));
            }
        } else
            System.out.println("username or password false");
    }

    private User inputUserLogin(User user) {
        System.out.println("enter you username ");
        String username = input.next();
        user.setUsername(username);
        System.out.println("enter you password ");
        String password = input.next();
        user.setPassword(password);
        return user;
    }

    private boolean cheekUserName(String text) {
        boolean isTrue;
        String regex = "^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){1,16}[a-zA-Z0-9]$";
        isTrue = Pattern.matches(regex, text);
        return isTrue;
    }

    private boolean cheekPassword(String text) {
        boolean isTrue;
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
        isTrue = Pattern.matches(regex, text);
        return isTrue;
    }

}