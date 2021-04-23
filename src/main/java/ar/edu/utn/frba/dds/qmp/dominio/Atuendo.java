package ar.edu.utn.frba.dds.qmp.dominio;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
  List<Prenda> prendas;

  public Atuendo(){
    prendas = new ArrayList<>();
  }

  public void addPrenda(Prenda prenda){
    prendas.add(prenda);
  }

}
