class Piso {
    private int numero;
    private BotonPiso []botones;  
    private PuertaPiso puerta;   
 
    // Constructor: crea el piso con sus botones y su puerta
    public Piso(int numero) {
        this.numero= numero;                // Guarda el número de piso
        this.botones= new BotonPiso[2];      // Cada piso tiene 2 botones: SUBIR y BAJAR
        this.botones[0]= new BotonPiso("SUBIR");  // Índice 0 = botón SUBIR
        this.botones[1]= new BotonPiso("BAJAR");  // Índice 1 = botón BAJAR
        this.puerta= new PuertaPiso();      // Crea la puerta del piso
    }
 
    // Llama al ascensor desde este piso (sin dirección específica)
    public void llamar() {
        System.out.println("[Piso " + numero + "] Llamando al ascensor...");
        botones[0].presionar();               // Presiona el botón de subida por defecto
    }
 
    // Abre la puerta del piso
    public void abrirPuerta() {
        puerta.abrir();                       // Delega a la puerta del piso
    }
 
    // Cierra la puerta del piso
    public void cerrarPuerta() {
        puerta.cerrar();                      // Delega a la puerta del piso
    }
 
    // Devuelve el número del piso
    public int getNumero() {
        return numero;
    }
 
    // Devuelve la puerta del piso (para abrir/cerrar desde el sistema)
    public PuertaPiso getPuerta() {
        return puerta;
    }
}