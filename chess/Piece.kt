package chess

class Piece(
        var position : Position,
        var color : Color,
        var type : Type,
        var isAbstract : Boolean = false,
        var isMoved : Boolean = false,
        var name : String = "",
) {
    companion object {
    }
}