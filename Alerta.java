class Alerta {
    private String mensaje; // Descripción de la alerta
    private String tipo; // Falla, Advertencia, Información
    private boolean activa; // Si la alerta activa
 
    // Constructor: crea una alerta con mensaje y tipo
    public Alerta(String mensaje, String tipo) {
        this.mensaje= mensaje; // Guarda el mensaje de la alerta
        this.tipo= tipo;  // Guarda el tipo de alerta
        this.activa= true;  // La alerta empieza activa
    }
 
    // Muestra la alerta 
    public void mostrar() {
        System.out.println(" ALERTA - " + tipo + " " + mensaje);
    }
 
    // Desactiva la alerta cuando se resuelve el problema
    public void desactivar() {
        activa= false;
        System.out.println(" Alerta desactivada: " + mensaje);
    }
 
    // Devuelve si la alerta está activa
    public boolean isActiva() {
        return activa;
    }
 
    public String getMensaje() { return mensaje; }
    public String getTipo()    { return tipo;    }
}