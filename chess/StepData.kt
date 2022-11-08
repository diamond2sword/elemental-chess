package chess

class StepData(
        var instruction : Instruction,
        var position : Position,
        var mainFun : (stepData : StepData) -> Boolean?,
        var rotation : Int,
        var stepLength : Int,
        var rotationIndex : Int,
        var stepLengthIndex : Int,
    ) {
}