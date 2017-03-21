package fr.ws.service;

import com.google.common.collect.ImmutableSet;
import fr.ws.bean.User;
import fr.ws.config.AfterSaleProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private AfterSaleProperties afterSaleProperties;

    @Before
    public void setup() {
        AfterSaleProperties.Vsa vca = Mockito.mock(AfterSaleProperties.Vsa.class);
        when(afterSaleProperties.getVsa()).thenReturn(vca);

        AfterSaleProperties.Cancel cancel = Mockito.mock(AfterSaleProperties.Cancel.class);
        when(afterSaleProperties.getCancel()).thenReturn(cancel);
    }

    @Test
    public void addUser() {
        // Given
        when(afterSaleProperties.getVsa().getAuthorisedCountries()).thenReturn("DE");
        when(afterSaleProperties.getCancel().getAuthorisedCountries()).thenReturn(ImmutableSet.of("FR", "IT"));

        // Then
        List<User> users = userService.addUser("3", "hmimiza", "32");
        assertTrue(users.size() == 3);
    }
}