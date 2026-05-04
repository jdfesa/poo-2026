package ar.edu.unsa.tp2_ej7;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un médico especialista que trabaja en el servicio de urgencias.
 * 
 * El nombre, la matrícula y la especialidad se establecen en el constructor
 * y no pueden cambiar. El cupo puede modificarse por necesidades del servicio.
 */
public class Medico {

    private final String nombre;
    private final int matricula;
    private final Especialidad especialidad;
    private int cupo;
    private List<Historia> historiasActivas;

    /**
     * Constructor completo.
     *
     * @param nombre       Nombre del médico.
     * @param matricula    Número de matrícula profesional.
     * @param especialidad Especialidad médica.
     * @param cupo         Número máximo de pacientes que puede atender.
     */
    public Medico(String nombre, int matricula, Especialidad especialidad, int cupo) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.cupo = cupo;
        this.historiasActivas = new ArrayList<>();
    }

    /**
     * Constructor con especialidad pero cupo por defecto (10).
     *
     * @param nombre       Nombre del médico.
     * @param matricula    Número de matrícula profesional.
     * @param especialidad Especialidad médica.
     */
    public Medico(String nombre, int matricula, Especialidad especialidad) {
        this(nombre, matricula, especialidad, 10);
    }

    /**
     * Constructor mínimo: especialidad FAMILIA y cupo 10 por defecto.
     *
     * @param nombre    Nombre del médico.
     * @param matricula Número de matrícula profesional.
     */
    public Medico(String nombre, int matricula) {
        this(nombre, matricula, Especialidad.FAMILIA, 10);
    }

    // ===================== Getters =====================

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public int getCupo() {
        return cupo;
    }

    public List<Historia> getHistoriasActivas() {
        return historiasActivas;
    }

    // ===================== Setter (solo cupo) =====================

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    // ===================== Funcionalidad =====================

    /**
     * Indica si el médico tiene disponibilidad para atender más pacientes.
     * Es decir, si el número de historias activas es menor que el cupo.
     *
     * @return true si puede atender más pacientes, false si está lleno.
     */
    public boolean estaDisponible() {
        return this.historiasActivas.size() < this.cupo;
    }

    /**
     * Retorna el nivel de disponibilidad del médico.
     * Es la cantidad de pacientes que aún puede recibir (cupo - historias activas).
     * Se usa para ordenar médicos por disponibilidad en el cuadro médico.
     *
     * @return Número de lugares libres.
     */
    public int getNivelDisponibilidad() {
        return this.cupo - this.historiasActivas.size();
    }

    /**
     * Asigna una historia a este médico.
     * 
     * Se verifica que la especialidad de la historia coincida con la del médico
     * y que el médico tenga disponibilidad. Si se cumplen las condiciones,
     * se agrega la historia a la lista del médico y se establece este médico
     * como médico de la historia.
     *
     * @param h Historia a asignar.
     * @return true si la asignación fue exitosa, false en caso contrario.
     */
    public boolean asignarHistoria(Historia h) {
        if (this.especialidad == h.getEspecialidadRequerida() && this.estaDisponible()) {
            if (h.asignarMedico(this)) {
                this.historiasActivas.add(h);
                return true;
            }
        }
        return false;
    }

    /**
     * Da el alta médica al paciente de una historia atendida por este médico.
     * 
     * Busca la historia por su identificador en la lista de historias activas.
     * Si la encuentra y tiene médico asignado, marca el alta y la elimina
     * de la lista de historias activas del médico.
     * La historia mantiene la referencia al médico que la atendió.
     *
     * @param idHistoria Identificador de la historia a dar de alta.
     */
    public void darAltaHistoria(int idHistoria) {
        int i = 0;
        while (i < this.historiasActivas.size()
                && this.historiasActivas.get(i).getIdentificador() != idHistoria) {
            i++;
        }
        if (i < this.historiasActivas.size()) {
            Historia h = this.historiasActivas.get(i);
            if (h.getMedicoAsignado() != null) {
                h.marcarAlta();
                this.historiasActivas.remove(i);
            }
        }
    }
}
