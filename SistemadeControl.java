class SistemaControl {
    private Piso[] pisos;       
    private Ascensor ascensor;   
    private Alerta[] alertas;     
    private int totalPisos;  
    private int totalAlertas;
 
    // Constructor: inicializa el sistema con el número de pisos indicado
    public SistemaControl(int totalPisos) {
        this.totalPisos= totalPisos;           // Guarda el total de pisos
        this.pisos= new Piso[totalPisos]; // Crea el arreglo de pisos
        this.alertas= new Alerta[20];       // Máximo 20 alertas simultáneas
        this.totalAlertas = 0;                    // Sin alertas al inicio
 
        // Crea cada piso del edificio
        for (int i = 0; i < totalPisos; i++) {
            pisos[i] = new Piso(i + 1);           // Piso 1, 2, 3, ...
        }
 
        // Crea el ascensor con acceso a todos los pisos
        this.ascensor= new Ascensor(1, totalPisos);
    }
 
    public void iniciarSistema() {
        System.out.println("  SISTEMA DE CONTROL DE ASCENSOR INICIADO  ");
        System.out.println("  Total de pisos: " + totalPisos);
    }
 
    // Procesa todas las solicitudes pendientes del ascensor
    public void procesarSolicitudes() {
        System.out.println(" ...Procesando solicitudes...");
        ascensor.mover();  // Mueve el ascensor según sus solicitudes
    }
 
    // Registra una nueva alerta en el sistema
    public void registrarAlerta(String mensaje, String tipo) {
        if (totalAlertas < alertas.length) {          // Verifica espacio en el arreglo
            alertas[totalAlertas] = new Alerta(mensaje, tipo); // Crea y guarda la alerta
            alertas[totalAlertas].mostrar();          // Muestra la alerta inmediatamente
            totalAlertas++;                           // Incrementa el contador
        } else {
            System.out.println("[Sistema] No se pueden registrar mas alertas.");
        }
    }
 
    // Detecta fallas revisando el estado del ascensor
    public void detectarFallas() {
        System.out.println("...Detectando fallas...");
 
        // Verifica si el ascensor está en emergencia
        if (ascensor.isEnMovimiento() && ascensor.getDireccion().equals("DETENIDO")) {
            registrarAlerta("Inconsistencia: ascensor en movimiento pero detenido.", "FALLA");
        } else {
            System.out.println(" No se detectaron fallas criticas.");
        }
    }
 
    // Muestra el estado general de todo el sistema
    public void mostrarEstadoSistema() {
        System.out.println("---- ESTADO DEL SISTEMA ----");
        ascensor.mostrarEstado();
 
        //PENDIENTE POR ENTENDER
        System.out.println("--- Pisos ---");
        for (int i = 0; i < totalPisos; i++) {        // Recorre todos los pisos
            System.out.println("Piso " + pisos[i].getNumero() + " Puerta: " + (pisos[i].getPuerta().isAbierta() ? "Abierta" : "Cerrada"));
        }
 
        System.out.println("--- Alertas activas: " + totalAlertas + " ---");
        for (int i = 0; i < totalAlertas; i++) {      // Recorre las alertas
            if (alertas[i].isActiva()) {              // Solo muestra las activas
                alertas[i].mostrar();
            }
        }
        System.out.println("..................................................");
    }
 
    // Genera un reporte completo del sistema
    public void generarReporte() {
        System.out.println("\n REPORTE DEL SISTEMA ");
        System.out.println(" Total pisos    : " + totalPisos);
        System.out.println(" Piso ascensor  : " + ascensor.getPisoActual());
        System.out.println(" Direccion      : " + ascensor.getDireccion());
        System.out.println(" Total alertas  : " + totalAlertas);
 
        int alertasActivas = 0;
        for (int i = 0; i < totalAlertas; i++) {      // Cuenta alertas activas
            if (alertas[i].isActiva()) alertasActivas++;
        }
        System.out.println("Alertas activas: " + alertasActivas);
        System.out.println("=========================================\n");
    }
 
    // Devuelve el ascensor para uso externo (por ejemplo, agregar solicitudes)
    public Ascensor getAscensor() {
        return ascensor;
    }
 
    // Devuelve un piso por índice (0-based)
    public Piso getPiso(int indice) {
        if (indice >= 0 && indice < totalPisos) {     // Valida el índice
            return pisos[indice];
        }
        return null;                                  // Retorna null si el índice es inválido
    }
}