package com.okayestprogrammer

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.{HBox, Priority, StackPane}
import javafx.stage.Stage

import com.okayestprogrammer.controls.GroupBox
import javafx.scene.layout.VBox

object Main {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[EntryPoint], args: _*)
  }
}

class EntryPoint extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("Hello World!")

    val groupBoxA = new GroupBox("Group Box Test 1", new Button("Merp"))
    val groupBoxB = new GroupBox("Group Box Test 2", new Button("Derp"))
    val groupBoxC = new GroupBox("Group Box Test 3", new Button("Berp"))

    val vbox = new VBox(5.0, groupBoxA, groupBoxB, groupBoxC) {
      setPadding(new Insets(15.0))
    }

    primaryStage.setScene(new Scene(vbox, 500, 400))
    primaryStage.show
  }
}
