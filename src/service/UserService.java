package service;
import model.User;
import repository.UserRepository;


public class UserService {

    public static void createUser(User user) {
        try {
            UserRepository.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
