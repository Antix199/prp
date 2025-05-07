package cl.ufro.dci.recompensas.dto;

public class RecCanDTO {

    private Long recId;
    private String recNombre;
    private String recDescripcion;
    private int recCostoPuntos;

    // GETTERS
    public Long getRecId() {
        return recId;
    }

    public String getRecNombre() {
        return recNombre;
    }

    public String getRecDescripcion() {
        return recDescripcion;
    }

    public int getRecCostoPuntos() {
        return recCostoPuntos;
    }

    // SETTERS
    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public void setRecNombre(String recNombre) {
        this.recNombre = recNombre;
    }

    public void setRecDescripcion(String recDescripcion) {
        this.recDescripcion = recDescripcion;
    }

    public void setRecCostoPuntos(int recCostoPuntos) {
        this.recCostoPuntos = recCostoPuntos;
    }
}
