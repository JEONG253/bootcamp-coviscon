package com.coviscon.itemservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    MISSING_REGISTER_BAD_REQUEST(BAD_REQUEST, "등록자에 대한 정보가 입력되지 않았습니다.", ""),
    MISSING_FILE_BAD_REQUEST(BAD_REQUEST,"요청에 대한 이미지 파일이 누락되었습니다.", ""),
    DELETED_ARTICLE_BAD_REQUEST(BAD_REQUEST,"해당 게시글이 삭제된 상태입니다.", ""),

    /* 403 FORBIDDEN : 접근 권한 제한 */
    /* Valid : 유효한 */
    VALID_USER_ID(FORBIDDEN, "해당 정보에 접근 권한이 존재하지 않습니다.", ""),
    LOGIN_FAIL(FORBIDDEN, "아이디나 비밀번호가 틀렸습니다.", "loginFail"),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    MEMBER_NOT_FOUND(NOT_FOUND, "해당 회원 정보를 찾을 수 없습니다.", "notFound"),
    EMAIL_NOT_FOUND(NOT_FOUND, "해당 이메일을 찾을 수 없습니다.", "notFound"),
    PASSWORD_NOT_FOUND(NOT_FOUND, "해당 비밀번호를 찾을 수 없습니다.", ""),
    TYPE_NOT_FOUND(NOT_FOUND,"해당 타입을 찾을 수 없습니다.", ""),
    ARTICLE_NOT_FOUND(NOT_FOUND,"해당 게시글을 찾을 수 없습니다.", "itemNotFound"),
    CATEGORY_NOT_FOUND(NOT_FOUND,"해당 카테고리를 찾을 수 없습니다.", "itemNotFound"),
    COMMENT_NOT_FOUND(NOT_FOUND,"해당 댓글을 찾을 수 없습니다.", ""),
    NOTE_NOT_FOUND(NOT_FOUND,"해당 쪽지방을 찾을 수 없습니다.", ""),
    NOTE_HISTORY_NOT_FOUND(NOT_FOUND,"해당 쪽지 내용을 찾을 수 없습니다.", ""),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    /* DUPLICATE : (다른 무엇과) 똑같은 */
    DUPLICATE_DIFFERENT_USER(CONFLICT, "해당 글의 작성자와 정보가 일치하지 않습니다.", ""),
    DUPLICATE_LIKE(CONFLICT, "해당 강의는 이미 좋아요 등록되어 있습니다.", ""),
    DUPLICATE_NOT_HEART(CONFLICT, "해당 강의를 좋아요 하지 않은 상태입니다.", ""),

    /* 500 : */
    UNSUCCESSFUL_UPLOAD(INTERNAL_SERVER_ERROR,"이미지 파일 업로드에 실패했습니다.", ""),
    UNSUCCESSFUL_INSERT(INTERNAL_SERVER_ERROR,"해당 강의 저장이 실패했습니다.", "itemSaveFail"),
    UNSUCCESSFUL_MODIFY(INTERNAL_SERVER_ERROR,"해당 강의의 상태 변경에 실패했습니다.", "itemUpdateFail"),
    UNSUCCESSFUL_DELETE(INTERNAL_SERVER_ERROR, "해당 강의의 삭제에 실패했습니다.", "itemUpdateFail");


    private final HttpStatus httpStatus;
    private final String message;
    private final String page;

    /**
     * method 로 사용 예시
     */
    public static CustomException throwNotEnterEmailOrToken(){
        throw new CustomException(MISSING_REGISTER_BAD_REQUEST);
    }
}