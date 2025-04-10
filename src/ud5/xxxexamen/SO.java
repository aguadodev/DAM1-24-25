package ud5.xxxexamen;

public enum SO {
    WINDOWS("Windows"),
    LINUX("Linux"),
    MAC("Mac"),
    ANDROID("Android"),
    IOS("iOS");

    private String nombre;

    SO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
