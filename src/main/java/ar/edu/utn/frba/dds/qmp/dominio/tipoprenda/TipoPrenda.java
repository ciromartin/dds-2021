package ar.edu.utn.frba.dds.qmp.dominio.tipoprenda;

import ar.edu.utn.frba.dds.qmp.dominio.fabrica.validacion.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.material.Material;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;
import ar.edu.utn.frba.dds.qmp.exception.DominioException;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public enum TipoPrenda {

  CAMISA(Categoria.SUPERIOR),
  PANTALON(Categoria.INFERIOR),
  ZAPATO(Categoria.CALZADO),
  ANTEOJOS(Categoria.ACCESORIO);


  private Categoria categoria;

  TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }


}
