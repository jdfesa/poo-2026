package ar.edu.unsa.tp2_ej7;

import java.util.ArrayList;
import java.util.List;

/**
 * Programa principal para probar la funcionalidad del sistema de urgencias.
 * 
 * Crea médicos, los inserta en un cuadro médico, crea historias de pacientes
 * y asigna cada historia al médico más disponible de la especialidad requerida.
 */
public class TP2_EJ7 {

    public static void main(String[] args) {

        // ============================================================
        // 1. Crear los médicos según la consigna
        // ============================================================
        Medico nortes = new Medico("Nortes", 5677, Especialidad.PEDIATRIA);
        Medico gutierrez = new Medico("Gutiérrez", 4568, Especialidad.FAMILIA);
        Medico mayor = new Medico("Mayor", 7890, Especialidad.FAMILIA);
        Medico guillen = new Medico("Guillén", 4567, Especialidad.TRAUMATOLOGIA);
        Medico mateo = new Medico("Mateo", 8976, Especialidad.TRAUMATOLOGIA);

        // ============================================================
        // 2. Crear el cuadro médico e insertar todos los médicos
        // ============================================================
        CuadroMedico cm = new CuadroMedico();
        cm.insertarMedico(nortes);
        cm.insertarMedico(gutierrez);
        cm.insertarMedico(mayor);
        cm.insertarMedico(guillen);
        cm.insertarMedico(mateo);

        // ============================================================
        // 3. Crear la lista de historias de los pacientes
        // ============================================================
        List<Historia> historias = new ArrayList<>();
        historias.add(new Historia("Rocío", EstadoPaciente.LEVE, Especialidad.PEDIATRIA));
        historias.add(new Historia("Andrés", EstadoPaciente.GRAVE, Especialidad.TRAUMATOLOGIA));
        historias.add(new Historia("Juan", EstadoPaciente.MEDIO, Especialidad.TRAUMATOLOGIA));
        historias.add(new Historia("Marieta", EstadoPaciente.LEVE, Especialidad.FAMILIA));
        historias.add(new Historia("Alfonso", EstadoPaciente.MEDIO, Especialidad.FAMILIA));

        // ============================================================
        // 4. Recorrer las historias y asignar el médico más disponible
        //    según la especialidad requerida.
        //    Imprimir: nombre del médico – nombre del paciente – nro de historia
        // ============================================================
        System.out.println("========== ASIGNACIONES ==========");
        for (Historia h : historias) {
            Medico seleccionado = cm.obtenerMedicoMayorDisponibilidad(h.getEspecialidadRequerida());
            if (seleccionado != null) {
                seleccionado.asignarHistoria(h);
                System.out.println(seleccionado.getNombre() + " – "
                        + h.getCodigoPaciente() + " – Historia #"
                        + h.getIdentificador());
            } else {
                System.out.println("Sin médico disponible para "
                        + h.getCodigoPaciente() + " (especialidad: "
                        + h.getEspecialidadRequerida() + ")");
            }
        }
        System.out.println("==================================");
    }
}
