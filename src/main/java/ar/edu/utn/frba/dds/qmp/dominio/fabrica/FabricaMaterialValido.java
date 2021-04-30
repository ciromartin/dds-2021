package ar.edu.utn.frba.dds.qmp.dominio.fabrica;

import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;

import java.util.List;

public interface FabricaMaterialValido {
  List<TipoTrama> tramasValidas(Categoria categoria);
  List<TipoMaterial> tiposMaterialesValidos(Categoria categoria);
}
