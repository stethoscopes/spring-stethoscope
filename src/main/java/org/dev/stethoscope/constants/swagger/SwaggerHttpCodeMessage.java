package org.dev.stethoscope.constants.swagger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class SwaggerHttpCodeMessage {
    public static final String OK = "정상 요청되었습니다.";
    public static final String BAD_REQUEST = "잘못된 입력값입니다. 파라미터를 확인하거나 에러코드를 확인해주세요.";
    public static final String UNAUTHENTICATED = "인증정보가 없습니다. 로그인 여부를 확인해주세요.";
    public static final String FORBIDDEN = "접근 권한이 없습니다.";
    public static final String NOT_FOUND = "요청하신 리소스가 서버에 없습니다.";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 오류입니다. 서버 개발자에게 문의해주세요.";
}
