package ar.edu.utn.frba.dds.qmp.dominio.material.tipo;

public enum TipoMaterial {
  ALGODON("ALGODON"),
  LANA("LANA"),
  CUERO("CUERO"),
  SEDA("SEDA"),
  MOHAIR("MOHAIR");

  private String nombre;

  TipoMaterial(String nombre){
    this.nombre = nombre;
  }

  public String getNombre(){
    return this.nombre;
  }
}
