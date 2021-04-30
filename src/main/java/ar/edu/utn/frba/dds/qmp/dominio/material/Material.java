package ar.edu.utn.frba.dds.qmp.dominio.material;

import ar.edu.utn.frba.dds.qmp.dominio.material.color.Color;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;

import static java.util.Objects.requireNonNull;

public class Material {
  private TipoTrama tipoTrama;
  private TipoMaterial tipoMaterial;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Material(TipoTrama tipoTrama, TipoMaterial tipoMaterial, Color colorPrincipal, Color colorSecundario) {
    requireNonNull(tipoTrama);
    requireNonNull(tipoMaterial);
    requireNonNull(colorPrincipal);
    requireNonNull(colorSecundario);
    this.tipoTrama = tipoTrama;
    this.tipoMaterial = tipoMaterial;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public Material(TipoTrama tipoTrama, TipoMaterial tipoMaterial, Color colorPrincipal) {
    this(tipoTrama, tipoMaterial, colorPrincipal, Color.blanco());
  }



  public TipoTrama getTrama() {
    return tipoTrama;
  }

  public TipoMaterial getTipoMaterial() {
    return tipoMaterial;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
