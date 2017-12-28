fun Double.roundTo2DecimalPlaces() =
        BigDecimal(this).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start
