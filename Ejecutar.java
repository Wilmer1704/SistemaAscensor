public class Ejecutar {
 
    public static void main(String[] args) {
 
        //Crear el sistema con 5 pisos
        SistemaControl sistema = new SistemaControl(5);
 
        //Iniciar el sistema
        sistema.iniciarSistema();
 
        //Agregar solicitudes al ascensor (usuario en piso 1 quiere ir al 4)
        sistema.getAscensor().agregarSolicitud(4); // Solicita piso 4
        sistema.getAscensor().agregarSolicitud(2); // Solicita piso 2
 
        //Procesar las solicitudes (el ascensor se mueve)
        sistema.procesarSolicitudes();
        sistema.procesarSolicitudes();
        sistema.procesarSolicitudes();
 
        //Abrir la puerta al llegar
        sistema.getAscensor().abrirPuerta();
 
        //Simular que una persona llama desde el piso 3
        Piso piso3 = sistema.getPiso(2); // Índice 2 = Piso número 3
        piso3.llamar(); // Llama al ascensor desde el piso 3
 
        //Registrar una alerta de prueba
        sistema.registrarAlerta("Sensor de puerta con falla en piso 2.", "ADVERTENCIA");
 
        //Detectar fallas
        sistema.detectarFallas();
 
        //Mostrar estado completo
        sistema.mostrarEstadoSistema();
 
        //Generar reporte final
        sistema.generarReporte();
    }
}