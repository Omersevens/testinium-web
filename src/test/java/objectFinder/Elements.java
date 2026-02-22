package objectFinder;

public class Elements {
    private String locator;

    private String locateUsing;

    private String elementName;

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getLocateUsing() {
        return locateUsing;
    }

    public void setLocateUsing(String locateUsing) {
        this.locateUsing = locateUsing;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    @Override
    public String toString() {
        return "ClassPojo [locator = " + locator + ", locateUsing = " + locateUsing + ", elementName = " + elementName + "]";
    }

}
