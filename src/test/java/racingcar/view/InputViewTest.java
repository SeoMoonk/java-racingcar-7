package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.RacingCarInfoMsg.TYPE_CAR_NAMES;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputViewTest extends NsTest {

    private final InputView inputView = new InputView();

    @Test
    @DisplayName("사용자로부터 자동차들의 이름을 입력받을 수 있게 안내 문구가 출력된다")
    void t001() {
        //given
        String testInput = "test";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        //when
        inputView.inputCarNames();

        //then
        assertThat(output()).contains(TYPE_CAR_NAMES.getMsg());
    }

    @Test
    @DisplayName("사용자로부터 자동차의 이름을 입력받는다")
    void t002() {
        //given
        String testInput = "test";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        //when
        String result = inputView.inputCarNames();

        //then
        assertThat(result).isEqualTo("test"); // 입력받은 문자열에서 개행 제거
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}