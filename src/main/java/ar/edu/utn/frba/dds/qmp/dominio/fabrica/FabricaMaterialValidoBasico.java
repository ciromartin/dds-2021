package ar.edu.utn.frba.dds.qmp.dominio.fabrica;

import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FabricaMaterialValidoBasico implements FabricaMaterialValido {

  @Override
  public List<TipoTrama> tramasValidas(Categoria categoria) {
    switch (categoria) {
      case SUPERIOR:
        return Arrays.asList(TipoTrama.LISA, TipoTrama.RAYADA, TipoTrama.LUNARES, TipoTrama.ESTAMPADO);
      case INFERIOR:
        return Arrays.asList(TipoTrama.LISA, TipoTrama.RAYADA);
      default:
        return Collections.singletonList(TipoTrama.LISA);
    }
  }

  @Override
  public List<TipoMaterial> tiposMaterialesValidos(Categoria categoria) {
    switch (categoria) {
      case SUPERIOR:
        return Arrays.asList(TipoMaterial.LANA, TipoMaterial.ALGODON, TipoMaterial.CUERO, TipoMaterial.SEDA);
      case INFERIOR:
        return Arrays.asList(TipoMaterial.ALGODON, TipoMaterial.SEDA);
      case CALZADO:
        return Collections.singletonList(TipoMaterial.CUERO);
      case ACCESORIO:
        return Collections.singletonList(TipoMaterial.LANA);
      default:
        return new ArrayList<>();
    }
  }
}
