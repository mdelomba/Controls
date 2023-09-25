package com.okayestprogrammer.controls

import javafx.scene.Node
import javafx.scene.control.Labeled

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
