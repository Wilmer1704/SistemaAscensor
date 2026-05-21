class BotonPiso extends Boton {
    private String direccion; // Dirección que solicitará: "SUBIR" o "BAJAR"
 
    // Constructor: recibe la dirección del botón de piso
    public BotonPiso(String direccion) {
        super();                    // Llama al constructor de Boton (clase padre)
        this.direccion= direccion; // Asigna la dirección (SUBIR o BAJAR)
    }
 
    // Solicita que el ascensor suba al piso donde está este botón
    public void solicitarSubida() {
        direccion= "SUBIR";       // Establece la dirección como subida
        presionar();               // Ejecuta la lógica de presionar (heredada)
        System.out.println(" Solicitud de SUBIDA enviada.");
    }
 
    // Solicita que el ascensor baje al piso donde está este botón
    public void solicitarBajada() {
        direccion= "BAJAR";       // Establece la dirección como bajada
        presionar();               // Ejecuta la lógica de presionar (heredada)
        System.out.println(" Solicitud de BAJADA enviada.");
    }
 
    // Devuelve la dirección actual del botón
    public String getDireccion() {
        return direccion;
    }
}
