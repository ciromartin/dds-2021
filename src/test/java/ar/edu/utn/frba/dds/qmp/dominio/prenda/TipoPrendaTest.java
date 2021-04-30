package ar.edu.utn.frba.dds.qmp.dominio.prenda;
import ar.edu.utn.frba.dds.qmp.dominio.fabrica.validacion.FabricaMaterialValido;
import ar.edu.utn.frba.dds.qmp.dominio.fabrica.validacion.FabricaMaterialValidoBasico;
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
        Arguments.of(TipoPrenda.CAMISA, Categoria.SUPERIOR),
        Arguments.of(TipoPrenda.PANTALON, Categoria.INFERIOR),
        Arguments.of(TipoPrenda.ZAPATO, Categoria.CALZADO),
        Arguments.of(TipoPrenda.ANTEOJOS, Categoria.ACCESORIO)
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
