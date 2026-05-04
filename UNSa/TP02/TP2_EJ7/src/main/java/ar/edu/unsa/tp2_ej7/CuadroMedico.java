package ar.edu.unsa.tp2_ej7;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa el cuadro médico de urgencias.
 * 
 * Contiene la lista de médicos que están trabajando en urgencias en un momento dado.
 * La lista está organizada internamente para facilitar búsquedas por especialidad
 * y disponibilidad.
 */
public class CuadroMedico {

    private List<Medico> doctores;

    public CuadroMedico() {
        this.doctores = new ArrayList<>();
    }

    /**
     * Inserta un médico en el cuadro médico.
     *
     * @param m Médico a insertar.
     */
    public void insertarMedico(Medico m) {
        this.doctores.add(m);
    }

    /**
     * Elimina un médico del cuadro médico.
     *
     * @param m Médico a eliminar.
     */
    public void eliminarMedico(Medico m) {
        this.doctores.remove(m);
    }

    /**
     * Obtiene el médico con mayor disponibilidad para una especialidad dada.
     * 
     * Recorre la lista de doctores buscando aquellos que coincidan con la
     * especialidad indicada y que tengan disponibilidad. De todos ellos,
     * retorna el que tenga más lugares libres (mayor nivel de disponibilidad).
     * 
     * Si no hay ningún médico disponible para esa especialidad, retorna null.
     *
     * @param e Especialidad buscada.
     * @return El médico con mayor disponibilidad, o null si no hay ninguno.
     */
    public Medico obtenerMedicoMayorDisponibilidad(Especialidad e) {
        Medico masDisponible = null;
        for (Medico m : this.doctores) {
            if (m.getEspecialidad() == e && m.estaDisponible()) {
                if (masDisponible == null) {
                    masDisponible = m;
                } else if (m.getNivelDisponibilidad() > masDisponible.getNivelDisponibilidad()) {
                    masDisponible = m;
                }
            }
        }
        return masDisponible;
    }
}
