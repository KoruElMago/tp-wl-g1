package controladores;

import Core.DueloEntreLeyendas;
import Jugador.Jugador;
import Personaje.Personaje;
import TarjetaDeDuelo.Linea;
import TarjetaDeDuelo.TarjetaDeDuelo;
import controladores.ControladorBuscadorDuelo;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.TransactionalAndObservable;
import usuario.Usuario;

@Accessors
@TransactionalAndObservable
@SuppressWarnings("all")
public class ControladorTarjetaDuelo {
  private Usuario usuario;
  
  private DueloEntreLeyendas del;
  
  private List<Linea> lineas;
  
  private List<Personaje> personajes;
  
  private Personaje personajeElegido;
  
  private Linea lineaElegida;
  
  public ControladorTarjetaDuelo(final DueloEntreLeyendas del, final Usuario us) {
    this.del = del;
    this.usuario = us;
    List<Personaje> _personajes = del.getPersonajes();
    this.personajes = _personajes;
    ArrayList<Linea> _arrayList = new ArrayList<Linea>();
    this.lineas = _arrayList;
    this.lineas.add(Linea.Bottom);
    this.lineas.add(Linea.Top);
    this.lineas.add(Linea.Mid);
    this.lineas.add(Linea.Jungle);
  }
  
  public ControladorBuscadorDuelo buscarDuelo() {
    Jugador _jugador = this.usuario.getJugador();
    TarjetaDeDuelo tarjeta = new TarjetaDeDuelo(this.personajeElegido, _jugador, this.lineaElegida);
    TarjetaDeDuelo rival = this.del.buscarRivalDigno(tarjeta);
    boolean _or = false;
    TarjetaDeDuelo _tddBoot = this.del.getTddBoot();
    boolean _equals = rival.equals(_tddBoot);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = rival.equals(null);
      _or = _equals_1;
    }
    if (_or) {
      return this.crearDueloConBot(this.del, tarjeta);
    } else {
      return this.crearDueloNormal(this.del, tarjeta, rival);
    }
  }
  
  public ControladorBuscadorDuelo crearDueloNormal(final DueloEntreLeyendas del, final TarjetaDeDuelo usuario, final TarjetaDeDuelo retador) {
    String text = "Se ha encontrado Rival";
    return new ControladorBuscadorDuelo(del, usuario, retador, text);
  }
  
  public ControladorBuscadorDuelo crearDueloConBot(final DueloEntreLeyendas del, final TarjetaDeDuelo usuario) {
    String text = "No se ha encontrado rival que te haga frente.\n\t\t\t\t\t¿Deseas jugar contra bot MR-X de todas maneras?";
    TarjetaDeDuelo bot = null;
    return new ControladorBuscadorDuelo(del, usuario, bot, text);
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
  
  @Pure
  public DueloEntreLeyendas getDel() {
    return this.del;
  }
  
  public void setDel(final DueloEntreLeyendas del) {
    this.del = del;
  }
  
  @Pure
  public List<Linea> getLineas() {
    return this.lineas;
  }
  
  public void setLineas(final List<Linea> lineas) {
    this.lineas = lineas;
  }
  
  @Pure
  public List<Personaje> getPersonajes() {
    return this.personajes;
  }
  
  public void setPersonajes(final List<Personaje> personajes) {
    this.personajes = personajes;
  }
  
  @Pure
  public Personaje getPersonajeElegido() {
    return this.personajeElegido;
  }
  
  public void setPersonajeElegido(final Personaje personajeElegido) {
    this.personajeElegido = personajeElegido;
  }
  
  @Pure
  public Linea getLineaElegida() {
    return this.lineaElegida;
  }
  
  public void setLineaElegida(final Linea lineaElegida) {
    this.lineaElegida = lineaElegida;
  }
}
