package com.dntwk.visiter.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class VisitorDTO {
    Integer total;
    Integer today;
    Integer yesterday;
}
