package com.okayestprogrammer.controls

import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.control.skin.LabeledSkinBase
import javafx.scene.layout.{HBox, StackPane}

import com.okayestprogrammer.utils.TextUtils
import javafx.scene.shape.Line
import javafx.scene.layout.Pane
import javafx.scene.shape.Arc
import javafx.scene.paint.Color
import javafx.scene.shape.ArcType
import javafx.scene.shape.StrokeType
import javafx.scene.shape.StrokeLineCap
import javafx.scene.shape.StrokeLineJoin

class GroupBoxSkin(control: GroupBox) extends LabeledSkinBase[GroupBox](control) {

  private var content: Node = getSkinnable().getGraphic()

  val cornerRadius = 10.0
  val width = 100
  val height = 100

  // Create lines for the sides of the rectangle
  val topLine = new Line(cornerRadius, 0, width - cornerRadius, 0) { getStyleClass().add("border") }
  topLine.setStrokeWidth(2.0)
  val bottomLine = new Line(cornerRadius, height, width - cornerRadius, height) { getStyleClass().add("border") }
  bottomLine.setStrokeWidth(2.0)
  val leftLine = new Line(0, cornerRadius, 0, height - cornerRadius) { getStyleClass().add("border") }
  leftLine.setStrokeWidth(2.0)
  val rightLine = new Line(width, cornerRadius, width, height - cornerRadius) { getStyleClass().add("border") }
  rightLine.setStrokeWidth(2.0)

  // Create arcs for the corners
  val topLeftArc = new Arc(cornerRadius, cornerRadius, cornerRadius, cornerRadius, 90, 90) { getStyleClass().add("border") }
  topLeftArc.setType(ArcType.OPEN)
  topLeftArc.setFill(Color.TRANSPARENT)
  topLeftArc.setStroke(Color.BLACK)
  topLeftArc.setStrokeWidth(2.0)
  topLeftArc.setStrokeLineCap(StrokeLineCap.BUTT)
  topLeftArc.setStrokeLineJoin(StrokeLineJoin.MITER)
  topLeftArc.setStrokeMiterLimit(10.0)
  topLeftArc.setSmooth(true)

  val bottomLeftArc = new Arc(cornerRadius, height - cornerRadius, cornerRadius, cornerRadius, 180, 90) {
    getStyleClass().add("border")
  }
  bottomLeftArc.setType(ArcType.OPEN)
  bottomLeftArc.setFill(Color.TRANSPARENT)
  bottomLeftArc.setStroke(Color.BLACK)
  bottomLeftArc.setStrokeWidth(2.0)
  bottomLeftArc.setStrokeLineCap(StrokeLineCap.BUTT)
  bottomLeftArc.setStrokeLineJoin(StrokeLineJoin.MITER)
  bottomLeftArc.setStrokeMiterLimit(10.0)
  bottomLeftArc.setSmooth(true)

  val topRightArc = new Arc(width - cornerRadius, cornerRadius, cornerRadius, cornerRadius, 0, 90) {
    getStyleClass().add("border")
  }
  topRightArc.setType(ArcType.OPEN)
  topRightArc.setFill(Color.TRANSPARENT)
  topRightArc.setStroke(Color.BLACK)
  topRightArc.setStrokeWidth(2.0)
  topRightArc.setStrokeType(StrokeType.CENTERED)
  topRightArc.setStrokeLineCap(StrokeLineCap.BUTT)
  topRightArc.setStrokeLineJoin(StrokeLineJoin.MITER)
  topRightArc.setStrokeMiterLimit(10.0)
  topRightArc.setSmooth(true)

  val bottomRightArc = new Arc(width - cornerRadius, height - cornerRadius, cornerRadius, cornerRadius, 270, 90) {
    getStyleClass().add("border")
  }
  bottomRightArc.setType(ArcType.OPEN)
  bottomRightArc.setFill(Color.TRANSPARENT)
  bottomRightArc.setStroke(Color.BLACK)
  bottomRightArc.setStrokeWidth(2.0)
  bottomRightArc.setStrokeType(StrokeType.CENTERED)
  bottomRightArc.setStrokeLineCap(StrokeLineCap.BUTT)
  bottomRightArc.setStrokeLineJoin(StrokeLineJoin.MITER)
  bottomRightArc.setStrokeMiterLimit(10.0)
  bottomRightArc.setSmooth(true)

  private val titleLabel = new Label("Test") {
    getStyleClass().add("title")
  }
  titleLabel.textProperty().bind(control.textProperty())

  private val contentContainer = new StackPane {
    getStyleClass.add("content")

    if (content != null) {
      getChildren().setAll(content)
    } else {
      getChildren().clear()
    }
  }

  getChildren().setAll(
    contentContainer,
    titleLabel,
    topLine,
    bottomLine,
    leftLine,
    rightLine,
    topLeftArc,
    topRightArc,
    bottomLeftArc,
    bottomRightArc
  )

  control.graphicProperty().addListener((_, _, newValue) => {
    content = newValue

    if (newValue != null) {
      contentContainer.getChildren().setAll(newValue)
    } else {
      contentContainer.getChildren().clear()
    }
  })

  override protected def layoutChildren(contentX: Double, contentY: Double, contentWidth: Double, contentHeight: Double): Unit = {
    val textWidth = TextUtils.computeTextWidth(titleLabel.getFont, titleLabel.getText()) + 5.0
    val textHeight = TextUtils.computeTextHeight(titleLabel.getFont, titleLabel.getText())

    titleLabel.resizeRelocate(
      contentX + 12.0,
      contentY,
      textWidth,
      textHeight
    )

    contentContainer.resizeRelocate(contentX, contentY + (textHeight / 2.0), contentWidth, contentHeight - (textHeight / 2.0))

    topLine.setStartX(contentX + cornerRadius + textWidth)
    topLine.setEndX(contentX + contentWidth - cornerRadius)
    topLine.setStartY(contentY + (textHeight / 2.0))
    topLine.setEndY(contentY + (textHeight / 2.0))

    bottomLine.setStartX(contentX + cornerRadius + 1.0)
    bottomLine.setEndX(contentX + contentWidth - cornerRadius)
    bottomLine.setStartY(contentY + contentHeight)
    bottomLine.setEndY(contentY + contentHeight)

    leftLine.setStartX(contentX + 1.0)
    leftLine.setEndX(contentX + 1.0)
    leftLine.setStartY(contentY + cornerRadius + (textHeight / 2.0))
    leftLine.setEndY(contentY + contentHeight - cornerRadius)

    rightLine.setStartX(contentX + contentWidth)
    rightLine.setEndX(contentX + contentWidth)
    rightLine.setStartY(contentY + cornerRadius + (textHeight / 2.0))
    rightLine.setEndY(contentY + contentHeight - cornerRadius)

    topLeftArc.relocate(contentX - 1.5 + 1.0, contentY - 1.5 + (textHeight / 2.0))
    bottomLeftArc.relocate(contentX - 1.5 + 1.0, contentY + contentHeight - cornerRadius - 0.5)
    topRightArc.relocate(contentX + contentWidth - cornerRadius - 0.5, contentY - 1.5 + (textHeight / 2.0))
    bottomRightArc.relocate(contentX + contentWidth - cornerRadius - 0.5, contentY + contentHeight - cornerRadius - 0.5)
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
