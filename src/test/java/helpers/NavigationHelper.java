package helpers;

import base.DriverManager;
import lombok.SneakyThrows;

public class NavigationHelper {

    @SneakyThrows
    public void navigateTo(String URL) throws Exception {
        DriverManager.getDriver().navigate().to(URL);
    }

}
