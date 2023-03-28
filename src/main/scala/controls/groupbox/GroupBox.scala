package com.okayestprogrammer.controls

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.scene.Node
import javafx.scene.control.Control
import javafx.scene.control.Label
import javafx.scene.control.Skin
import javafx.scene.layout.VBox
import javafx.beans.DefaultProperty
import javafx.scene.control.TitledPane
import javafx.scene.control.Button
import javafx.scene.control.Labeled
import javax.tools.SimpleJavaFileObject

class GroupBox extends Labeled {
  def this(_title: String) = {
    this()

    setText(_title)
  }

  def this(_title: String, _content: Node) = {
    this()

    setText(_title)
    setGraphic(_content)
  }

  getStylesheets().add(getClass().getResource("/GroupBox.css").toExternalForm())
  getStyleClass().add("group-box")

  override def createDefaultSkin = new GroupBoxSkin(this)
}
