package pl.pjatk.EatGood;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.pjatk.EatGood.controller.LdapController;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.exceptionshandlers.LdapAuthenticationException;
import pl.pjatk.EatGood.service.LdapService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class LdapControllerIT {
    @Autowired
    private LdapController ldapController;

    @MockBean
    private LdapService ldapService;

    @Test
    public void shouldLogin() throws LdapAuthenticationException {
        User user = new User(1, "username");
        user.setPassword("password");
        String jwt = ldapController.login(user);
        assertNotNull(jwt);
        verify(ldapService, times(1)).authenticate("username", "password");
    }
}
