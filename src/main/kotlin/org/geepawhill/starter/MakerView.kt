package org.geepawhill.starter

import javafx.animation.AnimationTimer
import javafx.geometry.Rectangle2D
import javafx.scene.canvas.Canvas
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.stage.Screen
import javafx.stage.WindowEvent
import tornadofx.*
import java.lang.Double.max
import java.lang.Double.min
import kotlin.random.Random

const val MAP_WIDTH = 4096.0
const val MAP_HEIGHT = 4096.0
const val TILE_SIZE = 32.0

class Input {

    var left = false
        private set

    var right = false
        private set

    var up = false
        private set

    var down = false
        private set

    fun handle(code: KeyCode, isOn: Boolean) {
        when (code) {
            KeyCode.A, KeyCode.LEFT -> left = isOn
            KeyCode.D, KeyCode.RIGHT -> right = isOn
            KeyCode.W, KeyCode.UP -> up = isOn
            KeyCode.S, KeyCode.DOWN -> down = isOn
            else -> {}
        }
    }
}

class MakerView : View("Raindrops") {

    inner class Timer : AnimationTimer() {
        private var lastFrame = System.nanoTime()
        var deltaTime = 0.0

        override fun handle(now: Long) {
            deltaTime = (now - lastFrame).toDouble() / 1000000.0
            lastFrame = now
            pulse(deltaTime)
        }
    }

    private var frames = 0
    private var dropped = 0

    val map = mutableListOf<Rectangle2D>()
    val canvas = populate()

    val screenBounds = Screen.getPrimary().bounds
    var viewportRect = screenBounds

    val input = Input()

    val timer = Timer()


    val viewport = Canvas()
    val context = viewport.graphicsContext2D

    override val root = pane {
        this += viewport
    }

    init {
        populate()
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWN) {
            primaryStage.scene.setOnKeyPressed { e -> input.handle(e.code, true) }
            primaryStage.scene.setOnKeyReleased { e -> input.handle(e.code, false) }

            viewport.width = viewportRect.width
            viewport.height = viewportRect.height
        }
        primaryStage.fullScreenExitHint = ""
        primaryStage.isFullScreen = true

        val fullScreenListener = ChangeListener<Boolean>() { _, _, new ->
            if (new == false) println("Frames: $frames Dropped: $dropped")
        }
        primaryStage.fullScreenProperty().addListener(fullScreenListener)
        timer.start()
    }

    private fun populate(): Canvas {
        for (i in 0..1000) {
            val x = Random.nextDouble() * MAP_WIDTH
            val y = Random.nextDouble() * MAP_HEIGHT
            val width = 20.0 + (Random.nextDouble() * 100.0)
            val height = 20.0 + (Random.nextDouble() * 100.0)
            val rectangle = Rectangle2D(x, y, width, height)
            map += rectangle
        }
        val canvas = Canvas()
        val context = canvas.graphicsContext2D
        context.fill = Color.WHITE
        context.fillRect(0.0, 0.0, MAP_WIDTH, MAP_HEIGHT)
        context.fill = Color.BLUE
        map.forEach { rectangle ->
            context.fillRect(rectangle.minX, rectangle.minY, rectangle.width, rectangle.height)
        }
        return canvas;
    }

    private fun handleKey(event: KeyEvent, deltaTime: Double) {
        when (event.code) {
            KeyCode.A, KeyCode.LEFT -> left(deltaTime)
            KeyCode.D, KeyCode.RIGHT -> right(deltaTime)
            KeyCode.W, KeyCode.UP -> up(deltaTime)
            KeyCode.S, KeyCode.DOWN -> down(deltaTime)
            else -> {}
        }
    }

    private fun left(deltaTime: Double) {
        var newX = max(viewportRect.minX - (300.0 / deltaTime), 0.0)
        viewportRect = Rectangle2D(newX, viewportRect.minY, viewportRect.width, viewportRect.height)
    }

    private fun up(deltaTime: Double) {
        var newY = max(viewportRect.minY - (300.0 / deltaTime), 0.0);
        viewportRect = Rectangle2D(viewportRect.minX, newY, viewportRect.width, viewportRect.height)
    }

    private fun down(deltaTime: Double) {
        var newY = min(viewportRect.minY + (300.0 / deltaTime), MAP_HEIGHT - viewportRect.height)
        viewportRect = Rectangle2D(viewportRect.minX, newY, viewportRect.width, viewportRect.height)
    }


    private fun right(deltaTime: Double) {
        var newX = min(viewportRect.minX + (300.0 / deltaTime), MAP_WIDTH - viewportRect.width)
        viewportRect = Rectangle2D(newX, viewportRect.minY, viewportRect.width, viewportRect.height)
    }


    var now = false

    private fun pulse(deltaTime: Double) {
        context.fill = Color.WHITE
        context.fillRect(0.0, 0.0, viewportRect.width, viewportRect.height)
        context.fill = Color.BLUE
        map.filter { viewportRect.intersects(it) }.forEach { rectangle ->
            val x = rectangle.minX - viewportRect.minX
            val y = rectangle.minY - viewportRect.minY
            context.fillRect(x, y, rectangle.width, rectangle.height)
        }
        frames += 1
        if (deltaTime > 16.0) dropped += 1
        if (input.left) left(deltaTime)
        if (input.right) right(deltaTime)
        if (input.up) up(deltaTime)
        if (input.down) down(deltaTime)
    }
}