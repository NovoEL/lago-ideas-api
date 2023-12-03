package xyz.lagosoft.ideas.Auth;

import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.repository.BuilderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BuilderRepository builderRepository;

    public UserVO signUp(SignupDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        user.setHashedPassword(hashedPassword);
        Date now = new Date();
        user.setCreatedAt(now);
        userRepository.save(user);
        Builder builder = new Builder();
        builder.setUsername(user.getUsername());
        builderRepository.save(builder);
        return new UserVO(user);
    }

    public Boolean isSignedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken);
    }

}
