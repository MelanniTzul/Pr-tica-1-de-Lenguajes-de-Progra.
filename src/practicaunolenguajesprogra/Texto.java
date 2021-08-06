
package practicaunolenguajesprogra;

/**
 *
 * @author Melanni Tzul
 */
public enum Texto {
    
    IDENTIFICADOR("ID: "),
    ENTERO("ENTERO: "),
    DECIMAL("DECIMAL: "),
    CARACTER("SIMBOLO:"),
    ERROR("ERROR:");
    String tipo;
    
    private Texto(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
    
}
