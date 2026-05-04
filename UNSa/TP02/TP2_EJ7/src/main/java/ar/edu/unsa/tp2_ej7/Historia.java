package ar.edu.unsa.tp2_ej7;

/**
 * Representa la historia clínica de un paciente atendido en urgencias.
 * 
 * El identificador se asigna automáticamente de forma consecutiva (arranca en 1).
 * El código de paciente, estado inicial y especialidad requerida se establecen
 * en el constructor y no pueden cambiar.
 */
public class Historia {

    // Contador estático compartido por todas las instancias.
    // Cada vez que se crea una Historia, se usa este valor y se incrementa.
    private static int siguienteId = 1;

    private final int identificador;
    private final String codigoPaciente;
    private final EstadoPaciente estadoInicial;
    private final Especialidad especialidadRequerida;
    private boolean altaPaciente;
    private Medico medicoAsignado;

    /**
     * Crea una nueva historia clínica.
     *
     * @param codigoPaciente       Código identificador del paciente (ej: "Rocío").
     * @param estadoInicial        Estado del paciente al ingresar (GRAVE, MEDIO o LEVE).
     * @param especialidadRequerida Especialidad del médico que debe atenderlo.
     */
    public Historia(String codigoPaciente, EstadoPaciente estadoInicial, Especialidad especialidadRequerida) {
        this.identificador = siguienteId;
        siguienteId++;
        this.codigoPaciente = codigoPaciente;
        this.estadoInicial = estadoInicial;
        this.especialidadRequerida = especialidadRequerida;
        this.altaPaciente = false;
        this.medicoAsignado = null;
    }

    // ===================== Getters =====================

    public int getIdentificador() {
        return identificador;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public EstadoPaciente getEstadoInicial() {
        return estadoInicial;
    }

    public Especialidad getEspecialidadRequerida() {
        return especialidadRequerida;
    }

    public boolean isAltaPaciente() {
        return altaPaciente;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    // ===================== Funcionalidad =====================

    /**
     * Asigna un médico a esta historia.
     * 
     * Para que la asignación sea exitosa se debe cumplir:
     * 1. La historia no debe tener ya un médico asignado.
     * 2. La especialidad del médico debe coincidir con la requerida.
     * 3. El médico debe tener disponibilidad (cupo libre).
     * 
     * Si se cumplen las condiciones, se establece el médico y se retorna true.
     * En caso contrario se retorna false.
     *
     * @param m Médico candidato a ser asignado.
     * @return true si la asignación fue exitosa, false en caso contrario.
     */
    public boolean asignarMedico(Medico m) {
        if (this.medicoAsignado == null
                && this.especialidadRequerida == m.getEspecialidad()
                && m.estaDisponible()) {
            this.medicoAsignado = m;
            return true;
        } else {
            System.out.println("No se pudo asignar médico a la historia #" + this.identificador
                    + " (ya tiene médico o no hay coincidencia/disponibilidad).");
            return false;
        }
    }

    /**
     * Marca el alta médica del paciente.
     * 
     * Solo se puede dar el alta si la historia tiene un médico asignado.
     * Una vez dada el alta, no se puede revertir.
     */
    public void marcarAlta() {
        if (this.medicoAsignado != null && !this.altaPaciente) {
            this.altaPaciente = true;
        }
    }
}
