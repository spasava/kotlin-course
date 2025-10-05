package org.example.ru.stimmax.lessons.lesson08

class homeworks {fun main() {
    println("--- 1. Преобразование строк ---")
    val phrases = listOf(
        "Это невозможно выполнить за один день",
        "Я не уверен в успехе этого проекта",
        "Произошла катастрофа на сервере",
        "Этот код работает без проблем",
        "Удача"
    )
    for (p in phrases) println(transformPhrase(p))

    println("\n--- 2. Извлечение даты из строки лога ---")
    val log = "Пользователь вошел в систему -> 2021-12-01 09:48:23"
    extractDateTime(log)

    println("\n--- 3. Маскирование личных данных ---")
    println(maskCard("4539 1488 0343 6467"))

    println("\n--- 4. Форматирование e-mail ---")
    println(formatEmail("username@example.com"))

    println("\n--- 5. Извлечение имени файла ---")
    println(extractFilename("C:/Пользователи/Документы/report.txt"))
    println(extractFilename("D:/good.themes/dracula.theme"))

    println("\n--- 6. Создание аббревиатуры ---")
    println(makeAbbreviation("Котлин лучший язык программирования"))

    println("\n--- 7. Все слова с большой буквы ---")
    println(capitalizeWords("кОТлин лУчший Язык Программирования"))

    println("\n--- 8. Игра в разведчика ---")
    val encrypted = encrypt("Kotlin")
    println("Encrypted: $encrypted")
    println("Decrypted: ${decrypt(encrypted)}")

    println("\n--- 9. Таблица умножения ---")
    multiplicationTable(5, 5)
}

    // ---------- 1 ----------
    fun transformPhrase(phrase: String): String {
        return when {
            phrase.contains("невозможно", ignoreCase = true) ->
                phrase.replace("невозможно", "совершенно точно возможно, просто требует времени", ignoreCase = true)

            phrase.startsWith("Я не уверен", ignoreCase = true) ->
                "$phrase, но моя интуиция говорит об обратном"

            phrase.contains("катастрофа", ignoreCase = true) ->
                phrase.replace("катастрофа", "интересное событие", ignoreCase = true)

            phrase.endsWith("без проблем", ignoreCase = true) ->
                phrase.replace("без проблем", "с парой интересных вызовов на пути", ignoreCase = true)

            phrase.trim().split(" ").size == 1 ->
                "Иногда, ${phrase.trim()}, но не всегда"

            else -> phrase
        }
    }

    // ---------- 2 ----------
    fun extractDateTime(log: String) {
        val parts = log.split("->")
        if (parts.size == 2) {
            val dateTime = parts[1].trim()
            val (date, time) = dateTime.split(" ")
            println("Дата: $date")
            println("Время: $time")
        }
    }

    // ---------- 3 ----------
    fun maskCard(card: String): String {
        val digits = card.replace(" ", "")
        val masked = "*".repeat(digits.length - 4) + digits.takeLast(4)
        return masked.chunked(4).joinToString(" ")
    }

    // ---------- 4 ----------
    fun formatEmail(email: String): String {
        return email.replace("@", " [at] ").replace(".", " [dot] ")
    }

    // ---------- 5 ----------
    fun extractFilename(path: String): String {
        return path.substringAfterLast("/")
            .substringAfterLast("\\")
    }

    // ---------- 6 ----------
    fun makeAbbreviation(phrase: String): String {
        val words = phrase.split(" ")
        var abbr = ""
        for (word in words) {
            if (word.isNotBlank()) abbr += word.first().uppercase()
        }
        return abbr
    }

    // ---------- 7 ----------
    fun capitalizeWords(text: String): String {
        return text.split(" ").joinToString(" ") { word ->
            word.lowercase().replaceFirstChar { it.uppercase() }
        }
    }

    // ---------- 8 ----------
    fun encrypt(text: String): String {
        val padded = if (text.length % 2 != 0) text + " " else text
        val chars = padded.toCharArray()
        for (i in chars.indices step 2) {
            if (i + 1 < chars.size) {
                val temp = chars[i]
                chars[i] = chars[i + 1]
                chars[i + 1] = temp
            }
        }
        return String(chars)
    }

    fun decrypt(text: String): String {
        return encrypt(text) // обратное действие то же самое
    }

    // ---------- 9 ----------
    fun multiplicationTable(rows: Int, cols: Int) {
        val maxNumber = rows * cols
        val width = maxNumber.toString().length + 1
        print(" ".repeat(width))
        for (j in 1..cols) print(String.format("%${width}d", j))
        println()
        for (i in 1..rows) {
            print(String.format("%${width}d", i))
            for (j in 1..cols) print(String.format("%${width}d", i * j))
            println()
        }
    }
}