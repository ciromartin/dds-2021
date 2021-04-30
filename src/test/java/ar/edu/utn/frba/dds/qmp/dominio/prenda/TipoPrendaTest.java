package ar.edu.utn.frba.dds.qmp.dominio.prenda;
import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.fabrica.FabricaMaterialValidoBasico;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.*;
import ar.edu.utn.frba.dds.qmp.dominio.tipoprenda.categoria.Categoria;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoPrendaTest {

  private static List<Arguments> tipoPrendaYCategoria() {
    FabricaMaterialValido fabrica = new FabricaMaterialValidoBasico();
    return Arrays.asList(
        Arguments.of(new Camisa(fabrica), Categoria.SUPERIOR),
        Arguments.of(new Pantalon(fabrica), Categoria.INFERIOR),
        Arguments.of(new Zapato(fabrica), Categoria.CALZADO),
        Arguments.of(new Anteojos(fabrica), Categoria.ACCESORIO)
    );
  }

  @ParameterizedTest
  @MethodSource("tipoPrendaYCategoria")
  public void elTipoDeUnaPrendaConcidaConSuCategoria(TipoPrenda tipo, Categoria categoria) {
    //Arrange
    //Act
    //Assert
    assertEquals(categoria, tipo.getCategoria());
  }
}
