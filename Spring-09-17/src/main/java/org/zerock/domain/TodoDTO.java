package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	@DateTimeFormat(pattern="yyyy/mm/dd")  // 데이터가 들어오면 이렇게 변환해주겠다. 
	private Date dueDate;
	
	
	
}
