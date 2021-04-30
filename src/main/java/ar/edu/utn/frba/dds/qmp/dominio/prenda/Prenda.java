package ar.edu.utn.frba.dds.qmp.dominio.prenda;

import ar.edu.utn.frba.dds.qmp.dominio.material.Material;
import ar.edu.utn.frba.dds.qmp.dominio.material.color.Color;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.TipoPrenda;

import static java.util.Objects.requireNonNull;

public class Prenda {
  TipoPrenda tipo;
  Material material;

  public Prenda(TipoPrenda tipo, Material material){
    requireNonNull(tipo);
    requireNonNull(material);
    this.tipo = tipo;
    this.material = material;
  }

  public TipoPrenda getTipoPrenda() {
    return tipo;
  }

  public Categoria getCategoria() {
    return tipo.getCategoria();
  }

  public TipoTrama getTrama() {
    return material.getTrama();
  }

  public TipoMaterial getTipoMaterial() {
    return material.getTipoMaterial();
  }

  public Color getColorPrincipal() {
    return material.getColorPrincipal();
  }

  public Color getColorSecundario() {
    return material.getColorSecundario();
  }
}
