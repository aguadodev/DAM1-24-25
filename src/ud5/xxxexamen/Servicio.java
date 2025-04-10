package ud5.xxxexamen;

class Servicio {
    String nombre;
    int puerto;
    String protocolo;

    public Servicio(String nombre, int puerto, String protocolo) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacío.");
        }
        if (puerto < 0 || puerto > 65535) {
            throw new IllegalArgumentException("El puerto debe estar entre 0 y 65535.");
        }
        if (!protocolo.equals("TCP") && !protocolo.equals("UDP")) {
            throw new IllegalArgumentException("El protocolo solo puede ser TCP o UDP");
        }

        this.nombre = nombre;
        this.protocolo = protocolo;
        this.puerto = puerto;
    }

    @Override
    public String toString() {
        return nombre + " (" + puerto + "/" + protocolo + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Servicio otro = (Servicio) obj;
        return puerto == otro.puerto && protocolo.equals(otro.protocolo);
    }
}