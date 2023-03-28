package com.okayestprogrammer

import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.event.ActionEvent
import javafx.scene.layout.StackPane
import com.okayestprogrammer.controls.GroupBox
import javafx.geometry.Insets
import javafx.scene.layout.VBox
import javafx.scene.layout.Priority
import javafx.scene.layout.HBox

object Main {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[EntryPoint], args: _*)
  }
}

class EntryPoint extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("Hello World!")
    val btn = new Button("DeLomba")
    btn.setOnAction((e: ActionEvent) => {
      println("Hello World!")
    })

    val groupBox = new GroupBox("Hello World", btn)
    HBox.setHgrow(groupBox, Priority.ALWAYS)
    groupBox.setMaxWidth(Double.MaxValue)
    groupBox.setMaxHeight(Double.MaxValue)

    val vbox = new StackPane(groupBox) {
      setPadding(new Insets(15.0))
    }

    primaryStage.setScene(new Scene(vbox, 300, 250))
    primaryStage.show
  }
}
