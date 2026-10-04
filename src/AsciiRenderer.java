public class AsciiRenderer implements Renderer {
    public String renderShape(String shapeName, String dimensionName, int dimension) {
        return "ASCII art of " + shapeName + " " + dimensionName + "=" + dimension;
    }
}