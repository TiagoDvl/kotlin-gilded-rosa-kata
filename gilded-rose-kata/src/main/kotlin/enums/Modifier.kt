package enums

enum class Modifier(val factor: Int) {
    // This sounds bad. Difficult to maintain?
    DOUBLE_DECAY(-2),
    DECAY(-1),
    STABLE(0),
    ENHANCE(1),
    DOUBLE(2),
    TRIPLE(3)

}