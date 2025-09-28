package org.example.ru.stimmax.lessons.lesson07.homeworks

fun main() {
    // Прямой диапазон
    // 1. Цикл от 1 до 5
    for (i in 1..5) {
        println(i)
    }

    // 2. Четные числа от 1 до 10
    for (i in 1..10) {
        if (i % 2 == 0) {
            println(i)
        }
    }

    // Обратный диапазон
    // 3. Цикл от 5 до 1
    for (i in 5 downTo 1) {
        println(i)
    }

    // 4. Цикл от 10 до 1 с шагом 2
    for (i in 10 downTo 1 step 2) {
        println(i)
    }

    // С шагом (step)
    // 5. Цикл с шагом 2 от 1 до 9
    for (i in 1..9 step 2) {
        println(i)
    }

    // 6. Каждое третье число от 1 до 20
    for (i in 1..20 step 3) {
        println(i)
    }

    // Использование until
    val size = 10
    // 7. Цикл от 3 до size (не включая size) с шагом 2
    for (i in 3 until size step 2) {
        println(i)
    }

    // Цикл while
    // 8. Квадраты чисел от 1 до 5
    var j = 1
    while (j <= 5) {
        println(j * j)
        j++
    }

    // 9. Уменьшение числа от 10 до 5
    var k = 10
    while (k >= 5) {
        k--
    }
    println(k) // Выведет 4

    // Цикл do while
    // 10. Числа от 5 до 1
    var m = 5
    do {
        println(m)
        m--
    } while (m >= 1)

    // 11. Повторять пока счетчик меньше 10, начиная с 5
    var n = 5
    do {
        println(n)
        n++
    } while (n < 10)

    // Использование break
    // 12. for от 1 до 10, прерывание при 6
    for (i in 1..10) {
        if (i == 6) break
        println(i)
    }

    // 13. while бесконечно, прерывание при 10
    var p = 1
    while (true) {
        if (p > 10) break
        println(p)
        p++
    }

    // Использование continue
    // 14. for 1..10, пропустить четные
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }

    // 15. while 1..10, пропустить числа кратные 3
    var q = 1
    while (q <= 10) {
        if (q % 3 == 0) {
            q++
            continue
        }
        println(q)
        q++
    }
}