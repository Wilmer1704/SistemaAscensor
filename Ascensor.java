class Ascensor {
    private int id;           
    private int pisoActual;   
    private String direccion;    
    private boolean enMovimiento;
    private int []solicitudes;  
    private int totalSolicitudes; 
    private BotonAscensor []botones; 
    private PuertaAscensor puerta;  
    //private int capacidad;    
    private double pesoActual;
 
    public Ascensor(int id, int totalPisos) {
        this.id= id;            
        this.pisoActual= 1;      
        this.direccion= "DETENIDO";    
        this.enMovimiento= false;         
        this.solicitudes= new int[10];   
        this.totalSolicitudes= 0;            
        this.botones= new BotonAscensor[totalPisos]; 
        this.puerta= new PuertaAscensor();          
        //this.capacidad= 8;             
        this.pesoActual= 0.0;           
 
        // Inicializa cada botón del panel interior del ascensor
        for (int i = 0; i < totalPisos; i++) {
            botones[i] = new BotonAscensor(i + 1); // Botón para el piso i+1
        }
    }
 
    //sube o baja según las solicitudes pendientes
    public void mover() {
        if (totalSolicitudes == 0) {          // Si no hay solicitudes, no hace nada
            System.out.println(" Ascensor " + id + " Sin solicitudes pendientes.");
            return;
        }
        int pisoDestino = solicitudes[0];     // Toma la primera solicitud del arreglo
 
        if (pisoDestino > pisoActual) {       // Si el destino está arriba
            subir();                          // Sube
        } else if (pisoDestino < pisoActual) {// Si el destino está abajo
            bajar();                          // Baja
        } else {
            detener();                        // Ya está en el piso destino
        }
    }
 
    // Mueve el ascensor hacia arriba piso por piso
    public void subir() {
        enMovimiento= true;                  // Marca que está en movimiento
        direccion= "SUBIR";               // Establece dirección
        pisoActual++;                         // Incrementa el piso actual
        System.out.println(" Ascensor " + id + " Subiendo... Piso actual: " + pisoActual);
    }
 
    // Mueve el ascensor hacia abajo piso por piso
    public void bajar() {
        enMovimiento= true;                  // Marca que está en movimiento
        direccion= "BAJAR";               // Establece dirección
        pisoActual--;                         // Decrementa el piso actual
        System.out.println(" Ascensor " + id + " Bajando... Piso actual: " + pisoActual);
    }
 
    // Detiene el ascensor en el piso actual
    public void detener() {
        enMovimiento= false;                 // Ya no está en movimiento
        direccion= "DETENIDO";            // Cambia dirección a detenido
        System.out.println(" Ascensor " + id + " Detenido en piso: " + pisoActual);
        eliminarSolicitud(pisoActual);        // Elimina la solicitud atendida
    }
 
    // Cambia la dirección del ascensor (SUBIR ↔ BAJAR)
    public void cambiarDireccion() {
        if (direccion.equals("SUBIR")) {
            direccion= "BAJAR";
        } else {
            direccion= "SUBIR";
        }
        System.out.println(" Ascensor " + id + " Direccion cambiada a: " + direccion);
    }
 
    // Agrega una solicitud (número de piso) al arreglo de solicitudes
    public void agregarSolicitud(int piso) {
        if (totalSolicitudes < solicitudes.length) { // Verifica que haya espacio
            solicitudes[totalSolicitudes] = piso;    // Agrega al final del arreglo
            totalSolicitudes++;                      // Incrementa el contador
            System.out.println(" Ascensor " + id + " Solicitud agregada: Piso " + piso);
        } else {
            System.out.println(" Ascensor " + id + " Cola de solicitudes llena.");
        }
    }
 
    // Elimina una solicitud atendida del arreglo (desplaza elementos)
    public void eliminarSolicitud(int piso) {
        for (int i = 0; i < totalSolicitudes; i++) {    // Recorre las solicitudes
            if (solicitudes[i] == piso) {               // Encuentra el piso a eliminar
                // Desplaza todos los elementos hacia la izquierda
                for (int j = i; j < totalSolicitudes - 1; j++) {
                    solicitudes[j] = solicitudes[j + 1]; // Mueve el siguiente al lugar actual
                }
                totalSolicitudes--;                     // Reduce el total de solicitudes
                System.out.println("[Ascensor " + id + "] Solicitud eliminada: Piso " + piso);
                return;                                 // Sale del método
            }
        }
    }
 
    // Ordena al ascensor abrir su puerta
    public void abrirPuerta() {
        puerta.abrir();                        // Delega la acción a la puerta
    }
 
    // Ordena al ascensor cerrar su puerta
    public void cerrarPuerta() {
        puerta.cerrar();                       // Delega la acción a la puerta
    }
 
    // Muestra el estado completo del ascensor
    public void mostrarEstado() {
        System.out.println(" ---- Estado Ascensor " + id + " ----");
        System.out.println(" Piso actual   : " + pisoActual);
        System.out.println(" Direccion     : " + direccion);
        System.out.println(" En movimiento : " + enMovimiento);
        System.out.println(" Solicitudes   : " + totalSolicitudes);
        System.out.println(" Peso actual   : " + pesoActual + " kg");
        System.out.println(" Puerta abierta: " + puerta.isAbierta());
    }
 
    // Getters necesarios para otras clases
    public int    getId()          { return id;           }
    public int    getPisoActual()  { return pisoActual;   }
    public String getDireccion()   { return direccion;    }
    public boolean isEnMovimiento(){ return enMovimiento; }
}
 