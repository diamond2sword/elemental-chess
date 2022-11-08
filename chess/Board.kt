package chess

class Board(var row : Int, var col : Int) {
    val visionBoard = Array(row) {Array(col) {mutableListOf<Vision>()}}
    val pieceBoard = mutableListOf<Piece>()

}