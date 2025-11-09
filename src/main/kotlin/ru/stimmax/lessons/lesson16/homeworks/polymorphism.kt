package org.example.ru.stimmax.lessons.lesson16.homeworks

import kotlin.math.sin

class polymorphism {

    /* ---------------------------
       1. Переопределение методов
    --------------------------- */
    // Базовый класс Animal
    open class Animal {
        open fun makeSound() {
            println("This animal makes no sound.")
        }
    }

    // Наследники
    class Dog : Animal() {
        override fun makeSound() {
            println("\u001B[33mBark\u001B[0m") // желтый
        }
    }

    class Cat : Animal() {
        override fun makeSound() {
            println("\u001B[35mMeow\u001B[0m") // фиолетовый
        }
    }

    class Bird : Animal() {
        override fun makeSound() {
            println("\u001B[36mTweet\u001B[0m") // голубой
        }
    }

    /* ---------------------------
       2. Геометрические фигуры
    --------------------------- */

    // Абстрактный класс
    open class Shape {
        open fun area(): Double = 0.0
    }

    // Наследники
    class Circle(private val radius: Double) : Shape() {
        override fun area(): Double = Math.PI * radius * radius
    }

    class Square(private val side: Double) : Shape() {
        override fun area(): Double = side * side
    }

    class Triangle(private val a: Double, private val b: Double, private val angleDegrees: Double) : Shape() {
        override fun area(): Double {
            val angleRadians = Math.toRadians(angleDegrees)
            return 0.5 * a * b * sin(angleRadians)
        }
    }

    /* ---------------------------
       3. Принтеры
    --------------------------- */

    abstract class Printer {
        abstract fun print(text: String)
    }

    class LaserPrinter : Printer() {
        override fun print(text: String) {
            val words = text.split(" ")
            for (word in words) {
                println("\u001B[30;47m $word \u001B[0m") // черный на белом фоне
            }
        }
    }

    class InkjetPrinter : Printer() {
        private val colors = listOf(
            "\u001B[31;43m", // красный текст на желтом фоне
            "\u001B[32;46m", // зеленый текст на голубом фоне
            "\u001B[34;45m", // синий текст на пурпурном фоне
            "\u001B[35;42m", // пурпурный текст на зеленом фоне
        )

        override fun print(text: String) {
            val words = text.split(" ")
            for ((i, word) in words.withIndex()) {
                val color = colors[i % colors.size]
                println("$color $word \u001B[0m")
            }
        }
    }

    /* ---------------------------
       4. Перегрузка методов: Корзина товаров
    --------------------------- */

    class Cart {
        private val items = mutableMapOf<Int, Int>()

        fun addToCart(itemId: Int) {
            items[itemId] = items.getOrDefault(itemId, 0) + 1
        }

        fun addToCart(itemId: Int, amount: Int) {
            items[itemId] = items.getOrDefault(itemId, 0) + amount
        }

        fun addToCart(newItems: Map<Int, Int>) {
            for ((id, amount) in newItems) {
                items[id] = items.getOrDefault(id, 0) + amount
            }
        }

        fun addToCart(ids: List<Int>) {
            for (id in ids) {
                addToCart(id)
            }
        }

        override fun toString(): String {
            val totalItems = items.size
            val totalQuantity = items.values.sum()
            val sb = StringBuilder()
            sb.appendLine("🛒 Cart Contents:")
            sb.appendLine("---------------------")
            for ((id, qty) in items) {
                sb.appendLine("Item ID: $id | Quantity: $qty")
            }
            sb.appendLine("---------------------")
            sb.appendLine("Total different items: $totalItems")
            sb.appendLine("Total quantity: $totalQuantity")
            return sb.toString()
        }
    }

    /* ---------------------------
       5. Перегрузка методов: Логгер
    --------------------------- */

    class Logger {
        fun log(message: String) {
            println("INFO: $message")
        }

        fun log(level: String, message: String) {
            when (level.uppercase()) {
                "WARNING" -> println("\u001B[33mWARNING: $message\u001B[0m")
                "ERROR" -> println("\u001B[37;41mERROR: $message\u001B[0m")
                "DEBUG" -> println("\u001B[36mDEBUG: $message\u001B[0m")
                else -> log(message)
            }
        }

        fun log(messages: List<String>) {
            for (msg in messages) log(msg)
        }

        fun log(exception: Exception) {
            println("\u001B[37;41mERROR: ${exception.message}\u001B[0m")
        }
    }

    /* ---------------------------
       MAIN
    --------------------------- */

    fun main() {
        println("=== Животные ===")
        val animals = listOf(Dog(), Cat(), Bird(), Animal())
        animals.forEach { it.makeSound() }

        println("\n=== Геометрические фигуры ===")
        val shapes = listOf(
            Circle(3.0),
            Square(4.0),
            Triangle(3.0, 4.0, 90.0)
        )
        shapes.forEach { println("Площадь: ${it.area()}") }

        println("\n=== Принтеры ===")
        val laser = LaserPrinter()
        val inkjet = InkjetPrinter()
        println("\nLaser printer output:")
        laser.print("Kotlin is great for backend and Android")
        println("\nInkjet printer output:")
        inkjet.print("Colorful text output with Kotlin printer simulation")

        println("\n=== Корзина ===")
        val cart = Cart()
        cart.addToCart(1)
        cart.addToCart(2, 3)
        cart.addToCart(mapOf(3 to 5, 4 to 2))
        cart.addToCart(listOf(1, 2, 3))
        println(cart)

        println("\n=== Логгер ===")
        val logger = Logger()
        logger.log("Program started")
        logger.log("WARNING", "Low disk space")
        logger.log("ERROR", "File not found")
        logger.log(listOf("Task 1 complete", "Task 2 complete"))
        logger.log(Exception("Unexpected null value"))
    }
}