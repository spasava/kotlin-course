package ru.stimmax.lessons.lesson09;

public class homeworks { fun main() {
    println("=== Работа с массивами ===")

    // 1. Массив из 5 целых чисел от 1 до 5
    val array1 = arrayOf(1, 2, 3, 4, 5)
    println(array1.joinToString())

    // 2. Пустой массив строк размером 10 элементов
    val array2 = Array(10) { "" }
    println(array2.joinToString())

    // 3. Массив Double — удвоенный индекс элемента
    val array3 = Array(5) { i -> i * 2.0 }
    println(array3.joinToString())

    // 4. Массив Int, каждый элемент = индекс * 3
    val array4 = Array(5) { i -> i * 3 }
    println(array4.joinToString())

    // 5. Массив из 3 nullable строк
    val array5 = arrayOf<String?>(null, "Kotlin", "Java")
    println(array5.joinToString())

    // 6. Копирование массива
    val src = arrayOf(1, 2, 3, 4)
    val copy = Array(src.size) { src[it] }
    println(copy.joinToString())

    // 7. Разность двух массивов
    val arrA = arrayOf(10, 20, 30, 40)
    val arrB = arrayOf(1, 2, 3, 4)
    val diff = Array(arrA.size) { i -> arrA[i] - arrB[i] }
    println(diff.joinToString())

    // 8. Найти индекс элемента 5 (через while)
    val nums = arrayOf(2, 4, 6, 8)
    var index = 0
    var foundIndex = -1
    while (index < nums.size) {
        if (nums[index] == 5) {
            foundIndex = index
            break
        }
        index++
    }
    println("Индекс 5 = $foundIndex")

    // 9. Чётное / нечётное
    val arrEvenOdd = arrayOf(1, 2, 3, 4, 5)
    for (n in arrEvenOdd) {
        val type = if (n % 2 == 0) "чётное" else "нечётное"
        println("$n — $type")
    }

    // 10. Поиск подстроки в массиве строк
    val arrStr = arrayOf("apple", "banana", "apricot")
    findString(arrStr, "pri")

    println("\n=== Работа со списками ===")

    // 1. Пустой неизменяемый список
    val list1 = listOf<Int>()
    println(list1)

    // 2. Неизменяемый список строк
    val list2 = listOf("Hello", "World", "Kotlin")
    println(list2)

    // 3. Изменяемый список от 1 до 5
    val list3 = mutableListOf(1, 2, 3, 4, 5)
    println(list3)

    // 4. Добавление новых элементов
    list3.addAll(listOf(6, 7, 8))
    println(list3)

    // 5. Удаление элемента
    val list4 = mutableListOf("Hello", "World", "Kotlin")
    list4.remove("World")
    println(list4)

    // 6. Вывод элементов
    val list5 = listOf(10, 20, 30)
    for (i in list5) println(i)

    // 7. Второй элемент
    val list6 = listOf("red", "green", "blue")
    println(list6[1])

    // 8. Изменение элемента
    val list7 = mutableListOf(5, 10, 15)
    list7[2] = 99
    println(list7)

    // 9. Объединение списков
    val listA = listOf("A", "B")
    val listB = listOf("C", "D")
    val merged = mutableListOf<String>()
    for (el in listA) merged.add(el)
    for (el in listB) merged.add(el)
    println(merged)

    // 10. Минимум и максимум
    val list8 = listOf(4, 9, 1, 7)
    var min = list8[0]
    var max = list8[0]
    for (n in list8) {
        if (n < min) min = n
        if (n > max) max = n
    }
    println("min=$min, max=$max")

    // 11. Только чётные
    val evenList = mutableListOf<Int>()
    for (n in list8) if (n % 2 == 0) evenList.add(n)
    println("Чётные: $evenList")

    println("\n=== Работа с множествами ===")

    // 1. Пустое неизменяемое множество
    val set1 = setOf<Int>()
    println(set1)

    // 2. Неизменяемое множество
    val set2 = setOf(1, 2, 3)
    println(set2)

    // 3. Изменяемое множество
    val set3 = mutableSetOf("Kotlin", "Java", "Scala")
    println(set3)

    // 4. Добавление новых элементов
    set3.addAll(listOf("Swift", "Go"))
    println(set3)

    // 5. Удаление элемента
    val set4 = mutableSetOf(1, 2, 3, 4)
    set4.remove(2)
    println(set4)

    // 6. Вывод каждого элемента
    for (el in set4) println(el)

    // 7. Проверка наличия строки
    println("Есть ли 'Kotlin'? " + containsString(set3, "Kotlin"))

    // 8. Конвертация множества в список
    val newList = mutableListOf<String>()
    for (el in set3) newList.add(el)
    println(newList)
}

    // Функция поиска подстроки
    fun findString(arr: Array<String>, query: String) {
        for (el in arr) {
            if (el.contains(query)) {
                println("Найдено: $el")
                return
            }
        }
        println("Не найдено")
    }

    // Функция проверки наличия строки в set
    fun containsString(set: Set<String>, query: String): Boolean {
        for (el in set) {
            if (el == query) return true
        }
        return false
    }
}
