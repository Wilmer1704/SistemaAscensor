public class SistemaAscensor {
 
    public static void main(String[] args) {
 
        // 1. Crear el sistema con 5 pisos
        SistemaControl sistema = new SistemaControl(5);
 
        // 2. Iniciar el sistema
        sistema.iniciarSistema();
 
        // 3. Agregar solicitudes al ascensor (usuario en piso 1 quiere ir al 4)
        sistema.getAscensor().agregarSolicitud(4); // Solicita piso 4
        sistema.getAscensor().agregarSolicitud(2); // Solicita piso 2
 
        // 4. Procesar las solicitudes (el ascensor se mueve)
        sistema.procesarSolicitudes();
        sistema.procesarSolicitudes();
        sistema.procesarSolicitudes();
 
        // 5. Abrir la puerta al llegar
        sistema.getAscensor().abrirPuerta();
 
        // 6. Simular que una persona llama desde el piso 3
        Piso piso3 = sistema.getPiso(2); // Índice 2 = Piso número 3
        piso3.llamar();                  // Llama al ascensor desde el piso 3
 
        // 7. Registrar una alerta de prueba
        sistema.registrarAlerta("Sensor de puerta con falla en piso 2.", "ADVERTENCIA");
 
        // 8. Detectar fallas
        sistema.detectarFallas();
 
        // 9. Mostrar estado completo
        sistema.mostrarEstadoSistema();
 
        // 10. Generar reporte final
        sistema.generarReporte();
    }
}