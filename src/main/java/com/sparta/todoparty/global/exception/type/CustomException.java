package com.sparta.todoparty.global.exception.type;

import com.sparta.todoparty.global.exception.dto.ExceptionResponseDto;
import lombok.Getter;

@Getter
public enum CustomException {
    NOT_FOUND_COMMENT(404, "요청하신 댓글이 존재하지 않습니다."),
    NOT_MATCH_USER(400, "작성자만 수정/삭제할 수 있습니다."),
    NOT_VALID_TOKEN(400, "유효하지 않는 JWT입니다."),
    EXPIRED_TOKEN(400, "만료된 JWT입니다."),
    UNSUPPORTED_TOKEN(400, "지원하지 않는 JWT입니다."),
    EMPTY_TOKEN(400, "JWT가 비어있습니다."),
    AUTHENTICATION_ERROR(400, "잘못된 인증입니다."),
    ALREADY_EXIST_USERNAME(400, "중복된 username입니다."),
    ALREADY_EXIST_EMAIL(400, "중복된 email입니다."),
    ALREADY_EXIST_NICKNAME(400, "중복된 nickname입니다."),
    PRIVATE_CARD_ACCESS(400, "작성자만 조회할 수 있습니다."),
    BAD_LOGIN(404, "회원을 찾을 수 없습니다."),
    ILLEGAL_BOARD_TYPE(400, "해당되지 않는 게시글 조회 기준입니다."),
    NOT_FOUND_BOARD(404, "요청하신 게시글이 존재하지 않습니다."),
    ALREADY_EXIST_BOARD_LIKE(400, "이미 좋아요를 눌렀습니다."),
    NOT_FOUND_BOARD_LIKE(404, "요청하신 게시글 좋아요가 존재하지 않습니다."),
    NOT_MATCH_COMMENT(400, "작성자만 수정/삭제할 수 있습니다."),
    ALREADY_EXIST_COMMENT_LIKE(400, "이미 좋아요를 눌렀습니다."),
    NOT_FOUND_COMMENT_LIKE(404, "요청하신 댓글 좋아요가 존재하지 않습니다."),
    ALREADY_EXISTS_FOLLOWING(400, "이미 팔로우를 하셨습니다."),
    NOT_ALLOW_FOLLOWING_YOURSELF(400, "자신을 팔로우할 순 없습니다."),
    NOT_FOUND_FOLLOWING(404, "팔로우를 찾지 못하였습니다."),
    FAIL_DELETE_IMAGE(400, "이미지 삭제를 실패했습니다."),
    FAIL_UPLOAD_IMAGE(400, "이미지 업로드를 실패했습니다."),
    NO_IMAGE_TYPE(400, "이미지 파일이 아닙니다."),
    NO_IMAGE_FILE(400, "이미지가 없습니다."),
    NOT_FOUND_USER(404, "사용자를 찾을 수 없습니다."),
    NOT_MATCH_CHECK_PASSWORD(400, "비밀번호 확인 입력이 일치하지 않습니다."),
    NOT_MATCH_CURRENT_PASSWORD(400, "현재 비밀번호와 일치하지 않습니다."),
    NOT_MATCH_CONFIRMATION_PHRASE(400, "회원탈퇴 확인 문구가 일치하지 않습니다.");

    private final int statusCode;
    private final String message;

    CustomException(final int statusCode, final String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ExceptionResponseDto toDto() {
        return ExceptionResponseDto.builder()
                .statusCode(statusCode)
                .message(message)
                .build();
    }
}