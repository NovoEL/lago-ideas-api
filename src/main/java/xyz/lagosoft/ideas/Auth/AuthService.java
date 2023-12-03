package xyz.lagosoft.ideas.Auth;

public interface AuthService {

    UserVO signUp(SignupDTO dto);

    Boolean isSignedIn();

}
