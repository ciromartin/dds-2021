package ar.edu.utn.frba.dds.qmp.dominio.tipoprenda;

import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;

public class Zapato extends TipoPrenda {

  public Zapato(FabricaMaterialValido fabricaMaterialValido) {
    super(Categoria.CALZADO, fabricaMaterialValido);
  }


}
