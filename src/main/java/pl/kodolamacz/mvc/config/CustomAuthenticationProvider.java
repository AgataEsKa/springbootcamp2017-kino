package pl.kodolamacz.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;
import pl.kodolamacz.spring.services.CinemaService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acacko on 19.11.17
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CinemaService cinemaService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userDao.findByEmail(name);

        try {

            if (user == null || !cinemaService.checkUser(name, password)) {
                throw new BadCredentialsException("Invalid username or password");
            }

        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username or password");
        }

        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        user.getRoles()
                .forEach(role -> grantedAuths.add(new SimpleGrantedAuthority(role.getRole())));

        return new UsernamePasswordAuthenticationToken(
                name, password, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
