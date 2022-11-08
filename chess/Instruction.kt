package chess

class Instruction(
        var directionList : List<Direction>,
        var rotationList : List<Int>,
        var stepLengthList : List<Int>,
        val preMainFun : (stepData : StepData) -> Boolean?,
        val postMainFun : (stepData : StepData) -> Boolean?,
        val generalPreExecuteFun : () -> Boolean?,
        val generalPostExecuteFun : () -> Boolean?,
        var name : String = "",
    ) {
    companion object {
        fun execute(
                instruction : Instruction,
                position : Position,
                mainFun : (stepData : StepData) -> Boolean?,
            ) {
            with (instruction) {
                generalPreExecuteFun() ?: return
                rotationList.forEachIndexed {rotationIndex, rotation ->
                    stepLengthList.forEachIndexed stepLength@ {stepLengthIndex, stepLength ->
                        fun mainCopyFun(stepData : StepData) = mainFun(stepData)
                        val stepData = StepData(
                            instruction = instruction,
                            position = position,
                            mainFun = ::mainCopyFun,
                            rotation = rotation,
                            stepLength = stepLength,
                            rotationIndex = rotationIndex,
                            stepLengthIndex = stepLengthIndex,
                        )
                        preMainFun(stepData)?.let {if (it) return@stepLength} ?: return
                        mainFun(stepData)?.let {if (it) return@stepLength} ?: return
                        postMainFun(stepData)?.let {if (it) return@stepLength} ?: return
                    }
                }
                generalPostExecuteFun()
            }
        }
    }
}