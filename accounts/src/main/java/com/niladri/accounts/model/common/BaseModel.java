package com.niladri.accounts.model.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
     @Column(insertable  = false)
    private LocalDateTime updatedDate;

    @LastModifiedBy
     @Column(insertable = false)
    private String updatedBy;
}
