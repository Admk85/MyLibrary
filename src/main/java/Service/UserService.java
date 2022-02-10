package Service;

import Model.dao.User;
import Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

   public void  save(User user){
       userRepository.save(user);

    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public void saveById(Long Userid) {
        User users = userRepository.getById(Userid);
        userRepository.save(users);

    }

    public User findByUserId(Long UserId) {
        User user = userRepository.findById(UserId).get();
        return user;

    }

    public void saveByUserCardID(Long UserCardID) {
        User user = userRepository.getById(UserCardID);
        userRepository.save(user);

    }

    public User searchByUserCardID(Long UserCardID) {
        User user = userRepository.findById(UserCardID).get();
        return user;
    }

    public List<User> getByFirstname(String firstname) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getFirstname().toLowerCase().contains(firstname.toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }

    public List<User> getBySurname(String surname) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getSurname().toLowerCase().contains(surname.toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }

    public List<User> getByEmail(String email) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getEmail().toLowerCase().contains(email.toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }

    public List<User> getByFirstnameAndSurname(String firstname, String surname) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getFirstname().toLowerCase().contains(firstname.toLowerCase()) &&
                    user.getSurname().toLowerCase().contains(surname.toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }
}



