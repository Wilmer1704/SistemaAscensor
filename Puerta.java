class Puerta {
    protected boolean abierta;   // true = abierta, false = cerrada
    protected boolean bloqueada; // true = bloqueada
    protected Sensor sensor;     // Sensor asociado a la puerta
 
    // inicializa la puerta cerrada, desbloqueada y con sensor
    public Puerta() {
        this.abierta   = false;     // Inicia cerrada
        this.bloqueada = false;     // Inicia desbloqueada
        this.sensor    = new Sensor(); // Crea el sensor de la puerta
    }
 
    // Abre la puerta si no está bloqueada y el sensor no detecta obstáculos
    public void abrir() {
        if (!bloqueada) {                              // Verifica que no esté bloqueada
            if (!sensor.detectarObstaculo()) {         // Verifica que no haya obstáculo
                abierta = true;                        // Cambia estado a abierta
                System.out.println(" Puerta abierta.");
            } else {
                System.out.println(" Obstaculo detectado. No se puede abrir.");
            }
        } else {
            System.out.println(" Puerta bloqueada. No se puede abrir.");
        }
    }
 
    // Cierra la puerta
    public void cerrar() {
        abierta = false;                               // Cambia estado a cerrada
        System.out.println(" Puerta cerrada.");
    }
 
    // Bloquea la puerta (no puede abrirse ni cerrarse)
    public void bloquear() {
        bloqueada = true;
        System.out.println("[Puerta] Puerta bloqueada.");
    }
 
    // Desbloquea la puerta
    public void desbloquear() {
        bloqueada = false;
        System.out.println("[Puerta] Puerta desbloqueada.");
    }
 
    // Devuelve si la puerta está abierta
    public boolean isAbierta() {
        return abierta;
    }
}