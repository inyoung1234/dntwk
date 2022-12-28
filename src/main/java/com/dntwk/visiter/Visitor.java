package com.dntwk.visiter;

import com.dntwk.visiter.dto.VisitorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@SqlResultSetMapping(
        name="myMapping",
        classes={@ConstructorResult(
                targetClass=VisitorDTO.class,
                columns={
                        @ColumnResult(name="total",type = Integer.class),
                        @ColumnResult(name="today",type = Integer.class),
                        @ColumnResult(name="yesterday",type = Integer.class)
                }
        )
        }
)
@NamedNativeQuery(
        name = "Visitor.visitCounting",
        query = "select total,today,yesterday from (select count(*) total from visitor ) total," +
                "(select count(*) today from visitor where dayofmonth(visit_time)=:today ) today," +
                "(select count(*) yesterday from visitor where dayofmonth(visit_time)=:yesterday ) yesterday",
        resultSetMapping = "myMapping"
)
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitId;
    private String visitIp;
    private String userId;
    private Date visitTime;
    private String visitRefer;

}
