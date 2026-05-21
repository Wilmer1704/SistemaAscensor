class BotonAscensor extends Boton {
    private int pisoDestino; // Número del piso al que el usuario quiere ir
 
    // Constructor: recibe el número de piso destino
    public BotonAscensor(int pisoDestino) {
        super();                       // Llama al constructor de Boton
        this.pisoDestino= pisoDestino; // Guarda el piso destino
    }
 
    // Selecciona el piso destino y registra la solicitud
    public void seleccionarPiso() {
        presionar();                   // Ejecuta lógica base del botón
        System.out.println(" Piso destino seleccionado: " + pisoDestino);
    }
 
    // Devuelve el número de piso destino
    public int getPisoDestino() {
        return pisoDestino;
    }
}