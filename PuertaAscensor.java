class PuertaAscensor extends Puerta {
    private boolean emergencia; // Indica si está en modo emergencia
 
    // Constructor: inicia sin emergencia activa
    public PuertaAscensor() {
        super();                    // Inicializa como Puerta base
        this.emergencia= false;    // Sin emergencia al inicio
    }
 
    // Activa el modo de emergencia: bloquea la puerta
    public void activarEmergencia() {
        emergencia= true;          // Marca el estado de emergencia
        bloquear();                 // Bloquea la puerta (heredado de Puerta)
        System.out.println(" --- PuertaAscensor--- EMERGENCIA activada. Puerta bloqueada.");
    }
 
    // Devuelve si hay emergencia activa
    public boolean isEmergencia() {
        return emergencia;
    }
}