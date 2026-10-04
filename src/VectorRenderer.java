public class VectorRenderer implements Renderer {
    public String renderShape(String shapeName, String dimensionName, int dimension) {
        return "VECTOR " + shapeName + " " + dimensionName + "=" + dimension;
    }
}