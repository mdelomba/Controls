package com.okayestprogrammer

import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.event.ActionEvent
import javafx.scene.layout.StackPane

object Main  {
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

        println("This is a test")
        
        val root = new StackPane(btn)
        primaryStage.setScene(new Scene(root, 300, 250))
        primaryStage.show
    }
}
