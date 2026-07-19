package com.example.ArpegioBackend.utils;

import com.example.ArpegioBackend.payload.PageResponse;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@NoArgsConstructor
public class PageUtils {

    public static Pageable buildPageable(
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        return PageRequest.of(page, size, sort);
    }

    public static <T> PageResponse<T> toPageableResponse(Page<T> page) {

        PageResponse<T> response = new PageResponse<>();

       /// TODO: implement the mapping based on class types?
       /// DTOS LIST FROM ENTITY? D - > E ?
        response.setContent(page.getContent());
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLastPage(page.isLast());

        return response;
    }

}
