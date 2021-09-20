package com.practice.sample.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    long id;
    String name;
    Address address;
    
    //latest book by this author using @JoinFormule
    /**
    @ManyToOne(fetch - FetchType.EAGER)
    @JoinFormule(
        "(SELECT B.ID FROM BOOK B WHERE B.AUTHOR_ID = ID and B.CREATE_TS = (select max(BK.CREATE_TS) From BOOK BK where BK.AUTHOR_ID = ID))"
    )
    private Book book;
    **/
}
