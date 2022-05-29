package woowacourse.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import woowacourse.exception.dto.ErrorResponse;
import woowacourse.member.exception.BadRequestException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private final Logger logger;

    public GlobalControllerAdvice() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestExceptionHandler(BadRequestException e) {
        logger.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }
}