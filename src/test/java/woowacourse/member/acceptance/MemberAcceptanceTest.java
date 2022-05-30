package woowacourse.member.acceptance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static woowacourse.helper.fixture.TMember.MARU;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import woowacourse.member.dto.MemberResponse;
import woowacourse.shoppingcart.acceptance.AcceptanceTest;

@DisplayName("멤버 관련 기능")
public class MemberAcceptanceTest extends AcceptanceTest {

    @DisplayName("email, password, name을 입력해서 회원가입을 진행하면 201 Created를 반환한다.")
    @Test
    void register() {
        ExtractableResponse<Response> response = MARU.register();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @DisplayName("토큰을 헤더에 담아 정보 조회를 요청하면 200 OK와 id, email, name을 반환한다.")
    @Test
    void getMyInformation() {
        MARU.register();
        MemberResponse response = MARU.loginAnd().getMyInformation();
        assertAll(
                () -> assertThat(response.getId()).isNotNull(),
                () -> assertThat(response.getEmail()).isEqualTo(MARU.getEmail()),
                () -> assertThat(response.getName()).isEqualTo(MARU.getName())
        );
    }
}
