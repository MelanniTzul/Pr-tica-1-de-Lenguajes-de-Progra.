
package practicaunolenguajesprogra;

/**
 *
 * @author Melanni Tzul
 */
public class Palabra {
        
    String texto;
    Texto tipo;
    public Palabra (String texto, Texto tipo){
        this.texto = texto;
        this.tipo  = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public Texto getTipo() {
        return tipo;
    }
 
    
}
