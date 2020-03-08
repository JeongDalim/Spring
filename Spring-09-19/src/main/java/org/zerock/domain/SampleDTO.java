package org.zerock.domain;

import lombok.Data;

@Data//이걸 사용하면 세터게터가 자동으로 만들어져 사용가능하게 함
public class SampleDTO {
	private String name;
	private int age;
	
}
