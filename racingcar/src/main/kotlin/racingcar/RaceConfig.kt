package racingcar

import racingcar.controller.RaceController
import racingcar.view.InputView
import racingcar.view.ResultView

class RaceConfig {
    fun raceController(): RaceController {
        return RaceController(
            inputView = inputView(),
            resultView = resultView(),
        )
    }

    private fun inputView(): InputView = InputView()

    private fun resultView(): ResultView = ResultView()
}
