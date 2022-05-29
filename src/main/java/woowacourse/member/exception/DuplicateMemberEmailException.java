package woowacourse.member.exception;

public class DuplicateMemberEmailException extends BadRequestException {

    public DuplicateMemberEmailException() {
        super("[ERROR] 동일한 이메일이 존재합니다.");
    }
}
