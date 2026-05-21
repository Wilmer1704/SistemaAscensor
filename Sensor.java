class Sensor {
    private boolean activo; // Indica si el sensor está funcionando
    private boolean obstaculoDetectado; // Indica si hay un obstáculo
 
    //el sensor inicia activo y sin obstáculos
    public Sensor() {
        this.activo= true;  // Sensor encendido
        this.obstaculoDetectado= false; // Sin obstáculos al inicio
    }
 
    // Simula la detección de un obstáculo
    public boolean detectarObstaculo() {
        System.out.println(" Sensor Verificando obstaculo...");
        if (!activo) {
            System.out.println(" Sensor inactivo.");
     }
        return obstaculoDetectado; // Retorna el estado actual
    }
    // Permite simular manualmente que hay un obstáculo (para pruebas)
    public void setObstaculo(boolean valor) {
        this.obstaculoDetectado = valor;
    }
}
