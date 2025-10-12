package org.example.ru.stimmax.lessons.lesson10.homework

class Pair {
    fun main() {
    // 1. Пустой неизменяемый словарь (ключи и значения - Int)
    val emptyMap: Map<Int, Int> = mapOf()
    println("Empty map: $emptyMap")

    // 2. Словарь с несколькими парами (ключи - Float, значения - Double)
    val floatDoubleMap: Map<Float, Double> = mapOf(
        1.1f to 2.2,
        3.3f to 4.4,
        5.5f to 6.6
    )
    println("Float-Double map: $floatDoubleMap")

    // 3. Изменяемый словарь (ключи Int, значения String)
    val mutableIntStringMap: MutableMap<Int, String> = mutableMapOf(
        1 to "one",
        2 to "two"
    )
    println("Initial mutable map: $mutableIntStringMap")

    // 4. Добавление новых пар в изменяемый словарь
    mutableIntStringMap[3] = "three"
    mutableIntStringMap.put(4, "four")
    println("After adding elements: $mutableIntStringMap")

    // 5. Извлечение значения по ключу
    println("Value for key 2: ${mutableIntStringMap[2]}")
    println("Value for key 10 (non-existent): ${mutableIntStringMap[10]}") // null

    // 6. Удаление элемента по ключу
    mutableIntStringMap.remove(1)
    println("After removing key 1: $mutableIntStringMap")

    // 7. Словарь (ключ Double, значение Int), вывод деления
    val doubleIntMap: Map<Double, Int> = mapOf(
        10.0 to 2,
        5.0 to 0,
        7.0 to 1
    )
    for ((key, value) in doubleIntMap) {
        val result = if (value != 0) key / value else "бесконечность"
        println("Key $key / Value $value = $result")
    }

    // 8. Изменение значения существующего ключа
    mutableIntStringMap[2] = "TWO"
    println("After modifying key 2: $mutableIntStringMap")

    // 9. Объединение двух словарей в третьем через циклы
    val map1: Map<Int, String> = mapOf(1 to "a", 2 to "b")
    val map2: Map<Int, String> = mapOf(3 to "c", 4 to "d")
    val combinedMap: MutableMap<Int, String> = mutableMapOf()
    for ((k, v) in map1) combinedMap[k] = v
    for ((k, v) in map2) combinedMap[k] = v
    println("Combined map: $combinedMap")

    // 10. Словарь (ключ String, значение List<Int>)
    val stringListMap: MutableMap<String, MutableList<Int>> = mutableMapOf()
    stringListMap["first"] = mutableListOf(1,2,3)
    stringListMap["second"] = mutableListOf(4,5)
    println("String-List map: $stringListMap")

    // 11. Словарь (ключ Int, значение MutableSet<String>)
    val intSetMap: MutableMap<Int, MutableSet<String>> = mutableMapOf()
    intSetMap[1] = mutableSetOf("a","b")
    val set = intSetMap[1]
    set?.add("c")
    println("Updated set for key 1: $set")

    // 12. Словарь с парами чисел в качестве ключей
    val pairMap: Map<Pair<Int,Int>, String> = mapOf(
        Pair(1,2) to "first",
        Pair(5,3) to "second",
        Pair(4,5) to "third"
    )
    for ((key, value) in pairMap) {
        if (key.first == 5 || key.second == 5) {
            println("Pair with 5: $key -> $value")
        }
    }

    // --- Задачи на подбор оптимального типа словаря ---

    // 13. Словарь библиотека: автор -> список книг
    val library: Map<String, List<String>> = mapOf(
        "Tolstoy" to listOf("War and Peace", "Anna Karenina"),
        "Dostoevsky" to listOf("Crime and Punishment", "The Idiot")
    )
    println("Library: $library")

    // 14. Справочник растений: тип -> список растений
    val plants: Map<String, List<String>> = mapOf(
        "Цветы" to listOf("Роза","Лилия"),
        "Деревья" to listOf("Дуб","Берёза")
    )
    println("Plants directory: $plants")

    // 15. Четвертьфинала: команда -> список игроков
    val teams: Map<String, List<String>> = mapOf(
        "TeamA" to listOf("Player1","Player2"),
        "TeamB" to listOf("Player3","Player4")
    )
    println("Teams: $teams")

    // 16. Курс лечения: дата -> список препаратов
    val treatmentSchedule: Map<String, List<String>> = mapOf(
        "2025-10-12" to listOf("DrugA","DrugB"),
        "2025-10-13" to listOf("DrugC")
    )
    println("Treatment schedule: $treatmentSchedule")

    // 17. Словарь путешественника: страна -> (город -> список мест)
    val travelMap: Map<String, Map<String, List<String>>> = mapOf(
        "France" to mapOf(
            "Paris" to listOf("Eiffel Tower","Louvre"),
            "Nice" to listOf("Promenade des Anglais")
        ),
        "Japan" to mapOf(
            "Tokyo" to listOf("Shibuya Crossing","Sensoji Temple"),
            "Kyoto" to listOf("Fushimi Inari Shrine")
        )
    )
    println("Travel map: $travelMap")
}
}