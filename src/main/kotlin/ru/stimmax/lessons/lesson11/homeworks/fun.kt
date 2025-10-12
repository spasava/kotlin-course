package org.example.ru.stimmax.lessons.lesson11.homeworks

class `fun` {
    fun main() {
        // --- Примеры вызова функций для проверки ---
        noArgsNoReturn()
        println(sumTwoNumbers(3, 5))
        printString("Hello")
        println(averageList(listOf(2,4,6)))
        println(lengthOfNullable("Kotlin"))
        println(getNullableDouble())
        processNullableList(mutableListOf(1, 2, 3))
        println(intToNullableString(42))
        println(getListOfNullableStrings())
        println(nullableStringAndIntToBoolean("test", 10))

        println(multiplyByTwo(5))
        println(isEven(4))
        printNumbersUntil(5)
        println(findFirstNegative(listOf(1,2,-3,4)))
        processList(listOf("a","b",null,"c"))
    }

// ------------------------
// Задачи на сигнатуру методов
// ------------------------

    // 1. Не принимает аргументов и не возвращает значения
    fun noArgsNoReturn() {
        println("Function with no args and no return")
    }

    // 2. Принимает два целых числа и возвращает их сумму
    fun sumTwoNumbers(a: Int, b: Int): Int {
        return a + b
    }

    // 3. Принимает строку и ничего не возвращает
    fun printString(s: String) {
        println(s)
    }

    // 4. Принимает список целых чисел и возвращает среднее значение типа Double
    fun averageList(list: List<Int>): Double {
        if (list.isEmpty()) return 0.0
        return list.average()
    }

    // 5. Принимает nullable строку и возвращает её длину в виде nullable Int, доступна только в текущем файле
    internal fun lengthOfNullable(s: String?): Int? {
        return s?.length
    }

    // 6. Не принимает аргументов и возвращает nullable Double
    fun getNullableDouble(): Double? {
        return 3.14
    }

    // 7. Принимает nullable список целых чисел, не возвращает значения, доступна только в текущем файле
    internal fun processNullableList(list: List<Int>?) {
        list?.forEach { println(it) }
    }

    // 8. Принимает целое число и возвращает nullable String
    fun intToNullableString(x: Int): String? {
        return x.toString()
    }

    // 9. Не принимает аргументов и возвращает список nullable строк
    fun getListOfNullableStrings(): List<String?> {
        return listOf("a", null, "b")
    }

    // 10. Принимает nullable строку и nullable Int и возвращает nullable Boolean
    fun nullableStringAndIntToBoolean(s: String?, n: Int?): Boolean? {
        if (s == null || n == null) return null
        return s.length == n
    }

// ------------------------
// Задачи на написание кода
// ------------------------

    // Умножение на два
    fun multiplyByTwo(x: Int): Int {
        return x * 2
    }

    // Проверка на чётность
    fun isEven(x: Int): Boolean {
        return x % 2 == 0
    }

    // Вывод чисел от 1 до n
    fun printNumbersUntil(n: Int) {
        if (n < 1) return
        for (i in 1..n) {
            println(i)
        }
    }

    // Поиск первого отрицательного числа в списке
    fun findFirstNegative(list: List<Int>): Int? {
        return list.firstOrNull { it < 0 }
    }

    // Обработка списка строк с остановкой на null
    fun processList(list: List<String?>) {
        for (item in list) {
            if (item == null) return
            println(item)
        }
    }
}