package ar.edu.utn.frba.dds.qmp.dominio.tipoprenda;

import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;

public class Pantalon extends TipoPrenda{
  public Pantalon(FabricaMaterialValido fabricaMaterialValido) {
    super(Categoria.INFERIOR, fabricaMaterialValido);
  }
}
