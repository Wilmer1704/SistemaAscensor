class Boton {      // reseprenta un botón de control en el sistema
    // Atributos
    protected boolean encendido;   // luz del botón está encendida
    protected boolean funcionando; // botón en funcionamiento 
    protected boolean sonido;      // botón tiene sonido
 
    // Constructor: inicializa el botón como apagado, funcionando y sin sonido
    public Boton() {
        this.encendido= false; // inicia luz apagada
        this.funcionando= true;  // botón funciona correctamente
        this.sonido= true;  // sonando habilitado
    }
 
    public void presionar() {         // si el boton no tiene falla, enciende la luz y emite sonido    
        if (funcionando == true) {            
            encenderLuz();            
            emitirSonido();           
            System.out.println(" BOTON Presionado.");
        } else {
            System.out.println(" BOTON Falla: el boton no funciona.");
        }
    }
 
    // Enciende la luz LED del botón
    public void encenderLuz() {
        encendido= true;                              // Cambia el estado a encendido
        System.out.println("[Boton] Luz encendida.");
    }
 
    // Apaga la luz LED del botón
    public void apagarLuz() {
        encendido= false;                             // Cambia el estado a apagado
        System.out.println("[Boton] Luz apagada.");
    }
 
    // Emite el sonido de confirmación
    public void emitirSonido() {
        if (sonido == true ) {                                  // Solo emite si el sonido está activo
            System.out.println("[Boton] *Beep*");
        }
    }
 
    // Reporta una falla en el botón al sistema
    public void reportarFalla() {
        funcionando= false;                           // Marca el botón como no funcional
        System.out.println("[Boton] Falla reportada.");
    }
}