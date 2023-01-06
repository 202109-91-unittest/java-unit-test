package otp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {
    @Mock
    private IProfile profile;
    @Mock
    private IToken token;
    @InjectMocks
    private AuthenticationService authenticationService;

    @Nested
    class WhenCheckingIfIsValid {

        @Test
        public void valid() {
            when(profile.getPassword("joey")).thenReturn("91");
            when(token.getRandom(anyString())).thenReturn("000000");

            boolean actual = authenticationService.isValid("joey", "91000000");
            assertTrue(actual);
        }

        @BeforeEach
        void setup() {
        }
    }
}
