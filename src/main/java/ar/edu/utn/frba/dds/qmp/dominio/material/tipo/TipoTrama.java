package ar.edu.utn.frba.dds.qmp.dominio.material.tipo;

public enum TipoTrama {
  LISA("LISA"),
  RAYADA("RAYADA"),
  LUNARES("LUNARES"),
  CUADROS("CUADROS"),
  ESTAMPADO("ESTAMPADO");

  private String nombre;

  TipoTrama(String nombre){
    this.nombre = nombre;
  }

  public String getNombre(){
    return this.nombre;
  }
}
