package ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria;

public enum Categoria {
  SUPERIOR("SUPERIOR"),
  INFERIOR("INFERIOR"),
  CALZADO("CALZADO"),
  ACCESORIO("ACCESORIO");

  private String nombre;

  Categoria(String nombre){
    this.nombre = nombre;
  }

  public String getNombre(){
    return this.nombre;
  }

}
