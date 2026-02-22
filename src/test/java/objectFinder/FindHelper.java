package objectFinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import steps.Steps;

import java.io.File;
import java.io.IOException;

public class FindHelper {
    String file;
    ObjectMapper om = new ObjectMapper();
    RootObject pageObjects;
    Elements[] el;
    String locateUsing = null;
    String by = null;
    String parent;

    @SneakyThrows
    public By createBy(String elementName) throws IOException {
        String fountElement = null;
        file = "./src/test/java/pageElements/" + Steps.prefs.get("Sayfa", null) + ".json";
        pageObjects = om.readValue(new File(file), RootObject.class);
        el = pageObjects.getElements();
        parent = pageObjects.getParent();
        for (Elements elements : el) {
            if (elementName.equalsIgnoreCase(elements.getElementName())) {
                locateUsing = elements.getLocateUsing();
                by = elements.getLocator();
                fountElement = elements.getElementName();
                break;
            }
        }
        if (fountElement == null) {
            file = "./src/test/java/pageElements/" + parent + ".json";
            pageObjects = om.readValue(new File(file), RootObject.class);
            el = pageObjects.getElements();
            for (Elements elements : el) {
                if (elementName.equalsIgnoreCase(elements.getElementName())) {
                    locateUsing = elements.getLocateUsing();
                    by = elements.getLocator();
                    break;
                }
            }
        }
        if (("xpath".equalsIgnoreCase(locateUsing))) {
            return new By.ByXPath(by);
        }
        if (("id".equalsIgnoreCase(locateUsing))) {
            return new By.ById(by);
        }
        if (("name".equalsIgnoreCase(locateUsing))) {
            return new By.ByName(by);
        }
        if (("className".equalsIgnoreCase(locateUsing))) {
            return new By.ByClassName(by);
        }
        if (("css".equalsIgnoreCase(locateUsing))) {
            return new By.ByCssSelector(by);
        }
        if (("tagName".equalsIgnoreCase(locateUsing))) {
            return new By.ByTagName(by);
        }
        if (("linkText".equalsIgnoreCase(locateUsing))) {
            return new By.ByLinkText(by);
        }
        if (("partialLinkText".equalsIgnoreCase(locateUsing))) {
            return new By.ByPartialLinkText(by);
        }
        throw new RuntimeException();
    }

}