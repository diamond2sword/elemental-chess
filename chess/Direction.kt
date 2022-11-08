package chess

enum class Direction(val row : Int, val col : Int) {
    NORTH(-1, 0),
    SOUTH(1, 0),
    WEST(0, -1),
    EAST(0, 1),
    NORTHWEST(-1, -1),
    NORTHEAST(-1, 1),
    SOUTHWEST(1, -1),
    SOUTHEAST(1, 1),;

    fun rotatedClockwise(rotation : Int = 0) : Direction {
        return if (rotation == 0) this else when (this) {
            NORTH -> NORTHEAST
            SOUTH -> SOUTHWEST
            WEST -> NORTHWEST
            EAST -> SOUTHEAST
            NORTHWEST -> NORTH
            NORTHEAST -> EAST
            SOUTHWEST -> WEST
            SOUTHEAST -> SOUTH
        }.rotatedClockwise(rotation - 1)
    }
}