package com.dntwk.directory.entity;

import com.dntwk.comm.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Cacheable
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Entity
public class Directory extends BaseEntity {
    /* (((중요)))디렉토리는 계층적 구조를 지닌다.
        수정 삭제 생성보다 조회가 압도적으로 많을 테이블이다.
    * {
    * - 장점  하위 디렉토리가 상위 디렉토리 테이블이 나뉘어 있으면 디렉토리의 변경이 용이하다.
    * - 단점 하지만 데이터가 얼마 들어 있지도 않을 테이블을 또 굳이 여러개 나눌 필요가 있을까..? 모르겠다
    *   그리고 post의 경우 어떤 디렉토리의 포스트인지 알아야 하니까 어떤 디렉토리를 참조 해야한다.
    *   그렇다면 테이블이 나뉜 만큼 컬럼의 개수가 늘어나고 null값이 추가된다 ex) 1,2,3번째 계층의 디렉토리를 전부 참조해야 하고 해당하는 디렉토리를 외래키로 사용한다.
    *   또 어떤 디렉토리의 위치를 변경한다면 ex) programin.opp.java >> programin.java
    *   테이블의 값이 다른 테이블로 변경되고 post가 참조하는 테이블도 변경이 되어야 하는데 이게 맞나? (디렉토리 계층 변경시 post에서 변경 해야 할 값이 2개)
    *   ****또한 디렉토리는 조회가 압도적으로 많을 테이블 일테고 조회한다면 1,2,3계층을 전부 조회 해야 하는데 이걸 2차 캐시에서 사용 할 수 있나?
    * }
    * {단일 테이블을 사용 해 버리면 superDirectoryName의 경우 같은 테이블의 디렉토리를 참조하는데 이걸 명료하게 표현 할 수가 없다.}
    * 일단 내가 낸 결론 - 조회가 많을 테이블이니 2차 캐시를 쉽게 이용 하기 위해 수정삭제생성이 불편해도 단일 테이블을 사용하자.
    * 일장 일단이 있는 것 인가? 실제로는 어떻게 사용하는지 잘 모르겠다. */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directoryIdx;

    @Column
    private String directoryName;

    @Column
    private Integer directoryLayer;

    @Column
    private String superDirectoryName;

    @Column
    private Integer directorySortedNum;

    public Directory modDirectoryName(String directoryName) {
        this.directoryName = directoryName;
        return this;
    }

    public Directory modDirectorySortNum(Integer directorySortedNum) {
        this.directorySortedNum = directorySortedNum;
        return this;
    }

    public Directory modDirectoryLayer(Integer directoryLayer) {
        this.directoryLayer = directoryLayer;
        return this;
    }

}
