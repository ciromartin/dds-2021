package ar.edu.utn.frba.dds.qmp.dominio.tipoprenda;

import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;

public class Camisa extends TipoPrenda{
  public Camisa(FabricaMaterialValido fabricaMaterialValido) {
    super(Categoria.SUPERIOR, fabricaMaterialValido);
  }
}
