package ar.edu.utn.frba.dds.qmp.dominio.prenda;

import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValidoBasico;
import ar.edu.utn.frba.dds.qmp.dominio.material.color.Color;
import ar.edu.utn.frba.dds.qmp.dominio.material.Material;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.*;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;
import ar.edu.utn.frba.dds.qmp.exception.DominioException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {
  @Test
  public void validarNullEnParametros() {
    //Arrange
    //Act
    // Assert
    assertThrows(NullPointerException.class, () -> new Prenda(null, null));
  }

  @Test
  public void validarPrendaSinColorSecundarioCreadaCorrectamente() {
    //Arrange
    Color verde =  Color.verde();
    FabricaMaterialValido fabrica = new FabricaMaterialValidoBasico();
    TipoPrenda tipoCamisa =  new Camisa(fabrica);
    TipoMaterial tipoMaterialLana =  TipoMaterial.LANA;
    TipoTrama tipoTramaLisa =  TipoTrama.LISA ;
    Material material = new Material(tipoTramaLisa, tipoMaterialLana, verde);


    //Act
    Prenda prendaCamisa = new Prenda(tipoCamisa, material);

    //Assert
    assertEquals(Categoria.SUPERIOR, prendaCamisa.getCategoria());
    assertEquals(tipoCamisa, prendaCamisa.getTipoPrenda());
    assertEquals(tipoMaterialLana, prendaCamisa.getTipoMaterial());
    assertEquals(tipoTramaLisa, prendaCamisa.getTrama());
    assertEquals(verde, prendaCamisa.getColorPrincipal());
    assertNotNull(prendaCamisa.getColorSecundario());
  }

  @Test
  public void validarPrendaConColorSecundarioCreadaCorrectamente() {
    //Arrange
    Color rojo =  Color.rojo();
    Color azul =  Color.azul();
    FabricaMaterialValido fabrica = new FabricaMaterialValidoBasico();
    TipoPrenda tipoCamisa =  new Camisa(fabrica);
    TipoMaterial tipoMaterialLana =  TipoMaterial.LANA;
    TipoTrama tipoTramaLisa =  TipoTrama.LISA ;
    Material material = new Material(tipoTramaLisa, tipoMaterialLana, rojo, azul);


    //Act
    Prenda prendaCamisa = new Prenda(tipoCamisa, material);

    //Assert
    assertEquals(Categoria.SUPERIOR, prendaCamisa.getCategoria());
    assertEquals(tipoCamisa, prendaCamisa.getTipoPrenda());
    assertEquals(tipoMaterialLana, prendaCamisa.getTipoMaterial());
    assertEquals(tipoTramaLisa, prendaCamisa.getTrama());
    assertEquals(rojo, prendaCamisa.getColorPrincipal());
    assertEquals(azul, prendaCamisa.getColorSecundario());
  }

  private static List<Arguments> tiposDePrendasYMaterialesIncorrectos() {
    FabricaMaterialValido fabrica = new FabricaMaterialValidoBasico();
    return Arrays.asList(
        Arguments.of(new Camisa(fabrica), new Material(TipoTrama.CUADROS,TipoMaterial.MOHAIR, Color.rojo())),
        Arguments.of(new Zapato(fabrica), new Material(TipoTrama.CUADROS,TipoMaterial.CUERO, Color.rojo()))
    );
  }

  @ParameterizedTest
  @MethodSource("tiposDePrendasYMaterialesIncorrectos")
  public void validarExcepcionDeDominioAlCrearTipoPrendaConMaterialIncorrecto(TipoPrenda tipoPrenda, Material material) {
    //Assert
    assertThrows(DominioException.class, () -> new Prenda(tipoPrenda, material));
  }
}
