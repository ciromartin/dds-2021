package ar.edu.utn.frba.dds.qmp.dominio.prenda;

import ar.edu.utn.frba.dds.qmp.dominio.material.Material;
import ar.edu.utn.frba.dds.qmp.dominio.material.color.Color;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoMaterial;
import ar.edu.utn.frba.dds.qmp.dominio.material.tipo.TipoTrama;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.TipoPrenda;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

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
    TipoMaterial tipoMaterialLana =  TipoMaterial.LANA;
    TipoTrama tipoTramaLisa =  TipoTrama.LISA ;
    Material material = new Material(tipoTramaLisa, tipoMaterialLana, verde);


    //Act
    Prenda prendaCamisa = new Prenda(TipoPrenda.CAMISA, material);

    //Assert
    assertEquals(Categoria.SUPERIOR, prendaCamisa.getCategoria());
    assertEquals(TipoPrenda.CAMISA, prendaCamisa.getTipoPrenda());
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
    TipoMaterial tipoMaterialLana =  TipoMaterial.LANA;
    TipoTrama tipoTramaLisa =  TipoTrama.LISA ;
    Material material = new Material(tipoTramaLisa, tipoMaterialLana, rojo, azul);


    //Act
    Prenda prendaCamisa = new Prenda(TipoPrenda.CAMISA, material);

    //Assert
    assertEquals(Categoria.SUPERIOR, prendaCamisa.getCategoria());
    assertEquals(TipoPrenda.CAMISA, prendaCamisa.getTipoPrenda());
    assertEquals(tipoMaterialLana, prendaCamisa.getTipoMaterial());
    assertEquals(tipoTramaLisa, prendaCamisa.getTrama());
    assertEquals(rojo, prendaCamisa.getColorPrincipal());
    assertEquals(azul, prendaCamisa.getColorSecundario());
  }

  private static List<Arguments> tiposDePrendasYMaterialesIncorrectos() {
    return Arrays.asList(
        Arguments.of(TipoPrenda.CAMISA, new Material(TipoTrama.CUADROS,TipoMaterial.MOHAIR, Color.rojo())),
        Arguments.of(TipoPrenda.ZAPATO, new Material(TipoTrama.CUADROS,TipoMaterial.CUERO, Color.rojo()))
    );
  }
}
