package pl.pjatk.EatGood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import pl.pjatk.EatGood.service.LdapService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LdapServiceTest {
    @Mock
    private LdapContextSource contextSource;

    @Mock
    private LdapTemplate ldapTemplate;

    private LdapService ldapService;

    @BeforeEach
    public void setUp() {
        ldapService = new LdapService(contextSource, ldapTemplate);
    }

    @Test
    public void shouldAuthenticate() {
        final String username = "testuser";
        final String password = "testpassword";

        ldapService.authenticate(username, password);

        verify(contextSource).getContext("cn=" + username + ",ou=Users,dc=eatgood,dc=local", password);
    }
}
