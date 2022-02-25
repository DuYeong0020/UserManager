package kr.flab.usermanager.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass @Getter
public abstract class BaseEntity {

    @Column(name = "INST_DT")
    private LocalDateTime createDate; // 등록일자

    @Column(name = "UPDT_DT")
    private LocalDateTime updateDate; // 수정일자

    @Column(name = "DELETED")
    private Boolean deleted; // 삭제 여부

    @PrePersist
    public void prePersist(){
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
        deleted = false;
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = LocalDateTime.now();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(getCreateDate(), that.getCreateDate()) && Objects.equals(getUpdateDate(), that.getUpdateDate()) && Objects.equals(getDeleted(), that.getDeleted());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreateDate(), getUpdateDate(), getDeleted());
    }
}
