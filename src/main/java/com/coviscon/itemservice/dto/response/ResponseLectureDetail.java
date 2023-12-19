package com.coviscon.itemservice.dto.response;

import com.coviscon.itemservice.entity.item.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/* ResponseDto -> Json 변환 후 반환 시 null 값이 데이터는 제외 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseLectureDetail implements Serializable {
    private Long id;
    private Category category;
    private String title;
    private String content;
    private Boolean isDelete;
    private Integer likeCnt;
    private int price;
    private String teacherId;
    private String teacherName;
    private String thumbnailFileName;
    private String subVideoName;
    private String realVideoName;
    private String savedPath;
}