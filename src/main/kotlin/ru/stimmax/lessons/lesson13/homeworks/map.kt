package org.example.ru.stimmax.lessons.lesson13.homeworks

class map {fun main() {
    // 1. Среднее время выполнения теста
    val times = mapOf("t1" to 10.0, "t2" to 20.0, "t3" to 30.0)
    val average = times.values.average()
    println("1) Average time: $average")

    // 2. Список всех тестовых методов
    val metadata = mapOf("testA" to "metaA", "testB" to "metaB")
    println("2) Test methods: ${metadata.keys}")

    // 3. Добавить новый тест в изменяемый словарь
    val results = mutableMapOf("t1" to "passed")
    results.put("t2", "failed")
    println("3) Updated results: $results")

    // 4. Количество успешных тестов
    val resultsMap = mapOf("t1" to "passed", "t2" to "failed", "t3" to "passed")
    val passedCount = resultsMap.count { it.value == "passed" }
    println("4) Passed count: $passedCount")

    // 5. Удалить запись о баге
    val bugTracker = mutableMapOf("BUG-1" to "open", "BUG-2" to "fixed")
    bugTracker.remove("BUG-2")
    println("5) Bug tracker after removal: $bugTracker")

    // 6. Вывести сообщение о странице и статусе
    val pageStatus = mapOf("https://a" to "200", "https://b" to "404")
    println("6) Page statuses:")
    pageStatus.forEach { (url, status) -> println("$url -> $status") }

    // 7. Найти сервисы с временем ответа выше порога
    val responseTimes = mapOf("svcA" to 120, "svcB" to 450, "svcC" to 300)
    val threshold = 300
    val slowServices = responseTimes.filterValues { it > threshold }
    println("7) Slow services: $slowServices")

    // 8. Найти статус endpoint или вернуть "Not tested"
    val apiResults = mapOf("/login" to "200", "/pay" to "500")
    val endpoint = "/profile"
    val status = apiResults.getOrElse(endpoint) { "Not tested" }
    println("8) $endpoint -> $status")

    // 9. Получить значение browserType, не null
    val config = mapOf("browserType" to "firefox", "timeout" to "30")
    val browserType = config.getOrElse("browserType") { "chrome" }
    println("9) Browser type: $browserType")

    // 10. Копия неизменяемого словаря + новая версия
    val versionsImmutable = mapOf("app" to "1.0")
    val newImmutable = versionsImmutable.toMutableMap().apply { this["app"] = "1.1" }.toMap()
    println("10) New versions: $newImmutable")

    // 11. Получить настройки устройства или дефолт
    val mobileSettings = mapOf("iPhoneX" to "settingsA")
    val model = "Pixel5"
    val settings = mobileSettings.getOrDefault(model, "default-settings")
    println("11) Settings for $model: $settings")

    // 12. Проверить наличие кода ошибки
    val errors = mapOf("E101" to "Null pointer", "E202" to "Timeout")
    val codeToCheck = "E101"
    println("12) Contains $codeToCheck: ${errors.containsKey(codeToCheck)}")

    // 13. Отфильтровать словарь по версии
    val scenarios = mapOf("TC1_v1.0" to "Passed", "TC2_v2.0" to "Failed")
    val version = "v1.0"
    val filteredByVersion = scenarios.filterKeys { it.contains(version) }
    println("13) Filtered by version: $filteredByVersion")

    // 14. Есть ли модули с неудачным тестом
    val modules = mapOf("auth" to "Passed", "billing" to "Failed")
    val hasFailed = modules.any { it.value == "Failed" }
    println("14) Any failed: $hasFailed")

    // 15. Добавить настройки из другого словаря
    val envSettings = mutableMapOf("env" to "staging")
    val otherSettings = mapOf("timeout" to "60", "retries" to "3")
    envSettings.putAll(otherSettings)
    println("15) Merged env settings: $envSettings")

    // 16. Объединить два неизменяемых словаря
    val bugsA = mapOf("B1" to "open")
    val bugsB = mapOf("B2" to "fixed")
    val mergedBugs = bugsA + bugsB
    println("16) Merged bugs: $mergedBugs")

    // 17. Очистить временные данные
    val tempRun = mutableMapOf("runId" to "123", "status" to "done")
    tempRun.clear()
    println("17) Temp run cleared: ${tempRun.isEmpty()}")

    // 18. Исключить skipped
    val allResults = mapOf("t1" to "passed", "t2" to "skipped", "t3" to "failed")
    val withoutSkipped = allResults.filterNot { it.value == "skipped" }
    println("18) Without skipped: $withoutSkipped")

    // 19. Копия словаря с удалением нескольких конфигураций
    val configs = mapOf("a" to "1", "b" to "2", "c" to "3")
    val reduced = configs - listOf("b", "c")
    println("19) Reduced configs: $reduced")

    // 20. Отчёт в формате "Test ID: результат"
    val resultsForReport = mapOf("T1" to "Passed", "T2" to "Failed")
    val reportLines = resultsForReport.map { (id, res) -> "$id: $res" }
    println("20) Report:\n${reportLines.joinToString("\n")}")

    // 21. Преобразовать изменяемый словарь в неизменяемый
    val mutableLast = mutableMapOf("x" to "y")
    val immutableArchive = mutableLast.toMap()
    println("21) Immutable archive: $immutableArchive")

    // 22. Заменить числовые ключи на строковые
    val numericIds = mapOf(1 to "ok", 2 to "fail")
    val stringKeyMap = numericIds.mapKeys { (key, _) -> key.toString() }
    println("22) String-key map: $stringKeyMap")

    // 23. Увеличить значения на 10%
    val perf = mapOf("v1" to 100.0, "v2" to 200.0)
    val adjusted = perf.mapValues { it.value * 1.10 }
    println("23) Adjusted perf: $adjusted")

    // 24. Проверить, пуст ли словарь ошибок компиляции
    val compileErrors = emptyMap<String, String>()
    println("24) Compile errors empty: ${compileErrors.isEmpty()}")

    // 25. Проверить, не пуст ли словарь нагрузочного теста
    val loadResults = mapOf("test1" to "ok")
    println("25) Load results not empty: ${loadResults.isNotEmpty()}")

    // 26. Проверить, все ли тесты прошли успешно
    val allResultsMap = mapOf("t1" to "Passed", "t2" to "Passed")
    val allPassed = allResultsMap.all { it.value == "Passed" }
    println("26) All passed: $allPassed")

    // 27. Есть ли хотя бы один тест с ошибкой
    val resultsMap2 = mapOf("t1" to "Passed", "t2" to "Failed")
    val hasError = resultsMap2.containsValue("Failed")
    println("27) Has failed test: $hasError")

    // 28. Отфильтровать сервисы optional с неуспешным результатом
    val serviceResults = mapOf("optional_db" to "Failed", "core" to "Failed", "optional_cache" to "Passed")
    val filtered = serviceResults.filter { (name, status) -> status != "Passed" && name.contains("optional") }
    println("28) Filtered services: $filtered")
    }
}