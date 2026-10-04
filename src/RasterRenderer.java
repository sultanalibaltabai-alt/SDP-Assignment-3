public class RasterRenderer implements Renderer {
    public String renderShape(String shapeName, String dimensionName, int dimension) {
        return "RASTER pixels of " + shapeName + " " + dimensionName + "=" + dimension;
    }
}