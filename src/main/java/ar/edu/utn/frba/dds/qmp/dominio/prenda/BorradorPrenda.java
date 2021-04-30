package ar.edu.utn.frba.dds.qmp.dominio.prenda;

import ar.edu.utn.frba.dds.qmp.dominio.fabrica.validacion.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.fabrica.validacion.FabricaMaterialValidoBasico;
import ar.edu.utn.frba.dds.qmp.dominio.material.Material;
import ar.edu.utn.frba.dds.qmp.dominio.material.color.Color;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.TipoPrenda;
import ar.edu.utn.frba.dds.qmp.exception.DominioException;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class BorradorPrenda {
  private final FabricaMaterialValido fabricaMaterialValido;
  private final TipoPrenda tipo;
  private TipoTrama tipoTrama;
  private TipoMaterial tipoMaterial;
  private Color colorPrincipal;
  private Color colorSecundario;

  public BorradorPrenda(TipoPrenda tipo) {
    requireNonNull(tipo);
    this.tipo = tipo;
    this.fabricaMaterialValido = new FabricaMaterialValidoBasico();
  }

  public BorradorPrenda(TipoPrenda tipo, FabricaMaterialValido fabricaMaterialValido) {
    requireNonNull(tipo);
    requireNonNull(fabricaMaterialValido);
    this.tipo = tipo;
    this.fabricaMaterialValido = fabricaMaterialValido;
  }

  public void setTipoTrama(TipoTrama tipoTrama) {
    validarTrama(tipoTrama);
    this.tipoTrama = tipoTrama;
  }

  public void setTipoMaterial(TipoMaterial tipoMaterial) {
    validarTipoMaterial(tipoMaterial);
    this.tipoMaterial = tipoMaterial;
  }

  public void setColorPrincipal(Color colorPrincipal) {
    requireNonNull(colorPrincipal);
    this.colorPrincipal = colorPrincipal;
  }

  public void setColorSecundario(Color colorSecundario) {
    requireNonNull(colorSecundario);
    this.colorSecundario = colorSecundario;
  }

  public Prenda generarPrenda(){
    return new Prenda(this.tipo, new Material(this.tipoTrama,this.tipoMaterial,this.colorPrincipal, this.colorSecundario ));
  }

  private void validarTrama(TipoTrama tipoTrama){
    requireNonNull(tipoTrama);
    List<TipoTrama> tramasValidas = this.fabricaMaterialValido.tramasValidas(this.tipo.getCategoria());
    if (tramasValidas.stream().noneMatch(t -> t.equals(tipoTrama)))
      throw new DominioException(MessageFormat.format("la trama {0} no es valida. Solo se permite en la categoria {1}, las siguientes tramas {2}",
          tipoTrama.getNombre(),
          this.tipo.getCategoria().getNombre(),
          tramasValidas.stream().map(TipoTrama::getNombre).collect(Collectors.joining(","))));
  }

  private void validarTipoMaterial(TipoMaterial tipoMaterial){
    requireNonNull(tipoMaterial);
    List<TipoMaterial> tiposMaterialesValidos = this.fabricaMaterialValido.tiposMaterialesValidos(this.tipo.getCategoria());
    if (tiposMaterialesValidos.stream().noneMatch(t -> t.equals(tipoMaterial)))
      throw new DominioException(MessageFormat.format("el tipo de material {0} no es valida. Solo se permite en la categoria {1}, los siguientes tipos de materiales {2}",
          tipoMaterial.getNombre(),
          this.tipo.getCategoria().getNombre(),
          tiposMaterialesValidos.stream().map(TipoMaterial::getNombre).collect(Collectors.joining(","))));
  }

}
