package TarjetaDeDuelo;

import Jugador.Jugador;
import Personaje.Personaje;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TarjetaDeDuelo {
  private String linea;
  
  private Personaje personaje;
  
  private Jugador jugador;
  
  public boolean esRivalDigno(final TarjetaDeDuelo duelo) {
    boolean _and = false;
    int _calificacion = duelo.jugador.getCalificacion();
    int _minus = (_calificacion - 100);
    int _calificacion_1 = this.jugador.getCalificacion();
    boolean _lessThan = (_minus < _calificacion_1);
    if (!_lessThan) {
      _and = false;
    } else {
      int _calificacion_2 = this.jugador.getCalificacion();
      int _calificacion_3 = duelo.jugador.getCalificacion();
      int _plus = (_calificacion_3 + 100);
      boolean _lessThan_1 = (_calificacion_2 < _plus);
      _and = _lessThan_1;
    }
    return _and;
  }
  
  public int obtenerPoderDeAtaque() {
    throw new Error("Unresolved compilation problems:"
      + "\nkills cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nassists cannot be resolved"
      + "\n/ cannot be resolved"
      + "\n- cannot be resolved"
      + "\ndeads cannot be resolved"
      + "\n* cannot be resolved"
      + "\nvecesQueInicio cannot be resolved");
  }
  
  @Pure
  public String getLinea() {
    return this.linea;
  }
  
  public void setLinea(final String linea) {
    this.linea = linea;
  }
  
  @Pure
  public Personaje getPersonaje() {
    return this.personaje;
  }
  
  public void setPersonaje(final Personaje personaje) {
    this.personaje = personaje;
  }
  
  @Pure
  public Jugador getJugador() {
    return this.jugador;
  }
  
  public void setJugador(final Jugador jugador) {
    this.jugador = jugador;
  }
}
