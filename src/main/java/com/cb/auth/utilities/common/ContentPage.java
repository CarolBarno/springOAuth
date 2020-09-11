/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.utilities.common;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class ContentPage<T> {

    private Integer page;
    private Long totalResults;
    private Integer pageSize;
    private Integer totalPages;
    private List<T> results;

    public static ContentPage createPage(Page page) {
        final ContentPage contentPage = new ContentPage<>();
        contentPage.setTotalPages(page.getTotalPages());
        contentPage.setPage(page.getNumber() + 1);
        contentPage.setTotalResults(page.getTotalElements());
        contentPage.setPageSize(page.getSize());
        if (page.getSize() > 0) {
            final ArrayList list = new ArrayList<>(page.getSize());
            contentPage.setResults(list);
            page.forEach(e -> list.add(e));
        }

        return contentPage;
    }
}
