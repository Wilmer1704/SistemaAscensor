class PuertaPiso extends Puerta {
    // Hereda bloqueada de Puerta (se redefine aquí por el diagrama)
 
    // Constructor: llama al padre
    public PuertaPiso() {
        super(); // Inicializa como Puerta normal
    }
 
    public void bloquear() {
        bloqueada= true;  // Bloquea la puerta del piso
        System.out.println(" --PuertaPiso-- Puerta de piso bloqueada.");
    }
}