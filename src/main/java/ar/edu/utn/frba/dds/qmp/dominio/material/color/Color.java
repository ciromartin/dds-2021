package ar.edu.utn.frba.dds.qmp.dominio.material.color;

public class Color {
  private int rojo;
  private int verde;
  private int azul;

  public Color(int rojo, int verde, int azul){
    this.rojo = rojo;
    this.verde = verde;
    this.azul = azul;
  }

  public static Color blanco(){
    return new Color(255,255, 255);
  }
  public static Color rojo(){
    return new Color(255,0, 0);
  }
  public static Color azul(){
    return new Color(0,0, 255);
  }
  public static Color verde(){
    return new Color(0,255, 0);
  }
  public static Color negro(){
    return new Color(0,0, 0);
  }
}
