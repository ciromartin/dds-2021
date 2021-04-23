package ar.edu.utn.frba.dds.qmp.dominio;

public enum TipoPrenda {
  ZAPATO(Categoria.CALZADO),
  CAMISA(Categoria.SUPERIOR),
  PANTALON(Categoria.INFERIOR),
  ANTEOJOS(Categoria.ACCESORIO);

  private Categoria categoria;

  TipoPrenda(Categoria categoria){
    this.categoria = categoria;
  }

  public Categoria getCategoria(){
    return this.categoria;
  }
}
