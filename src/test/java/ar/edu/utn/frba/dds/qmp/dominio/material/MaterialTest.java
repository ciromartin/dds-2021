package ar.edu.utn.frba.dds.qmp.dominio.material;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaterialTest {

  @Test
  public void validarNullEnParametros() {
    //Arrange
    //Act
    // Assert
    assertThrows(NullPointerException.class, () -> {
      Material material = new Material(null, null, null);
    });
  }
}
