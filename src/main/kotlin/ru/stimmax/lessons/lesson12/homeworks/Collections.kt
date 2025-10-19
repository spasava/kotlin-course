package org.example.ru.stimmax.lessons.lesson12.homeworks

class Collections {
    fun main() {
        // Задачи на приведение коллекции к значению
        val numbers = listOf(10, 20, 30, 40, 50, 60)

        println("1) Size > 5: ${numbers.size > 5}")
        println("2) Is empty: ${numbers.isEmpty()}")
        println("3) Is not empty: ${numbers.isNotEmpty()}")
        println("4) Get by index or default: ${numbers.getOrElse(10) { 999 }}")
        println("5) Join to string: ${numbers.joinToString(", ")}")
        println("6) Sum: ${numbers.sum()}")
        println("7) Average: ${numbers.average()}")
        println("8) Max: ${numbers.maxOrNull()}")
        println("9) Min: ${numbers.minOrNull()}")
        println("10) First or null: ${numbers.firstOrNull()}")
        println("11) Contains 40: ${numbers.contains(40)}")

        //  Задачи на обработку коллекций
        val ages = listOf(12, 18, 20, 25, 31, 40)
        println("12) Ages 18–30: ${ages.filter { it in 18..30 }}")

        val nums = listOf(2, 3, 4, 5, 6, 9, 12)
        println("13) Not divisible by 2 and 3: ${nums.filterNot { it % 2 == 0 && it % 3 == 0 }}")

        val texts: List<String?> = listOf("cat", null, "dog", null, "sun")
        println("14) Filter not null: ${texts.filterNotNull()}")

        val words = listOf("sun", "moon", "star")
        println("15) Map to lengths: ${words.map { it.length }}")

        val words2 = listOf("cat", "dog", "owl")
        val mapReversed = words2.associate { it.reversed() to it.length }
        println("16) Associate reversed to length: $mapReversed")

        val unordered = listOf("banana", "apple", "pear")
        println("17) Sorted: ${unordered.sorted()}")

        val nums2 = listOf(1, 2, 3, 4, 5)
        println("18) Take first 3: ${nums2.take(3)}")

        val nums3 = listOf(2, 4, 6)
        print("19) Squares: ")
        nums3.forEach { print("${it * it} ") }
        println()

        val words3 = listOf("кот", "куст", "арбуз", "апельсин", "кактус")
        println("20) Group by first letter: ${words3.groupBy { it.first() }}")

        val withDuplicates = listOf("a", "b", "a", "c", "b")
        println("21) Distinct: ${withDuplicates.distinct()}")

        val nums4 = listOf(10, 2, 33, 4)
        println("22) Sorted descending: ${nums4.sortedDescending()}")

        val nums5 = listOf(1, 2, 3, 4, 5, 6)
        println("23) Take last 3: ${nums5.takeLast(3)}")

        // Задача 24. Характеристика числовой коллекции
        println("24) Characteristics tests:")
        println(characterize(listOf()))                      // Пусто
        println(characterize(listOf(1, 2, 3)))               // Короткая
        println(characterize(listOf(0, 5, 10)))              // Стартовая
        println(characterize(List(2000) { 10 }))             // Массивная
        println(characterize(List(5) { 10 }))                // Сбалансированная
        println(characterize(listOf(1234567890)))            // Клейкая
        println(characterize(listOf(-11, -20)))              // Отрицательная
        println(characterize(listOf(2000, 3000)))            // Положительная
        println(characterize(listOf(3, 14)))                 // Пи***тая
        println(characterize(listOf(7, 77)))                 // Уникальная

        // Задача 25. Анализ учебных оценок
        val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
        println("25) Grades analysis: ${analyzeGrades(grades)}")

        // Задача 26. Каталог по первой букве
        val furniture = listOf(
            "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы",
            "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга",
            "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор",
            "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница",
            "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба",
            "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир",
            "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
        )
        println("26) Catalog: ${createCatalog(furniture)}")

        // Задача 27. Средняя длина слов
        println("27) Average word length: ${averageWordLength(furniture)}")

        // Задача 28. Категоризация чисел
        val numbersFor28 = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
        println("28) Categorized numbers: ${categorizeNumbers(numbersFor28)}")

        // Задача 29. Поиск первого подходящего элемента
        val agesList = listOf(22, 18, 30, 45, 17, null, 60)
        println("29) First older than 18: ${findFirstGreaterThan(agesList, 18)}")
    }

    // Задача 24
    fun characterize(nums: List<Int>): String = when {
        nums.isEmpty() -> "Пусто"
        nums.size < 5 -> "Короткая"
        nums.firstOrNull() == 0 -> "Стартовая"
        nums.sum() > 10000 -> "Массивная"
        nums.average() == 10.0 -> "Сбалансированная"
        nums.joinToString("").length == 20 -> "Клейкая"
        (nums.maxOrNull() ?: 0) < -10 -> "Отрицательная"
        (nums.minOrNull() ?: 0) > 1000 -> "Положительная"
        nums.contains(3) && nums.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }

    // Задача 25
    fun analyzeGrades(grades: List<Int>): List<Int> =
        grades.filter { it >= 60 }.sorted().take(3)

    // Задача 26
    fun createCatalog(list: List<String>): Map<Char, List<String>> =
        list.map { it.lowercase() }.groupBy { it.first() }

    // Задача 27
    fun averageWordLength(list: List<String>): String {
        val avg = list.map { it.length }.average()
        return "Средняя длина слов: %.2f".format(avg)
    }

    //  Задача 28
    fun categorizeNumbers(numbers: List<Int>): Map<String, List<Int>> =
        numbers.distinct().sortedDescending().groupBy { if (it % 2 == 0) "четные" else "нечетные" }

    // Задача 29
    fun findFirstGreaterThan(ages: List<Int?>, limit: Int): Int? =
        ages.filterNotNull().firstOrNull { it > limit }
}