package exercises.extensions

private const val NANOSECONDS_IN_SECONDS = 1_000_000_000f

fun Long.nanoTimeToSecondsString() = String.format("%.8f", this / NANOSECONDS_IN_SECONDS)