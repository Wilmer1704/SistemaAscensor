class Sensor {
    private boolean activo;       // Indica si el sensor está funcionando
    private boolean obstaculoDetectado; // Indica si hay un obstáculo
 
    // Constructor: el sensor inicia activo y sin obstáculos
    public Sensor() {
        this.activo= true;  // Sensor encendido
        this.obstaculoDetectado= false; // Sin obstáculos al inicio
    }
 
    // Simula la detección de un obstáculo
    public boolean detectarObstaculo() {
        // En un sistema real, aquí leería hardware (infrarrojo, etc.)
        System.out.println(" Sensor Verificando obstaculo...");
        if (!activo) {
            System.out.println(" Sensor inactivo.");
     }else{
        }
        return obstaculoDetectado; // Retorna el estado actual
    }
    // Permite simular manualmente que hay un obstáculo (para pruebas)
    public void setObstaculo(boolean valor) {
        this.obstaculoDetectado = valor;
    }
}
