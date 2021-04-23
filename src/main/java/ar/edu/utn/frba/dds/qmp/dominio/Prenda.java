package ar.edu.utn.frba.dds.qmp.dominio;

public class Prenda {
  TipoPrenda tipo;
  Material material;
  Color colorPrincipal;
  Color colorSecundario;

  public Prenda(TipoPrenda tipo, Material material, Color colorPrincipal, Color colorSecundario){
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal= colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public Prenda(TipoPrenda tipo, Material material, Color colorPrincipal) {
    this(tipo, material, colorPrincipal, null);
  }

  public TipoPrenda getTipo() {
    return tipo;
  }
  public Categoria getCategoria() {
    return tipo.getCategoria();
  }
  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Material getMaterial() {
    return material;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
