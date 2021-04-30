package ar.edu.utn.frba.dds.qmp.dominio.tipoprenda;

import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.material.Material;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;
import ar.edu.utn.frba.dds.qmp.exception.DominioException;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TipoPrenda {
  protected Categoria categoria;
  protected FabricaMaterialValido fabricaMaterialValido;

  protected TipoPrenda(Categoria categoria, FabricaMaterialValido fabricaMaterialValido) {
    this.categoria = categoria;
    this.fabricaMaterialValido = fabricaMaterialValido;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public void esMaterialValido(Material material){
    validarTrama(material);
    validarTipoMaterial(material);
  }

  private void validarTrama(Material material){
    List<TipoTrama> tramasValidas = this.fabricaMaterialValido.tramasValidas(this.categoria);
    if (tramasValidas.stream().noneMatch(t -> t.equals(material.getTrama())))
      throw new DominioException(MessageFormat.format("la trama {0} no es valida. Solo se permite en la categoria {1}, las siguientes tramas {2}",
          material.getTrama().getNombre(),
          this.categoria.getNombre(),
          tramasValidas.stream().map(TipoTrama::getNombre).collect(Collectors.joining(","))));
  }

  private void validarTipoMaterial(Material material){
    List<TipoMaterial> tiposMaterialesValidos = this.fabricaMaterialValido.tiposMaterialesValidos(this.categoria);
    if (tiposMaterialesValidos.stream().noneMatch(t -> t.equals(material.getTipoMaterial())))
      throw new DominioException(MessageFormat.format("el tipo de material {0} no es valida. Solo se permite en la categoria {1}, los siguientes tipos de materiales {2}",
          material.getTipoMaterial().getNombre(),
          this.categoria.getNombre(),
          tiposMaterialesValidos.stream().map(TipoMaterial::getNombre).collect(Collectors.joining(","))));
  }
}
