package objectFinder;

public class RootObject {
    private String parent;

    private Elements[] elements;

    public String getParent() {
        return parent;
    }

    public Elements[] getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "ClassPojo [parent = " + parent + ", elements = " + elements + "]";
    }

}
