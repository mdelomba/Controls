package com.okayestprogrammer.controls

import javafx.scene.control.Skin
import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import javafx.scene.control.SkinBase
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javax.tools.SimpleJavaFileObject
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.skin.TitledPaneSkin
import javafx.scene.control.skin.LabeledSkinBase
import javafx.scene.layout.StackPane
import javafx.geometry.HPos
import javafx.geometry.VPos
import javafx.scene.control.Button
import com.okayestprogrammer.utils.TextUtils

class GroupBoxSkin(control: GroupBox) extends LabeledSkinBase[GroupBox](control) {

  private var content: Node = getSkinnable().getGraphic()

  private val titleLabel = new Label("Test")
  titleLabel.getStyleClass.add("title")
  titleLabel.textProperty().bind(control.textProperty())

  private val contentContainer = new StackPane {
    if (content != null) {
      getChildren().setAll(content)
    } else {
      getChildren().clear()
    }
  }

  getChildren().setAll(titleLabel, contentContainer)

  control.graphicProperty().addListener((_, _, newValue) => {
    content = newValue

    if (newValue != null) {
      contentContainer.getChildren().setAll(newValue)
    } else {
      contentContainer.getChildren().clear()
    }
  })

  override protected def layoutChildren(contentX: Double, contentY: Double, contentWidth: Double, contentHeight: Double): Unit = {
    titleLabel.resizeRelocate(
      contentX + 10.0,
      contentY - 25.0,
      TextUtils.computeTextWidth(titleLabel.getFont, titleLabel.getText()) + 5,
      30
    )
    contentContainer.resizeRelocate(contentX, contentY, contentWidth, contentHeight)
  }

  override def computePrefHeight(
    width: Double,
    topInset: Double,
    rightInset: Double,
    bottomInset: Double,
    leftInset: Double
  ): Double = {
    titleLabel.prefHeight(width) + contentContainer.prefHeight(width)
  }

  override def computePrefWidth(
    height: Double,
    topInset: Double,
    rightInset: Double,
    bottomInset: Double,
    leftInset: Double
  ): Double = {
    Math.max(TextUtils.computeTextWidth(titleLabel.getFont, titleLabel.getText()) + 40, contentContainer.prefWidth(height))
  }
}
