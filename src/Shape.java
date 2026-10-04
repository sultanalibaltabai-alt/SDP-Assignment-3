public abstract class Shape {
    private String id;
    private Renderer renderer;

    public Shape(String id, Renderer renderer) {
        this.id = id;
        this.renderer = renderer;
    }

    public String getId() {
        return id;
    }

    public void setImplementation(Renderer renderer) {
        this.renderer = renderer;
    }

    public String draw(String shapeName, String dimensionName, int dimension) {
        return renderer.renderShape(shapeName, dimensionName, dimension);
    }

    public abstract String execute();
}