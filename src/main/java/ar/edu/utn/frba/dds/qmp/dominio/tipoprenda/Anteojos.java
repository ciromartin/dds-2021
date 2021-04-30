package ar.edu.utn.frba.dds.qmp.dominio.tipoprenda;

import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;

public class Anteojos extends TipoPrenda{
  public Anteojos(FabricaMaterialValido fabricaMaterialValido) {
    super(Categoria.ACCESORIO, fabricaMaterialValido);
  }
}
