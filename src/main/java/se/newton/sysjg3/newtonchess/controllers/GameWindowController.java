package se.newton.sysjg3.newtonchess.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class GameWindowController extends GenericController {
  // Row 1
  @FXML VBox sq00;
  @FXML VBox sq01;
  @FXML VBox sq02;
  @FXML VBox sq03;
  @FXML VBox sq04;
  @FXML VBox sq05;
  @FXML VBox sq06;
  @FXML VBox sq07;

  // Row 2
  @FXML VBox sq10;
  @FXML VBox sq11;
  @FXML VBox sq12;
  @FXML VBox sq13;
  @FXML VBox sq14;
  @FXML VBox sq15;
  @FXML VBox sq16;
  @FXML VBox sq17;

  // Row 3
  @FXML VBox sq20;
  @FXML VBox sq21;
  @FXML VBox sq22;
  @FXML VBox sq23;
  @FXML VBox sq24;
  @FXML VBox sq25;
  @FXML VBox sq26;
  @FXML VBox sq27;

  // Row 4
  @FXML VBox sq30;
  @FXML VBox sq31;
  @FXML VBox sq32;
  @FXML VBox sq33;
  @FXML VBox sq34;
  @FXML VBox sq35;
  @FXML VBox sq36;
  @FXML VBox sq37;

  // Row 5
  @FXML VBox sq40;
  @FXML VBox sq41;
  @FXML VBox sq42;
  @FXML VBox sq43;
  @FXML VBox sq44;
  @FXML VBox sq45;
  @FXML VBox sq46;
  @FXML VBox sq47;

  // Row 6
  @FXML VBox sq50;
  @FXML VBox sq51;
  @FXML VBox sq52;
  @FXML VBox sq53;
  @FXML VBox sq54;
  @FXML VBox sq55;
  @FXML VBox sq56;
  @FXML VBox sq57;

  // Row 7
  @FXML VBox sq60;
  @FXML VBox sq61;
  @FXML VBox sq62;
  @FXML VBox sq63;
  @FXML VBox sq64;
  @FXML VBox sq65;
  @FXML VBox sq66;
  @FXML VBox sq67;

  // Row 8
  @FXML VBox sq70;
  @FXML VBox sq71;
  @FXML VBox sq72;
  @FXML VBox sq73;
  @FXML VBox sq74;
  @FXML VBox sq75;
  @FXML VBox sq76;
  @FXML VBox sq77;

  @FXML
  protected void initialize() {
    sq00.setOnMouseClicked(this::test);
  }

  @FXML
  private void test(MouseEvent mouseEvent) {
    System.out.println("hej");
  }
}
