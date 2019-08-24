package com.github.edjdc.ativos.helper.web.jpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("Page")
@NoArgsConstructor @AllArgsConstructor @Builder
@Data
public class PageDTO<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 7554694887811814079L;
	
	private List<T> content;
	private Long totalElements;
	private Integer totalPages;
	private boolean last;
	private boolean first;
	private Integer numberOfElements;
	private Integer size;
	private Integer number;
	
	public PageDTO(Page<T> page) {
		this.content = page.getContent();
		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.last = page.isLast();
		this.first = page.isFirst();
		this.numberOfElements = page.getNumberOfElements();
		this.size = page.getSize();
		this.number = page.getNumber();
	}
	
}
